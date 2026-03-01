package commands;

import game.Hrac;
import model.Postava;
import model.Predmet;

/**
 * Příkaz "mluv" umožňuje hráči mluvit s postavou v místnosti.
 * Obsahuje speciální logiku pro nájemníka a zahradníka.
 */
public class PrikazMluv implements Prikaz {

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (parametry.length == 0) {
            return "S kým chceš mluvit?";
        }

        String jmeno = parametry[0];

        for (Postava p : hrac.getAktualniMistnost().getPostavy()) {
            if (p.getJmeno().equalsIgnoreCase(jmeno)) {

                // nájemník
                if (p.getJmeno().equalsIgnoreCase("najemnik")) {
                    if (hrac.getInventar().obsahuje("baterka")) {
                        return "Nájemník říká: 'Díky za baterku. Klíč ti pomůže najít zahradník na zahradě.'";
                    } else {
                        return p.mluv();
                    }
                }

                // zahradník
                if (p.getJmeno().equalsIgnoreCase("zahradnik")) {
                    if (hrac.getInventar().obsahuje("rukavice")) {

                        if (!hrac.getInventar().obsahuje("hlavni_klic")) {
                            hrac.getInventar().pridejPredmet(
                                    new Predmet("hlavni_klic", "Hlavní klíč od domu.", true));
                            return "Zahradník si vezme rukavice a dá ti hlavní klíč!";
                        } else {
                            return "Zahradník říká: 'Klíč už máš, tak běž ke vchodu.'";
                        }
                    } else {
                        return p.mluv();
                    }
                }

                return p.mluv();
            }
        }

        return "Taková postava tu není.";
    }
}
