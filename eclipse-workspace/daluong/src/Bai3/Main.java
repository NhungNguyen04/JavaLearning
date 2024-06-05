package Bai3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrimeFinder primeFinder = new PrimeFinder();
        List<Integer> primeNumbers = primeFinder.primeNumbers;

        Thread finderThread = new Thread(() -> primeFinder.findPrimes(1000, 10000));
        Thread printerThread = new Thread(() -> new PrimePrinter(primeNumbers).printPrimes());

        finderThread.start();
        printerThread.start();

        try {
            finderThread.join();
            printerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        primeFinder.stop(); // Dừng thread tìm kiếm sau khi hoàn tất
        System.out.println("Chương trình đã hoàn tất!");
    }
}

