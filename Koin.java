class Koin {
    private int nilai;
    private String nama;

    public Koin() {
        // Konstruktor default
    }

    public Koin(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    public int getNilai() {
        return this.nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public String getNama(){
        return nama;
    }

    public String getJenisKoinByNilai(int nilai) {
        if (nilai >= 1 && nilai <= 40) {
            return this.nama = "Bronze";
        } else if (nilai >= 41 && nilai <= 75) {
            return this.nama = "Silver";
        } else if (nilai >= 76 && nilai <= 120) {
            return this.nama = "Gold";
        } else if (nilai >= 121 && nilai <= 170) {
            return this.nama = "Platinum";
        } else {
            return null;
        }
    }

}
