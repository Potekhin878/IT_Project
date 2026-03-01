package model;

/**
 * Reprezentuje předmět ve hře.
 * Každý předmět má název, popis a informaci o tom,
 * zda je přenositelný (hráč ho může sebrat).
 */
public class Predmet {

    private final String nazev;
    private final String popis;
    private final boolean prenosny;

    /**
     * Vytvoří nový předmět.
     *
     * @param nazev název předmětu
     * @param popis popis předmětu
     * @param prenosny zda je možné předmět sebrat
     */
    public Predmet(String nazev, String popis, boolean prenosny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenosny = prenosny;
    }

    /** @return název předmětu */
    public String getNazev() {
        return nazev;
    }

    /** @return popis předmětu */
    public String getPopis() {
        return popis;
    }

    /** @return true pokud je předmět přenositelný */
    public boolean jePrenosny() {
        return prenosny;
    }
}
