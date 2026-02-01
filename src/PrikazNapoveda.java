public class PrikazNapoveda implements Prikaz {

    private final SpravcePrikazu spravce;

    public PrikazNapoveda(SpravcePrikazu spravce) {
        this.spravce = spravce;
    }

    @Override
    public String getNazev() {
        return "napoveda";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {
        return "Dostupné příkazy: " + spravce.seznamPrikazu();
    }
}
