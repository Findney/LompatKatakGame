/**
 * Kelas abstrak Makhluk merupakan kelas dasar untuk merepresentasikan makhluk dalam suatu permainan.
 * Kelas ini memiliki properti nilai dan nama yang dapat diakses oleh kelas turunannya.
 */
public abstract class Makhluk {
    /** Nilai dari makhluk. */
    protected int nilai;

    /** Nama dari makhluk. */
    protected String nama;

    /**
     * Konstruktor default untuk objek Makhluk.
     */
    public Makhluk() {
        // Kosong karena tidak ada inisialisasi khusus yang diperlukan.
    }

    /**
     * Konstruktor untuk membuat objek Makhluk dengan nama dan nilai tertentu.
     *
     * @param nama  Nama makhluk.
     * @param nilai Nilai makhluk.
     */
    public Makhluk(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    /**
     * Mengembalikan nilai makhluk.
     *
     * @return Nilai makhluk.
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * Mengembalikan nama makhluk.
     *
     * @return Nama makhluk.
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Metode abstrak untuk mendapatkan jenis nama berdasarkan nilai tertentu.
     *
     * @param nilai Nilai makhluk.
     * @return Jenis nama makhluk berdasarkan nilai.
     */
    public abstract String getJenisNamaByNilai(int nilai);
}
