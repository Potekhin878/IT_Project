package game;

import commands.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Hlavní třída hry.
 * Načítá JSON soubor, vytváří svět, hráče a registruje příkazy.
 */
public class Main {

    public static void main(String[] args) {

        // 1) Načtení JSON souboru svet.json
        InputStream is = Main.class.getResourceAsStream("/svet.json");
        if (is == null) {
            System.out.println("Soubor svet.json nebyl nalezen!");
            return;
        }

        JsonObject data = JsonParser.parseReader(new InputStreamReader(is)).getAsJsonObject();

        // 2) Vytvoření světa
        Svet svet = new Svet();
        svet.nacistZeJson(data);

        // 3) Vytvoření hráče (startovní místnost = "vchod")
        Hrac hrac = new Hrac(svet.getMistnost("vchod"));

        // 4) Správce příkazů
        SpravcePrikazu spravce = new SpravcePrikazu();

        // 5) Registrace příkazů
        spravce.registruj(new PrikazJdi(svet));
        spravce.registruj(new PrikazSeber());
        spravce.registruj(new PrikazPoloz());
        spravce.registruj(new PrikazInventar());
        spravce.registruj(new PrikazMluv());
        spravce.registruj(new PrikazPouzij());
        spravce.registruj(new PrikazNapoveda(spravce));
        spravce.registruj(new PrikazKonec());

        // 6) Vytvoření hry
        Hra hra = new Hra(svet, hrac, spravce);

        // 7) Úvod
        hra.spustHru();

        // 8) Herní smyčka
        java.util.Scanner sc = new java.util.Scanner(System.in);

        while (!hra.jeKonec()) {
            System.out.print("> ");
            String vstup = sc.nextLine();
            String odpoved = hra.zpracujVstup(vstup);
            System.out.println(odpoved);
        }
    }
}
