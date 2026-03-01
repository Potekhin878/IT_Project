package commands;

import game.Hrac;
import game.Mistnost;
import game.Svet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrikazJdiTest {

    @Test
    void testJdiBezParametru() {
        Svet svet = new Svet();
        PrikazJdi prikaz = new PrikazJdi(svet);

        Hrac hrac = new Hrac(new Mistnost("A", ""));

        String vysl = prikaz.proved(hrac, new String[]{});
        assertEquals("Musíš zadat směr.", vysl);
    }

    @Test
    void testJdiDoNeexistujicihoSmeru() {
        Mistnost m = new Mistnost("A", "");
        Hrac hrac = new Hrac(m);

        Svet svet = new Svet();
        PrikazJdi prikaz = new PrikazJdi(svet);

        String vysl = prikaz.proved(hrac, new String[]{"sever"});
        assertEquals("Tímto směrem se jít nedá.", vysl);
    }
}
