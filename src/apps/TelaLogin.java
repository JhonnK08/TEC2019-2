/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class TelaLogin extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label lUsuario = new Label("Usuário:");
        Label lSenha = new Label("Senha:");
        TextField tUsuario = new TextField();
        TextField tSenha = new PasswordField();
        Button button = new Button("Confirma");
        Button button1 = new Button("Sair");
        Hyperlink link = new Hyperlink("Novo usuário? - Clique aqui");
       /* link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Scene scene = new Scene(TelaCadastro());
                primaryStage.setTitle("Cadastro");
                primaryStage.setScene(scene);
                primaryStage.show();
        }
        });
        */
        
        GridPane root = new GridPane();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(5));
        hbox.getChildren().add(button);
        hbox.getChildren().add(button1);
        hbox.setMargin(button, new Insets(5));
        hbox.setMargin(button1, new Insets(5));
        root.add(hbox, 0, 4);
        
        root.setHgap(6);
        root.setVgap(6);
        root.add(lUsuario, 0, 0);
        root.add(tUsuario, 1, 0);
        root.add(lSenha, 0, 2);
        root.add(tSenha,1, 2);
        root.add(link,0,3);
        GridPane.setColumnSpan(link, 2);
        GridPane.setColumnSpan(hbox, 2);
        GridPane.setHalignment(link, HPos.CENTER);
        GridPane.setHalignment(hbox, HPos.CENTER);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public GridPane telaCadastro() {
        Label lUsuario = new Label("Nome de Usuário:");
        Label lSenha = new Label("Senha:");
        Label lRepete = new Label("Repita a Senha:");
        TextField tUsuario = new TextField();
        TextField tSenha = new PasswordField();
        TextField tRepete = new PasswordField();
        Button button = new Button("Cadastrar");
        Button button1 = new Button("Sair");
        
        GridPane cadastro = new GridPane();
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.setPadding(new Insets(5));
        hbox.getChildren().add(button);
        hbox.getChildren().add(button1);
        hbox.setMargin(button, new Insets(5));
        hbox.setMargin(button1, new Insets(5));
        
        cadastro.add(hbox, 0, 4);
        cadastro.setHgap(6);
        cadastro.setVgap(6);
        cadastro.add(lUsuario, 0, 0);
        cadastro.add(tUsuario, 1, 0);
        cadastro.add(lSenha, 0, 2);
        cadastro.add(tSenha,1, 2);
        cadastro.add(lRepete, 0, 3);
        cadastro.add(tRepete,1, 3);  
        GridPane.setColumnSpan(hbox, 2);
        GridPane.setHalignment(hbox, HPos.CENTER);
        cadastro.setPadding(new Insets(10));
        
        return cadastro;      
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
