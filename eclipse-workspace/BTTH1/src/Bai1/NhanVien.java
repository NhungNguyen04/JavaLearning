package Bai1;

public class NhanVien extends Person {
	
	// thuoc tinh
	double luongCB, heSo, luong;
	
	@Override
	public void nhap() {
		super.nhap();
		System.out.println("Nhap luong co ban: ");
		luongCB = scanner.nextDouble();
		System.out.println("Nhap he so: ");
		heSo = scanner.nextDouble();
	}
	
	public void xuat() {
		super.xuat();
		System.out.printf("Luong: %2f \n", luong);
	}
	
	public void tinhLuong() {
		luong = luongCB*heSo;
	}
}