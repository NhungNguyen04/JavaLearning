package bai1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrimeMultithreads {
	static long primeSum = 0;
	static ArrayList<Long> primes = new ArrayList<Long>();
    public static void main(String[] args) {

        // Tạo 2 thread
        Thread primeFinderThread = new Thread(() -> findPrimes(1000, 1000000));
        Thread sumCalculatorThread = new Thread(() -> calculateSum());

        // Bắt đầu cả 2 thread
        primeFinderThread.start();
        sumCalculatorThread.start();

        // Chờ cho cả 2 thread kết thúc
        try {
            primeFinderThread.join();
            sumCalculatorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hiển thị tổng số nguyên tố
        System.out.println("Tổng số nguyên tố từ 1000 đến 1000000: " + totalSum);
    }

    // Hàm tìm số nguyên tố trong khoảng từ start đến end
    private static void findPrimes(int start, int end) {
    	System.out.print("Thread finding primes");
        for (long i = start; i <= end; i++) {
            if (isPrime(i)) {
            	System.out.println(i);
                primes.add(i);
                System.out.println(primes.toString());
            }
        } 
    }

    // Hàm kiểm tra số nguyên tố
    private static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Biến lưu trữ tổng số nguyên tố được tìm thấy
    private static volatile long totalSum = 0;

    // Hàm tính tổng số nguyên tố
    private static void calculateSum() {
    	System.out.println(primes.toString());
        System.out.println("Tính tổng số nguyên tố...");
        for (long p : primes) {
        	primeSum += p;
        }
        System.out.println("Tổng số nguyên tố được tính toán: " + primeSum);
    }
}
