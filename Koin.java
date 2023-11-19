/**
 * Kelas Koin merepresentasikan objek koin dalam suatu permainan.
 * Koin merupakan turunan dari kelas Makhluk.
 */
public class Koin extends Makhluk {

    /**
     * Konstruktor default untuk objek Koin.
     */
    public Koin() {
        // Kosong karena tidak ada inisialisasi khusus yang diperlukan.
    }

    /**
     * Konstruktor untuk membuat objek Koin dengan nama dan nilai tertentu.
     *
     * @param nama  Nama koin.
     * @param nilai Nilai koin.
     */
    public Koin(String nama, int nilai) {
        super(nama, nilai);
    }

    /**
     * Mengembalikan jenis nama koin berdasarkan nilai tertentu.
     *
     * @param nilai Nilai koin.
     * @return Nama jenis koin (Bronze, Silver, Gold, Platinum) berdasarkan nilai.
     *         Jika nilai tidak sesuai dengan kriteria, mengembalikan null.
     */
    @Override
    public String getJenisNamaByNilai(int nilai) {
        if (nilai >= 1 && nilai <= 40) {
            return this.nama = "Bronze";
        } else if (nilai >= 41 && nilai <= 75) {
            return this.nama = "Silver";
        } else if (nilai >= 76 && nilai <= 120) {
            return this.nama = "Gold";
        } else if (nilai >= 121 && nilai <= 170) {
            return this.nama = "Platinum";
        } else {
            return null;
        }
    }
}
