package Bai2;

public class Circle extends Shape{

	// thuoc tinh
	double banKinh;
	
	@Override
	public void nhap() {
		System.out.println("Nhap ban kinh: ");
		banKinh = scanner.nextDouble();
		kieu = 0;
	}
	
	public void tinhDT() {
		dienTich = Math.PI*(banKinh*banKinh);
	}
	
	public String toString() {
		String dt = dienTich.toString();
		return "Ten: Circle, dien tich: \n" + dt;
	}
}
