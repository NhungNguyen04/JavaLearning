package Bai1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bai1 {
	
	public static void main(String[] args) {
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nhap chuoi A: ");
		String A = new String(); 
		try {
			A = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Nhap chuoi B: ");
		String B = new String();
		try {
			B = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Dem so lan B xuat hien trong A
		int count = 0;
		  int lastIndex = 0;
		  while (lastIndex != -1) {
		    lastIndex = A.indexOf(B, lastIndex);
		    if (lastIndex != -1) {
		      count++;
		      lastIndex += B.length();
		    }
		  }
  
        System.out.println("Chuoi B xuat hien trong chuoi A " + count + " lan");
        
        // Trả về chuỗi C sau khi đã loại bỏ mọi kí tự khoảng trắng của chuỗi A
        String C = A.replaceAll("\\s", "");
        System.out.println("Chuoi A sau khi loai bo khoang trang: " + C);
        
        // kiểm tra chuỗi A có đối xứng hay không
        int n = A.length();
        Boolean dx = true;
        for(int i = 0; i<n/2; i++) {
        	if (A.charAt(i) != A.charAt(n-1-i)) {
        		dx = false;
        		break;
        	}
        }
        System.out.println("Chuoi A la chuoi " + (dx==true?"doi xung": "khong doi xung"));
        
        //  đảo ngược từng từ (word) của chuỗi A để tạo thành chuỗi D 
        String[] Awords = A.split("\\s+");
        String D = "";
        for (String word : Awords) {
        	for (int i=word.length()-1; i>=0; i--) {
        		D += word.charAt(i);
        	}
        	D += " ";
        }
        System.out.println("Chuoi dao nguoc cua A: " + D);
	}
}
