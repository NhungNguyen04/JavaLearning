package bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ThreadDocFile extends Thread {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Number.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
