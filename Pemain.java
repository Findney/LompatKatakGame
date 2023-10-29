/**
 * Kelas Pemain digunakan untuk merepresentasikan seorang pemain dalam permainan.
 */
class Pemain {
    private String nama; // Nama pemain
    private int nilai;    // Nilai pemain

    /**
     * Konstruktor untuk membuat objek Pemain dengan nama tertentu.
     *
     * @param nama Nama pemain yang akan diatur.
     */
    public Pemain(String nama) {
        this.nama = nama;
        this.nilai = 0;
    }

    /**
     * Mengembalikan nama pemain.
     *
     * @return Nama pemain.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengatur nama pemain.
     *
     * @param nama Nama pemain yang baru.
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mengembalikan nilai pemain.
     *
     * @return Nilai pemain.
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Mengatur nilai pemain.
     *
     * @param nilaiBaru Nilai baru yang akan diatur untuk pemain.
     */
    public void setNilai(int nilaiBaru) {
        nilai = nilaiBaru;
    }

    /**
     * Mengembalikan nama level berdasarkan nomor level yang diberikan.
     *
     * @param level Nomor level.
     * @return Nama level yang sesuai dengan nomor level.
     */
    public String getNamaLevel(int level) {
        switch (level) {
            case 1:
                return "Easy";
            case 2:
                return "Intermediate";
            case 3:
                return "Hard";
            case 4:
                return "Impossible";
            default:
                return "Unknown";
        }
    }
}
