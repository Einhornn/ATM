package GIAODICH;
import CHUCNANG.DoFile;
import CHUCNANG.PhuongThuc;
import CHUCNANG.RangBuoc;
import KHACHHANG.*;
import java.util.List;
import java.util.Scanner;

public class GiaoDich extends KhachHang_GiaoDich implements PhuongThuc {
    public List <KhachHang_GiaoDich> KHList;
    public DoFile file;
    public KhachHang_GiaoDich KHGD = null;
    public GiaoDich() {
        file = new DoFile("KhachHang.txt");
        KHList = file.read();
    }
    public static Scanner inp = new Scanner(System.in);
    public boolean checkTontai(KhachHang_GiaoDich KHM) {
        for (KhachHang KH : KHList) {
            if (KHM.getSdtKH().equals(KH.getSdtKH())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void tao() {
        System.out.println("+============================+");
        System.out.println("|        TAO TAI KHOAN       |");
        System.out.println("+----------------------------+");
        KhachHang_GiaoDich KHM = new KhachHang_GiaoDich();
        KHM.nhap();
        if (checkTontai(KHM)) {
            System.out.println("Da ton tai thong tin khach hang nay!");
        }
        else {
            long stk = 10000 + KHList.size();
            KHM.setMaKH(stk);
            KHList.add(KHM);
            file.write((KHList));
            System.out.println("TAO TAI KHOAN THANH CONG, SO TAI KHOAN CUA BAN LA " + KHM.getMaKH() + ", VUI LONG GHI NHO!");
        }
    }
    @Override
    public void chuyen() {
        if(KHList.isEmpty()) {
            System.out.println("KHONG CO DU LIEU");
            return;
        }
        System.out.println("+=================================+");
        System.out.println("|            CHUYEN TIEN          |");
        System.out.println("+---------------------------------+");
        System.out.print("| Nhap so tai khoan dich den: ");
        long matkdich = RangBuoc.rbMaKH();
        KhachHang_GiaoDich tkdich = null;
        for (KhachHang_GiaoDich KH : KHList) {
            if (KH.getMaKH() == matkdich) {
                tkdich = KH;
                break;
            }
        }
        if (tkdich == null) {
            System.out.println("TAI KHOAN DICH KHONG TON TAI, QUAY LAI!");
            return;
        }
        System.out.print("| Nhap so tien muon chuyen: ");
        long tienchuyen = RangBuoc.rbSodu();
        KhachHang_GiaoDich tknguon = KHGD;
        if (tknguon.getSoduKH() < tienchuyen) {
            System.out.println("SO TIEN TRONG TAI KHOAN KHONG DU, GIAO DICH KHONG THANH CONG!");
            return;
        }
        tknguon.setSoduKH(tknguon.getSoduKH() - tienchuyen);
        tkdich.setSoduKH(tkdich.getSoduKH() + tienchuyen);
        file.write(KHList);
        System.out.println("CHUYEN TIEN THANH CONG, SO DU KHA DUNG: " + tknguon.getSoduKH());
    }
    @Override
    public void nap() {
        if(KHList.isEmpty()) {
            System.out.println("KHONG CO DU LIEU");
            return;
        }
        System.out.println("+===========================+");
        System.out.println("|          NAP TIEN         |");
        System.out.println("+---------------------------+");
        KhachHang_GiaoDich tkNguon = KHGD;
        System.out.print("| Nhap so tien can nap: ");
        long tienNap = RangBuoc.rbSodu();
        tkNguon.setSoduKH(tkNguon.getSoduKH() + tienNap);
        file.write(KHList);
        System.out.println("NAP TIEN THANH CONG!");
        System.out.println("SO DU KHA DUNG: " + tkNguon.getSoduKH());
    }
    @Override
    public void rut() {
        if(KHList.isEmpty()) {
            System.out.println("KHONG CO DU LIEU");
            return;
        }
        System.out.println("+===========================+");
        System.out.println("|           RUT TIEN        |");
        System.out.println("+---------------------------+");
        KhachHang_GiaoDich tkNguon = KHGD;
        System.out.print("| Nhap so tien can rut: ");
        long tienRut = RangBuoc.rbSodu();
        if(tkNguon.getSoduKH() - 10000 < tienRut) {
            System.out.println("SO DU KHONG DU DE THUC HIEN GIAO DICH!");
            return;
        }
        tkNguon.setSoduKH(tkNguon.getSoduKH() - tienRut - 10000);
        file.write(KHList);
        System.out.println("RUT TIEN THANH CONG!");
        System.out.println("SO DU CON LAI: " + tkNguon.getSoduKH());
    }
    @Override
    public void xoa() {
        if(KHList.isEmpty()) {
            System.out.println("KHONG CO DU LIEU");
            return;
        }
        System.out.println("+---------------------------+");
        System.out.println("|        XOA TAI KHOAN      |");
        System.out.println("+---------------------------+");
        System.out.println("");
        KHGD.xuat();
        System.out.print("| Ban co chac chan muon xoa? (Y/N): ");
        if(!RangBuoc.rbYN().equalsIgnoreCase("Y")) {
            System.out.println("| Da huy lenh xoa tai khoan.");
            return;
        }
        KHList.remove(KHGD);
        file.write(KHList);
        System.out.println("\n| DA XOA TAI KHOAN KHOI HE THONG |\n" +
                           "|  BAN KHONG CON QUYEN TRUY CAP  |");
        System.exit(0);
    }
    @Override
    public void sua() {
        if(KHList.isEmpty()) {
            System.out.println("KHONG CO DU LIEU");
            return;
        }
        System.out.println("+---------------------------+");
        System.out.println("|        SUA THONG TIN      |");
        System.out.println("+---------------------------+");
        System.out.println("");
        KHGD.xuat();
        int choice;
        do {
            System.out.println("+---------------------------+");
            System.out.println("| 1. So dien thoai          |");
            System.out.println("| 2. Ho ten                 |");
            System.out.println("| 3. Dia chi                |");
            System.out.println("| 4. Mat khau               |");
            System.out.println("| 0. Thoat                  |");
            System.out.println("+---------------------------+");
            System.out.print("| Lua chon: ");
            choice = RangBuoc.rbChoice();
            switch(choice) {
                case 1:
                    System.out.print("| Nhap SDT moi: ");
                    String sdtMoi = RangBuoc.rbSdt();
                    int tontai = 0;
                    for(KhachHang_GiaoDich KH : KHList) {
                        if (KH.getSdtKH().equals(sdtMoi)) {
                            tontai++;
                        }
                    }
                    if (tontai == 0) {
                        KHGD.setSdtKH(sdtMoi);
                        System.out.println("| SDT da duoc cap nhat!");
                        break;
                    }
                    else {
                        System.out.println("| So dien thoai da duoc su dung, vui long dung so khac!");
                        break;
                    }
                case 2:
                    System.out.print("| Nhap ho ten moi: ");
                    String hoTenMoi = RangBuoc.rbTen();
                    KHGD.setTenKH(hoTenMoi);
                    System.out.println("| Ho ten da duoc cap nhat!");
                    break;
                case 3:
                    System.out.print("| Nhap dia chi moi: ");
                    String diachiMoi = inp.nextLine();
                    KHGD.setDiachiKH(diachiMoi);
                    System.out.println("| Dia chi moi da duoc cap nhat!");
                    break;
                case 4:
                    doimatkhau(KHGD);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("| Lua chon khong hop le!");
            }
        } while(choice != 0);
        file.write(KHList);
        System.out.println("| DA CAP NHAT THONG TIN TAI KHOAN!");
    }
    @Override
    public void doimatkhau(KhachHang_GiaoDich KH) {
        System.out.println("+=================================+");
        System.out.println("|           DOI MAT KHAU          |");
        System.out.println("+---------------------------------+");
        System.out.print("| Nhap so dien thoai: ");
        String sdt = RangBuoc.rbSdt();
        if (sdt.equals(KH.getSdtKH())) {
            System.out.print("| Nhap mat khau moi: ");
            String mk = RangBuoc.rbMatkhau();
            KH.setMatkhauKH(mk);
            System.out.println("DOI MAT KHAU THANH CONG! ");
        }
    }
    public void xuat() {
        super.xuat();
    }

    public void ThucHienGiaoDich() {
        System.out.println("BAN CO TAI KHOAN CHUA? (y/n)");
        String checktk = RangBuoc.rbYN();
        int cotk = 0;
        if (checktk.equals("y")) {
            cotk++;
        }
        if (cotk == 0) {
            System.out.println("BAN MUON TAO TAI KHOAN? (y/n)");
            String c = RangBuoc.rbYN();
            if (c.equals("y")) {
                tao();
            }
            else {
                System.out.println("KHONG THE THUC HIEN GIAO DICH!");
                    System.exit(0);
            }
        }
        System.out.println("+=================================+");
        System.out.println("|            DANG NHAP            |");
        System.out.println("+---------------------------------+");
        System.out.print("| So tai khoan: ");
        long stk = RangBuoc.rbMaKH();
        int found = 0;
        for (KhachHang_GiaoDich KH : KHList) {
            if (KH.getMaKH() == stk) {
                found++;
                KHGD = KH;
            }
        }
        if (found == 0) {
            System.out.println("KHONG TON TAI MA KHACH HANG NAY, VUI LONG THU LAI!");
        } else {
            System.out.print("| Mat khau: ");
            int enter = 0;
            while (enter < 4) {
                String mk = inp.nextLine(); 
                int choice;
                if (KHGD.getMatkhauKH().equals(mk)) {
                    do {
                        System.out.println("+=================================+");
                        System.out.println("|       SOMBRE LICORNE BANK       |");
                        System.out.println("+---------------------------------+");
                        System.out.println("| 1. Rut tien                     |");
                        System.out.println("| 2. Chuyen tien                  |");
                        System.out.println("| 3. Nap tien                     |");
                        System.out.println("| 4. Kiem tra thong tin, so du    |");
                        System.out.println("| 5. Sua thong tin tai khoan      |");
                        System.out.println("| 6. Xoa tai khoan                |");
                        System.out.println("| 0. Thoat giao dich              |");
                        System.out.println("+---------------------------------+");
                        System.out.println("|          CHON 1 HANH DONG       |");
                        System.out.println("+=================================+");
                        choice = RangBuoc.rbChoice();
                        switch (choice) {
                            case 1:
                                rut();
                                break;
                            case 2:
                                chuyen();
                                break;
                            case 3:
                                nap();
                                break;
                            case 4:
                                KHGD.xuat();
                                break;
                            case 5:
                                sua();
                                break;
                            case 6:
                                xoa();
                                break;
                            case 0:
                                System.out.println("THOAT GIAO DICH........");
                                System.exit(0);
                            default:
                                System.out.println("LUA CHON KHONG HOP LE!");
                        }
                    } while (choice != 0);
                } else {
                    if (enter == 3) {
                        System.out.println("NHAP SAI MAT KHAU QUA NHIEU, BAN MUON DOI MAT KHAU ?(y/n)");
                        String c = RangBuoc.rbYN();
                        if (c.equals("y")) {
                            doimatkhau(KHGD);
                            file.write((KHList));
                            System.out.println("VUI LONG THUC HIEN LAI DANG NHAP!");
                            break;
                        } else {
                            System.out.println("KHONG THE THUC HIEN GIAO DICH!");
                            System.exit(0);
                        }
                    }
                    else {
                        System.out.printf("SAI MAT KHAU, VUI LONG NHAP LAI: ");
                        enter ++;
                        continue;
                    }
                }
            }
        }
    }
}
