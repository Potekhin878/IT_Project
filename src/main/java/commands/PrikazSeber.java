package commands;

import game.Hrac;

/**
 * Příkaz "seber" umožňuje hráči sebrat předmět z místnosti.
 */
public class PrikazSeber implements Prikaz {

    @Override
    public String getNazev() {
        return "seber";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (parametry.length == 0) {
            return "Musíš zadat název předmětu.";
        }

        return hrac.seberPredmet(parametry[0]);
    }
}
