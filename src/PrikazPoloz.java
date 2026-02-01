public class PrikazPoloz implements Prikaz {

    @Override
    public String getNazev() {
        return "poloz";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (parametry.length == 0) {
            return "Musíš zadat název předmětu.";
        }

        return hrac.polozPredmet(parametry[0]);
    }
}
