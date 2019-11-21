/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class ComboEditavel extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> dados = FXCollections.observableArrayList("anonimo");
        ComboBox<String> cbDados = new ComboBox<>(dados);
        cbDados.setEditable(false);
        cbDados.setCellFactory(TextFieldListCell.forListView());
        
        Button btn = new Button();
        btn.setText("Adiciona");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                dados.add(new String("Digite o novo item"));
            }
        });
        
        HBox root = new HBox();
        root.getChildren().addAll(cbDados, btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Combo Editavel");
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
