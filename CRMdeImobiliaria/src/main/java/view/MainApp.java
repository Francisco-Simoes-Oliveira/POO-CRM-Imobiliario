package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        sideMenu.setPadding(new Insets(10));
        sideMenu.setStyle("-fx-background-color: #cccccc;");

        Button btnPagina1 = new Button("Clinte");
        Button btnPagina2 = new Button("Página 2");
        Button btnPagina3 = new Button("Página 3");

        sideMenu.getChildren().addAll(btnPagina1, btnPagina2, btnPagina3);
        borderPane.setLeft(sideMenu);

        // === Centro (conteúdo) ===
        StackPane centerPane = new StackPane();
        Label label = new Label("Conteúdo inicial");
        centerPane.getChildren().add(label);
        borderPane.setCenter(centerPane);

        // === Ações dos botões ===
        btnPagina1.setOnAction(e -> centerPane.getChildren().setAll(criarListaCliente()));
        btnPagina2.setOnAction(e -> label.setText("Página 2"));
        btnPagina3.setOnAction(e -> label.setText("Página 3"));
        btnHome.setOnAction(e -> label.setText("Página Inicial"));
        btnSobre.setOnAction(e -> label.setText("Sobre o programa"));
        btnSair.setOnAction(e -> stage.close());

        // === Cena e Stage ===
        Scene scene = new Scene(borderPane, 800, 600);
        stage.setTitle("Programa");
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    private VBox criarListaCliente() {
        // Lista de clientes (exemplo)
        List<Cliente> clientes = List.of(
                new Cliente("Francisco", "","francisco@email.com",""),
                new Cliente("Maria", "","maria@email.com", ""),
                new Cliente("João", "","joao@email.com", "")
        );

        VBox vbox = new VBox(10); // 10 = espaçamento vertical
        vbox.setPadding(new Insets(10));

        for (Cliente cliente : clientes) {
            HBox clienteBox = new HBox(20); // 20 = espaçamento horizontal
            clienteBox.setPadding(new Insets(5));
            clienteBox.setStyle("-fx-border-color: gray; -fx-border-width: 1;");

            Label nomeLabel = new Label(cliente.getNome());
            Label emailLabel = new Label(cliente.getEmail());

            clienteBox.getChildren().addAll(nomeLabel, emailLabel);
            vbox.getChildren().add(clienteBox);
        }

        return vbox;
    }

    public static void main(String[] args) {
        launch(args); // inicia a aplicação
    }
}
