/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class CadastroUsuario extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MenuBar menu = new MenuBar();
        Menu menuUsuario = new Menu("Usuários");
        MenuItem menuItemCadastro = new MenuItem("Cadastro de usuário");
        MenuItem menuItemBusca = new MenuItem("Busca de usuários");
        MenuItem menuItemExcluir = new MenuItem("Exclusão de usuários");
        Menu menuSabores = new Menu("Sabores");
        MenuItem menuItemSaboresCadastro = new MenuItem("Cadastro de sabores");
        MenuItem menuItemSaboresBusca = new MenuItem("Busca de sabores");
        MenuItem menuItemSaboresExcluir = new MenuItem("Exclusão de sabores");
        Menu menuCEP = new Menu("CEP");
        Menu menuArquivo = new Menu("Arquivo");
        MenuItem menuSair = new MenuItem("Sair");
        menuArquivo.getItems().add(menuSair);
        menuUsuario.getItems().addAll(menuItemCadastro, menuItemBusca, menuItemExcluir);
        menuSabores.getItems().addAll(menuItemSaboresCadastro, menuItemSaboresBusca, menuItemSaboresExcluir);
        menuSair.setOnAction(new EventHandler<ActionEvent>(){
            @Override
                public void handle (ActionEvent t) {
                    Platform.exit();
                }
        });
        
        menu.getMenus().addAll(menuUsuario, menuSabores, menuCEP, menuArquivo);
        
        
        Pane root = new Pane();
        root.getChildren().add(menu);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Cadastro de Usuários");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
