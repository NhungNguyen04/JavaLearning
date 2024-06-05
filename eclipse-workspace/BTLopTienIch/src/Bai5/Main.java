package Bai5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) throws IOException {
		String username, email, password;

		Pattern usernamePattern = Pattern.compile("[A-Z]\\w+\\s+");
		Pattern emailPattern = Pattern.compile("^[a-z0-9][a-z0-9._-]+@[a-z]+.[a-z]+$");
		Pattern passwordPattern = Pattern.compile("^[A-Z][a-zA-Z0-9]{7,}$");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Nhap ten: ");
		username = reader.readLine();
		if (username.length() < 15 || username.length() > 30 || !usernamePattern.matcher(username).matches()) {
			System.out.println("Ten dang nhap khong hop le!");
		}
		
		System.out.println("Nhap email: ");
		email = reader.readLine();
		if (email.isEmpty() || !emailPattern.matcher(email).matches()) {
			System.out.println("Email khong hop le!");
		}
		
		System.out.println("Nhap mat khau: ");
		password = reader.readLine();
		if (password.isEmpty() || !passwordPattern.matcher(password).matches()) {
			System.out.println("Mat khau khong hop le!");
		}
	}
}
