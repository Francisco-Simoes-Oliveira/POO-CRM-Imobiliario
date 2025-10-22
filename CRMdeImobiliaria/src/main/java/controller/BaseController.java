package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public abstract class BaseController {

    protected StackPane conteudo; // referência compartilhada

    public void setConteudo(StackPane conteudo) {
        this.conteudo = conteudo;
    }

    protected void trocarTela(String caminhoFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(caminhoFXML));
            Node novaTela = loader.load();

            // vincula o mesmo StackPane ao novo controller
            Object controller = loader.getController();
            if (controller instanceof BaseController baseCtrl) {
                baseCtrl.setConteudo(conteudo);
            }

            conteudo.getChildren().setAll(novaTela);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
