package Bai3;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
	    boolean isLeapYear = new GregorianCalendar().isLeapYear(year);
	
	    System.out.println("Năm " + year + (isLeapYear ? " là năm nhuận." : " không phải năm nhuận."));
	
	    // Tìm ngày đầu tiên của năm
	    GregorianCalendar calendar = new GregorianCalendar(year, 0, 1);
	    int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
	
	    System.out.println("Ngày đầu tiên của năm " + year + " là thứ " + firstDay);
	    
	    
	    Date currentDate = new Date();

        // Định dạng 1: dd/MM/yyyy
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate1 = format1.format(currentDate);

        // Định dạng 2: dd-MMM-yyyy
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate2 = format2.format(currentDate);

        // Định dạng 3: EEEE, dd MMM yyyy HH:mm:ss
        SimpleDateFormat format3 = new SimpleDateFormat("EEEE, dd MMM yyyy HH:mm:ss");
        String formattedDate3 = format3.format(currentDate);

        System.out.println("Ngày hiện tại:");
        System.out.println(" - Định dạng 1: " + formattedDate1);
        System.out.println(" - Định dạng 2: " + formattedDate2);
        System.out.println(" - Định dạng 3: " + formattedDate3);
	}
}
