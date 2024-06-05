package Bai2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static // thuoc tinh
	ArrayList<Shape> arr = new ArrayList<Shape>();
	static int n;
	
	// ham main
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so luong hinh: ");
		n = scanner.nextInt();
		for (int i=0; i<n; i++) {
			Shape s;
			System.out.println("Nhap loai hinh (1-Redtangle, 0-Circle): ");
			int type = scanner.nextInt();
			if (type == 1) {
				s = new Redtangle();
			}
			else {
				s = new Circle();
			}
			s.nhap();
			s.tinhDT();
			arr.add(s);
		}
		scanner.close();
		
		int sohcn = 0;
		int soht = 0;
		for (Shape s: arr) {
			if (s.kieu == 1) {
				sohcn++;
			}
			else {
				soht++;
			}
		}
		System.out.printf("So hinh chu nhat: %d, hinh tron: %d\n", sohcn, soht);
		
		arr.sort((Shape a, Shape b) -> a.dienTich < b.dienTich ? 1 : -1);
		System.out.println("Hinh co dien tich lon nhat: ");
		String max = arr.get(0).toString();
		System.out.print(max);
	}
}
