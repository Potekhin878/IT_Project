package game;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Predmet;
import model.Postava;

import java.util.HashMap;
import java.util.Map;

/**
 * Herní svět obsahující všechny místnosti.
 * Umožňuje načtení mapy ze souboru JSON
 * a pohyb hráče mezi místnostmi.
 */
public class Svet {

    private final Map<String, Mistnost> mistnosti = new HashMap<>();

    /** Načte svět z JSON souboru. */
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

    /** Inicializuje předměty a postavy ve světě. */
    private void inicializujObsah() {
        mistnosti.get("obyvaci_pokoj")
                .pridatPredmet(new Predmet("baterka", "Stará baterka.", true));

        mistnosti.get("kuchyne")
                .pridatPredmet(new Predmet("rukavice", "Pracovní rukavice.", true));

        mistnosti.get("knihovna")
                .pridatPredmet(new Predmet("skrin", "Velká skříň.", false));

        mistnosti.get("obyvaci_pokoj")
                .pridatPredmet(new Predmet("stul", "Stůl.", false));

        mistnosti.get("vchod")
                .pridatPredmet(new Predmet("dvere", "Zamčené dveře.", false));

        mistnosti.get("knihovna")
                .pridatPostavu(new Postava("spravce",
                        "Klíč hledej tam, kde je tma a roste zeleň."));

        mistnosti.get("sklep")
                .pridatPostavu(new Postava("najemnik",
                        "Dej mi baterku a poradím ti víc."));

        mistnosti.get("zahrada")
                .pridatPostavu(new Postava("zahradnik",
                        "Bez rukavic nebudu pracovat."));
    }

    /** Vrátí místnost podle názvu. */
    public Mistnost getMistnost(String nazev) {
        return mistnosti.get(nazev);
    }

    /**
     * Pokusí se přesunout hráče do směru.
     * Obsahuje speciální logiku (např. zákaz vstupu do sklepa bez baterky).
     */
    public Mistnost pohniSe(Hrac hrac, String smer) {
        Mistnost aktualni = hrac.getAktualniMistnost();
        Map<String, Mistnost> vychody = aktualni.getVychody();

        if (!vychody.containsKey(smer)) {
            return aktualni;
        }

        Mistnost cil = vychody.get(smer);

        if (cil.getNazev().equals("sklep")
                && !hrac.getInventar().obsahuje("baterka")) {
            System.out.println("Je tam tma. Bez baterky tam nemůžeš.");
            return aktualni;
        }

        return cil;
    }
}
