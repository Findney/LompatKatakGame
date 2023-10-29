class Katak {
    private int posisi;
    private int skor;
    private boolean Arah; // Menambahkan atribut untuk menentukan apakah permainan sudah dimulai
    private int pilihanArah;

    public Katak() {
        posisi = 0;
        skor = 100;
        Arah = true;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisiBaru) {
        posisi = posisiBaru;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skorBaru) {
        skor = skorBaru;
    }

    public boolean getArah(){
        return this.Arah;
    }

    public void setArah(boolean arahBaru){
        this.Arah = arahBaru;
    }

    public int getPilihanArah(){
        return this.pilihanArah;
    }

    public void setPilihanArah(int arahBaru){
        this.pilihanArah = arahBaru;
    }

    public void loncatDekat() {
        if (Arah) {
            posisi++;
        } else {
            posisi--;
        }
    }
    
    public void loncatJauh() {
        if (Arah) {
            posisi += 2;
        } else {
            posisi -= 2;
        }
    }
}
