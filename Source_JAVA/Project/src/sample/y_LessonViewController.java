package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class y_LessonViewController extends openController{


    @FXML
    private WebView webView;

    @FXML
    private Button Exit;

    @FXML
    private Button testsButton;

    @FXML
    public void initialize() {
        WebEngine engine = webView.getEngine();
        engine.load(y_PersonalAccountController.urlFull);       //Чтение файла урока
        Exit.setOnAction(event -> {                             //Выход на тесты
            Exit.getScene().getWindow().hide();

                super.openShow("/sample/FXML/y_PersonalAccount.fxml");
            });

            testsButton.setOnAction(event ->{
                testsButton.getScene().getWindow().hide();
                super.openShow("FXML/testsView.fxml");
            });

        }
}