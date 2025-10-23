package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cliente;
import service.ClienteService;
import view.MainApp;

import java.awt.event.ActionEvent;

public class FormClienteController {
    private ClienteService service = new ClienteService();

    @FXML private TextField nomeField;
    @FXML private TextField cpfField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;

    @FXML
    private void salvar() {
        if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
            MainApp.mostrarAlerta("Erro", "O campo nome e CPF são obrigatórios!");
            return;
        }
        if(!nomeField.getText().isEmpty() && !cpfField.getText().isEmpty()) {
            if (Cliente.validarCpf(cpfField.getText())) {
                ClienteService service = new ClienteService();
                service.add(nomeField.getText(), cpfField.getText(),
                        emailField.getText(), telefoneField.getText());
                Stage stage = (Stage) nomeField.getScene().getWindow();
                stage.close();
            }else MainApp.mostrarAlerta("Erro", "CPF inválido!");;
        }
    }
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