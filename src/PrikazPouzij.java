public class PrikazPouzij implements Prikaz {

    @Override
    public String getNazev() {
        return "pouzij";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (parametry.length == 0) {
            return "Musíš zadat, co chceš použít.";
        }

        String nazev = parametry[0];


        for (Predmet p : hrac.getInventar().getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {



                return "Použil jsi předmět: " + p.getNazev();
            }
        }

        return "Tento předmět nemáš.";
    }
}
