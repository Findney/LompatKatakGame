/**
 * Kelas Monster merupakan turunan dari kelas Makhluk, merepresentasikan monster dalam suatu permainan.
 */
public class Monster extends Makhluk {

    /**
     * Konstruktor default untuk objek Monster.
     */
    public Monster() {
        // Kosong karena tidak ada inisialisasi khusus yang diperlukan.
    }

    /**
     * Konstruktor untuk membuat objek Monster dengan nama dan nilai tertentu.
     *
     * @param nama  Nama monster.
     * @param nilai Nilai monster.
     */
    public Monster(String nama, int nilai) {
        super(nama, nilai);
    }

    /**
     * Mengembalikan jenis nama monster berdasarkan nilai tertentu.
     *
     * @param nilai Nilai monster.
     * @return Nama jenis monster (Goblin, Witch, Dragon, Godzilla) berdasarkan nilai.
     *         Jika nilai tidak sesuai dengan kriteria, mengembalikan null.
     */
    @Override
    public String getJenisNamaByNilai(int nilai) {
        if (nilai <= -1 && nilai >= -40) {
            return this.nama = "Goblin";
        } else if (nilai <= -41 && nilai >= -75) {
            return this.nama = "Witch";
        } else if (nilai <= -76 && nilai >= -120) {
            return this.nama = "Dragon";
        } else if (nilai <= -121 && nilai >= -170) {
            return this.nama = "Godzilla";
        } else {
            return null;
        }
    }
}
