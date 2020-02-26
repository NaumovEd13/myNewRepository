import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] arrOfPaths = args;
        Date date = new Date();//Создаю экземпляр текущей даты, мне это необходимо для названия текстового файла,
        // чтобы при запуске программы каждый раз создавался новый файл и имел идентификацию.
        System.out.println(date);
        StringBuilder str = new StringBuilder(date.toString().replaceAll(" ", "_").substring(0, 20));
        str.replace(13, 14, "h");
        str.replace(16, 17, "m");
        str.replace(19, 20, "s");
        String fileToWriteResult = "C:\\result_" + str + ".txt";
        ServiceSplitter serviceSplitter = new ServiceSplitter(arrOfPaths);//создается новый экземпляр класса, который разделяет процесс на отдельные потоки,
        //согласно количеству введенных папок.
        serviceSplitter.setFiletoResult(fileToWriteResult);
        serviceSplitter.startThreads();
    }
}