import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		double x = 9.439;
		double y = 9.230;
		
		System.out.println(Math.max(x, y));
		
		double a, b;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter side a: ");
		a = scanner.nextDouble();
		System.out.println("Enter side b: ");
		b = scanner.nextDouble();
		
		System.out.println(Math.sqrt(a*a+b*b));
		
		scanner.close();
	}
}
