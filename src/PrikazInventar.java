public class PrikazInventar implements Prikaz {

    @Override
    public String getNazev() {
        return "inventar";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (hrac.getInventar().getPredmety().isEmpty()) {
            return "Inventář je prázdný.";
        }

        StringBuilder sb = new StringBuilder("V inventáři máš:\n");
        for (Predmet p : hrac.getInventar().getPredmety()) {
            sb.append("- ").append(p.getNazev()).append("\n");
        }

        return sb.toString();
    }
}
