import java.util.ArrayList;
import java.util.List;

public class Inventar {

    private final List<Predmet> predmety = new ArrayList<>();
    private final int kapacita = 3; // podle Game designu

    public boolean pridejPredmet(Predmet predmet) {
        if (jePlny()) {
            return false;
        }
        predmety.add(predmet);
        return true;
    }

    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
    }

    public boolean jePlny() {
        return predmety.size() >= kapacita;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

    public boolean obsahuje(String nazev) {
        return predmety.stream().anyMatch(p -> p.getNazev().equalsIgnoreCase(nazev));
    }

    public Predmet najdi(String nazev) {
        return predmety.stream()
                .filter(p -> p.getNazev().equalsIgnoreCase(nazev))
                .findFirst()
                .orElse(null);
    }
}
