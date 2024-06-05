package bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadGhiSo extends Thread {

    private int start;
    private int end;

    public ThreadGhiSo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Number.txt", true))) {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    writer.write(i + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
