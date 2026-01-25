import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws Exception {

        // Читаем JSON файл со světem
        String jsonText = Files.readString(Path.of("IT_Project/svet.json"));

        // Преобразуем текст в JsonObject (Gson)
        JsonObject data = JsonParser.parseString(jsonText).getAsJsonObject();

        // Vytvoření světa a jeho načtení z JSON
        Svet svet = new Svet();
        svet.nacistZeJson(data);

        // Начальная místnost
        Mistnost mistnost = svet.getMistnost("vstupni_hala");
        System.out.println("Jsi v: " + mistnost.getNazev());
        System.out.println(mistnost.getPopis());

        // Pokus o pohyb na sever
        mistnost = svet.pohniSe(mistnost, "sever");
        System.out.println("Jdeš na sever → " + mistnost.getNazev());

        // Pokus o pohyb na východ
        mistnost = svet.pohniSe(mistnost, "vychod");
        System.out.println("Jdeš na východ → " + mistnost.getNazev());
    }
}
