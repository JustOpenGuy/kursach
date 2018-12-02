package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                DatabaseHandler dbt = new DatabaseHandler();
               ResultSet NeW = dbt.getMark(Users.getUserName());
                try {
                    NeW.next();
                    {
                        if (NeW.getInt(4 + y_PersonalAccountController.lessonInd) == 0) {
                            testsButton.getScene().getWindow().hide();
                            super.openShow("FXML/testsView.fxml");
                        } else {testsButton.getScene().getWindow().hide(); super.openShow("FXML/y_PersonalAccount.fxml");}
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }
                /*testsButton.getScene().getWindow().hide();
                super.openShow("/sample/FXML/y_PersonalAccount.fxml");*/


            });

        }
}