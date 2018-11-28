package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

            Exit.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {                             //Выход
                    Exit.getScene().getWindow().hide();
                    y_LessonViewController.super.openShow("/sample/FXML/y_PersonalAccount.fxml");
                }
            });

            testsButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    testsButton.getScene().getWindow().hide();
                    y_LessonViewController.super.openShow("FXML/testsView.fxml");
                }
            });

        });
}
}