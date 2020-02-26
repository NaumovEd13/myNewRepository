import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
    public Service(String path) {
        this.path = path;
    }

    private String path;

    public String getPath() {
        return path;
    }


    public void callingTheGetFileTree(String path) throws IOException {
        synchronized (ServiceSplitter.class) {//синхронизируемся по классу, статический список которого используем, чтобы не было одновременного доступа нескольких потоков к списку
            List<Entity> list = getFileTree(path);
            ServiceSplitter.result.addAll(list);
        }
    }


    public List<Entity> getFileTree(String path) throws IOException {//метод обхода по дереву папок, если это файл-записывается новый файл Entity, который представляет из себя
        //сущность, имеющую поля имя, длину и дату последнего изменения и фактически являющуюся текстовым представлением свойств файла
        List<Entity> listOfPaths = new ArrayList<>();//выбрал ArrayList, потому что названия файлов в папках и подпапках могут быть и
                                                     //не уникальными, ArrayList самая простая структура данных и уместно подходит здесь.
        File[] arr = new File(path).listFiles();
        for (File file : arr) {
            if (!file.isDirectory()) {
                listOfPaths.add(new Entity(file.getName(), file.length(), new Date(file.lastModified())));
            }
            if (file.isDirectory()) {
                if (ServiceSplitter.setExcludePaths.contains(file.getAbsolutePath())) {
                    continue;//если список, хранящий исключенные папки содержит название текущей папки, то цикл переходит на очередной шаг итерации и данная папка не участвует в поиске
                }
                listOfPaths.addAll(this.getFileTree(file.getAbsolutePath()));
            }
        }
        return listOfPaths;
    }
}