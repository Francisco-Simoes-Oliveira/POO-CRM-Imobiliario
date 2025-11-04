package Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Cliente;

import java.io.InputStreamReader;
import java.util.List;

public class JsonImporter{

    public static List<Cliente> carregarClientes() {
        Gson gson = new Gson();
        try (InputStreamReader reader = new InputStreamReader(
                JsonImporter.class.getResourceAsStream("/json/clientes.json"))) {

            return gson.fromJson(reader, new TypeToken<List<Cliente>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
