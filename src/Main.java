import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        InputStream is = Main.class.getResourceAsStream("/svet.json");

        String jsonText;
        if (is != null) {
            jsonText = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } else {
            jsonText = Files.readString(Path.of("svet.json"));
        }

        JsonObject data = JsonParser.parseString(jsonText).getAsJsonObject();

        Svet svet = new Svet();
        svet.nacistZeJson(data);

        Mistnost start = svet.getMistnost("vstupni_hala");
        Hrac hrac = new Hrac(start);

        SpravcePrikazu spravce = new SpravcePrikazu();
        spravce.registruj(new PrikazJdi(svet));
        spravce.registruj(new PrikazSeber());
        spravce.registruj(new PrikazPoloz());
        spravce.registruj(new PrikazInventar());
        spravce.registruj(new PrikazMluv());
        spravce.registruj(new PrikazPouzij());
        spravce.registruj(new PrikazKonec());
        spravce.registruj(new PrikazNapoveda(spravce));

        Hra hra = new Hra(svet, hrac, spravce);
        hra.spustHru();

        Scanner sc = new Scanner(System.in);
        while (!hra.jeKonec()) {
            System.out.print("> ");
            String vstup = sc.nextLine();
            String vysledek = hra.zpracujVstup(vstup);
            System.out.println(vysledek);
        }
    }
}
