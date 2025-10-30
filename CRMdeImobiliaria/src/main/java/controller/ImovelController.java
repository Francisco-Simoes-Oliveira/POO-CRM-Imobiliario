package controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Imovel;

public class ImovelController {


}


/*
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

    private GridPane listaImovelPage(Stage stage) {
        ImovelService service = new ImovelService();
        List<Imovel> imoveis = service.buscarTodos();
               List.of(
                new Cliente("Francisco", "11570209928", "francisco@email.com", ""),
                new Cliente("Maria", "", "maria@email.com", ""),
                new Cliente("João", "", "joao@email.com", "")
        );

VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getStyleClass().add("lista-imoveis");

        for (
Imovel imovel : imoveis) {
HBox imovelBox = new HBox(20);
            imovelBox.setPadding(new Insets(5));
        imovelBox.getStyleClass().add("imovel-box");

            Label nomeLabel = new Label(imovel.getNome());
            Label emailLabel = new Label(imovel.getEmail());

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
Label tituloLabel = new Label("Imovel");

Button bntAdd = new Button("Adicionar");

        barraPesquisa.getChildren().addAll(tituloLabel,bntAdd);

        grid.add(barraPesquisa,1,1);



        bntAdd.setOnAction(e-> formAddImovel(stage));


        return grid;
    }

*/
