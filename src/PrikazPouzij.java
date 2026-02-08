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

        Predmet p = hrac.getInventar().najdi(nazev);
        if (p == null) {
            return "Tento předmět nemáš.";
        }

        Mistnost mistnost = hrac.getAktualniMistnost();

        if (nazev.equalsIgnoreCase("hlavni_klic") && mistnost.getNazev().equals("vchod")) {
            return "Odemkl jsi dveře hlavním klíčem a utekl z domu. Vyhrál jsi!";
        }

        return "Použil jsi předmět: " + p.getNazev() + ", ale nic zvláštního se nestalo.";
    }
}
