package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	// thuoc tinh
	static ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
	static double tongLuong = 0;
	static int n;
	
	// ham nhap
	public static void nhap() {
		System.out.println("Nhap so nhan vien: ");
		n = scanner.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.printf("Nhap nhan vien thu %d\n", i);
			NhanVien nv = new NhanVien();
			nv.nhap();
			nv.tinhLuong();
			arr.add(nv);
		}
	}
	
	// Ham xuat
	public static void xuat() {
		System.out.println("Danh sach nhan vien: ");
		for(int i=0; i<n; i++) {
			System.out.printf("---------------- Nhan vien thu %d ---------------------\n", i);
			arr.get(i).xuat();
			tongLuong += arr.get(i).luong;
		}
		System.out.printf("Tong luong la: %2f", tongLuong);
		
		arr.sort((NhanVien nv1, NhanVien nv2) -> nv1.luong < nv2.luong ? 1 : -1);
		
		System.out.println("Nhan vien co luong cao nhat: ");
		arr.get(0).xuat();
	}
	
	public static void main(String[] args) {
		nhap();
		xuat();
	}
}
