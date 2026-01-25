import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Mistnost {

    private String nazev;
    private String popis;
    private Map<String, Mistnost> vychody = new HashMap<>();
    private List<Predmet> predmety = new ArrayList<>();
    private List<Postava> postavy = new ArrayList<>();

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public Map<String, Mistnost> getVychody() {
        return vychody;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public List<Postava> getPostavy() {
        return postavy;
    }

    public void pridatVychod(String smer, Mistnost cil) {
        vychody.put(smer, cil);
    }

    public void pridatPredmet(Predmet predmet) {
        predmety.add(predmet);
    }

    public void pridatPostavu(Postava postava) {
        postavy.add(postava);
    }
}
