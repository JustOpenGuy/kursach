package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LessonView implements Initializable {
    @FXML
    private WebView webView;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        WebEngine engine = webView.getEngine();
        engine.load("http://www.google.com");
}
}