package Bai5;

public class NhanVien implements Measurable {

    private String hoTen;
    private String maNV;
    private int soGioLam;
    private double giaTheoGio;

    public NhanVien(String hoTen, String maNV, int soGioLam, double giaTheoGio) {
        this.hoTen = hoTen;
        this.maNV = maNV;
        this.soGioLam = soGioLam;
        this.giaTheoGio = giaTheoGio;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public double getGiaTheoGio() {
        return giaTheoGio;
    }

    public void setGiaTheoGio(double giaTheoGio) {
        this.giaTheoGio = giaTheoGio;
    }

    @Override
    public double Valuate() {
        return soGioLam * giaTheoGio;
    }
}
