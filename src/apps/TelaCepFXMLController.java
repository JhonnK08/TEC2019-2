/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class TelaCepFXMLController implements Initializable {
    
    @FXML
    private TextField txCep;

    @FXML
    private TextField txRua;

    @FXML
    private ComboBox<String> cbUF;

    @FXML
    private ListView<String> lvCidades;

    @FXML
    private Button bAdicionarCity;

    @FXML
    private Button bRemoverCity;

    @FXML
    private Button bGravar;

    @FXML
    private Button bApagar;

    @FXML
    private Button bSair;
    
    private ObservableList <CEP> listaCEPs;
    
    private ObservableList <String> listaUF;
    
    private ObservableList <ObservableList<String>> listaCidade;
            
    private ObservableList <String> listaRua; 
    
    @FXML
    private TableColumn<CEP, Integer> CEPColumn;
    @FXML
    private TableColumn<CEP, String> ruaColumn;
    @FXML
    private TableColumn<CEP, String> cidadeColumn;
    @FXML
    private TableView<CEP> tabela;
    @FXML
    private TableColumn<CEP, String> UFColumn;

    @FXML
    void adicionarCity(ActionEvent event) {
        int ind = cbUF.getSelectionModel().getSelectedIndex();
        listaCidade.get(ind).add(new String("Digite uma nova cidade"));
    }

    @FXML
    void apagar(ActionEvent event) {
        txCep.clear();
        txRua.clear();
    }

    @FXML
    void buscaCidade(ActionEvent event) {
        int ind = cbUF.getSelectionModel().getSelectedIndex();
        lvCidades.setItems(listaCidade.get(ind));
    }

    @FXML
    void gravar(ActionEvent event) {
        int ind = cbUF.getSelectionModel().getSelectedIndex();
        listaCidade.get(ind).setAll(listaRua);
    }

    @FXML
    void removerCity(ActionEvent event) {
        int ind = cbUF.getSelectionModel().getSelectedIndex();
        int ind2 = lvCidades.getSelectionModel().getSelectedIndex();
        listaCidade.get(ind).remove(ind2);
        
    }

    @FXML
    void sair(ActionEvent event) {
        Platform.exit();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaUF = FXCollections.observableArrayList("AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO");
        cbUF.setItems(listaUF);
        lvCidades.setEditable(true);
        lvCidades.setCellFactory(TextFieldListCell.forListView());
        for(int i = 0;i<listaUF.size();i++) {
            listaCidade =  FXCollections.observableArrayList();
        }    
        tabela.setItems(listaCEPs);
        CEPColumn.setCellValueFactory(new PropertyValueFactory<>("cep"));
        ruaColumn.setCellValueFactory(new PropertyValueFactory<>("rua"));
        cidadeColumn.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        UFColumn.setCellValueFactory(new PropertyValueFactory<>("UF"));
}

    @FXML
    private void editarCEP(TableColumn.CellEditEvent<CEP, Integer> event) {
    }

    @FXML
    private void editarRua(TableColumn.CellEditEvent<CEP, String> event) {
        event.getTableView().getItems().get(
        event.getTablePosition().getRow()).setRua(event.getNewValue());
    }

    @FXML
    private void editarCidade(TableColumn.CellEditEvent<CEP, String> event) {
    }

    @FXML
    private void editarUF(TableColumn.CellEditEvent<CEP, String> event) {
    }
}
