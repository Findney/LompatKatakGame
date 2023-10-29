/**
 * Ini adalah program permainan Katak Petualang. Katak akan bergerak di papan permainan
 * dan mendapatkan koin atau bertemu monster. Pemain dapat memilih level permainan, 
 * menggerakkan katak, dan melihat hasil akhir.
 * <p>  
 * Pada versi kali ini terdapat beberapa perubahan yaitu penggunaan konsep OOP, penambahan
 * level Impossible, penambahan jenis-jenis koin dan monster yang sesuai berdasarkan level 
 * yang dipilih oleh pemain. 
 *
 * @author Agil Mughni
 * @version 1.2
 * @since 2023-10-08
 * @update 2023-10-29
 */

public class MainLompatKatak {
    /**
     * Metode utama (main) dari aplikasi ini. Ini merupakan titik masuk untuk menjalankan 
     * permainan Lompat Katak.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam permainan ini).
     */
    public static void main(String[] args) {
         // Membuat objek permainan LompatKatak.
        LompatKatak game = new LompatKatak();

        // Memulai permainan.
        game.mainkan();
    }
}
