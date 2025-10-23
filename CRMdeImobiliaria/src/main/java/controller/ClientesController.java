package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import service.ClienteService;

import java.io.IOException;


public class ClientesController extends BaseController {

    private ClienteService service = new ClienteService();


    @FXML
    private void abrirImoveis() {
        trocarTela("/view/ImoveisView.fxml");

    }



    @FXML
    private Button NovoCliente;

    @FXML
    private void abrirNovoClienteModal() {
        try {
            // Carrega o FXML do modal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneBuilder/FormCliente.fxml"));
            Parent root = loader.load();

            // Cria um novo stage
            Stage modalStage = new Stage();
            modalStage.setTitle("Novo Cliente");

            // Define que é modal (bloqueia a janela principal enquanto está aberto)
            modalStage.initModality(Modality.APPLICATION_MODAL);

            // Faz com que fique "sobre" a janela principal
            modalStage.initOwner(conteudo.getScene().getWindow());

            // Cria a cena e mostra
            Scene scene = new Scene(root);
            modalStage.setScene(scene);
            modalStage.showAndWait(); // espera o usuário fechar

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TableView<Cliente> tabelaClientes;

    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaEmail;
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    @FXML
    private TableColumn<Cliente, String> colunaStatus;
    @FXML
    private TableColumn<Cliente, String> colunaCorretor;

    @FXML
    public void initialize() {
        // Vincula cada coluna a uma propriedade da classe Cliente
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("statusInteresse"));
        colunaCorretor.setCellValueFactory(new PropertyValueFactory<>("corretor"));

        tabelaClientes.setItems(FXCollections.observableArrayList(service.buscarTodos()));
    }
}
