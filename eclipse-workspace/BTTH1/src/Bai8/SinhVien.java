package Bai8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SinhVien implements Comparable<SinhVien>{
	
	// thuoc tinh
	protected String hoTen;
	protected Double diemTB;
	
	// constructors
	public SinhVien() {
		hoTen = null;
		diemTB = null;
	}
	public SinhVien(String ht, Double gpa) {
		hoTen = ht;
		diemTB = gpa;
	}
	
	// ham nhap
	public void nhap() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten: ");
		try {
			hoTen = reader.readLine();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Nhap diem trung binh: ");
		diemTB = scanner.nextDouble();
	}
	
	@Override
	public int compareTo(SinhVien sv) {
		return Double.compare(this.diemTB, sv.diemTB);
	}
	
	public String toString() {
		return hoTen += " _ " +diemTB;
	}
}
