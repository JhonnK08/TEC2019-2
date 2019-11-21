/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Jhonatan
 */
public class TelaLoginController implements Initializable{
    @FXML
    private Label lUsuario;

    @FXML
    private TextField tUsuario;

    @FXML
    private Label lSenha;

    @FXML
    private TextField tSenha;

    @FXML
    private Hyperlink linkNovo;

    @FXML
    private Button bConfirma;

    @FXML
    private Button bSair;

    @FXML
    void confirma(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) {

    }

    @FXML
    void telaCadastro(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
