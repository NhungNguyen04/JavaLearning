package Bai4;

public class Main {
	 public static void main(String[] args) {
        Complex a = new Complex();
        Complex b = new Complex();
        
        a.nhap();
        b.nhap();

        System.out.println("Số phức a: " + a);
        System.out.println("Số phức b: " + b);

        System.out.println("a + b = " + a.cong(b));
        System.out.println("a - b = " + a.tru(b));
        System.out.println("a * b = " + a.nhan(b));
        System.out.println("a / b = " + a.chia(b));
	 }
}
