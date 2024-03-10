import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Nhap nam: ");
    	int nam = scanner.nextInt();
    	scanner.close();
    	
    	// Lấy lịch năm cần biết
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, nam);

        // Duyệt qua từng tháng
        for (int month = 0; month < 12; month++) {
            calendar.set(Calendar.MONTH, month);

            // In tên tháng
            System.out.println("Tháng " + (month + 1) + " - " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));

            // In tiêu đề các ngày trong tuần
            System.out.println("T2 T3 T4 T5 T6 T7 CN");

            // In ngày đầu tiên của tháng
            int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
            for (int i = 1; i < firstDay; i++) {
                System.out.print("   ");
            }

            // In các ngày còn lại
            for (int day = 1; day <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); day++) {
            	if (firstDay > 7) {
            		System.out.println();
            		firstDay = 2;
            	}
            	else {
            		firstDay++;
            	}
                System.out.printf("%2d ", day);
            }

            System.out.println();
        }
    }
}
