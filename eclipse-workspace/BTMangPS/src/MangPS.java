import java.util.Scanner;

public class MangPS implements SapXepDuoc {
	static Scanner scanner = new Scanner(System.in);

	// thuoc tinh
	private int n;
	private PhanSo[] ps;
	
	// ham nhap
	public void nhap() {
		System.out.println("Nhap so phan so: ");
		n = scanner.nextInt();
		ps = new PhanSo[n];
		for (int i=0; i<n; i++) {
			ps[i] = new PhanSo();
			ps[i].nhap();
		}
	}
	
	// ham xuat
	public void xuat() {
		for(PhanSo PS: ps) {
			PS.xuat();
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	
	// Cac ham de thuc hien quicksort
	public void swap(int x, int y) {
		PhanSo temp = ps[x];
		ps[x] = ps[y];
		ps[y] = temp;
	}
	
	@Override
	public int partition(int low, int high, int t) {
		PhanSo pivot = ps[high];
		int i = low-1;
		for(int j=low; j < high; j++) {
			if (ps[j].soSanh(pivot) != t) {
				i++;
				swap(j, i);
			}
		}
		swap(i+1, high);
		return i+1;
	}
	
	public void quickSort(int low, int high, int t) {
		if(low < high) {
			int pivotIndex = partition(low, high, t);
			quickSort(low, pivotIndex-1, t);
			quickSort(pivotIndex+1, high, t);
		}
	}
	
	public void sapXep(int t) {
		quickSort(0, n-1, t);
	}
	
	public void xuatMax(int t) {
		if (t == 1) {
			ps[n-1].xuat();
		}
		else {
			ps[0].xuat();
		}
	}
	
	public void xuatMin(int t) {
		if (t == 1) {
			ps[0].xuat();
		}
		else {
			ps[n-1].xuat();
		}
	}
}
