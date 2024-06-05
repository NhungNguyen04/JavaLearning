package Bai2;

import java.util.Scanner;

public abstract class Shape {
	// thuoc tinh
	int kieu;
	Double dienTich;
	
	static Scanner scanner = new Scanner(System.in);
	public abstract void nhap();
	public abstract void tinhDT();
	public abstract String toString();
}
