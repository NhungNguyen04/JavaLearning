import java.util.ArrayList;
import java.util.Scanner;

public class Bai2 {
	public static ArrayList<Double> giaiPtBac2 (Double a, Double b, Double c) {
		double delta = b*b - 4*a*c;
		ArrayList<Double> nghiem = new ArrayList<Double>();
		if (delta > 0) {
		    // Phương trình có hai nghiệm phân biệt
		    nghiem.add((-b+Math.sqrt(delta))/(2 * a));
		    nghiem.add((-b-Math.sqrt(delta))/(2 * a));
		} else if (delta == 0) {
		    // Phương trình có một nghiệm kép
		    nghiem.add(-b/(2 * a));
		    nghiem.add(-b/(2 * a));
		}
		return nghiem;
	}
	public static void main(String[] args) {
		Double a, b, c;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Nhap so thu nhat: ");
		a = scanner.nextDouble();
		System.out.print("Nhap so thu hai: ");
		b = scanner.nextDouble();
		System.out.print("Nhap so thu ba: ");
		c = scanner.nextDouble();
		scanner.close();
		
		ArrayList<Double> nghiem = giaiPtBac2(a, b, c);
		
		if(nghiem.isEmpty() | nghiem.get(0).isNaN() | nghiem.get(1).isNaN()) {
			System.out.print("Phuong trinh khong co nghiem!");
		}
		else {
			System.out.printf("Nghiem cua phuong trinh lan luot la: x1 = %.2f, x2 = %.2f", nghiem.get(0), nghiem.get(1)); 
		}
	}
}
