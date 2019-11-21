/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class PizzaOrder extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "D:/Documentos/NetBeansProjects/TEC2019-2/src/pizzaorder/PizzaOrderFXML.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        
        Parent root = loader.load(fxmlStream);
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Pedido de Pizza");
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
