package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import modelo.Cargo;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Imovel;
import service.CargoService;
import service.FuncionarioService;
import service.ImovelService;
import util.JsonImporter;
import service.ClienteService;

import java.util.List;

public class ConfiguracaoController {

    @FXML
    private Button clienteJson;


    public void prencherBanco(){
        ClienteService serviceCliente = new ClienteService();
        ImovelService serviceImovel = new ImovelService();
        FuncionarioService serviceFunc = new FuncionarioService();
        CargoService cargoService = new CargoService();

        // Se o banco estiver vazio, popula com os dados do JSON
        if (serviceCliente.buscarTodos().isEmpty()) {
            List<Cliente> clientes = JsonImporter.carregarClientes();
            for (Cliente c : clientes) {
                serviceCliente.add(c);
            }
            System.out.println("Banco populado com dados do JSON!");
        } else System.out.println("ERRO: Banco Cliente populado");

        if (cargoService.buscarTodos().isEmpty()){
            cargoService.add(new Cargo("Gerente",6000.));
            cargoService.add(new Cargo("Corretor",3000.));
        }

        if (serviceFunc.buscarTodos().isEmpty()){
           serviceFunc.add(new Funcionario("Daniel Alves", "00000000000", cargoService.buscarPorNome("Corretor")));
           serviceFunc.add(new Funcionario("Toninho tornado", "00000000000", cargoService.buscarPorNome("Corretor")));
           serviceFunc.add(new Funcionario("Zico Corninhos", "00000000000", cargoService.buscarPorNome("Corretor")));
           serviceFunc.add(new Funcionario("Francisco S", "00000000000", cargoService.buscarPorNome("Gerente")));
        }

        if (serviceImovel.buscarTodos().isEmpty()) {
            List<Imovel> imoveis = JsonImporter.carregarImoveis();
            for (Imovel i : imoveis) {
                serviceImovel.add(i);
            }
            System.out.println("Banco de imóveis populado com dados do JSON!");
        } else {
            System.out.println("ERRO: Banco de imóveis já está populado");
        }
    }
}
