/**
 * Kelas Koin digunakan untuk merepresentasikan koin dengan nilai dan nama
 * tertentu.
 */
public class Koin {
    private int nilai; // Nilai koin
    private String nama; // Nama koin

    /**
     * Konstruktor default untuk kelas Koin.
     */
    public Koin() {
        // Konstruktor default
    }

    /**
     * Konstruktor untuk membuat objek Koin dengan nama dan nilai tertentu.
     *
     * @param nama  Nama koin.
     * @param nilai Nilai koin.
     */
    public Koin(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    /**
     * Mendapatkan nilai koin.
     *
     * @return Nilai koin.
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * Mengatur nilai koin.
     *
     * @param nilai Nilai koin yang akan diatur.
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    /**
     * Mendapatkan nama koin.
     *
     * @return Nama koin.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mendapatkan jenis koin berdasarkan nilai tertentu.
     *
     * @param nilai Nilai koin yang akan digunakan untuk menentukan jenis.
     * @return Nama jenis koin (Bronze, Silver, Gold, Platinum) atau null jika nilai
     *         tidak valid.
     */
    public String getJenisKoinByNilai(int nilai) {
        if (nilai >= 1 && nilai <= 40) {
            return this.nama="Bronze";
        } else if (nilai >= 41 && nilai <= 75) {
            return this.nama="Silver";
        } else if (nilai >= 76 && nilai <= 120) {
            return this.nama="Gold";
        } else if (nilai >= 121 && nilai <= 170) {
            return this.nama="Platinum";
        } else {
            return null;
        }
    }
}
