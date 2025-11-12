package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelo.Cliente;
import modelo.Imovel;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
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

    public static List<Imovel> carregarImoveis() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = JsonImporter.class.getResourceAsStream("/json/imoveis.json");
            if (inputStream == null) {
                throw new RuntimeException("Arquivo imoveis.json não encontrado!");
            }

            return Arrays.asList(mapper.readValue(inputStream, Imovel[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
