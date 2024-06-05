package Bai6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
    private static Vector<SinhVien> danhSachSV_Vector = new Vector<>();
    private static ArrayList<SinhVien> danhSachSV_ArrayList = new ArrayList<>();

    public static void nhapDanhSachSV() {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Tiêu thụ dòng mới còn sót

        for (int i = 0; i < n; i++) {
            System.out.println("\nSinh viên " + (i + 1) + ":");
            System.out.print("MSSV: ");
            String MSSV = scanner.nextLine();
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Điểm trung bình: ");
            double diemTB = scanner.nextDouble();
            System.out.print("Điểm rèn luyện: ");
            double diemRL = scanner.nextDouble();
            scanner.nextLine();

            SinhVien sv = new SinhVien(MSSV, hoTen, diemTB, diemRL);
            danhSachSV_Vector.add(sv);
            danhSachSV_ArrayList.add(sv);
        }
    }
    
    public static void nhapDanhSachSV(int m) {
    	for (int i = 0; i < m; i++) {
            System.out.println("\nSinh viên " + (i + 1) + ":");
            System.out.print("MSSV: ");
            String MSSV = scanner.nextLine();
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Điểm trung bình: ");
            double diemTB = scanner.nextDouble();
            System.out.print("Điểm rèn luyện: ");
            double diemRL = scanner.nextDouble();
            scanner.nextLine();

            SinhVien sv = new SinhVien(MSSV, hoTen, diemTB, diemRL);
            danhSachSV_Vector.add(sv);
            danhSachSV_ArrayList.add(sv);
    	}
    }
    	
    public static void sapXepTheoDiemTB() {
        // Sắp xếp cho cả 2 danh sách Vector và ArrayList (sử dụng Collections.sort)
        danhSachSV_Vector.sort((sv1, sv2) -> {
            double diff = sv2.getDiemTB() - sv1.getDiemTB();
            if (diff == 0) {
                return Double.compare(sv2.getDiemRL(), sv1.getDiemRL()); 
            } else {
                return diff > 0 ? 1 : -1;
            }
        });
        // Tương tự cho 'danhSachSV_ArrayList' 
    }

    public static void hienThiDanhSachSV() {
        System.out.println("\nDanh sách sinh viên (Vector):");
        System.out.println(String.format("%-10s %-20s %5s %5s", "MSSV", "HoTen", "DiemTB", "DiemRL"));
        for (SinhVien sv : danhSachSV_Vector) {
            System.out.println(sv);
        }
        // Tương tự cho 'danhSachSV_ArrayList'
    }

    public static void xoaSV_DiemTB_DiemRL() {
        danhSachSV_Vector.removeIf(sv -> sv.getDiemTB() < 5 || sv.getDiemRL() < 50);
        // Tương tự cho 'danhSachSV_ArrayList'
    }

    public static void chenDanhSachSV(int k) {
        // Giả sử bạn đã có danh sách sinh viên cần chèn trong 'danhSachSV_Moi'
    	ArrayList<SinhVien> danhSachSV_Moi = new ArrayList<>();
    	
        danhSachSV_Vector.addAll(k, danhSachSV_Moi); 
        //  Tương tự cho 'danhSachSV_ArrayList'
    }

    public static void demSV_LoaiGioi() {
        int dem = 0;
        for (SinhVien sv : danhSachSV_Vector) {
            if (sv.getDiemTB() >= 8 && sv.getDiemRL() >= 80) {
                dem++;
            }
        }
        System.out.println("Số sinh viên loại giỏi: " + dem);
    } 

    public static void main(String[] args) {
    	
        nhapDanhSachSV();

        // b. Hiển thị danh sách theo điểm TB giảm dần
        sapXepTheoDiemTB();
        hienThiDanhSachSV();

        // c. Xóa sinh viên có điểm TB hoặc điểm RL thấp
        xoaSV_DiemTB_DiemRL();
        hienThiDanhSachSV();

        // d. Chèn danh sách sinh viên và đếm số lượng sinh viên đạt loại Giỏi
        System.out.println("Nhap so sinh vien muon chen: ");
        int m = scanner.nextInt();
        System.out.println("Nhap vi tri muon chen: ");
        int k = scanner.nextInt();
        nhapDanhSachSV(m);
        chenDanhSachSV(k);
        hienThiDanhSachSV();
        demSV_LoaiGioi();
    }
}
