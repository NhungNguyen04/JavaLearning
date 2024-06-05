package Bai5;

public class SinhVien implements Measurable {

    private String hoTen;
    private String maSV;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public SinhVien(String hoTen, String maSV, double diemToan, double diemLy, double diemHoa) {
        this.hoTen = hoTen;
        this.maSV = maSV;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    @Override
    public double Valuate() {
        return (diemToan + diemLy + diemHoa) / 3;
    }
}

