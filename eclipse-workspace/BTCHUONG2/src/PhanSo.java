import java.util.ArrayList;
import java.util.Scanner;

public class PhanSo {
	
	// Thuoc tinh
	private int ts;
	private int ms;
	private double giaTri;
	
	// Constructors
	private PhanSo() {}	
	
	private void tinhGiaTri() {
		this.giaTri = (double)this.ts/(double)this.ms;
	}
	private PhanSo(int t) {
		ts = t;
		ms = 1;
		tinhGiaTri();
	}	
	private PhanSo(int t, int m) {
		ts = t;
		ms = m;
		tinhGiaTri();
	}
	
	static Scanner scanner = new Scanner(System.in);
	// Nhap
	public void nhap() {
		System.out.println("Nhap tu so: ");
		ts = scanner.nextInt();
		System.out.println("Nhap mau so: ");
		ms = scanner.nextInt();
		tinhGiaTri();
	}
	
	// Xuat
	public void xuat() {
		System.out.printf("%d/%d ", ts, ms);
	}
	
	// Tim UCLN cua tu va mau
	 public static int findUCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findUCLN(b, a % b);
    }
	
	// Rut gon
	public void rutGon() {
		int UCLN = findUCLN(ts, ms);
		ts = ts/UCLN;
		ms = ms/UCLN;
	}
	
	// Cong
	public void cong(PhanSo p2) {
		ts = ts*p2.ms + p2.ts*ms;
		ms = ms*p2.ms;
	}
	
	// Tru
	public void tru(PhanSo p2) {
		ts = ts*p2.ms - p2.ts*ms;
		ms = ms*p2.ms;
	}
	
	// Nhan
	public void nhan(PhanSo p2) {
		ts *= p2.ts;
		ms *= p2.ms;
	}
	
	// Chia
	public void chia(PhanSo p2) {
		ts *= p2.ms;
		ms *= p2.ts;
	}
	
	// So sanh
	public int soSanh(PhanSo p2) {
		if (this.giaTri > p2.giaTri) return 1;
		else if(this.giaTri < p2.giaTri) return -1;
		else return 0;
	}
	
	public static void swap(PhanSo[] a, int x, int y) {
		PhanSo temp;
		temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static int partition (PhanSo[] a, int low, int high) {
		int i=low-1;
		PhanSo pivot = a[high];
		for(int j=low; j<high; j++) {
			if(a[j].soSanh(pivot) <= 0) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, high, i+1);
		return i+1;
	}
	public static void quickSort(PhanSo[] a, int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);
			quickSort(a, low, pivot-1);
			quickSort(a, pivot+1, high);
		}
	}
	
	// Ham main
	public static void main(String[] args) {
		int n;
		System.out.println("Nhap so luong phan so: ");
		n = scanner.nextInt();
		PhanSo[] a = new PhanSo[n];
		for(int i=0; i<n; i++) {
			PhanSo p = new PhanSo();
			p.nhap();
			a[i] = p;
		}
		System.out.println("Cac phan so vua nhap: ");
		for(PhanSo p: a) {
			p.xuat();
		}
		PhanSo tong = new PhanSo(0);
		for(PhanSo p: a) {
			tong.cong(p);
		}
		tong.rutGon();
		System.out.println("\nTong cac phan so trong mang: ");
		tong.xuat();
		
		System.out.println("\nMang sau khi sap xep theo thu tu tang dan: ");
		quickSort(a, 0, a.length-1);
		for(PhanSo p: a) {
			p.xuat();
		}
	}
}

