import java.util.Scanner;

// Kelas dasar untuk menyimpan informasi faktur
class Faktur {
    protected String noFaktur;      // Nomor faktur
    protected String kodeBarang;     // Kode barang
    protected String namaBarang;     // Nama barang
    protected double hargaBarang;    // Harga per unit barang
    protected int jumlahBeli;        // Jumlah barang yang dibeli

    // Konstruktor untuk inisialisasi atribut
    public Faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.noFaktur = noFaktur;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }

    // Metode untuk menghitung total harga
    public double hitungTotal() {
        return hargaBarang * jumlahBeli;
    }
}

// Kelas turunan dari Faktur yang khusus untuk faktur penjualan
class FakturPenjualan extends Faktur {

    // Konstruktor yang memanggil konstruktor kelas dasar (super)
    public FakturPenjualan(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
    }

    // Metode untuk menampilkan informasi faktur
    public void tampilkanFaktur() {
        double total = hitungTotal(); // Menghitung total
        System.out.println("No Faktur: " + noFaktur);
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Harga Barang: " + hargaBarang);
        System.out.println("Jumlah Beli: " + jumlahBeli);
        System.out.println("Total: " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Mengambil input dari pengguna
            System.out.print("Masukkan No Faktur: ");
            String noFaktur = scanner.nextLine();
            System.out.print("Masukkan Kode Barang: ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            double hargaBarang = scanner.nextDouble();
            // Memeriksa apakah harga barang negatif
            if (hargaBarang < 0) {
                throw new IllegalArgumentException("Harga barang tidak boleh negatif.");
            }

            System.out.print("Masukkan Jumlah Beli: ");
            int jumlahBeli = scanner.nextInt();
            // Memeriksa apakah jumlah beli negatif
            if (jumlahBeli < 0) {
                throw new IllegalArgumentException("Jumlah beli tidak boleh negatif.");
            }

            // Membuat objek FakturPenjualan dan menampilkan faktur
            FakturPenjualan faktur = new FakturPenjualan(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);
            faktur.tampilkanFaktur();

        } catch (IllegalArgumentException e) {
            // Menangani kesalahan yang disebabkan oleh input yang tidak valid
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } catch (Exception e) {
            // Menangani kesalahan lainnya yang tidak terduga
            System.out.println("Kesalahan tidak terduga: " + e.getMessage());
        } finally {
            // Menutup scanner untuk mencegah kebocoran sumber daya
            scanner.close();
        }
    }
}