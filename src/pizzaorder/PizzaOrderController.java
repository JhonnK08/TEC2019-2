/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import tiposDados.ItensPedido;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class PizzaOrderController implements Initializable {

    @FXML
    private BorderPane paneMain;

    @FXML
    private HBox paneTop;

    @FXML
    private Label lTitulo;

    @FXML
    private VBox paneCenter;

    @FXML
    private VBox paneCostumer;

    @FXML
    private HBox paneName;

    @FXML
    private Label lNome;

    @FXML
    private TextField tNome;

    @FXML
    private HBox panePhone;

    @FXML
    private Label lPhone;

    @FXML
    private TextField tPhone;

    @FXML
    private HBox paneAddress;

    @FXML
    private Label lEndereco;

    @FXML
    private TextField tEndereco;

    @FXML
    private HBox paneOrder;

    @FXML
    private VBox paneSize;

    @FXML
    private Label lTamanho;

    @FXML
    private RadioButton rbPequena;

    @FXML
    private ToggleGroup rbGroupTamanho;

    @FXML
    private RadioButton rbMedia;

    @FXML
    private RadioButton rbGrande;

    @FXML
    private VBox paneCrust;

    @FXML
    private Label lEspessura;

    @FXML
    private RadioButton rbFina;

    @FXML
    private ToggleGroup rbGroupEspessura;

    @FXML
    private RadioButton rbGrossa;

    @FXML
    private VBox paneTopping;

    @FXML
    private Label lCobertura;

    @FXML
    private FlowPane paneToppings;

    @FXML
    private HBox paneBottom;

    @FXML
    private Button bOk;

    @FXML
    private Button bCancela;


    @FXML
    private MenuItem calcularPedido;

    private ListView<?> listViewPedido;
    
    private ObservableList oList;
    
    @FXML
    private ComboBox<Sabor> cbCobertura;

    private ObservableList<Sabor> coberturas;
   
    @FXML
    private TableView<ItensPedido> tablePedido;
    
    @FXML
    private MenuItem excluiPedido;
    
    @FXML
    private TableColumn<ItensPedido, String> columnTamanho;
    @FXML
    private TableColumn<ItensPedido, String> columnEspessura;
    @FXML
    private TableColumn<ItensPedido, String> columnSabor;
    @FXML
    private TableColumn<ItensPedido, Double> columnValor;

    @FXML
    void calculaPedido(ActionEvent event) {
        int i = tablePedido.getSelectionModel().getSelectedIndex();
        ItensPedido itens = (ItensPedido) oList.get(i);
        itens.calcularValor(itens.getTamanho(), itens.getEspessura(), itens.getValor());
        oList.remove(i);
        oList.add(i, itens);
        tablePedido.refresh();
//        Alert alert = new Alert(AlertType.INFORMATION);
//        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
//        alert.setTitle("Pedido Calculado!");
//        alert.setHeaderText(null);
//        alert.setContentText("Valor do pedido calculado com sucesso!");
//        alert.showAndWait();
        
    }

    @FXML
    void excluirPedido(ActionEvent event) {
        int i = tablePedido.getSelectionModel().getSelectedIndex();
        oList.remove(i);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("Pedido Excluido");
        alert.setHeaderText(null);
        alert.setContentText("Pedido excluído com sucesso!");
        alert.showAndWait();
        tablePedido.refresh();
    }

    @FXML
    void cancelaPedido(ActionEvent event) {
        tEndereco.clear();
        tNome.clear();
        tPhone.clear();
    }

    @FXML
    void confirmaPedido(ActionEvent event) {
        String nome = tNome.getText();
        String endereco = tEndereco.getText();
        String telefone = tPhone.getText();
        String tamanho = null;
        String espessura = null;
        Sabor sabor = cbCobertura.getSelectionModel().getSelectedItem();

        if (rbGrande.isSelected()) {
            tamanho = "Grande";
        } else if (rbMedia.isSelected()) {
            tamanho = "Médio";
        } else if (rbPequena.isSelected()) {
            tamanho = "Pequeno";
        }

        if (rbFina.isSelected()) {
            espessura = "Fina";
        } else if (rbGrossa.isSelected()) {
            espessura = "Grossa";
        }
        ItensPedido itens = new ItensPedido(tamanho, espessura, sabor.getNome(), sabor.getPreco());
        String msg = "CLIENTE:\n";
        msg += "Nome: " + nome + "\n";
        msg += "Endereço: " + endereco + "\n";
        msg += "Telefone: " + telefone + "\n";
        msg += nome + " pediu uma pizza " + sabor.getNome()+ " " + tamanho + " com massa " + espessura;

        oList.add(itens);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("Pedido Cadastrado!");
        alert.setHeaderText(null);
        alert.setContentText("Pedido cadastrado com sucesso!\n\n" + msg);
        alert.showAndWait();

        tEndereco.clear();
        tNome.clear();
        tPhone.clear();

    }
    private ObservableList<Sabor> buscaSabores() {
       ObservableList<Sabor> listaSabores = FXCollections.observableArrayList();
       Sabor sabor1 = new Sabor("Quatro queijos", "São quatro queijos", 40.00);
       listaSabores.add(sabor1);
       Sabor sabor2 = new Sabor("Calabresa", "Calabresa e mais alguns ingredientes", 35.00);
       listaSabores.add(sabor2);
       Sabor sabor3 = new Sabor("Chocolate preto", "Pizza de chocolate com Nescau", 50.00);
       listaSabores.add(sabor3);
       return listaSabores;
   
   }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //coberturas = FXCollections.observableArrayList("Pepperoni", "Salsicha", "Calabresa", "Azeitona", "Cogumelos", "Tomates", "Anchovas");
        
        cbCobertura.setItems(buscaSabores());
        //cbCobertura.setCellFactory();
        oList = FXCollections.observableArrayList();
        tablePedido.setItems(oList);
        columnEspessura.setCellValueFactory(new PropertyValueFactory<>("espessura"));
        columnTamanho.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        columnSabor.setCellValueFactory(new PropertyValueFactory<>("sabor"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

}
