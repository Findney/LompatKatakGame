// Kelas Pemain
class Pemain {
    private String nama;
    private int nilai;

    public Pemain(String nama) {
        this.nama = nama;
        this.nilai = 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilaiBaru) {
        nilai = nilaiBaru;
    }
}