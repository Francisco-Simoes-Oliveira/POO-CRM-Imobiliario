package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField campoNome;

    @FXML
    private Button botaoSalvar;

    @FXML
    private void salvar() {
        System.out.println("Nome digitado: " + campoNome.getText());
    }
}
