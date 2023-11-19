/**
 * Kelas abstrak Entitas merupakan kelas dasar untuk merepresentasikan Entitas dalam suatu permainan.
 * Kelas ini memiliki properti nilai dan nama yang dapat diakses oleh kelas turunannya.
 */
public abstract class Entitas {
    /** Nilai dari Entitas. */
    protected int nilai;

    /** Nama dari Entitas. */
    protected String nama;

    /**
     * Konstruktor default untuk objek Entitas.
     */
    public Entitas() {
        // Kosong karena tidak ada inisialisasi khusus yang diperlukan.
    }

    /**
     * Konstruktor untuk membuat objek Entitas dengan nama dan nilai tertentu.
     *
     * @param nama  Nama Entitas.
     * @param nilai Nilai Entitas.
     */
    public Entitas(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    /**
     * Mengembalikan nilai Entitas.
     *
     * @return Nilai Entitas.
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * Mengembalikan nama Entitas.
     *
     * @return Nama Entitas.
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Metode abstrak untuk mendapatkan jenis nama berdasarkan nilai tertentu.
     *
     * @param nilai Nilai Entitas.
     * @return Jenis nama Entitas berdasarkan nilai.
     */
    public abstract String getJenisNamaByNilai(int nilai);
}
