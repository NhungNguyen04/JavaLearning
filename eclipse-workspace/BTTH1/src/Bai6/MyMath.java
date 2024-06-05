package Bai6;

public class MyMath {

    // Hàm tìm ước chung lớn nhất của 2 số nguyên
    public static int USCLN(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // Hàm tìm giá trị lớn nhất của 3 số thực
    public static double max(double a, double b, double c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        }
        return c;
    }

    // Hàm tìm giá trị nhỏ nhất của 3 số thực
    public static double min(double a, double b, double c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        }
        return c;
    }

    // Hàm kiểm tra một số có là số nguyên tố
    public static boolean ktSNT(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Hàm tính tổng dãy từ 1 đến N
    public static int tongDay(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        return s;
    }

    // Hàm tính trị tuyệt đối của 1 số nguyên
    public static int iAbs(int n) {
        if (n < 0) {
            return -n;
        }
        return n;
    }

    // Hàm làm tròn một số thực
    public static double round(double n) {
        String str = String.format("%.2f", n);
        return Double.valueOf(str);
    }
}
