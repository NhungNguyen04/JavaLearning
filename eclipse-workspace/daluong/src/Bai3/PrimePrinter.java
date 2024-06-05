package Bai3;

import java.util.List;

public class PrimePrinter {

    private List<Integer> primeNumbers;

    public PrimePrinter(List<Integer> primeNumbers) {
        this.primeNumbers = primeNumbers;
    }

    public void printPrimes() {
        synchronized (primeNumbers) { // Đồng bộ hóa truy cập vào danh sách
            while (!primeNumbers.isEmpty()) {
                int prime = primeNumbers.remove(0);
                System.out.println("Xuất số nguyên tố: " + prime);
            }
        }
    }
}
