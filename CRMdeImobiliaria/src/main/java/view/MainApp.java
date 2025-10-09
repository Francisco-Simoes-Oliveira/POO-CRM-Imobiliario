package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Endereco;
import modelo.Imovel;
import org.json.JSONObject;
import service.ClienteService;
import service.ImovelService;


import java.io.IOException;
import java.net.URL;
import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // === Criar o layout principal ===
        BorderPane borderPane = new BorderPane();

        // === Centro (conteúdo) ===
        BorderPane contentPane = new BorderPane();
        Label label = new Label("Conteúdo inicial");
        contentPane.setCenter(label);

        borderPane.setCenter(contentPane);

        // === Topo (menu) usando HBox ===
        HBox topMenu = headerPage(contentPane,stage);
        borderPane.setTop(topMenu);

        // === Esquerda (menu lateral) usando VBox ===
        VBox sideMenu = menuPage(contentPane,stage);
        borderPane.setLeft(sideMenu);


        // === Cena e Stage ===
        Scene scene = new Scene(borderPane, 800, 600);


        scene.getStylesheets().add(
                getClass().getResource("/css/style.css").toExternalForm()
        );
        stage.setTitle("Programa");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private HBox headerPage(BorderPane contentPane,Stage stage){
        HBox topMenu = new HBox(10); // 10 = espaçamento entre elementos
        topMenu.setPadding(new Insets(10));
        topMenu.setStyle("-fx-background-color: #336699;");

        Button btnHome = new Button("Home");
        Button btnSobre = new Button("Sobre");
        Button btnSair = new Button("Sair");

        topMenu.getChildren().addAll(btnHome, btnSobre, btnSair);

        // === Ações dos botões ===
        btnHome.setOnAction(e -> contentPane.setCenter(new Label("Página Inicial")));
        btnSobre.setOnAction(e -> contentPane.setCenter(new Label("Sobre o programa")));
        btnSair.setOnAction(e -> stage.close());

        return topMenu;
    }

    private VBox menuPage(BorderPane contentPane,Stage stage){
        VBox sideMenu = new VBox(10);
        sideMenu.setPrefWidth(200);

        sideMenu.setPadding(new Insets(10));
        sideMenu.setStyle("-fx-background-color: #cccccc;");

        Button btnPagina1 = new Button("Cliente");
        Button btnPagina2 = new Button("Imovel");
        Button btnPagina3 = new Button("Página 3");

        sideMenu.getChildren().addAll(btnPagina1, btnPagina2, btnPagina3);

        // === Ações dos botões ===
        btnPagina1.setOnAction(e -> contentPane.setCenter(listaClientePage(stage)));
        btnPagina2.setOnAction(e -> contentPane.setCenter(listaImovelPage(stage)));
        btnPagina3.setOnAction(e -> contentPane.setCenter(new Label("Página 3")));


        return sideMenu;
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

    private GridPane listaImovelPage(Stage stage) {
        ImovelService service = new ImovelService();
        List<Imovel> imoveis = service.buscarTodos();
    /*            List.of(
                new Cliente("Francisco", "11570209928", "francisco@email.com", ""),
                new Cliente("Maria", "", "maria@email.com", ""),
                new Cliente("João", "", "joao@email.com", "")
        );*/

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getStyleClass().add("lista-imoveis");

        for (Imovel imovel : imoveis) {
            HBox imovelBox = new HBox(20);
            imovelBox.setPadding(new Insets(5));
            imovelBox.getStyleClass().add("imovel-box");
/*
            Label nomeLabel = new Label(imovel.getNome());
            Label emailLabel = new Label(imovel.getEmail());

            clienteBox.getChildren().addAll(nomeLabel, emailLabel);
            vbox.getChildren().add(clienteBox);*/
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
        Label tituloLabel = new Label("Imovel");

        Button bntAdd = new Button("Adicionar");

        barraPesquisa.getChildren().addAll(tituloLabel,bntAdd);

        grid.add(barraPesquisa,1,1);



        bntAdd.setOnAction(e-> formAddImovel(stage));


        return grid;
    }

    private void formAddCliente(Stage principalStage){
        try {
            System.out.println(getClass().getResource("/sceneBuilder/formCliente.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneBuilder/formCliente.fxml"));

            URL url = getClass().getResource("/sceneBuilder/formCliente.fxml");
            System.out.println("Caminho encontrado: " + url);

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

    private void formAddImovel(Stage principalStage){
        Stage formCliente = new Stage();
        GridPane gridForm = new GridPane();
        Scene scene = new Scene(gridForm,450,300);

        Label cidadeLabel = new Label("Cidade*   ");
        TextField cidadeField  = new TextField();

        Label cepLabel = new Label("CEP(Apenas numeros)*   ");
        TextField cepField  = new TextField();
        Button btnCep = new Button();

        Label ufLabel = new Label("UF   ");
        TextField ufField  = new TextField();

        Label precoLabel = new Label("Preço R$  ");
        TextField precoField  = new TextField();

        Label esp = new Label("      ");
        gridForm.setAlignment(Pos.TOP_CENTER);
        gridForm.add(esp,1,0);
        gridForm.add(cidadeLabel,0,0);
        gridForm.add(cidadeField,0,1);
        gridForm.add(cepLabel,2,0);
        gridForm.add(cepField,2,1);
        gridForm.add(btnCep,3,1);
        gridForm.add(ufLabel,0,2);
        gridForm.add(ufField,0,3);
        gridForm.add(precoLabel,2,2);
        gridForm.add(precoField,2,3);

        btnCep.setOnAction(e->{
            JSONObject ojt = Endereco.buscaViaCep(cepField.getText());
            cidadeField.setText(ojt.getString("localidade"));
            ufField.setText(ojt.getString("uf"));
        });

        Button salvar = new Button("SALVAR");
        salvar.setOnAction(e->{
            if(!cidadeLabel.getText().isEmpty() && !cepLabel.getText().isEmpty()) {
                if (Cliente.validarCpf(cepLabel.getText())) {
                    ClienteService service = new ClienteService();
                    service.add(cidadeField.getText(), cepField.getText(),
                            ufField.getText(), precoField.getText());
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

        formCliente.showAndWait();
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
