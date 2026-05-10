import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Array menu
        Menu[] menu = new Menu[8];

        menu[0] = new Menu("Nasi Padang", 25000, "Makanan");
        menu[1] = new Menu("Mie Ayam", 20000, "Makanan");
        menu[2] = new Menu("Ayam Goreng", 30000, "Makanan");
        menu[3] = new Menu("Sate", 28000, "Makanan");

        menu[4] = new Menu("Es Teh", 5000, "Minuman");
        menu[5] = new Menu("Jus Alpukat", 15000, "Minuman");
        menu[6] = new Menu("Kopi", 10000, "Minuman");
        menu[7] = new Menu("Air Mineral", 4000, "Minuman");

        // ===== TAMPIL MENU TANPA LOOP =====
        System.out.println("===== MENU MAKANAN =====");
        tampil(menu, 0);
        tampil(menu, 1);
        tampil(menu, 2);
        tampil(menu, 3);

        System.out.println("\n===== MENU MINUMAN =====");
        tampil(menu, 4);
        tampil(menu, 5);
        tampil(menu, 6);
        tampil(menu, 7);

        // ===== INPUT =====
        System.out.println("\nMasukkan pesanan (index & jumlah)");

        System.out.print("Pesanan 1 index: ");
        int i1 = input.nextInt();
        System.out.print("Jumlah: ");
        int j1 = input.nextInt();

        System.out.print("Pesanan 2 index: ");
        int i2 = input.nextInt();
        System.out.print("Jumlah: ");
        int j2 = input.nextInt();

        System.out.print("Pesanan 3 index: ");
        int i3 = input.nextInt();
        System.out.print("Jumlah: ");
        int j3 = input.nextInt();

        System.out.print("Pesanan 4 index: ");
        int i4 = input.nextInt();
        System.out.print("Jumlah: ");
        int j4 = input.nextInt();

        // ===== HITUNG TOTAL =====
        int t1 = menu[i1].harga * j1;
        int t2 = menu[i2].harga * j2;
        int t3 = menu[i3].harga * j3;
        int t4 = menu[i4].harga * j4;

        int total = t1 + t2 + t3 + t4;

        // ===== DISKON & BONUS =====
        double diskon = 0;
        boolean bonus = false;

        if (total > 100000) {
            diskon = total * 0.1;
        } else {
            diskon = 0;
        }

        if (total > 50000) {
            bonus = true;
        } else {
            bonus = false;
        }

        double setelahDiskon = total - diskon;
        double pajak = setelahDiskon * 0.1;
        int service = 20000;

        double grandTotal = setelahDiskon + pajak + service;

        // ===== STRUK =====
        System.out.println("\n===== STRUK =====");

        cetak(menu[i1], j1, t1);
        cetak(menu[i2], j2, t2);
        cetak(menu[i3], j3, t3);
        cetak(menu[i4], j4, t4);

        System.out.println("----------------------");
        System.out.println("Total Awal   : Rp " + total);

        if (diskon > 0) {
            System.out.println("Diskon 10%   : Rp " + diskon);
        } else {
            System.out.println("Diskon       : Tidak ada");
        }

        if (bonus) {
            System.out.println("Bonus        : Beli 1 Gratis 1 Minuman");
        } else {
            System.out.println("Bonus        : Tidak ada");
        }

        System.out.println("Pajak 10%    : Rp " + pajak);
        System.out.println("Service      : Rp " + service);
        System.out.println("TOTAL BAYAR  : Rp " + grandTotal);
    }

    // Method tampil menu per item
    static void tampil(Menu m[], int i) {
        System.out.println(i + ". " + m[i].nama + " - Rp " + m[i].harga);
    }

    // Method cetak struk per item
    static void cetak(Menu m, int jumlah, int total) {
        System.out.println(m.nama + " x" + jumlah + " = Rp " + total);
    }
}