package game;

import model.Predmet;
import java.util.ArrayList;
import java.util.List;

/**
 * Inventář hráče. Ukládá přenositelné předměty
 * a kontroluje kapacitu.
 */
public class Inventar {

    private final List<Predmet> predmety = new ArrayList<>();
    private final int kapacita = 3;

    /**
     * Pokusí se přidat předmět do inventáře.
     *
     * @param predmet předmět k přidání
     * @return true pokud byl přidán, false pokud je inventář plný
     */
    public boolean pridejPredmet(Predmet predmet) {
        if (jePlny()) return false;
        predmety.add(predmet);
        return true;
    }

    /** Odebere předmět z inventáře. */
    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
    }

    /** @return true pokud je inventář plný */
    public boolean jePlny() {
        return predmety.size() >= kapacita;
    }

    /** @return seznam předmětů v inventáři */
    public List<Predmet> getPredmety() {
        return predmety;
    }

    /** Zjistí, zda inventář obsahuje předmět podle názvu. */
    public boolean obsahuje(String nazev) {
        return predmety.stream().anyMatch(p -> p.getNazev().equalsIgnoreCase(nazev));
    }

    /** Najde předmět podle názvu. */
    public Predmet najdi(String nazev) {
        return predmety.stream()
                .filter(p -> p.getNazev().equalsIgnoreCase(nazev))
                .findFirst()
                .orElse(null);
    }
}
