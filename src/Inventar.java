import java.util.ArrayList;
import java.util.List;

public class Inventar {

    private final List<Predmet> predmety = new ArrayList<>();
    private final int kapacita = 10;

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
}
