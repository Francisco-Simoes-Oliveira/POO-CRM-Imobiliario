package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modelo.Cliente;
import modelo.JsonImporter;
import service.ClienteService;

import java.util.List;

public class ConfiguracaoController {

    @FXML
    private Button clienteJson;


    public void prencherBanco(){
        ClienteService service = new ClienteService();

        // Se o banco estiver vazio, popula com os dados do JSON
        if (service.buscarTodos().isEmpty()) {
            List<Cliente> clientes = JsonImporter.carregarClientes();
            for (Cliente c : clientes) {
                service.add(c);
            }
            System.out.println("Banco populado com dados do JSON!");
        } else System.out.println("ERRO: Banco populado");
    }
}
