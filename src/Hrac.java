public class Hrac {

    private Mistnost aktualniMistnost;
    private final Inventar inventar = new Inventar();

    public Hrac(Mistnost start) {
        this.aktualniMistnost = start;
    }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost mistnost) {
        this.aktualniMistnost = mistnost;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public String seberPredmet(String nazev) {
        for (Predmet p : aktualniMistnost.getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {

                if (!p.jePrenosny()) {
                    return "Tento předmět nemůžeš sebrat.";
                }

                if (!inventar.pridejPredmet(p)) {
                    return "Inventář je plný.";
                }

                aktualniMistnost.getPredmety().remove(p);
                return "Sebral jsi: " + p.getNazev();
            }
        }
        return "Takový předmět tu není.";
    }

    public String polozPredmet(String nazev) {
        for (Predmet p : inventar.getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                inventar.odeberPredmet(p);
                aktualniMistnost.getPredmety().add(p);
                return "Položil jsi: " + p.getNazev();
            }
        }
        return "Tento předmět nemáš.";
    }
}
