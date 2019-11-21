/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jhonatan
 */
public class DadosGrafico extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        final CategoryAxis x = new CategoryAxis();
        final NumberAxis y = new NumberAxis();
        final BarChart<String, Number> grafico = new BarChart<String, Number>(x,y);
        grafico.setTitle("5 países mais ricos do mundo - PIB per capita");
        x.setLabel("Países");
        y.setLabel("PIB per capita, em mil €");
        XYChart.Series serie = new XYChart.Series();
        serie.setName("Irlanda");
        serie.getData().add(new XYChart.Data("Irlanda", 67.953));
        XYChart.Series serie1 = new XYChart.Series();
        serie1.setName("Singapura");
        serie1.getData().add(new XYChart.Data("Singapura", 83.334));
        XYChart.Series serie2 = new XYChart.Series();
        serie2.setName("Luxemburgo");
        serie2.getData().add(new XYChart.Data("Luxemburgo", 94.264));
        XYChart.Series serie3 = new XYChart.Series();
        serie3.setName("Macau");
        serie3.getData().add(new XYChart.Data("Macau", 104.143));
        XYChart.Series serie4 = new XYChart.Series();
        serie4.setName("Qatar");
        serie4.getData().add(new XYChart.Data("Qatar", 109.425));
        grafico.getData().addAll(serie,serie1,serie2,serie3,serie4);
        grafico.setCategoryGap(0);
        grafico.setBarGap(0);
        grafico.setAnimated(true);
        grafico.setVerticalGridLinesVisible(false);
        grafico.setHorizontalGridLinesVisible(false);
        grafico.setLegendSide(Side.TOP);
        
        StackPane root = new StackPane();
        root.getChildren().add(grafico);
        
        Scene scene = new Scene(root, 800, 400);
        
        primaryStage.setTitle("Gráfico dos 10 países mais ricos do mundo - PIB per capita");
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
