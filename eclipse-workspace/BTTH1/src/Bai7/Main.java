package Bai7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số lượng nhân viên
        System.out.print("Nhập số lượng nhân viên: ");
        int n = scanner.nextInt();

        // Danh sách nhân viên
        List<NhanSu> danhSach = new ArrayList<>();

        // Nhập thông tin nhân viên
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin nhân viên thứ " + (i + 1) + ":");
            System.out.print("Loại nhân viên (1 - Giám đốc, 2 - Quản lý, 3 - Nhân viên): ");
            int loaiNV = scanner.nextInt();
            scanner.nextLine();

            String hoTen = scanner.nextLine();
            String ngaySinh = scanner.nextLine();
            double heSoLuong = scanner.nextDouble();

            switch (loaiNV) {
                case 1:
                    System.out.print("Hệ số chức vụ: ");
                    double heSoChucVu = scanner.nextDouble();
                    danhSach.add(new GiamDoc(hoTen, ngaySinh, heSoLuong, heSoChucVu));
                    break;
                case 2:
                    System.out.print("Số lượng nhân viên quản lý: ");
                    int soLuongNhanVienQuanLy = scanner.nextInt();
                    danhSach.add(new QuanLy(hoTen, ngaySinh, heSoLuong, soLuongNhanVienQuanLy));
                    break;
                case 3:
                    System.out.print("Tên đơn vị: ");
                    String tenDonVi = scanner.nextLine();
                    danhSach.add(new NhanVien(hoTen, ngaySinh, heSoLuong, tenDonVi));
                    break;
            }
        }

        // Hiển thị thông tin nhân viên
        System.out.println("\nDanh sách nhân viên:");
        for (NhanSu ns : danhSach) {
            System.out.println(ns);
        }

        // Xuất nhân viên có lương cao nhất
        NhanSu nhanVienLuongCaoNhat = danhSach.get(0);
        for (NhanSu ns : danhSach) {
            if (ns.tinhLuong() > nhanVienLuongCaoNhat.tinhLuong()) {
                nhanVienLuongCaoNhat = ns;
            }
        }
        System.out.println("\nNhân viên có lương cao nhất:");
        System.out.println(nhanVienLuongCaoNhat);

        // Hiển thị nhân viên sinh trong tháng 2
        System.out.println("\nNhân viên sinh trong tháng 2:");
        for (NhanSu ns : danhSach) {
            if (ns.getNgaySinh().substring(5, 7).equals("02")) {
                System.out.println(ns);
            }
        }

        // Xuất thông tin nhân viên thuộc phòng "Kế toán"
        System.out.println("\nNhân viên thuộc phòng Kế toán:");
        for (NhanSu ns : danhSach) {
            if (ns instanceof NhanVien && ((NhanVien) ns).getTenDonVi().equals("Kế toán")) {
                System.out.println(ns);
            }
        }

        // Đếm số nhân viên tên "An"
        int soNhanVienTenAn = 0;
        for (NhanSu ns : danhSach) {
            if (ns.getHoTen().equals("An")) {
                soNhanVienTenAn++;
            }
        }
        System.out.println("\nSố nhân viên tên An: " + soNhanVienTenAn);
    }
}
