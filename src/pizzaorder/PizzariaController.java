/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class PizzariaController implements Initializable {

    @FXML
    private Menu Cadastros;

    @FXML
    private MenuItem Tamanho;

    @FXML
    private MenuItem tipoMassa;

    @FXML
    private MenuItem Sabores;

    @FXML
    private MenuItem Sair;

    @FXML
    private Menu Pedidos;

    @FXML
    private MenuItem fazerPedido;

    @FXML
    private Menu Relatorios;

    @FXML
    private MenuItem listaPedidos;
    
    @FXML
    void cadastroSabor(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cadastroSaboresFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Sabores");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a página");
        }
    }
    
    @FXML
    void fazerPedido (ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PizzaOrderFXML.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Fazer Pedido");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar a página");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
}
