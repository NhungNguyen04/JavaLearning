package bai2;

public class Main {

    public static void main(String[] args) {
        ThreadGhiSo writerThread = new ThreadGhiSo(1000, 10000);
        ThreadDocFile readerThread = new ThreadDocFile();

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chương trình đã hoàn tất!");
    }
}
