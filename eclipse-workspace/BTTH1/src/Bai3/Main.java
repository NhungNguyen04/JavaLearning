package Bai3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<SinhVien> SinhViens = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nhap so sinh vien: ");
        // Nhập danh sách sinh viên
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("============ Nhap sinh vien ============ ");
            System.out.println("Nhap ma so sinh vien: ");
            String id = "";
			try {
				id = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Nhap ho ten sinh vien: ");
            String name = "";
			try {
				name = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Nhap diem trung binh: ");
            double gpa = scanner.nextDouble();

            SinhViens.add(new SinhVien(id, name, gpa));
        }

        // Xem danh sách sinh viên
        System.out.println("Danh sách sinh viên:");
        for (SinhVien SinhVien : SinhViens) {
            System.out.println(SinhVien);
        }

        // Sắp xếp và hiển thị danh sách sinh viên theo điểm trung bình tăng dần
        Collections.sort(SinhViens, (s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()));
        System.out.println("\nDanh sách sinh viên theo điểm trung bình tăng dần:");
        for (SinhVien SinhVien : SinhViens) {
            System.out.println(SinhVien);
        }

        // Tìm kiếm sinh viên theo tên
        System.out.println("\nNhập tên sinh viên cần tìm:");
        String name = "";
		try {
			name = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SinhVien foundSinhVien = null;
        for (SinhVien SinhVien : SinhViens) {
            if (SinhVien.getName().equals(name)) {
                foundSinhVien = SinhVien;
                break;
            }
        }
        if (foundSinhVien != null) {
            System.out.println("Thông tin sinh viên: " + foundSinhVien);
        } else {
            System.out.println("Sinh viên không tồn tại!");
        }

        // Xuất ra thông tin các sinh viên có họ là “Lê”
        System.out.println("\nDanh sách sinh viên có họ Lê:");
        for (SinhVien SinhVien : SinhViens) {
            if (SinhVien.getName().startsWith("Lê")) {
                System.out.println(SinhVien);
            }
        }
    }
}
