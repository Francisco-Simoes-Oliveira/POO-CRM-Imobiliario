package controller;

import javafx.fxml.FXML;


public class ClientesController extends BaseController {
    @FXML
    private void abrirImoveis() {
        trocarTela("/view/ImoveisView.fxml");

    }
}
