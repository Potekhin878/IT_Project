import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws Exception {

        // Načtení JSON
        String jsonText = Files.readString(Path.of("svet.json"));
        JsonObject data = JsonParser.parseString(jsonText).getAsJsonObject();

        // Vytvoření světa
        Svet svet = new Svet();
        svet.nacistZeJson(data);

        // Hráč začíná ve vstupní hale
        Mistnost start = svet.getMistnost("vstupni_hala");
        Hrac hrac = new Hrac(start);

        // Správce příkazů
        SpravcePrikazu spravce = new SpravcePrikazu();

        spravce.registruj(new PrikazJdi(svet));
        spravce.registruj(new PrikazSeber());
        spravce.registruj(new PrikazPoloz());
        spravce.registruj(new PrikazInventar());
        spravce.registruj(new PrikazMluv());
        spravce.registruj(new PrikazPouzij());
        spravce.registruj(new PrikazKonec());
        spravce.registruj(new PrikazNapoveda(spravce));

        // 🔥 Herní smyčka
        Scanner sc = new Scanner(System.in);

        System.out.println("Vítej ve hře!");
        System.out.println(start.getPopis());

        while (true) {
            System.out.print("> ");
            String vstup = sc.nextLine();
            String vysledek = spravce.provedPrikaz(hrac, vstup);
            System.out.println(vysledek);
        }
    }
}
