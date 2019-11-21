/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaorder;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class GraficosFXMLController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnPizza;

    @FXML
    private Button btnLinha;

    @FXML
    private Button btnBarra;

    @FXML
    void geraBarra(ActionEvent event) {
        final CategoryAxis x = new CategoryAxis();
        final NumberAxis y = new NumberAxis();
        final BarChart<String, Number> grafico = new BarChart<String, Number>(x, y);
        grafico.setTitle("Desempenho em Matemática");
        XYChart.Series serie = new XYChart.Series();
        serie.getData().add(new XYChart.Data("Ruim", 12));
        serie.getData().add(new XYChart.Data("Regular", 20));
        serie.getData().add(new XYChart.Data("Bom", 28));
        serie.getData().add(new XYChart.Data("Ótimo", 20));
        grafico.getData().add(serie);
        borderPane.setCenter(grafico);
    }

    @FXML
    void geraLinha(ActionEvent event) {
        final CategoryAxis x = new CategoryAxis();
        final NumberAxis y = new NumberAxis();
        final LineChart<String, Number> linha = new LineChart<String, Number>(x,y);
        linha.setTitle("Desempenho em Matemática");
        XYChart.Series serie = new XYChart.Series();
        serie.getData().add(new XYChart.Data("Ruim", 12));
        serie.getData().add(new XYChart.Data("Regular", 20));
        serie.getData().add(new XYChart.Data("Bom", 28));
        serie.getData().add(new XYChart.Data("Ótimo", 20));
        linha.getData().add(serie);
        borderPane.setCenter(linha);
    }

    @FXML
    void geraPizza(ActionEvent event) {
        final PieChart pie = new PieChart();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Ruim", 12),
                new PieChart.Data("Regular", 20),
                new PieChart.Data("Bom", 28),
                new PieChart.Data("Ótimo", 20));
        pie.setData(pieChartData);
        pie.setTitle("Desempenho em Matemática");
        borderPane.setCenter(pie);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
