package KHACHHANG;

import CHUCNANG.RangBuoc;

public class KhachHang_GiaoDich extends KhachHang {
    protected String loaiKH;
    protected String matkhauKH;
    protected long soduKh;

    public String getMatkhauKH() {
        return matkhauKH;
    }

    public void setMatkhauKH(String matkhauKH) {
        this.matkhauKH = matkhauKH;
    }

    public long getSoduKH() {
        return soduKh;
    }

    public void setSoduKH(long soduKh) {
        this.soduKh = soduKh;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public void nhap() {
        super.nhap();
        System.out.print("Tao mat khau cho tai khoan: ");
        matkhauKH = RangBuoc.rbMatkhau();

        System.out.print("Nhap so du: ");
        soduKh = RangBuoc.rbSodu();
        if (soduKh > 0 && soduKh < 10000000) {
            setLoaiKH("Thuong");
        }
        else {
            setLoaiKH("Vip");
        }
    }
    @Override
    public void xuat() {
        System.out.println("+===========================================================================================================================================+");
        System.out.println("|                                                           THONG TIN KHACH HANG                                                            |");
        System.out.print("+===========================================================================================================================================+\n");
        System.out.printf("%-3s %-14s %-10s %-19s %-4s %-16s %-15s %-21s %-4s %-6s %-2s %-12s %-2s", "|", "So tai khoan", "|", "Ho va ten", "|", "So dien thoai", "|", "Dia chi", "|", "Loai", "|", "So du kha dung", "|\n");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("%-3s %-15s %-30s %-21s %-38s %-12s %-14s %-2s", "|", getMaKH(), getTenKH(), getSdtKH(), getDiachiKH(), getLoaiKH(), getSoduKH(), "|\n" );
        System.out.println("+===========================================================================================================================================+\n");
    }

}
