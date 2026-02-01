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
        Mistnost nova = svet.pohniSe(hrac.getAktualniMistnost(), smer);

        if (nova == hrac.getAktualniMistnost()) {
            return "Tímto směrem se jít nedá.";
        }

        hrac.setAktualniMistnost(nova);

        return "Jdeš " + smer + ".\n" +
                "Jsi v místnosti: " + nova.getNazev() + "\n" +
                nova.getPopis();
    }
}


