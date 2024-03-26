
// Tạo lớp Person gồm các thuộc tính: họ tên, tuổi và địa chỉ 
// và các phương thức: khởi 
//tạo, hiện thị thông tin. Tạo lớp NhanVien kế thừa từ lớp Nguoi và có thêm thuộc 
//tính: lương cơ bản và hệ số có phương thức khởi tạo, tính lương (lương cơ bản * hệ 
//số). Trong hàm main nhập vào danh sách các nhân viên và xuất ra tổng lương và 
//nhân viên có lương cao nhất.

package Bai1;

import java.util.Scanner;


public class Person {
	
	static Scanner scanner = new Scanner(System.in);
	
	// thuoc tinh
	String hoTen, tuoi, diaChi;
	
	// Constructor
	public Person() {}
	
	public Person(String ht, String t, String dc) {
		hoTen = ht;
		tuoi = t;
		diaChi = dc;
	}
	
	// ham nhap
	public void nhap() {
		System.out.println("Nhap ho ten: ");
		hoTen = scanner.next();
		System.out.println("Nhap tuoi: ");
		tuoi = scanner.next();
		System.out.println("Nhap dia chi: ");
		diaChi = scanner.next();
	}
	
	// ham xuat
	public void xuat() {
		System.out.println("Ho ten: " + hoTen + ", tuoi: " + tuoi + ", dia chi: " + diaChi);
	}
}


