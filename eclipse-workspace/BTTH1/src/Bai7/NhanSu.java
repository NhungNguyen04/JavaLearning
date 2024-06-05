package Bai7;

public abstract class NhanSu {
	private String hoTen;
    private String ngaySinh;
    protected double heSoLuong;

    public NhanSu(String hoTen, String ngaySinh, double heSoLuong) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.heSoLuong = heSoLuong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public abstract double tinhLuong();

    @Override
    public String toString() {
        return String.format("%s - %s - %.2f - %s", hoTen, ngaySinh, tinhLuong(), getTenDonVi());
    }

    public abstract String getTenDonVi();
}
