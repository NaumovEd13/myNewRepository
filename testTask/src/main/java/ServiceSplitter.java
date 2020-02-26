import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceSplitter {
    protected static final List<Entity> result = new ArrayList<>();//статический список объектов сканированных файлов я создал для того, чтобы в него шла запись
    //всех найденных обьектов во всех папках во всех потоках, после выполнения всех потоков из него все объекты будут записаны в
    //текст.файл.
    protected Set<String> setIncludePaths = new HashSet<>();//директории, участвующие в сканировании, выбран Set, потому что
                                                             //я хочу избежать невынужденного сканирования по два раза в одной папке,
                                                             //в наборе хранятся только уникальные значения
    protected static Set<String> setExcludePaths = new HashSet<>();//исключенные из сканирования директории
                                                                    //выбран Set, потому что в классе Service, методе getFileTree
                                                             //я сравниваю, не является ли текущая директория "запретной" для скана
                                                             //поиск в Set осуществляется быстрее.
    private File fileToWriteResult;
    private final String sp = System.getProperty("line.separator");//перенос на новую строку в блокноте

    public ServiceSplitter(String... allFilePaths) {//вот в этом конструкторе класса сразу происходит разделение на сканируемые директивы и несканируемые директивы по позиции директивы относительно
        //ключа - .
        List<String> listOfAllFilePaths = Arrays.asList(allFilePaths);
        if(listOfAllFilePaths.contains("-")) {
            int indexOfExcludeSymbol = listOfAllFilePaths.indexOf("-");
            for (String str : listOfAllFilePaths) {
                if (listOfAllFilePaths.indexOf(str) < indexOfExcludeSymbol) {
                    setIncludePaths.add(str);
                }
                if (listOfAllFilePaths.indexOf(str) > indexOfExcludeSymbol) {
                    setExcludePaths.add(str);
                }
            }
        }
        else{
            setIncludePaths.addAll(listOfAllFilePaths);
        }
    }

    public void setFiletoResult(String nameOfFile) {
        fileToWriteResult = new File(nameOfFile);
    }

    public void startThreads() throws Exception {//в этом методе поиск в каждой папке запускается в разном потоке и в главном потоке выводятся точка и вертикальная тире.
        ExecutorService executorService = Executors.newCachedThreadPool();//в тредпул добавляются объекты, реализующие runnable-
        //в моем случае объекты класса ThreadClass, и в тредпуле запускаются потоки, мне нужно такое групповое управление потоками,
        //для того чтобы было понятно, когда все потоки завершатся и можно будет записывать итоговый список Entity в текстовый файл.
        for (String path : setIncludePaths) {
            Service service = new Service(path);
            executorService.submit(new ThreadClass(service));
        }
        executorService.shutdown();
        int count = 0;
        while (!executorService.isTerminated()) {//пока потоки в тредпуле не завершились, на экран выводится точка и черточка
            try {
                Thread.sleep(1000);
                if (count != 0 && count % 60 == 0) {
                    System.out.println("|");
                } else if (count != 0 && count % 6 == 0) {
                    System.out.println(".");
                }
                count++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//после завершения всех потоков тредпула происходит кульминация-сортировка итогового списка сущностей и запись в блокнот.
        try (FileWriter fileWriter = new FileWriter(fileToWriteResult, true)) {
            Collections.sort(result);
            for (Entity entity : result) {
                fileWriter.write(entity + sp);
            }
        }
    }
}