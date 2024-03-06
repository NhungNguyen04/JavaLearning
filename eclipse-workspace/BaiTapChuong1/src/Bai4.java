import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập tháng và năm
        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();
        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        // Xác định số ngày trong tháng
        int numDays;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
                if (isLeapYear(year)) {
                    numDays = 29;
                } else {
                    numDays = 28;
                }
                break;
            default:
                numDays = -1;
        }

        // Xuất kết quả
        if (numDays == -1) {
            System.out.println("Tháng không hợp lệ!");
        } else {
            System.out.printf("Tháng %d năm %d có %d ngày.", month, year, numDays);
        }
    }

    // Hàm kiểm tra năm nhuận
	static boolean isLeapYear(int year) {
	     return (year%4==0 && year%100!=0) || year%400 == 0;
	}
}
