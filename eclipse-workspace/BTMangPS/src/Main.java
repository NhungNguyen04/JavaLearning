import java.util.Scanner;

public class Main {
	// thuoc tinh
	static MangPS mangPS = new MangPS();
	
	// ham nhap
	public static void nhap() {
		mangPS.nhap();
	}
	
	// ham xuat
	public static void xuat() {
		System.out.println("Mang phan so da nhap la: ");
		mangPS.xuat();
	}
	
	// ham sap xep
	public static void sapXep() {
		System.out.println("Nhap thu tu muon sap xep (1 cho tang dan, -1 cho giam dan): ");
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		mangPS.sapXep(t);
		System.out.println("Mang phan so sau khi sap xep: ");
		mangPS.xuat();
		System.out.println("Min la: ");
		System.out.println("");
		mangPS.xuatMin(t);
		System.out.println("Max la: ");
		mangPS.xuatMax(t);
	}
	
	public static void main(String[] args) {
		nhap();
		xuat();
		sapXep();
	}
}
