public class PrikazJdi implements Prikaz {

    private final Svet svet;

    public PrikazJdi(Svet svet) {
        this.svet = svet;
    }

    @Override
    public String getNazev() {
        return "jdi";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {
        if (parametry.length == 0) {
            return "Musíš zadat směr.";
        }

        String smer = parametry[0];
        Mistnost nova = svet.pohniSe(hrac, smer);

        if (nova == hrac.getAktualniMistnost()) {
            return "Tímto směrem se jít nedá.";
        }

        hrac.setAktualniMistnost(nova);

        StringBuilder sb = new StringBuilder();
        sb.append("Jdeš ").append(smer).append(".\n");
        sb.append("Jsi v místnosti: ").append(nova.getNazev()).append("\n");
        sb.append(nova.getPopis()).append("\n");

        if (!nova.getPredmety().isEmpty()) {
            sb.append("Vidíš předměty:\n");
            for (Predmet p : nova.getPredmety()) {
                sb.append("- ").append(p.getNazev()).append("\n");
            }
        }

        if (!nova.getPostavy().isEmpty()) {
            sb.append("Jsou tu postavy:\n");
            for (Postava postava : nova.getPostavy()) {
                sb.append("- ").append(postava.getJmeno()).append("\n");
            }
        }

        return sb.toString();
    }
}
