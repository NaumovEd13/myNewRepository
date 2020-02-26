public class ThreadClass extends Thread {//класс, наследующий Thread и в отдельном потоке запускающий выполнение поиска в папке.
    public ThreadClass(Service service) {
        this.service = service;
    }

    private Service service;

    public void run() {//метод запуска отдельного потока.
        try {
            service.callingTheGetFileTree(service.getPath());
        } catch (Exception e) {
            e.getMessage();
        }
    }
}