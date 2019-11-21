/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class Menus extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "D:/Documentos/NetBeansProjects/TEC2019-2/src/apps/Menu.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        
        Parent root = loader.load(fxmlStream);
        
        Scene scene = new Scene(root);

        File f = new File("D:/Documentos/NetBeansProjects/TEC2019-2/src/apps/menu.css");
        scene.getStylesheets().clear();
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        primaryStage.setTitle("Menu Mídias");
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
