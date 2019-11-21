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
//        String fxmlDocPath = "C:/Users/Jhonatan/Documents/tec2019/src/apps/Menu.fxml";
//        
//        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//        
//        Parent root = loader.load(fxmlStream);
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);

        File f = new File("C:/Users/Jhonatan/Documents/tec2019/src/apps/menu.css");
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
