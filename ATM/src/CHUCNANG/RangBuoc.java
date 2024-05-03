package CHUCNANG;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RangBuoc {

    public static Scanner inp = new Scanner(System.in);
    public static String rbSdt() {
        String Input;
        while (true) {
            Input = inp.nextLine();
            if (Input.matches("0" + "[0-9]{1,9}")) {
                return Input;
            } else {
                System.out.println("So dien thoai gom 10 chu so, dinh dang: 0____. Vi du: 0912345678");
            }
            System.out.print("Vui nhap lai dung dinh dang: ");
        }
    }
    public static String rbTen() {
        String input;
        while (true) {
            input = inp.nextLine();
            if (input.matches("[^0-9]+") && input.length() > 0) {
                return input;
            } else {
                System.out.println("Ten khong duoc co so. Vui long nhap lai.");
            }
            System.out.print("Vui long nhap ten dung dinh dang: ");
        }
    }
    public static String rbMatkhau() {
        String input;
        while (true) {
            input = inp.nextLine();
            if (input.length() >= 8 && input.matches(".*[A-Z].*") && input.matches(".*[a-z].*") && input.matches(".*[@#!&].*")) {
                return input;
            } else {
                System.out.println("Mat khau phai co 8 ky tu tro len, co ky tu in hoa, ky tu thuong, cac ky tu dac biet nhu @!#&");
            }
            System.out.print("Vui long nhap lai mat khau dung dinh dang: ");
        }
    }
    public static int rbChoice() {
        while (true) {
            try {
                int choice = inp.nextInt();
                inp.nextLine();
                if (choice >= 0) {
                    return choice;
                } else {
                    System.out.println("Nhap sai! Vui long nhap so nguyen khong am.");
                    System.out.print("Moi nhap lai: ");
                }
            } catch (Exception e) {
                System.out.println("Nhap sai! Vui long nhap so nguyen khong am.");
                System.out.print("Moi nhap lai: ");
                inp.nextLine();
            }
        }
    }
    public static String rbYN() {
        while (true) {
            String choice = inp.nextLine().trim().toLowerCase();
            if (choice.equals("y") || choice.equals("n")) {
                return choice;
            } else {
                System.out.println("Nhap sai! Vui long nhap y hoac n.");
                System.out.print("Moi nhap lai: ");
            }
        }
    }
    public static long rbSodu() {
        while (true) {
            try {
                long input = inp.nextLong();
                inp.nextLine();
                if (input >= 0) {
                    return input;
                } else {
                    System.out.println("Nhap so tien >= 0. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhap sai! Vui long nhap so nguyen khong am.");
                System.out.print("Vui long nhap lai: ");
                inp.nextLine();
            }
        }
    }

    public static long rbMaKH() {
        while (true) {
                try {
                long input = inp.nextLong();
                inp.nextLine();
                if (input >= 10000 && input <= 99999) {
                    return input;
                } else {
                    System.out.println("Ma khach hang gom 5 chu so, dinh dang: 10___. Vi du: 10001");
                }
                } catch (InputMismatchException e) {
                System.out.println("Nhap sai!Vui nhap lai dung dinh dang: ");
                inp.nextLine();
                }
        }
    }

}
