package Bai4;

import java.util.Scanner;

public class Complex {

    private double thuc;
    private double ao;

    public Complex() {
        this.thuc = 0;
        this.ao = 0;
    }

    public Complex(double thuc, double ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public double getThuc() {
        return thuc;
    }

    public void setThuc(double thuc) {
        this.thuc = thuc;
    }

    public double getAo() {
        return ao;
    }

    public void setAo(double ao) {
        this.ao = ao;
    }

    public Complex cong(Complex b) {
        return new Complex(this.thuc + b.thuc, this.ao + b.ao);
    }

    public Complex tru(Complex b) {
        return new Complex(this.thuc - b.thuc, this.ao - b.ao);
    }

    public Complex nhan(Complex b) {
        double real = this.thuc * b.thuc - this.ao * b.ao;
        double imag = this.thuc * b.ao + this.ao * b.thuc;
        return new Complex(real, imag);
    }

    public Complex chia(Complex b) {
        double scale = b.thuc * b.thuc + b.ao * b.ao;
        return nhan(new Complex(b.thuc / scale, -b.ao / scale));
    }
    
    // Ham nhap
    public void nhap() {
    	Scanner s = new Scanner(System.in);
    	System.out.println("Nhap phan thuc: ");
    	thuc = s.nextDouble();
    	System.out.println("Nhap phan ao: ");
    	ao = s.nextDouble();
    }

    @Override
    public String toString() {
        return String.format("%2f + %2f * i", thuc, ao);
    }
}
