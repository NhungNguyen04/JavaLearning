import java.util.Scanner;

public class Time {
	// Thuoc tinh
	private int gio, phut, giay, giaTri;
	static Scanner scanner = new Scanner(System.in);
	
	// Constructor
	private Time() {}
	
	private Time(int h, int m, int s) {
		gio = h;
		phut = m;
		giay = s;
		giaTri = gio*3600 + phut*60 + s;
	}
	
	// Setters
	public void setGio(int h) {
		if (h >=0 & h <= 23) {
			gio = h;
		}
	}
	public void setPhut(int m) {
		if (m >=0 & m <= 59) {
			phut = m;
		}
	}
	public void setGiay(int s) {
		if (s >=0 & s <= 59) {
			giay = s;
		}
	}
	
	// Getters
	public int getGio() {
		return gio;
	}
	public int getPhut() {
		return phut;
	}
	public int getGiay() {
		return giay;
	}
	
	
	// Ham nhap
	public void nhap() {
		int h, m, s;
		System.out.println("Nhap lan luot gio, phut, giay: ");
		h = scanner.nextInt();
		m = scanner.nextInt();
		s = scanner.nextInt();
		while(true) {
			if (h >=0 & h <= 23) {
				if(m >= 0 & m <= 59) {
					if(s>=0 & s<=59) {
						break;
					} else {
						System.out.println("Giay phai nam trong khoang 0 den 59, moi nhap lai: ");
					}
				} else {
					System.out.println("Phut phai nam trong khoang 0 den 59, moi nhap lai: ");
				}
			} else {
				System.out.println("Gio phai nam trong khoang 0 den 23, moi nhap lai: ");
			}
		}
		gio = h;
		phut = m;
		giay = s;
		giaTri = gio*3600 + phut*60 + s;
	}
	
	// Ham xuat
	public void xuat() {
		System.out.printf("%2d:%2d:%2d", gio, phut, giay);
	}
	
	// Ham tang 1 s
	public void tang1s() {
		this.giay += 1;
		if(giay == 60) {
			giay = 0;
			phut += 1;
			if(phut == 60) {
				phut = 0;
				gio += 1;
				if(gio == 24) {
					gio = 0;
				}
			}
		}
	}
	
	// So sanh
	public int soSanh(Time t2) {
		if(this.giaTri > t2.giaTri) return 1;
		else if(this.giaTri < t2.giaTri) return -1;
		else return 0;
	}
	
	// Ham main
	public static void main(String[] args) {
		Time t1 = new Time();
		t1.nhap();
		Time t2 = new Time();
		t2.nhap();
		System.out.println("T1 la: ");
		t1.xuat();
		System.out.println("\nT2 la: ");
		t2.xuat();
		
		System.out.println("\nKet qua so sanh 2 thoi gian: ");
		int kqSS = t1.soSanh(t2);
		if(kqSS == 0) System.out.println("2 thoi gian bang nhau");
		else if(kqSS == 1) System.out.println("t1 lon hon");
		else System.out.println("t2 lon hon");
		
		System.out.println("\nSau khi tang them 1s: ");
		t1.tang1s();
		t2.tang1s();
		System.out.println("T1 la: ");
		t1.xuat();
		System.out.println("\nT2 la: ");
		t2.xuat();
		
		scanner.close();
	}
}
