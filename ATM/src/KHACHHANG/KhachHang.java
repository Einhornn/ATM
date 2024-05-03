package KHACHHANG;

import java.util.Scanner;
import CHUCNANG.RangBuoc;

public abstract class KhachHang {
    protected String tenKH;
    protected String sdtKH;
    protected String diachiKH;
    protected long maKH;
    public static Scanner inp = new Scanner(System.in);

    public long getMaKH() {
        return maKH;
    }

    public void setMaKH(long maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getDiachiKH() {
        return diachiKH;
    }

    public void setDiachiKH(String diachiKH) {
        this.diachiKH = diachiKH;
    }
    public void nhap() {
        System.out.print("Nhap ho va ten: ");
        tenKH = RangBuoc.rbTen();
        System.out.print("Nhap so dien thoai: ");
        sdtKH = RangBuoc.rbSdt();
        System.out.print("Nhap dia chi: ");
        diachiKH = inp.nextLine();
    }
    public abstract void xuat();
}
