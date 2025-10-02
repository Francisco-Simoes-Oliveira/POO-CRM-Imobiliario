package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Cliente;

import java.util.List;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        // === Criar o layout principal ===
        BorderPane borderPane = new BorderPane();

        // === Topo (menu) usando HBox ===
        HBox topMenu = new HBox(10); // 10 = espaçamento entre elementos
        topMenu.setPadding(new Insets(10));
        topMenu.setStyle("-fx-background-color: #336699;");

        Button btnHome = new Button("Home");
        Button btnSobre = new Button("Sobre");
        Button btnSair = new Button("Sair");

        topMenu.getChildren().addAll(btnHome, btnSobre, btnSair);
        borderPane.setTop(topMenu);

        // === Esquerda (menu lateral) usando VBox ===
        VBox sideMenu = new VBox(10);
        sideMenu.setPrefWidth(200);

        sideMenu.setPadding(new Insets(10));
        sideMenu.setStyle("-fx-background-color: #cccccc;");

        Button btnPagina1 = new Button("Clinte");
        Button btnPagina2 = new Button("Página 2");
        Button btnPagina3 = new Button("Página 3");

        sideMenu.getChildren().addAll(btnPagina1, btnPagina2, btnPagina3);
        borderPane.setLeft(sideMenu);

        // === Centro (conteúdo) ===
        BorderPane contentPane = new BorderPane();
        Label label = new Label("Conteúdo inicial");
        contentPane.setCenter(label);

        borderPane.setCenter(contentPane);

        // === Ações dos botões ===
        btnPagina1.setOnAction(e -> contentPane.setCenter(criarListaCliente()));
        btnPagina2.setOnAction(e -> contentPane.setCenter(new Label("Página 2")));
        btnPagina3.setOnAction(e -> contentPane.setCenter(new Label("Página 3")));
        btnHome.setOnAction(e -> contentPane.setCenter(new Label("Página Inicial")));
        btnSobre.setOnAction(e -> contentPane.setCenter(new Label("Sobre o programa")));
        btnSair.setOnAction(e -> stage.close());
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

    private GridPane criarListaCliente() {
        List<Cliente> clientes = List.of(
                new Cliente("Francisco", "", "francisco@email.com", ""),
                new Cliente("Maria", "", "maria@email.com", ""),
                new Cliente("João", "", "joao@email.com", "")
        );

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
        grid.add(scrollPane,5,3);

        HBox barraPesquisa = new HBox(50);
        barraPesquisa.setPadding(new Insets(5));
        barraPesquisa.getStyleClass().add("barra-pesquisa");
        Label tituloLabel = new Label("Cliente");

        barraPesquisa.getChildren().addAll(tituloLabel);

        grid.add(barraPesquisa,1,2);

        Button bnt
        return grid;
    }

    public static void main(String[] args) {
        launch(args); // inicia a aplicação
    }
}
