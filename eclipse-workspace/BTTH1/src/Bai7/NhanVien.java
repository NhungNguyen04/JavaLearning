package Bai7;

public class NhanVien extends NhanSu {

	protected String tenDonVi;
	
	public NhanVien(String hoTen, String ngaySinh, double heSoLuong, String tenDV) {
        super(hoTen, ngaySinh, heSoLuong);
        tenDonVi = tenDV;
    }


    @Override
    public double tinhLuong() {
        return (heSoLuong) * 1200000;
    }

    @Override
    public String getTenDonVi() {
        return tenDonVi;
    }
}
