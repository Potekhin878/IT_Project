import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Svet {

    private Map<String, Mistnost> mistnosti = new HashMap<>();

    public void nacistZeJson(JsonObject data) {
        JsonArray poleMistnosti = data.getAsJsonArray("mistnosti");

        for (JsonElement element : poleMistnosti) {
            JsonObject m = element.getAsJsonObject();
            String nazev = m.get("nazev").getAsString();
            String popis = m.get("popis").getAsString();
            Mistnost mistnost = new Mistnost(nazev, popis);
            mistnosti.put(nazev, mistnost);
        }

        for (JsonElement element : poleMistnosti) {
            JsonObject m = element.getAsJsonObject();
            String nazev = m.get("nazev").getAsString();
            Mistnost mistnost = mistnosti.get(nazev);

            JsonObject vychody = m.getAsJsonObject("vychody");
            for (String smer : vychody.keySet()) {
                String cilNazev = vychody.get(smer).getAsString();
                Mistnost cil = mistnosti.get(cilNazev);
                mistnost.pridatVychod(smer, cil);
            }
        }

        inicializujObsah();
    }

    private void inicializujObsah() {
        // předměty
        mistnosti.get("obyvaci_pokoj")
                .pridatPredmet(new Predmet("baterka", "Stará baterka, ale ještě funguje.", true));

        mistnosti.get("kuchyne")
                .pridatPredmet(new Predmet("rukavice", "Pracovní rukavice, hodí se na zahradu.", true));

        // nepřenosné – jen pro atmosféru / případné rozšíření
        mistnosti.get("knihovna")
                .pridatPredmet(new Predmet("skrin", "Velká stará skříň, vypadá těžce.", false));

        mistnosti.get("obyvaci_pokoj")
                .pridatPredmet(new Predmet("stul", "Stůl s papírkem.", false));

        mistnosti.get("vchod")
                .pridatPredmet(new Predmet("dvere", "Vchodové dveře, zamčené.", false));

        // postavy
        mistnosti.get("knihovna")
                .pridatPostavu(new Postava("spravce",
                        "Starý správce ti šeptá: 'Klíč hledej tam, kde je největší tma a kde roste zeleň.'"));

        mistnosti.get("sklep")
                .pridatPostavu(new Postava("najemnik",
                        "Ztracený nájemník říká: 'Jestli mi dáš baterku, poradím ti víc.'"));

        mistnosti.get("zahrada")
                .pridatPostavu(new Postava("zahradnik",
                        "Zahradník říká: 'Bez rukavic nebudu pracovat. Přines mi je.'"));
    }

    public Mistnost getMistnost(String nazev) {
        return mistnosti.get(nazev);
    }

    public Mistnost pohniSe(Hrac hrac, String smer) {
        Mistnost aktualni = hrac.getAktualniMistnost();
        Map<String, Mistnost> vychody = aktualni.getVychody();
        if (!vychody.containsKey(smer)) {
            return aktualni;
        }
        Mistnost cil = vychody.get(smer);

        // speciální logika místností
        if (cil.getNazev().equals("sklep") && !hrac.getInventar().obsahuje("baterka")) {
            System.out.println("Je tam přílišná tma. Bez baterky tam nemůžeš.");
            return aktualni;
        }

        return cil;
    }
}
