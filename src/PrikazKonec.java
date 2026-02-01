public class PrikazKonec implements Prikaz {

    @Override
    public String getNazev() {
        return "konec";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {
        System.exit(0);
        return "Hra ukončena.";
    }
}
