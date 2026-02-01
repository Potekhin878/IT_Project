import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Svet {

    private Map<String, Mistnost> mistnosti = new HashMap<>();

    public void nacistZeJson(JsonObject data) {

        JsonArray poleMistnosti = data.getAsJsonArray("mistnosti");

        // 1) vytvoření místností
        for (JsonElement element : poleMistnosti) {
            JsonObject m = element.getAsJsonObject();

            String nazev = m.get("nazev").getAsString();
            String popis = m.get("popis").getAsString();

            Mistnost mistnost = new Mistnost(nazev, popis);
            mistnosti.put(nazev, mistnost);
        }

        // 2) propojení místností
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
    }

    public Mistnost getMistnost(String nazev) {
        return mistnosti.get(nazev);
    }

    public Mistnost pohniSe(Mistnost aktualni, String smer) {
        Map<String, Mistnost> vychody = aktualni.getVychody();
        if (vychody.containsKey(smer)) {
            return vychody.get(smer);
        }
        return aktualni;
    }
}
