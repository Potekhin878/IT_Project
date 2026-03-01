package game;

import model.Predmet;
import java.util.List;

/**
 * Reprezentuje hráče ve hře.
 * Hráč má aktuální místnost a inventář.
 */
public class Hrac {

    private Mistnost aktualniMistnost;
    private final Inventar inventar = new Inventar();

    /**
     * Vytvoří hráče ve startovní místnosti.
     *
     * @param start výchozí místnost
     */
    public Hrac(Mistnost start) {
        this.aktualniMistnost = start;
    }

    /** @return aktuální místnost hráče */
    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    /** Nastaví novou místnost hráče. */
    public void setAktualniMistnost(Mistnost mistnost) {
        this.aktualniMistnost = mistnost;
    }

    /** @return inventář hráče */
    public Inventar getInventar() {
        return inventar;
    }

    /**
     * Pokusí se sebrat předmět z místnosti.
     *
     * @param nazev název předmětu
     * @return textová odpověď
     */
    public String seberPredmet(String nazev) {
        for (Predmet p : aktualniMistnost.getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {

                if (!p.jePrenosny()) {
                    return "Tento předmět nemůžeš sebrat.";
                }

                if (!inventar.pridejPredmet(p)) {
                    return "Inventář je plný.";
                }

                aktualniMistnost.getPredmety().remove(p);
                return "Sebral jsi: " + p.getNazev();
            }
        }
        return "Takový předmět tu není.";
    }

    /**
     * Položí předmět z inventáře do místnosti.
     *
     * @param nazev název předmětu
     * @return textová odpověď
     */
    public String polozPredmet(String nazev) {
        for (Predmet p : inventar.getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                inventar.odeberPredmet(p);
                aktualniMistnost.getPredmety().add(p);
                return "Položil jsi: " + p.getNazev();
            }
        }
        return "Tento předmět nemáš.";
    }
}
