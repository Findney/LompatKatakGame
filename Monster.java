/**
 * Kelas Monster digunakan untuk merepresentasikan makhluk-makhluk dalam permainan.
 */
class Monster {
    private int nilai;
    private String nama;

    /**
     * Konstruktor default untuk kelas Monster.
     */
    public Monster() {
        // Konstruktor default
    }

    /**
     * Konstruktor parameter untuk kelas Monster.
     *
     * @param nama Nama monster.
     * @param nilai Nilai atau tingkat monster.
     */
    public Monster(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    /**
     * Mendapatkan nilai monster.
     *
     * @return Nilai monster.
     */
    public int getNilai() {
        return this.nilai;
    }

    /**
     * Mendapatkan nama monster.
     *
     * @return Nama monster.
     */
    public String getNama() {
        return this.nama;
    }

    /**
     * Mendapatkan jenis monster berdasarkan nilai tertentu.
     *
     * @param nilai Nilai yang akan digunakan untuk menentukan jenis monster.
     * @return Nama jenis monster berdasarkan nilai yang diberikan.
     */
    public String getJenisMonsterByNilai(int nilai) {
        if (nilai <= -1 && nilai >= -40) {
            return this.nama="Goblin";
        } else if (nilai <= -41 && nilai >= -75) {
            return this.nama="Witch";
        } else if (nilai <= -76 && nilai >= -120) {
            return this.nama="Dragon";
        } else if (nilai <= -121 && nilai >= -170) {
            return this.nama="Godzilla";
        } else {
            return null;
        }
    }
}
