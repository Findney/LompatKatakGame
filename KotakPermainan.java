import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Kelas KotakPermainan digunakan untuk merepresentasikan permainan dengan
 * kotak-kotak
 * yang berisi koin dan monster.
 */
class KotakPermainan {
    private Kotak[] boardGame;
    private int jumKotak;
    private int jumlahKoin;
    private int jumlahMonster;
    private int jumlahLompatan;
    private int[] acakKoin;
    private int[] acakMonster;
    private int pilihanLevel;
    private Monster monster;
    private Koin koin;

    /**
     * Konstruktor untuk kelas KotakPermainan.
     *
     * @param jumKotak      Jumlah kotak dalam permainan.
     * @param jumlahKoin    Jumlah koin dalam permainan.
     * @param jumlahMonster Jumlah monster dalam permainan.
     * @param pilihanLevel  Tingkatan kesulitan permainan.
     * @param monster       Objek monster yang digunakan dalam permainan.
     * @param koin          Objek koin yang digunakan dalam permainan.
     */
    public KotakPermainan(int jumKotak, int jumlahKoin, int jumlahMonster, int pilihanLevel, Monster monster,
            Koin koin) {
        this.jumKotak = jumKotak;
        this.jumlahKoin = jumlahKoin;
        this.jumlahMonster = jumlahMonster;
        boardGame = new Kotak[jumKotak];
        acakKoin = new int[jumlahKoin];
        acakMonster = new int[jumlahMonster];
        this.pilihanLevel = pilihanLevel;
        this.monster = monster;
        this.koin = koin;

        generateAcak();
        inisialisasiKotak();
    }

    /**
     * Menghasilkan indeks acak untuk koin dan monster dalam permainan.
     */
    private void generateAcak() {
        ArrayList<Integer> koinList = new ArrayList<>();
        ArrayList<Integer> monsterList = new ArrayList<>();

        for (int i = 0; i < jumKotak; i++) {
            koinList.add(i);
            monsterList.add(i);
        }

        Collections.shuffle(koinList);
        Collections.shuffle(monsterList);

        for (int i = 0; i < jumlahKoin; i++) {
            acakKoin[i] = koinList.get(i);
        }

        for (int i = 0; i < jumlahMonster; i++) {
            acakMonster[i] = monsterList.get(i);
        }
    }

    /**
     * Menginisialisasi kotak-kotak dalam permainan dengan koin dan monster.
     */
    private void inisialisasiKotak() {
        for (int i = 0; i < jumKotak; i++) {
            Kotak kotak = new Kotak();

            for (int j = 0; j < jumlahKoin; j++) {
                if (i == acakKoin[j]) {
                    int nilaiKoin = generateNilaiKoin(pilihanLevel);
                    String namaKoin = koin.getJenisKoinByNilai(nilaiKoin);
                    koin = new Koin(namaKoin, nilaiKoin);
                    kotak.addKoin(koin);
                }
            }

            for (int j = 0; j < jumlahMonster; j++) {
                if (i == acakMonster[j]) {
                    int nilaiMonster = generateNilaiMonster(pilihanLevel);
                    String namaMonster = monster.getJenisMonsterByNilai(nilaiMonster);
                    monster = new Monster(namaMonster, nilaiMonster);
                    kotak.addMonster(monster);
                }
            }

            boardGame[i] = kotak;
        }
    }

    /**
     * Menghasilkan nilai koin berdasarkan tingkatan kesulitan.
     *
     * @param pilihanLevel Tingkatan kesulitan permainan.
     * @return Nilai koin yang dihasilkan.
     */
    private int generateNilaiKoin(int pilihanLevel) {
        Random rand = new Random();
        int nilai = 0;

        if (pilihanLevel == 1) {
            // pilihanLevel Easy - Bronze Koin (1-40)
            nilai = rand.nextInt(40) + 1;
        } else if (pilihanLevel == 2) {
            // pilihanLevel Intermediate - Silver Koin (41-75)
            nilai = rand.nextInt(35) + 41;
        } else if (pilihanLevel == 3) {
            // pilihanLevel Hard - Gold Koin (76-120)
            nilai = rand.nextInt(45) + 76;
        } else if (pilihanLevel == 4) {
            // pilihanLevel Impossible - Platinum Koin (121-170)
            nilai = rand.nextInt(50) + 121;
        }

        return nilai;
    }

    /**
     * Menghasilkan nilai monster berdasarkan tingkatan kesulitan.
     *
     * @param pilihanLevel Tingkatan kesulitan permainan.
     * @return Nilai monster yang dihasilkan.
     */
    private int generateNilaiMonster(int pilihanLevel) {
        Random rand = new Random();
        int nilai = 0;

        if (pilihanLevel == 1) {
            // pilihanLevel Easy - Goblin Monster (-1 to -40)
            nilai = -rand.nextInt(40) - 1;
        } else if (pilihanLevel == 2) {
            // pilihanLevel Intermediate - Witch Monster (-41 to -75)
            nilai = -rand.nextInt(35) - 41;
        } else if (pilihanLevel == 3) {
            // pilihanLevel Hard - Dragon Monster (-76 to -120)
            nilai = -rand.nextInt(45) - 76;
        } else if (pilihanLevel == 4) {
            // pilihanLevel Impossible - Godzilla Monster (-121 to -170)
            nilai = -rand.nextInt(50) - 121;
        }

        return nilai;
    }

    /**
     * Mengembalikan total skor dari kotak pada posisi tertentu dalam permainan.
     *
     * @param posisi Posisi kotak dalam permainan.
     * @return Total skor dari kotak pada posisi tersebut.
     */
    public int contain(int posisi) {
        if (posisi >= 0 && posisi < jumKotak) {
            Kotak kotak = boardGame[posisi];
            int skor = 0;

            if (kotak.isThereKoin()) {
                Koin koin = kotak.getKoin();
                int nilaiKoin = koin.getNilai();
                skor += nilaiKoin;
            }

            if (kotak.isThereMonster()) {
                Monster monster = kotak.getMonster();
                int nilaiMonster = monster.getNilai();

                skor += nilaiMonster;
            }

            return skor;
        }

        return 0;
    }

    /**
     * Mendapatkan jumlah kotak dalam permainan.
     *
     * @return Jumlah kotak dalam permainan.
     */
    public int getJumKotak() {
        return this.jumKotak;
    }

    /**
     * Mendapatkan jumlah lompatan dalam permainan.
     *
     * @return Jumlah lompatan dalam permainan.
     */
    public int getJumlahLompatan() {
        return this.jumlahLompatan;
    }

    /**
     * Mengatur jumlah lompatan dalam permainan.
     *
     * @param jumBaru Jumlah lompatan yang baru.
     */
    public void setJumlahLompatan(int jumBaru) {
        this.jumlahLompatan = jumBaru;
    }
}
