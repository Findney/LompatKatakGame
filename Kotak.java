class Kotak {
    private Koin koin;
    private Monster monster;

    public Kotak() {
        // Konstruktor default
    }

    public void addKoin(Koin koin) {
        this.koin = koin;
    }

    public void addMonster(Monster monster) {
        this.monster = monster;
    }

    public Koin getKoin() {
        return koin;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean isThereKoin() {
        return koin != null;
    }

    public boolean isThereMonster() {
        return monster != null;
    }
}
