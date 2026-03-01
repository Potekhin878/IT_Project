package commands;

import game.Hrac;
import game.Mistnost;
import model.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazPolozTest {

    @Test
    void testPolozBezParametru() {
        PrikazPoloz prikaz = new PrikazPoloz();
        Hrac hrac = new Hrac(new Mistnost("A", ""));

        String vysl = prikaz.proved(hrac, new String[]{});
        assertEquals("Musíš zadat název předmětu.", vysl);
    }

    @Test
    void testPolozPredmet() {
        Mistnost m = new Mistnost("A", "");
        Hrac hrac = new Hrac(m);

        Predmet p = new Predmet("klic", "", true);
        hrac.getInventar().pridejPredmet(p);

        PrikazPoloz prikaz = new PrikazPoloz();
        String vysl = prikaz.proved(hrac, new String[]{"klic"});

        assertEquals("Položil jsi: klic", vysl);
        assertFalse(hrac.getInventar().obsahuje("klic"));
        assertEquals(1, m.getPredmety().size());
    }
}
