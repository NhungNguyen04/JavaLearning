import java.util.Scanner;

public class PhanSo implements SoSanhDuoc {
	static Scanner scanner = new Scanner(System.in);
	
	// thuoc tinh
	private int tu, mau;
	
	// phuong thuc nhap
	public void nhap() {
		System.out.println("Nhap tu so: ");
		tu = scanner.nextInt();
		System.out.println("Nhap mau so: ");
		mau = scanner.nextInt();
	}
	
	// phuong thuc xuat
	public void xuat() {
		System.out.printf("%d/%d", tu, mau);
	}
	
	@Override
	public int soSanh (Object obj) {
		PhanSo b = (PhanSo) obj;
		double gt1 = (double)this.tu/(double)this.mau;
		double gt2 = (double)b.tu/(double)b.mau;
		if (gt1 > gt2) return 1;
		else if (gt1 < gt2) return -1;
		else return 0;
	}
}


