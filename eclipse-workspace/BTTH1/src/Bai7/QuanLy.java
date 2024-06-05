package Bai7;

public class QuanLy extends NhanSu {

    private int soLuongNhanVienQuanLy;

    public QuanLy(String hoTen, String ngaySinh, double heSoLuong, int soLuongNhanVienQuanLy) {
        super(hoTen, ngaySinh, heSoLuong);
        this.soLuongNhanVienQuanLy = soLuongNhanVienQuanLy;
    }

    public int getSoLuongNhanVienQuanLy() {
        return soLuongNhanVienQuanLy;
    }

    public void setSoLuongNhanVienQuanLy(int soLuongNhanVienQuanLy) {
        this.soLuongNhanVienQuanLy = soLuongNhanVienQuanLy;
    }

    @Override
    public double tinhLuong() {
        return (heSoLuong + 0.5) * 1200000;
    }

    @Override
    public String getTenDonVi() {
        return "Bộ phận quản lý";
    }
}
