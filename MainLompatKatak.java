
// Link Video Penjelasan: https://drive.google.com/file/d/1Bzr0LmC4Q8kv282GdrOP7ztQOtwvxHyX/view?usp=sharing

/**
 * Ini adalah program permainan Katak Petualang. Katak akan bergerak di papan
 * permainan
 * dan mendapatkan koin atau bertemu monster. Pemain dapat memilih level
 * permainan,
 * menggerakkan katak, dan melihat hasil akhir.
 * <p>
 * Pada versi kali ini terdapat beberapa perubahan yaitu penggunaan konsep kelas abstrak,
 * inheritance, collection, dan penggunaan exception handling.
 *
 * @author Agil Mughni
 * @version 1.3
 * @since 2023-10-08
 * @update 2023-11-18
 */

public class MainLompatKatak {
    /**
     * Metode utama (main) dari aplikasi ini. Ini merupakan titik masuk untuk
     * menjalankan
     * permainan Lompat Katak.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam permainan ini).
     */
    public static void main(String[] args) {
        try {
            // Membuat objek permainan LompatKatak.
            LompatKatak game = new LompatKatak();

            // Memulai permainan.
            game.mainkan();
        } catch (Exception e) {
            // Menangani exception jika terjadi kesalahan selama eksekusi permainan
            System.out.println("Terjadi error: " + e.getMessage());

            // Mencetak informasi kesalahan dan jejak eksekusi (stack trace)
            e.printStackTrace();
        } 

    }
}
