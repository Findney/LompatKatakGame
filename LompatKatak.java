import java.util.Random;
import java.util.Scanner;

/**
 * Kelas LompatKatak adalah kelas utama yang mengatur permainan Lompat Katak.
 */
public class LompatKatak {
    private boolean play;

    /**
     * Konstruktor untuk kelas LompatKatak.
     * Inisialisasi variabel play ke true.
     */
    public LompatKatak() {
        play = true;
    }

    /**
     * Metode mainkan mengatur alur permainan Lompat Katak.
     */
    public void mainkan() {
        // Membuat objek dari kelas Scanner
        Scanner input = new Scanner(System.in);
        // Membuat objek dari kelas Random
        Random rand = new Random();

        while (play) {
            // Memulai permainan dan menerima nama pemain
            System.out.println("+-------------------------------------+");
            System.out.print("Masukkan nama pemain: ");
            String namaPemain = input.nextLine();
            
            // Membuat objek dari kelas Pemain
            Pemain pemain = new Pemain(namaPemain);

            // Memilih level permainan
            System.out.println("+-------------------------------------+");
            System.out.println("| Pilih level permainan:              |");
            System.out.println("| 1. "+pemain.getNamaLevel(1)+"                             |");
            System.out.println("| 2. "+pemain.getNamaLevel(2)+"                     |");
            System.out.println("| 3. "+pemain.getNamaLevel(3)+"                             |");
            System.out.println("| 4. "+pemain.getNamaLevel(4)+"                       |");
            System.out.println("+-------------------------------------+");
            System.out.print("Masukkan pilihan: ");
            int pilihanLevel = input.nextInt();

            // Validasi pemilihan level
            while (pilihanLevel < 1 || pilihanLevel > 4) {
                System.out.println("Pilihan LEVEL TIDAK VALID. Harap pilih level 1, 2, 3 atau 4.");
                System.out.print("Masukkan pilihan level: ");
                pilihanLevel = input.nextInt();
            }

            int jumlahKoin = 0;
            int jumlahMonster = 0;

            // Mengatur jumlah koin dan monster berdasarkan level yang dipilih
            switch (pilihanLevel) {
                case 1:
                    jumlahKoin = rand.nextInt(21) + 30;
                    jumlahMonster = rand.nextInt(21) + 40;
                    break;
                case 2:
                    jumlahKoin = rand.nextInt(26) + 40;
                    jumlahMonster = rand.nextInt(26) + 50;
                    break;
                case 3:
                    jumlahKoin = rand.nextInt(21) + 60;
                    jumlahMonster = rand.nextInt(21) + 70;
                    break;
                case 4:
                    jumlahKoin = rand.nextInt(25) + 75;
                    jumlahMonster = rand.nextInt(26) + 100;
                    break;
                default:
                    break;
            }
            
            // Membuat objek dari kelas Monster
            Monster monster = new Monster();
            // Membuat objek dari kelas Koin
            Koin koin = new Koin();
            // Membuat objek dari kelas Katak       
            Katak katak = new Katak();
            // Membuat objek dari kelas KotakPermainan
            KotakPermainan permainan = new KotakPermainan(300, jumlahKoin, jumlahMonster, pilihanLevel, monster, koin);

            // Memulai permainan lompat katak
            while (katak.getSkor() >= 0 && katak.getPosisi() < permainan.getJumKotak()) {
                System.out.println("\n+--------------------------------------------+");
                System.out.println("|           Permainan Lompat Katak           |");
                System.out.println("+--------------------------------------------+");
                System.out.println(" Nama Pemain: " + namaPemain);
                System.out.println(" Level: " + pemain.getNamaLevel(pilihanLevel));
                System.out.println("----------------------------------------------");
                System.out.println(" Posisi Katak: " + katak.getPosisi());
                System.out.println(" Nilai Katak: " + katak.getSkor());
                System.out.println("----------------------------------------------");

                // Menentukan pilihan arah
                if (katak.getPosisi() == 0) {
                    katak.setArah(true);
                    System.out.println("Katak HANYA dapat MAJU");
                } else {
                    System.out.println(" Pilih arah pergerakan katak:");
                    System.out.println(" 1. Maju");
                    System.out.println(" 2. Mundur");
                    System.out.println("----------------------------------------------");

                    System.out.print("Masukkan pilihan arah pergerakan: ");
                    katak.setPilihanArah(input.nextInt());

                    // Validasi pilihan arah
                    while (katak.getPilihanArah() < 1 || katak.getPilihanArah() > 2) {
                        System.out.println("\n********************************************************************************");
                        System.out.println("Pilihan arah TIDAK VALID. Masukkan pilihan yang sesuai (1 atau 2).");
                        System.out.println("********************************************************************************");  
                        System.out.print("Masukkan pilihan arah pergerakan: ");
                        katak.setPilihanArah(input.nextInt());
                    }

                    if (katak.getPilihanArah() == 2) {
                        katak.setArah(false);
                    } else {
                        katak.setArah(true);
                    }
                }

                // Meminta jumlah kotak yang akan dilewati
                System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                permainan.setJumlahLompatan(input.nextInt());
                System.out.println("+--------------------------------------------+");


                // Validasi jumlah lompatan
                while (permainan.getJumlahLompatan() < 1 || permainan.getJumlahLompatan() > 2) {
                    System.out.println("\n********************************************************************************");                    
                    System.out.println("Pilihan langkah TIDAK VALID. Masukkan jumlah kotak yang sesuai (1 atau 2).");
                    System.out.println("********************************************************************************");                                        
                    System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                    permainan.setJumlahLompatan(input.nextInt());
                }

                // Validasi jumlah lompatan agar tidak melewati kotak 0 saat mundur
                while (!katak.getArah() && permainan.getJumlahLompatan() > katak.getPosisi()) {
                    System.out.println("\n****************************************************************");
                    System.out.println("Jumlah lompatan untuk mundur TIDAK BOLEH melewati kotak 0.");
                    System.out.println("****************************************************************");                    
                    System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                    permainan.setJumlahLompatan(input.nextInt());
                }

                // Melakukan lompatan sesuai jumlah lompatan yang dimasukkan
                if (permainan.getJumlahLompatan() == 1) {
                    katak.loncatDekat();
                } else if (permainan.getJumlahLompatan() == 2) {
                    katak.loncatJauh();
                }

                // Mengambil skor dari kotak yang dilewati
                int skor = permainan.contain(katak.getPosisi());

                // Menentukan apakah kotak berisi koin atau monster
                if (skor > 0) {
                    katak.setSkor(katak.getSkor() + skor);
                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Selamat! " + pemain.getNama() + " menemukan koin " + koin.getNama() + " dan mendapatkan " + skor + " poin.");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                } else if (skor < 0) {
                    katak.setSkor(katak.getSkor() + skor);
                    System.out.println("\n------------------------------------------------------------------------------");
                    System.out.println("Sayang sekali! " + pemain.getNama() + " menemukan monster " + monster.getNama()
                            + " dan kehilangan " + (-skor) + " poin.");
                    System.out.println("------------------------------------------------------------------------------\n");

                }

                // Mengakhiri permainan jika katak mencapai kotak terakhir
                if (katak.getPosisi() == permainan.getJumKotak() - 1) {
                    break;
                }
            }

            // Menentukan komentar berdasarkan skor pemain
            String komentar;
            if (katak.getSkor() > 1000) {
                komentar = "Excellent!";
            } else if (katak.getSkor() >= 500 && katak.getSkor() <= 1000) {
                komentar = "Good!";
            } else {
                komentar = "Bad!";
            }

            // Mengambil nilai dari karakter (Katak) dan mengatur nilai pemain
            pemain.setNilai(katak.getSkor()); 

            // Tampilkan skor akhir dan komentar
            System.out.println("+-------------------------------------+");
            System.out.println("|          PERMAINAN BERAKHIR         |");
            System.out.println("+-------------------------------------+");
            System.out.println(" Pemain: " + pemain.getNama());
            System.out.println(" Nilai total: "+ pemain.getNilai());
            System.out.println(" Level permainan: " + pemain.getNamaLevel(pilihanLevel));
            System.out.println(" Komentar: " + komentar);
            System.out.println("+-------------------------------------+");
            System.out.print("Apakah Anda ingin melanjutkan bermain? [y/n]: ");
            String jawaban = input.next();

            // Validasi jawaban pemain
            while (!jawaban.equalsIgnoreCase("y") && !jawaban.equalsIgnoreCase("n")) {
                System.out.println("Pilihan tidak valid. Harap masukkan 'y' untuk lanjut atau 'n' untuk berhenti.");
                System.out.print("Apakah Anda ingin melanjutkan bermain? [y/n]: ");
                jawaban = input.next();
            }
                        
            if (!jawaban.equalsIgnoreCase("y")) {
                play = false;
                System.out.println("Terima Kasih Telah Bermain.");
            }
            
            // Mengambil karakter '\n' saat ENTER dari sisa buffer sebelumnya
            input.nextLine();
        }

        // Menutup dan mengakhiri dari objek Scanner
        input.close();
    }
}
