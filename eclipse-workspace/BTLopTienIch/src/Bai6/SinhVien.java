package Bai6;

public class SinhVien {
	private String MSSV;
    private String hoTen;
    private double diemTB;
    private double diemRL;

    public SinhVien(String MSSV, String hoTen, double diemTB, double diemRL) {
        this.MSSV = MSSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.diemRL = diemRL;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public double getDiemRL() {
        return diemRL;
    }

    public void setDiemRL(double diemRL) {
        this.diemRL = diemRL;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %5.2f %5.2f", MSSV, hoTen, diemTB, diemRL);
    }
    
}
