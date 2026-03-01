package commands;

import game.Hrac;
import game.Mistnost;
import model.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazSeberTest {

    @Test
    void testSeberBezParametru() {
        PrikazSeber prikaz = new PrikazSeber();
        Hrac hrac = new Hrac(new Mistnost("A", ""));

        String vysl = prikaz.proved(hrac, new String[]{});
        assertEquals("Musíš zadat název předmětu.", vysl);
    }

    @Test
    void testSeberPredmet() {
        Mistnost m = new Mistnost("A", "");
        Predmet p = new Predmet("klic", "", true);
        m.pridatPredmet(p);

        Hrac hrac = new Hrac(m);
        PrikazSeber prikaz = new PrikazSeber();

        String vysl = prikaz.proved(hrac, new String[]{"klic"});

        assertEquals("Sebral jsi: klic", vysl);
        assertTrue(hrac.getInventar().obsahuje("klic"));
    }
}
