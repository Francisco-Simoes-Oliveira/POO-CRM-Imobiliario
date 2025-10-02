package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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

        Button btnPagina1 = new Button("Página 1");
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
        btnPagina1.setOnAction(e -> centerPane.getChildren().setAll(criarPagina1()));
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

    private StackPane criarPagina1() {
        StackPane pane = new StackPane();
        pane.getChildren().add(new Label("Conteúdo complexo da Página 1"));
        // aqui você pode adicionar tabelas, imagens, campos de formulário, etc.
        return pane;
    }

    public static void main(String[] args) {
        launch(args); // inicia a aplicação
    }
}
