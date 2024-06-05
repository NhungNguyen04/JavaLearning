package Bai4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Đọc file
        FileReader fileReader = new FileReader("./input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] array = new int[n];
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }

        bufferedReader.close();
    }
}
