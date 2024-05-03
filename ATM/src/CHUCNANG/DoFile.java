package CHUCNANG;

import KHACHHANG.KhachHang_GiaoDich;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoFile {
    private String fileName = "KhachHang.txt";

    public DoFile(String fileName) {
        this.fileName = fileName;
    }

    public void write(List<KhachHang_GiaoDich> khachHangs) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (KhachHang_GiaoDich kh : khachHangs) {
                writer.println(kh.getMaKH() + "," + kh.getTenKH() + "," + kh.getDiachiKH()
                        + "," + kh.getSdtKH() + "," + kh.getLoaiKH() + "," + kh.getSoduKH() + "," + kh.getMatkhauKH());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<KhachHang_GiaoDich> read() {
        List<KhachHang_GiaoDich> khachHangs = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] fields = data.split(",");
                KhachHang_GiaoDich kh = new KhachHang_GiaoDich();
                kh.setMaKH(Long.parseLong(fields[0]));
                kh.setTenKH(fields[1]);
                kh.setDiachiKH(fields[2]);
                kh.setSdtKH(fields[3]);
                kh.setLoaiKH(fields[4]);
                kh.setSoduKH(Long.parseLong(fields[5]));
                kh.setMatkhauKH(fields[6]);
                khachHangs.add(kh);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return khachHangs;
    }
}
