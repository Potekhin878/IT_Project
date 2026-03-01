package commands;

import game.Hrac;

import java.util.HashMap;
import java.util.Map;

/**
 * Spravuje registraci a provádění příkazů.
 */
public class SpravcePrikazu {

    private final Map<String, Prikaz> prikazy = new HashMap<>();

    /** Zaregistruje nový příkaz. */
    public void registruj(Prikaz prikaz) {
        prikazy.put(prikaz.getNazev(), prikaz);
    }

    /**
     * Zpracuje textový vstup a provede příkaz.
     *
     * @param hrac hráč
     * @param vstup text příkazu
     * @return odpověď hry
     */
    public String provedPrikaz(Hrac hrac, String vstup) {

        String[] casti = vstup.trim().split("\\s+");
        String nazev = casti[0];

        String[] parametry = new String[casti.length - 1];
        System.arraycopy(casti, 1, parametry, 0, parametry.length);

        Prikaz prikaz = prikazy.get(nazev);

        if (prikaz == null) {
            return "Tomuto příkazu nerozumím.";
        }

        return prikaz.proved(hrac, parametry);
    }

    /** @return seznam názvů příkazů */
    public String seznamPrikazu() {
        return String.join(", ", prikazy.keySet());
    }
}
