/**
 * Kelas Kotak mewakili sebuah kotak dalam sebuah permainan. Kotak ini dapat
 * berisi sebuah Koin
 * dan/atau sebuah Monster.
 */
public class Kotak {
    private Koin koin;
    private Monster monster;

    /**
     * Konstruktor default untuk kelas Kotak. Inisialisasi kotak tanpa Koin dan
     * Monster.
     */
    public Kotak() {
        // Konstruktor default
    }

    /**
     * Menambahkan sebuah Koin ke dalam kotak.
     *
     * @param koin Koin yang akan ditambahkan ke kotak.
     */
    public void addKoin(Koin koin) {
        this.koin = koin;
    }

    /**
     * Menambahkan sebuah Monster ke dalam kotak.
     *
     * @param monster Monster yang akan ditambahkan ke kotak.
     */
    public void addMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Mengembalikan Koin yang ada dalam kotak.
     *
     * @return Objek Koin yang ada dalam kotak, atau null jika tidak ada Koin.
     */
    public Koin getKoin() {
        return koin;
    }

    /**
     * Mengembalikan Monster yang ada dalam kotak.
     *
     * @return Objek Monster yang ada dalam kotak, atau null jika tidak ada Monster.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Memeriksa apakah terdapat Koin dalam kotak.
     *
     * @return true jika ada Koin dalam kotak, false jika tidak ada.
     */
    public boolean isThereKoin() {
        return koin != null;
    }

    /**
     * Memeriksa apakah terdapat Monster dalam kotak.
     *
     * @return true jika ada Monster dalam kotak, false jika tidak ada.
     */
    public boolean isThereMonster() {
        return monster != null;
    }
}
