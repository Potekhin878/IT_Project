public class Predmet {

    private final String nazev;
    private final String popis;
    private final boolean prenosny;

    public Predmet(String nazev, String popis, boolean prenosny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenosny = prenosny;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean jePrenosny() {
        return prenosny;
    }
}

