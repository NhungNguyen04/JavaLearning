package Bai3;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

    private volatile boolean isRunning = true; // Biến cờ để điều khiển thread
    List<Integer> primeNumbers = new ArrayList<>(); // Danh sách số nguyên tố

    public void findPrimes(int start, int end) {
        for (int i = start; i <= end && isRunning; i++) {
            if (isPrime(i)) {
                synchronized (primeNumbers) { // Đồng bộ hóa truy cập vào danh sách
                    primeNumbers.add(i);
                    System.out.println("Tìm thấy số nguyên tố: " + i);
                }
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    private boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
