/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author Jhonatan
 */
public class CadastraSabores extends Application {
    ObservableList<String> lSabores = FXCollections.observableArrayList();
    ObservableMap<String,String> lTamanho;

    public CadastraSabores() {
        //this.lTamanho = FXCollections.observableMap();
    }
    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();
        ListView<String> lvSabores = new ListView<>(lSabores);
        //ComboBox<String> comboBox = new ComboBox<>(map);
        Map<String,String> map = new HashMap<>(lTamanho);
        map.put("tamanho", "grande");
        map.put("tamanho", "medio");
        map.put("tamanho", "pequeno");
        //comboBox.itemsProperty().setValue());
        
        Button bAdicionar = new Button("Incluir");
        bAdicionar.setOnAction(e->incluir());
        Button bRemover = new Button("Excluir");
        bRemover.setOnAction(e->excluir());
        
        VBox pBotoes = new VBox(bAdicionar,bRemover);
        root.getChildren().addAll(lvSabores,pBotoes);
        root.setSpacing(10);
        pBotoes.setSpacing(10);
        
        Scene scene = new Scene(root, 500,500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void incluir() {
        String texto = JOptionPane.showInputDialog("Informe um sabor:");
        lSabores.add(texto);
        
    }

    private void excluir() {
        String texto = JOptionPane.showInputDialog("Informe o sabor a ser removido:");
        lSabores.remove(texto);
    }
    
}
