package game;

import model.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HracTest {

    @Test
    void testPohybHrace() {
        Mistnost m1 = new Mistnost("A", "první");
        Mistnost m2 = new Mistnost("B", "druhá");

        m1.pridatVychod("vychod", m2);

        Hrac hrac = new Hrac(m1);
        hrac.setAktualniMistnost(m2);

        assertEquals("B", hrac.getAktualniMistnost().getNazev());
    }

    @Test
    void testSebraniPredmetu() {
        Mistnost m = new Mistnost("A", "");
        Predmet p = new Predmet("klic", "", true);
        m.pridatPredmet(p);

        Hrac hrac = new Hrac(m);

        String vysl = hrac.seberPredmet("klic");
        assertTrue(hrac.getInventar().obsahuje("klic"));
        assertEquals("Sebral jsi: klic", vysl);
    }

    @Test
    void testPolozeniPredmetu() {
        Mistnost m = new Mistnost("A", "");
        Hrac hrac = new Hrac(m);

        Predmet p = new Predmet("klic", "", true);
        hrac.getInventar().pridejPredmet(p);

        String vysl = hrac.polozPredmet("klic");

        assertEquals("Položil jsi: klic", vysl);
        assertFalse(hrac.getInventar().obsahuje("klic"));
        assertEquals(1, m.getPredmety().size());
    }
}
