package game;

import model.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventarTest {

    @Test
    void testPridejPredmet() {
        Inventar inv = new Inventar();
        Predmet p = new Predmet("klic", "malý klíč", true);

        assertTrue(inv.pridejPredmet(p));
        assertTrue(inv.obsahuje("klic"));
    }

    @Test
    void testKapacita() {
        Inventar inv = new Inventar();

        inv.pridejPredmet(new Predmet("a", "", true));
        inv.pridejPredmet(new Predmet("b", "", true));
        inv.pridejPredmet(new Predmet("c", "", true));

        assertTrue(inv.jePlny());
        assertFalse(inv.pridejPredmet(new Predmet("d", "", true)));
    }

    @Test
    void testOdeberPredmet() {
        Inventar inv = new Inventar();
        Predmet p = new Predmet("klic", "", true);

        inv.pridejPredmet(p);
        inv.odeberPredmet(p);

        assertFalse(inv.obsahuje("klic"));
    }
}
