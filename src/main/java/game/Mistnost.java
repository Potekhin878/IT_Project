package game;

import model.Predmet;
import model.Postava;

import java.util.*;

/**
 * Reprezentuje místnost ve hře.
 * Místnost má název, popis, seznam předmětů, postav a východů.
 */
public class Mistnost {

    private final String nazev;
    private final String popis;
    private final Map<String, Mistnost> vychody = new HashMap<>();
    private final List<Predmet> predmety = new ArrayList<>();
    private final List<Postava> postavy = new ArrayList<>();

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getNazev() { return nazev; }

    public String getPopis() { return popis; }

    public Map<String, Mistnost> getVychody() { return vychody; }

    public List<Predmet> getPredmety() { return predmety; }

    public List<Postava> getPostavy() { return postavy; }

    /** Přidá východ z místnosti. */
    public void pridatVychod(String smer, Mistnost cil) {
        vychody.put(smer, cil);
    }

    /** Přidá předmět do místnosti. */
    public void pridatPredmet(Predmet predmet) {
        predmety.add(predmet);
    }

    /** Přidá postavu do místnosti. */
    public void pridatPostavu(Postava postava) {
        postavy.add(postava);
    }
}
