/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class CadastroSaboresController implements Initializable {
    
    ObservableList<Sabor> listaSabores = FXCollections.observableArrayList();
    
    @FXML
    private Label nomeSabor;

    @FXML
    private TextField tNomeSabor;

    @FXML
    private Label itemSabor;

    @FXML
    private Label precoSabor;

    @FXML
    private TextField tPrecoSabor;
    
    @FXML
    private TextArea taItens;

    @FXML
    private Button bConfirma;

    @FXML
    private Button bCancelar;

    @FXML
    private Button bSair;
    
    @FXML
    private void confirma(ActionEvent event) {
        Sabor sabor = new Sabor();
        sabor.setNome(tNomeSabor.getText());
        sabor.setItens(taItens.getText());
        sabor.setPreco(Float.parseFloat(tPrecoSabor.getText()));
        listaSabores.add(sabor);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmado");
        alert.setHeaderText(null);
        alert.setContentText("Cadastro do sabor realizado com sucesso!");
        alert.showAndWait();
        
        tNomeSabor.clear();
        tPrecoSabor.clear();
        taItens.clear();
        tNomeSabor.requestFocus();
    
    }
    
    @FXML
    private void cancela(ActionEvent event) {
        tNomeSabor.clear();
        tPrecoSabor.clear();
        taItens.clear();
        tNomeSabor.requestFocus();
    }
    
    @FXML
    private void sair(ActionEvent event) {
       
       listaSabores.forEach((i) -> {
        int id = 1;
        System.out.println("Cadastro número: " + id);
        System.out.println("Nome:" + i.getNome());
        System.out.println("Itens:" + i.getItens());
        System.out.println("Preço:" + Double.toString(i.getPreco()));
        id++;
    });
        Platform.exit();
    }
    

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
