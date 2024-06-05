package Bai7;

public class GiamDoc extends NhanSu {

    private double heSoChucVu;

    public GiamDoc(String hoTen, String ngaySinh, double heSoLuong, double heSoChucVu) {
        super(hoTen, ngaySinh, heSoLuong);
        this.heSoChucVu = heSoChucVu;
    }

    public double getHeSoChucVu() {
        return heSoChucVu;
    }

    public void setHeSoChucVu(double heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }

    @Override
    public double tinhLuong() {
        return (heSoLuong + heSoChucVu) * 1200000;
    }

    @Override
    public String getTenDonVi() {
        return "Ban Giám đốc";
    }
}
