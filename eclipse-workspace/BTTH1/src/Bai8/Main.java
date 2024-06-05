package Bai8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// thuoc tinh
	private static ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
	private static int n;
	
	// ham main
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so sinh vien: ");
		n = scanner.nextInt();
		for(int i=0; i<n; i++) {
			System.out.printf("Nhap sinh vien thu %d\n", i);
			SinhVien sv = new SinhVien();
			sv.nhap();
			arr.add(sv);
		}
		arr.sort(null);
		System.out.println("Danh sach sinh vien voi diem trung binh tang dan: ");
		for(SinhVien sv: arr) {
			System.out.println(sv.toString());
		}
	}
}
