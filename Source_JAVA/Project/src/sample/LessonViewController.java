package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class LessonViewController {
    @FXML
    private WebView webView;

    @FXML
    public void initialize(){
        WebEngine engine = webView.getEngine();
        engine.load(PersonalAccountController.urlS);

    }
    }
