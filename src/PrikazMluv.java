public class PrikazMluv implements Prikaz {

    @Override
    public String getNazev() {
        return "mluv";
    }

    @Override
    public String proved(Hrac hrac, String[] parametry) {

        if (parametry.length == 0) {
            return "S kým chceš mluvit?";
        }

        String jmeno = parametry[0];

        for (Postava p : hrac.getAktualniMistnost().getPostavy()) {
            if (p.getJmeno().equalsIgnoreCase(jmeno)) {
                return p.mluv();
            }
        }

        return "Taková postava tu není.";
    }
}
