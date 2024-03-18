import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QLDKHP {
	
	static Scanner scanner = new Scanner(System.in);
	
	// class sinh vien
	public class SinhVien {
		// Thuoc tinh
		private String MSSV;
		private String HoTen;
		private int soTCDK = 0;
		private ArrayList<String> MHDK = new ArrayList<String>();
		private ArrayList<LopHoc> LHDK = new ArrayList<LopHoc>();
		
		// Constructors
		private SinhVien() {}
		private SinhVien(String ms, String ten) {
			MSSV = ms;
			HoTen = ten;
		}
		
		// Ham nhap
		public void nhap() {	
			System.out.println("Nhap ma so sinh vien: ");
			MSSV = scanner.nextLine();
			System.out.println("Nhap ho ten: ");
			HoTen = scanner.nextLine();
		}
		
		// Ham xuat
		public void xuat() {
			System.out.println(MSSV+" - "+HoTen);
		}
	}
	
	// Class mon hoc
	public class MonHoc {
		String tenMH;
		ArrayList<LopHoc> lop;
		int soSV = 0;
		
		private MonHoc(String tenMon) {
			tenMH = tenMon;
			lop = new ArrayList<LopHoc>();
		}
	}
	
	// Cac class phu
	public class tgHoc{
		int tietbd, tietkt, thu;
		
		private tgHoc(int BD, int KT, int Thu) {
			tietbd = BD;
			tietkt = KT;
			thu = Thu;
		}
	}
	
	public class date{
		int ngay, thang, nam;
		
		private date(int d, int m, int y) {
			ngay = d;
			thang = m;
			nam = y;
		}
		public void xuat() {
			System.out.printf("%2d/%2d/%4d", ngay, thang, nam);
		}
	}
	
	// Class lop hoc
	public class LopHoc {
		
		// thuoc tinh
		private String malop;
		private MonHoc tenmon;
		private int sotc;
		private tgHoc tg;
		private date tgbd, tgkt;
		private int soSV;
		
		// Constructor
		private LopHoc() {}
		private LopHoc(String ml, String tm, int tc, 
				int tietBD, int tietKT, int Thu, 
				int dbd, int mbd, int ybd,
				int dkt, int mkt, int ykt) {
			malop = ml;
			sotc = tc;
			tg = new tgHoc(tietBD, tietKT, Thu);
			tgbd = new date (dbd, mbd, ybd);
			tgkt = new date (dkt, mkt, ykt);
		}
		
		// Ham nhap
		public void nhap() {
			System.out.println("Nhap ma lop: ");
			malop = scanner.nextLine();
			sotc = scanner.nextInt();
			System.out.println("Nhap thoi gian hoc (tiet bat dau, tiet ket thuc, thu): ");
			tg = new tgHoc(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			System.out.println("Nhap thoi gian bat dau, ket thuc hoc ky (ngay, thang nam): ");
			tgbd = new date (scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			tgkt = new date (scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		}		
	}
	
	public class Main {
		
		// thuoc tinh
		private int n, m;
		ArrayList<SinhVien> sv;
		ArrayList<LopHoc> lh;
		ArrayList<MonHoc> mh;
		
		// ham nhap
		public void nhapSV() {
			System.out.println("Nhap so sinh vien: ");
			n = scanner.nextInt();
			for (int i=0; i<n; i++) {
				SinhVien sv1 = new SinhVien();
				sv1.nhap();
				sv.add(sv1);
			}
			System.out.println("Nhap so lop hoc: ");
			m = scanner.nextInt();
			for (int i=0; i<m; i++) {
				LopHoc lh1 = new LopHoc();
				System.out.println("Nhap mon hoc: ");
				String monHoc = scanner.nextLine();
				int flag = 0;
				for(MonHoc mon: mh) {
					if (mon.tenMH == monHoc) {
						mon.lop.add(lh1);
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					MonHoc mon = new MonHoc(monHoc);
					mon.lop.add(lh1);
				}
				lh1.nhap();
				lh.add(lh1);
			}
		}
		
		// ham dkhp
		public void dkHP() {
			System.out.println("Nhap mssv cua ban: ");
			String ms = scanner.nextLine();
			System.out.println("Nhap mon hoc muon dang ky: ");
			String mon = scanner.nextLine();
			
			for(LopHoc lop: lh) {
				if (lop.tenmon.tenMH == mon) {
					for(SinhVien sv: sv) {
						if(sv.MSSV == ms) {
							if (sv.soTCDK >= 14 & sv.soTCDK+lop.sotc <=24 & sv.MHDK.contains(mon)==false) {
								sv.MHDK.add(mon);
								sv.LHDK.add(lop);
								lop.soSV += 1;
								break;
							} else {
								System.out.println("Khong them duoc");
							}
						}
					}
				} else {
					System.out.println("Khong co mon nay");
				}
			}
		}
		
		// Xuat ra mon hoc co so sinh vien dang ky nhieu nhat
		public MonHoc monNhieuDK() {
			for (MonHoc mon: mh) {
				for(LopHoc lop: mon.lop) {
					mon.soSV += lop.soSV;
				}
			}
			
			Collections.sort(mh, new Comparator<MonHoc>() {
				@Override
				public int compare(MonHoc mh1, MonHoc mh2) {
					return mh1.soSV - mh2.soSV;
				}
			});		
			return mh.get(0);
		}
		
		// SV dang ki nhieu tin chi nhat
		public SinhVien svdkNhieuTCNhat() {
			Collections.sort(sv, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					return sv1.soTCDK - sv2.soTCDK;
				}
			});		
			return sv.get(0);
		}
		
		// SV dang ky nhieu mon nhat
		public SinhVien svdkNhieuMonNhat() {
			Collections.sort(sv, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					return sv1.MHDK.size() - sv2.MHDK.size();
				}
			});		
			return sv.get(0);
		}
		
		// Xuat lich hoc sv
		public void xuatLichHoc(SinhVien sinhVien) {
			Collections.sort(sinhVien.LHDK, new Comparator<LopHoc>() {
				@Override
				public int compare(LopHoc lh1, LopHoc lh2) {
					return lh1.tg.thu - lh2.tg.thu;
				}
			});		
			System.out.println("Lich hoc cua sinh vien nay la: ");
			for (LopHoc lh: sinhVien.LHDK) {
				System.out.println(lh.malop + " - mon hoc: " + lh.tenmon.tenMH + " - thu: " + lh.tg.thu);
			}
		}
	}
}