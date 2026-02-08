public class Hra {

    private final Svet svet;
    private final Hrac hrac;
    private final SpravcePrikazu spravce;
    private boolean konec = false;

    public Hra(Svet svet, Hrac hrac, SpravcePrikazu spravce) {
        this.svet = svet;
        this.hrac = hrac;
        this.spravce = spravce;
    }

    public void spustHru() {
        System.out.println("Vítej ve hře Tajemství starého domu!");
        System.out.println(hrac.getAktualniMistnost().getPopis());
    }

    public String zpracujVstup(String vstup) {
        String vysledek = spravce.provedPrikaz(hrac, vstup);

        if (vysledek.contains("Vyhrál jsi")) {
            konec = true;
        }

        return vysledek;
    }

    public void ukonciHru() {
        konec = true;
    }

    public boolean jeKonec() {
        return konec;
    }
}
