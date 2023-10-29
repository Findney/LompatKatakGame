import java.util.Random;
import java.util.Scanner;

public class LompatKatak {
    private boolean play;

    public LompatKatak() {
        play = true;
    }

    public void mainkan() {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        while (play) {
            System.out.println("+-------------------------------------+");
            System.out.print("Masukkan nama pemain: ");
            String namaPemain = input.nextLine();
            Pemain pemain = new Pemain(namaPemain);
            Katak katak = new Katak();

            System.out.println("+-------------------------------------+");
            System.out.println("| Pilih level permainan:              |");
            System.out.println("| 1. "+pemain.getNamaLevel(1)+"                             |");
            System.out.println("| 2. "+pemain.getNamaLevel(2)+"                     |");
            System.out.println("| 3. "+pemain.getNamaLevel(3)+"                             |");
            System.out.println("| 4. "+pemain.getNamaLevel(4)+"                       |");
            System.out.println("+-------------------------------------+");
            System.out.print("Masukkan pilihan: ");
            int pilihanLevel = input.nextInt();

            while (pilihanLevel < 1 || pilihanLevel > 4) {
                System.out.println("Pilihan LEVEL TIDAK VALID. Harap pilih level 1, 2, 3 atau 4.");
                System.out.print("Masukkan pilihan level: ");
                pilihanLevel = input.nextInt();
            }

            int jumlahKoin = 0;
            int jumlahMonster = 0;

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
            Monster monster = new Monster();
            Koin koin = new Koin();
            KotakPermainan permainan = new KotakPermainan(300, jumlahKoin, jumlahMonster, pilihanLevel, monster, koin);

            while (katak.getSkor() >= 0 && katak.getPosisi() < permainan.getJumKotak()) {
                System.out.println("\n+-------------------------------------+");
                System.out.println("|        Permainan Lompat Katak       |");
                System.out.println("+-------------------------------------+");
                System.out.println(" Nama Pemain: " + namaPemain);
                System.out.println(" Level: " + pemain.getNamaLevel(pilihanLevel));
                System.out.println("---------------------------------------");
                System.out.println(" Posisi Katak: " + katak.getPosisi());
                System.out.println(" Nilai Katak: " + katak.getSkor());
                System.out.println("+-------------------------------------+");

                if (katak.getPosisi() == 0) {
                    katak.setArah(true);
                    System.out.println("Katak HANYA dapat MAJU");
                } else {
                    System.out.println(" Pilih arah pergerakan katak:");
                    System.out.println(" 1. Maju");
                    System.out.println(" 2. Mundur");
                    System.out.println("+-------------------------------------+");

                    System.out.print("Masukkan pilihan arah pergerakan: ");
                    katak.setPilihanArah(input.nextInt());

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

                System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                permainan.setJumlahLompatan(input.nextInt());

                while (permainan.getJumlahLompatan() < 1 || permainan.getJumlahLompatan() > 2) {
                    System.out.println("\n********************************************************************************");                    
                    System.out.println("Pilihan langkah TIDAK VALID. Masukkan jumlah kotak yang sesuai (1 atau 2).");
                    System.out.println("********************************************************************************");                                        
                    System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                    permainan.setJumlahLompatan(input.nextInt());
                }

                while (!katak.getArah() && permainan.getJumlahLompatan() > katak.getPosisi()) {
                    System.out.println("\n****************************************************************");
                    System.out.println("Jumlah lompatan untuk mundur TIDAK BOLEH melewati kotak 0.");
                    System.out.println("****************************************************************");                    
                    System.out.print("Masukkan jumlah kotak yang ingin dilewati: ");
                    permainan.setJumlahLompatan(input.nextInt());
                }

                if (permainan.getJumlahLompatan() == 1) {
                    katak.loncatDekat();
                } else if (permainan.getJumlahLompatan() == 2) {
                    katak.loncatJauh();
                }

                int skor = permainan.contain(katak.getPosisi());

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

                if (katak.getPosisi() == permainan.getJumKotak() - 1) {
                    break;
                }
            }

            String komentar;

            if (katak.getSkor() > 1000) {
                komentar = "Excellent!";
            } else if (katak.getSkor() >= 500 && katak.getSkor() <= 1000) {
                komentar = "Good!";
            } else {
                komentar = "Bad!";
            }

            pemain.setNilai(katak.getSkor()); // Mengambil nilai dari karakter (Katak) dan mengatur nilai pemain

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

            while (!jawaban.equalsIgnoreCase("y") && !jawaban.equalsIgnoreCase("n")) {
                System.out.println("Pilihan tidak valid. Harap masukkan 'y' untuk lanjut atau 'n' untuk berhenti.");
                System.out.print("Apakah Anda ingin melanjutkan bermain? [y/n]: ");
                jawaban = input.next();
            }
                        
            if (!jawaban.equalsIgnoreCase("y")) {
                play = false;
                System.out.println("Terima Kasih Telah Bermain.");
            }
            input.nextLine();
        }
        input.close();
    }
}
