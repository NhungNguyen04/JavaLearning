import java.util.ArrayList;
import java.util.Scanner;

public class Bai3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		System.out.println("Nhap so phan tu cua mang: ");
		int n = scanner.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.printf("Nhap so thu %d: ", i+1);
			a.add(scanner.nextInt());
		}
		scanner.close();
		
		a.sort(null);
		
		System.out.println("Mang duoc sap xep theo thu tu tang dan: ");
		for(Integer k : a) {
			System.out.printf("%d ",k);
		}
	}
}
