package Bai5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng nhân viên và sinh viên
        System.out.print("Nhập số lượng nhân viên: ");
        int n = scanner.nextInt();
        System.out.print("Nhập số lượng sinh viên: ");
        int m = scanner.nextInt();

        // Tạo danh sách chung
        List<Measurable> danhSach = new ArrayList<>();

        // Nhập thông tin nhân viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            scanner.nextLine();
            String hoTen = scanner.nextLine();
            String maNV = scanner.nextLine();
            int soGioLam = scanner.nextInt();
            double giaTheoGio = scanner.nextDouble();
            danhSach.add(new NhanVien(hoTen, maNV, soGioLam, giaTheoGio));
        }
        for (int i = 0; i < m; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            scanner.nextLine();
            String hoTen = scanner.nextLine();
            String maSV = scanner.nextLine();
            double diemToan = scanner.nextDouble();
            double diemLy = scanner.nextDouble();
            double diemHoa = scanner.nextDouble();
            danhSach.add(new SinhVien(hoTen, maSV, diemToan, diemLy, diemHoa));
        }
        
     // Tính toán lương trung bình của nhân viên
        double tongLuong = 0;
        for (Measurable nv : danhSach) {
            if (nv instanceof NhanVien) {
                tongLuong += nv.Valuate();
            }
        }
        double lươngTrungBinhNV = tongLuong / n;

        // Tính toán điểm trung bình của sinh viên
        double tongDiem = 0;
        for (Measurable sv : danhSach) {
            if (sv instanceof SinhVien) {
                tongDiem += sv.Valuate();
            }
        }
        double diemTrungBinhSV = tongDiem / m;

        // In kết quả
        System.out.println("Lương trung bình của nhân viên: " + lươngTrungBinhNV);
        System.out.println("Điểm trung bình của sinh viên: " + diemTrungBinhSV);
    }
}