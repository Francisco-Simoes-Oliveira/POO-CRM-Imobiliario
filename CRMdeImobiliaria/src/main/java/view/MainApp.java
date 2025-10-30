package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Imovel;
import modelo.JsonImporter;
import org.json.JSONObject;
import service.ClienteService;
import service.ImovelService;


import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        ClienteService service = new ClienteService();

        // Se o banco estiver vazio, popula com os dados do JSON
        if (service.buscarTodos().isEmpty()) {
            List<Cliente> clientes = JsonImporter.carregarClientes();
            for (Cliente c : clientes) {
                service.add(c);
            }
            System.out.println("Banco populado com dados do JSON!");
        }

        try {

            // debug: ver se o resource existe no classpath
            URL fxmlUrl = getClass().getResource("/sceneBuilder/MainApp.fxml");
            System.out.println("FXML URL -> " + fxmlUrl);

            if (fxmlUrl == null) {
                System.err.println("ERRO: MainApp.fxml NÃO encontrado no classpath. Verifique o caminho e resources.");
                // ajuda visual para o dev: listar a pasta resources (opcional)
            }

            FXMLLoader loader = (fxmlUrl != null) ? new FXMLLoader(fxmlUrl) : new FXMLLoader();
            Parent root = loader.load(); // aqui vai jogar a exceção se algo estiver errado

            Scene scene = new Scene(root);
            URL css = getClass().getResource("/css/style.css");
            if (css != null) scene.getStylesheets().add(css.toExternalForm());
            else System.out.println("Aviso: style.css não encontrado.");

            stage.setTitle("Programa");
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (IOException ex) {
            System.err.println("IOException ao carregar FXML:");
            ex.printStackTrace();
        } catch (RuntimeException ex) {
            System.err.println("RuntimeException ao carregar FXML (verificar fx:controller, campos @FXML, namespaces):");
            ex.printStackTrace();
        }
    }

    private GridPane listaClientePage(Stage stage) {
        ClienteService service = new ClienteService();
        List<Cliente> clientes = service.buscarTodos();
    /*            List.of(
                new Cliente("Francisco", "11570209928", "francisco@email.com", ""),
                new Cliente("Maria", "", "maria@email.com", ""),
                new Cliente("João", "", "joao@email.com", "")
        );*/

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getStyleClass().add("lista-clientes");

        for (Cliente cliente : clientes) {
            HBox clienteBox = new HBox(20);
            clienteBox.setPadding(new Insets(5));
            clienteBox.getStyleClass().add("cliente-box");

            Label nomeLabel = new Label(cliente.getNome());
            Label emailLabel = new Label(cliente.getEmail());

            clienteBox.getChildren().addAll(nomeLabel, emailLabel);
            vbox.getChildren().add(clienteBox);
        }

        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);

        GridPane grid = new GridPane();
        grid.getStyleClass().add("grid");
        grid.setAlignment(Pos.TOP_CENTER);
        grid.add(scrollPane,1,2);


        HBox barraPesquisa = new HBox(200);
        barraPesquisa.setAlignment(Pos.TOP_CENTER);
        barraPesquisa.setPadding(new Insets(5));
        barraPesquisa.getStyleClass().add("barra-pesquisa");
        Label tituloLabel = new Label("Cliente");

        Button bntAdd = new Button("Adicionar");

        barraPesquisa.getChildren().addAll(tituloLabel,bntAdd);

        grid.add(barraPesquisa,1,1);



        bntAdd.setOnAction(e-> formAddCliente(stage));


        return grid;
    }



    private void formAddCliente(Stage principalStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneBuilder/formCliente.fxml"));

            Scene scene = new Scene(loader.load());
            Stage formCliente = new Stage();
            formCliente.setScene(scene);
            formCliente.initOwner(principalStage);
            formCliente.initModality(Modality.APPLICATION_MODAL);
            formCliente.setTitle("Novo Cliente");
            formCliente.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Stage formCliente = new Stage();
        GridPane gridForm = new GridPane();
        Scene scene = new Scene(gridForm,450,300);

        Label nomeLabel = new Label("Nome*   ");
        TextField nomeField  = new TextField();

        Label cpfLabel = new Label("CPF(Apenas numeros)*   ");
        TextField cpfField  = new TextField();

        Label emailLabel = new Label("Email   ");
        TextField emailField  = new TextField();

        Label telefoneLabel = new Label("telefone  ");
        TextField telefoneField  = new TextField();

        Label esp = new Label("      ");
        gridForm.setAlignment(Pos.TOP_CENTER);
        gridForm.add(esp,1,0);
        gridForm.add(nomeLabel,0,0);
        gridForm.add(nomeField,0,1);
        gridForm.add(cpfLabel,2,0);
        gridForm.add(cpfField,2,1);
        gridForm.add(emailLabel,0,2);
        gridForm.add(emailField,0,3);
        gridForm.add(telefoneLabel,2,2);
        gridForm.add(telefoneField,2,3);


        Button salvar = new Button("SALVAR");
        salvar.setOnAction(e->{
            if(!nomeField.getText().isEmpty() && !cpfField.getText().isEmpty()) {
                if (Cliente.validarCpf(cpfField.getText())) {
                    ClienteService service = new ClienteService();
                    service.add(nomeField.getText(), cpfField.getText(),
                            emailField.getText(), telefoneField.getText());
                    formCliente.close();
                }else mostrarAlerta("Erro", "CPF inválido!");;
            }else {
                mostrarAlerta("Erro", "O campo nome e cpf são obrigatórios!");
            }
        });
        Label obs = new Label("Os campos com * são obrigatórios");
        gridForm.add(obs,0,4,1,4);
        gridForm.add(salvar,2, 4);


        formCliente.setScene(scene);

        formCliente.initOwner(principalStage);
        formCliente.initModality(Modality.APPLICATION_MODAL);

        formCliente.showAndWait();*/
    }


    public static void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.initModality(Modality.APPLICATION_MODAL); // impede interação até fechar
        alert.showAndWait();
    }



    public static void main(String[] args) {
        launch(args); // inicia a aplicação
    }
}
