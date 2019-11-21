/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Jhonatan
 */
public class MenuController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private Hyperlink linkMoodle;

    @FXML
    private Hyperlink linkFiguras;

    @FXML
    private Hyperlink linkUTFPR;


    @FXML
    private Hyperlink linkSons;

    @FXML
    private Hyperlink linkVideo;

    @FXML
    private HBox hbox;
    
    @FXML
    private VBox vbox;

    @FXML
    private Button btnIniciar;

    @FXML
    private ToggleButton btnPausar;

    @FXML
    private Button btnParar;
    
    private ContextMenu menu;
    
    private Menu iluminar;
    
    private Menu desfocar;
    
    private MenuItem rotaciona;
    
    private MenuItem rotacionaNegativo;
    
    private CheckMenuItem bloom;
    
    private CheckMenuItem glow;

    private CheckMenuItem blur;
    
    private CheckMenuItem gaussian;
    
    private CheckMenuItem motion;
    
    private CheckMenuItem refletir;
    
    private MediaPlayer player;
    
    private Media media;
    
    private Image img;
    
    private ImageView view = new ImageView();

    @FXML
    void abrirFiguras(ActionEvent event) {
        FileChooser selecionaImg = new FileChooser();
        selecionaImg.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File arquivo = selecionaImg.showOpenDialog(null);
        if(arquivo != null) {
        img = new Image(arquivo.toURI().toString());
        view = new ImageView(img);
        view.setFitHeight(400);
        view.setFitWidth(400);
        borderPane.setCenter(view);
        }
    }

    @FXML
    void abrirMoodle(ActionEvent event) {
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load("http://moodle.utfpr.edu.br/");
        borderPane.setCenter(browser);
    }

    @FXML
    void abrirSom(ActionEvent event) {
        FileChooser selecionaSom = new FileChooser();
        selecionaSom.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MP3", "*.mp3"),
                new FileChooser.ExtensionFilter("mp4", "*.mp4"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );
        File arquivo = selecionaSom.showOpenDialog(null);
        if(arquivo != null) {
        hbox.setVisible(true);
        img = new Image("file:C:\\Users\\Jhonatan\\Desktop\\som.png");
        view = new ImageView(img);
        view.setFitHeight(200);
        view.setFitWidth(200);
        borderPane.setCenter(view);
        media = new Media(arquivo.toURI().toString());
        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        btnIniciar.setDisable(true);
        }
        }

    @FXML
    void abrirUTF(ActionEvent event) {
        WebView browser = new WebView();
        WebEngine engine = browser.getEngine();
        engine.load("https://www.utfpr.edu.br");
        borderPane.setCenter(browser);
    }

    @FXML
    void abrirVideo(ActionEvent event) {
        FileChooser selecionaSom = new FileChooser();
        selecionaSom.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("wmv", "*.wmv"),
                new FileChooser.ExtensionFilter("avi", "*.avi"),
                new FileChooser.ExtensionFilter("mp4", "*.mp4"),
                new FileChooser.ExtensionFilter("Todos os arquivos", "*.*")
        );
        File arquivo = selecionaSom.showOpenDialog(null);
        if(arquivo != null) {
        media = new Media(arquivo.toURI().toString());
        player = new MediaPlayer(media);
        player.setAutoPlay(true);
        MediaView mediaView = new MediaView(player);
        borderPane.setCenter(mediaView);
        mediaView.setFitHeight(500);
        mediaView.setFitWidth(500);
        hbox.setVisible(true);
        btnIniciar.setDisable(true);
        }
    }

    @FXML
    void inicia(ActionEvent event) {
        if(player != null) {
            player.play();    
        }
        btnIniciar.setDisable(true);


    }

    @FXML
    void para(ActionEvent event) {
        if(player != null) {
            player.stop();    
        }
        btnIniciar.setDisable(false);
    }

    @FXML
    void pausa(ActionEvent event) {
        if (player != null) {
            if (btnPausar.isSelected()) {
                player.pause();
                btnIniciar.setDisable(false);
            }
            else {
                player.play();
                btnIniciar.setDisable(true);
            }
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        menu = new ContextMenu();
        vbox.getStyleClass().add("Vbox");
        rotaciona = new MenuItem("Rotaciona 90 graus");
        rotaciona.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                view.setRotate(90);
            }
        });
        rotacionaNegativo = new MenuItem("Rotaciona -90 graus");
        rotaciona.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                view.setRotate(-90);
            }
        });
        bloom = new CheckMenuItem("Bloom");
        bloom.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(bloom.isSelected()) {
                    view.setEffect(new Bloom());
                }else
                    view.setEffect(null);                   
            }
        });
        glow = new CheckMenuItem("Glow");
        glow.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(glow.isSelected()) {
              view.setEffect(new Glow());
                }else
                    view.setEffect(null);                   
            }
        });
        blur = new CheckMenuItem("BoxBlur");
        blur.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(blur.isSelected()) {
              view.setEffect(new BoxBlur());
                }else
                    view.setEffect(null);                   
            }
        });
        gaussian = new CheckMenuItem("GaussianBlur");
        gaussian.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(gaussian.isSelected()) {
              view.setEffect(new GaussianBlur());
                }else
                    view.setEffect(null);                   
            }
        });
        motion = new CheckMenuItem("MotionBlur");
        motion.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                if(motion.isSelected()) {
              view.setEffect(new MotionBlur());
                }else
                    view.setEffect(null);                   
            }
        });
        refletir = new CheckMenuItem("Refletir Imagem");
        refletir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(refletir.isSelected()) {
                    view.setEffect(new Reflection());
            }else
                    view.setEffect(null);   
            }
        });
        iluminar = new Menu("Iluminar");
        iluminar.getItems().addAll(bloom,glow);
        desfocar = new Menu("Desfocar");
        desfocar.getItems().addAll(blur,gaussian,motion);
        menu.getItems().addAll(rotaciona, rotacionaNegativo, iluminar, desfocar, refletir);
 //       view.setOnContextMenuRequested(e -> menu.show(view, e.getScreenX(), e.getScreenY())  );
      view.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent event) {
           if(event.getButton() == MouseButton.SECONDARY) {
               menu.show(view, event.getScreenX(), event.getScreenY());
           }
      }
    });
        
    }

}
