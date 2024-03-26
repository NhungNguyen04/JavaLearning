import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ho ten: ");
		String hoTen = scanner.nextLine();
		scanner.close();
		
		hoTen = hoTen.trim();
		
//		int kt = hoTen.lastIndexOf(" ");
//		int bd = hoTen.indexOf(" ");
//		
//		String ten = hoTen.substring(kt+1);
//		String ho = hoTen.substring(0, bd);
//		String tendem;
//		try {
//			tendem = hoTen.substring(bd+1, kt);
//		} catch (StringIndexOutOfBoundsException e) {
//			tendem = "Khong co ten dem";
//		}
//		
		
		while (hoTen.contains("  ")) {
			hoTen = hoTen.replace("  ", " ");
		}
		String[] arr = hoTen.split(" ");
		
		String ho = arr[0].trim();
		String ten = arr[arr.length-1].trim();
		String tendem = "";
		
		for(int i=1; i<arr.length-1; i++) {
			tendem = tendem.concat(arr[i]+ " ");
		}
		
		System.out.print("Ho: " + ho + ", ten: "+ten + ", ten dem: " + tendem);
	}
}
