package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainAppController {

    @FXML
    private TextField campoNome;

    @FXML
    private Button Sair;

    @FXML
    private void onSairClick(ActionEvent event) {
        Platform.exit();
    }
}
