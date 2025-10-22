package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MainAppController extends BaseController {

    @FXML
    private StackPane conteudo;

    @FXML
    private void initialize() {
        // ao iniciar, carrega a tela de imóveis por padrão
        trocarTela("/scaneBuilder/ClientesView.fxml");
    }

    @FXML
    private void abrirImoveis() {
        trocarTela("/scaneBuilder/ImoveisView.fxml");
    }

    @FXML
    private void abrirClientes() {
        trocarTela("/scaneBuilder/ClientesView.fxml");
    }

    @FXML
    private void abrirVisitas() {
        trocarTela("/scaneBuilder/VisitasView.fxml");
    }

    @FXML
    private void abrirRelatorios() {
        trocarTela("/scaneBuilder/RelatoriosView.fxml");
    }
    @FXML
    private Button Sair;

    @FXML
    private void onSairClick(ActionEvent event) {
        Platform.exit();
    }
}
