// Kelas Monster

class Monster {
    private int nilai;
    private String nama;

    public Monster() {
        // Konstruktor default
    }

    public Monster(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public int getNilai() {
        return this.nilai;
    }

    public String getNama(){
        return this.nama;
    }
    
    public String getJenisMonsterByNilai(int nilai) {
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
