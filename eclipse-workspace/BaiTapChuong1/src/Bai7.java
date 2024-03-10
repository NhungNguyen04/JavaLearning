import java.util.ArrayList;
import java.util.Scanner;

public class Bai7 {
	// Dinh nghia kieu phan so
	public static class PhanSo {
		int tuSo;
		int mauSo;
		double giaTri;
		
		public PhanSo(int t, int m) {
			this.tuSo = t;
			this.mauSo = m;
			giaTri = (t*1.0)/m;
		}
		
		public void xuat() {
			System.out.printf("%d/%d ", tuSo, mauSo);
		}
	}
	
	public static class QuickSort {
		public static void quickSort(PhanSo[] arr, int low, int high) {
	        if (low < high) {
	            int pivotIndex = partition(arr, low, high); 

	            // Đệ quy trên mảng con bên trái pivot
	            quickSort(arr, low, pivotIndex - 1);  

	            // Đệ quy trên mảng con bên phải pivot
	            quickSort(arr, pivotIndex + 1, high); 
	        }
	    }

	    private static int partition(PhanSo[] arr, int low, int high) {
	        double pivot = arr[high].giaTri; // Chọn phần tử cuối làm pivot
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	            if (arr[j].giaTri <= pivot) {
	                i++; 
	                swap(arr, i, j); // Hoán đổi arr[i] và arr[j]
	            }
	        }

	        swap(arr, i + 1, high); // Hoán đổi phần tử tại i+1 với pivot 
	        return i + 1; // Trả về chỉ số mới của pivot
	    }

	    private static void swap(PhanSo[] arr, int i, int j) {
	        PhanSo temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so phan tu: ");
		int n = scanner.nextInt();
		PhanSo[] a = new PhanSo[n];
		
		for (int i = 0; i<n; i++) {
			System.out.printf("Nhap tu so cua a[%d]: ", i);
			int t = scanner.nextInt();
			int m = 0;
			do {
				System.out.printf("Nhap mau so cua a[%d]: ", i);
				m = scanner.nextInt();
				if (m == 0) {
					System.out.println("Mau so phai khac 0, moi ban nhap lai: ");
				}
			} while (m == 0);
			PhanSo x = new PhanSo(t, m);
			a[i] = x;
		}
		
		scanner.close();
		QuickSort.quickSort(a, 0, n-1);
		
		System.out.println("Mang sau khi da sap xep la: ");
		for(int i = 0; i <n; i++) {
			a[i].xuat();
		}
	}
}
