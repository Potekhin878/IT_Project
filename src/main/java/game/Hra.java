package game;

import commands.SpravcePrikazu;
import model.Predmet;

/**
 * Hlavní logika hry. Uchovává stav světa, hráče a správce příkazů.
 * Zpracovává vstup od hráče a určuje, zda hra skončila.
 */
public class Hra {

    private final Svet svet;
    private final Hrac hrac;
    private final SpravcePrikazu spravce;
    private boolean konec = false;

    /**
     * Vytvoří novou hru.
     *
     * @param svet herní svět
     * @param hrac hráč
     * @param spravce správce příkazů
     */
    public Hra(Svet svet, Hrac hrac, SpravcePrikazu spravce) {
        this.svet = svet;
        this.hrac = hrac;
        this.spravce = spravce;
    }

    /** Spustí úvod hry. */
    public void spustHru() {
        System.out.println("Vítej ve hře Tajemství starého domu!");
        System.out.println(hrac.getAktualniMistnost().getPopis());
    }

    /**
     * Zpracuje textový vstup od hráče.
     *
     * @param vstup text příkazu
     * @return odpověď hry
     */
    public String zpracujVstup(String vstup) {
        String vysledek = spravce.provedPrikaz(hrac, vstup);

        if (vysledek.contains("Vyhrál jsi")) {
            konec = true;
        }

        return vysledek;
    }

    /** Ukončí hru. */
    public void ukonciHru() {
        konec = true;
    }

    /** @return true pokud hra skončila */
    public boolean jeKonec() {
        return konec;
    }
}
