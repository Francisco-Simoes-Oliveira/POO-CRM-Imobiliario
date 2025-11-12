package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Imovel;

import java.io.IOException;

public class ImovelController extends BaseController {

    @FXML private ComboBox<String> comboFiltro;
    @FXML private TextField campoPesquisa;

    @FXML
    private TableView<Cliente> tabelaClientes;
    private ObservableList<Cliente> clientesObservable;

    @FXML
    private TableColumn<Cliente, String> colunaId;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaEmail;
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    @FXML
    private TableColumn<Cliente, String> colunaStatus;

    @FXML
    private TableColumn<Cliente, Void> colunaAcoes;

    @FXML
    public void initialize() {
        comboFiltro.getSelectionModel().selectFirst(); // Seleciona "Nome" por padrão


        // 1️⃣ Vincula cada coluna à propriedade correspondente da classe Cliente
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("status"));


        // 2️⃣ Define tamanhos preferenciais (servem como "proporções")
        colunaId.setPrefWidth(60);
        colunaNome.setPrefWidth(200);
        colunaEmail.setPrefWidth(240);
        colunaTelefone.setPrefWidth(120);
        colunaStatus.setPrefWidth(120);

        // (Opcional) Define tamanhos mínimos para não espremer demais
        colunaNome.setMinWidth(150);
        colunaEmail.setMinWidth(180);

        // 3️⃣ Ativa o redimensionamento automático das colunas
        tabelaClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        // 4️⃣ Carrega os
        carregarClientes();

        campoPesquisa.textProperty().addListener((obs, oldVal, newVal) -> pesquisar());

        tabelaClientes.setRowFactory(tv -> {
            TableRow<Cliente> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    Cliente clienteSelecionado = row.getItem();
                    abrirModalEdicao(clienteSelecionado);
                }
            });
            return row;
        });

        colunaAcoes.setCellFactory(coluna -> new TableCell<>() {
            private final Button btn = new Button("Editar");

            {
                btn.getStyleClass().add("edit-button"); // se quiser estilizar no CSS
                btn.setOnAction(event -> {
                    Cliente cliente = getTableView().getItems().get(getIndex());
                    abrirModalEdicao(cliente);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : btn);
            }
        });

    }

    @FXML
    private void abrirNovoImovelModal(){
        try {
            // Carrega o FXML do modal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneBuilder/FormImovel.fxml"));
            Parent root = loader.load();

            FormClienteController controller = loader.getController();
            controller.setClientesObservable(clientesObservable);

            // Cria um novo stage
            Stage modalStage = new Stage();
            modalStage.setTitle("Novo Imovel");

            // Define que é modal (bloqueia a janela principal enquanto está aberto)
            modalStage.initModality(Modality.APPLICATION_MODAL);

            // Faz com que fique "sobre" a janela principal
            modalStage.initOwner(conteudo.getScene().getWindow());

            // Cria a cena e mostra
            Scene scene = new Scene(root);
            modalStage.setScene(scene);
            modalStage.showAndWait(); // espera o usuário fechar

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarClientes() {
        clientesObservable = FXCollections.observableArrayList(service.buscarTodos());
        tabelaClientes.setItems(clientesObservable);
    }

    private void abrirModalEdicao(Imovel imovel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneBuilder/FormCliente.fxml"));
            Parent root = loader.load();

            // Passa o cliente selecionado para o controlador do modal
            FormImovelController controller = loader.getController();
            controller.setCliente(imovel); // você cria esse método no FormClienteController

            Stage stage = new Stage();
            stage.setTitle("Editar Cliente");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(conteudo.getScene().getWindow());

            stage.setScene(new Scene(root));
            stage.showAndWait(); // bloqueia até o modal ser fechado

            // Atualiza a tabela depois que o modal fecha
            tabelaClientes.setItems(FXCollections.observableArrayList(service.buscarTodos()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
