/**
 * Kelas ini merepresentasikan sebuah objek Katak dalam permainan.
 * Katak memiliki posisi, skor, arah, dan pilihan arah yang dapat diubah.
 */
public class Katak {
    private int posisi;
    private int skor;
    private boolean arah;
    private int pilihanArah;

    /**
     * Konstruktor untuk membuat objek Katak baru dengan posisi awal 0, skor awal
     * 100,
     * dan arah awal yang menghadap ke kanan.
     */
    public Katak() {
        posisi = 0;
        skor = 100;
        arah = true;
    }

    /**
     * Mengembalikan posisi saat ini dari Katak.
     *
     * @return Posisi saat ini dari Katak.
     */
    public int getPosisi() {
        return posisi;
    }

    /**
     * Mengatur posisi baru untuk Katak.
     *
     * @param posisiBaru Posisi baru yang akan diatur untuk Katak.
     */
    public void setPosisi(int posisiBaru) {
        posisi = posisiBaru;
    }

    /**
     * Mengembalikan skor saat ini dari Katak.
     *
     * @return Skor saat ini dari Katak.
     */
    public int getSkor() {
        return skor;
    }

    /**
     * Mengatur skor baru untuk Katak.
     *
     * @param skorBaru Skor baru yang akan diatur untuk Katak.
     */
    public void setSkor(int skorBaru) {
        skor = skorBaru;
    }

    /**
     * Mengembalikan arah saat ini yang dihadapi oleh Katak.
     *
     * @return `true` jika Katak menghadap ke kanan, `false` jika menghadap ke kiri.
     */
    public boolean getArah() {
        return arah;
    }

    /**
     * Mengatur arah baru yang dihadapi oleh Katak.
     *
     * @param arahBaru `true` untuk menghadap ke kanan, `false` untuk menghadap ke
     *                 kiri.
     */
    public void setArah(boolean arahBaru) {
        arah = arahBaru;
    }

    /**
     * Mengembalikan pilihan arah yang tersedia untuk Katak.
     *
     * @return Pilihan arah yang dapat dipilih oleh Katak.
     */
    public int getPilihanArah() {
        return pilihanArah;
    }

    /**
     * Mengatur pilihan arah yang dapat dipilih oleh Katak.
     *
     * @param arahBaru Pilihan arah yang akan diatur untuk Katak.
     */
    public void setPilihanArah(int arahBaru) {
        pilihanArah = arahBaru;
    }

    /**
     * Melakukan loncatan dekat. Posisi Katak akan bertambah atau berkurang
     * tergantung pada arahnya.
     */
    public void loncatDekat() {
        if (arah) {
            posisi++;
        } else {
            posisi--;
        }
    }

    /**
     * Melakukan loncatan jauh. Posisi Katak akan bertambah atau berkurang dua kali
     * lipat tergantung pada arahnya.
     */
    public void loncatJauh() {
        if (arah) {
            posisi += 2;
        } else {
            posisi -= 2;
        }
    }
}
