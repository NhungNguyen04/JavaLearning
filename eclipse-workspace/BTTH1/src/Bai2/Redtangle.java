package Bai2;

public class Redtangle extends Shape {

	// thuoc tinh
	double cDai, cRong;
	
	@Override
	public void nhap() {
		System.out.println("Nhap chieu dai: ");
		cDai = scanner.nextDouble();
		System.out.println("Nhap chieu rong: ");
		cRong = scanner.nextDouble();
		kieu = 1;
	}
	
	public void tinhDT() {
		dienTich = cDai*cRong;
	}
	
	public String toString() {
		String dt = dienTich.toString();
		return "Ten: Redtangle, dien tich: \n" + dt;
	}
}
