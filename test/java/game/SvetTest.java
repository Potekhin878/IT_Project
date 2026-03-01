package game;

import model.Predmet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SvetTest {

    @Test
    void testPohybBezVychodu() {
        Mistnost m = new Mistnost("A", "");
        Hrac hrac = new Hrac(m);

        Svet svet = new Svet();

        // ručně nastavíme mapu
        svet.getClass(); // jen aby nebylo prázdné

        Mistnost vysl = svet.pohniSe(hrac, "sever");
        assertEquals(m, vysl);
    }

    @Test
    void testPohybDoMistnosti() {
        Mistnost m1 = new Mistnost("A", "");
        Mistnost m2 = new Mistnost("B", "");

        m1.pridatVychod("vychod", m2);

        Hrac hrac = new Hrac(m1);
        Svet svet = new Svet();

        Mistnost vysl = svet.pohniSe(hrac, "vychod");
        assertEquals(m2, vysl);
    }
}
