package Bai6;

public class Main {

    public static void main(String[] args) {

        int a = 27, b = 326;
        System.out.println("Ước chung lớn nhất của " + a + " và " + b + " là: " + MyMath.USCLN(a, b));

        double x = 1.2, y = 3.5, z = 2.7;
        System.out.println("Giá trị lớn nhất của " + x + ", " + y + " và " + z + " là: " + MyMath.max(x, y, z));

        System.out.println("Số " + a + " có là số nguyên tố? " + MyMath.ktSNT(a));

        int n = 5;
        System.out.println("Tổng dãy từ 1 đến " + n + " là: " + MyMath.tongDay(n));

        double f = 929.5418501435;
        System.out.println("Làm tròn số " + f + " đến 2 chữ số thập phân: " + MyMath.round(f));
    }
}
