package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class y_PersonalAccountController {
    private String rafUrl = new String("/sample/C++/les1/p1.html"); //Создаем сырую строку получения ссылки на
                                                                            // урок(которую будем модифицировать,
                                                                            // в зависимости от того, какой урок  нам нужен
    public URL url = this.getClass().getResource(rafUrl); //чтоб получить точную ссылку на наш урок, где бы не находилась прога

    public static String urlS;                             //строка с полной ссылкой, статик, потому что вебВью принимает только статик ссылки
    public static void setUrl(String u){
        urlS = u;
    }       //методы для работы с статик полем
    public static String getUrl(){
        return urlS;
    }                                                           //эта ссылка паблик, потому что нам нужно будет с ней работать во многих классах,
                                                                // например класс с тестами в кнопке (след урок)
    @FXML
    private Button GoToLesson;

    @FXML
    private Button GetMarks;

    @FXML
    private MenuItem About;

    @FXML
    private MenuItem Information;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem ChangePass;

    @FXML
    void initialize() {
        setUrl(url.toString());

        LogOut.setOnAction(event -> {
            GoToLesson.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent rot = loader.getRoot();
            loader.setRoot(rot);
            Stage stage = new Stage();
            stage.setScene(new Scene(rot));
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
        }       //кнопка выход
        );
        About.setOnAction(event -> {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXML/About.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent rot = loader.getRoot();
                    loader.setRoot(rot);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(rot));
                    stage.setResizable(false);
                    stage.sizeToScene();
                    stage.show();
                }          //кнопка о программе
        );
        Information.setOnAction(event -> {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXML/Inf.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent rot = loader.getRoot();
                    loader.setRoot(rot);
                    Stage stage = new Stage();
                    stage.setScene(new Scene(rot));
                    stage.setResizable(false);
                    stage.sizeToScene();
                    stage.show();
                }      //кнопка о гайде
        );

        GoToLesson.setOnAction(event ->{GoToLesson.getScene().getWindow().hide();       //тут как всегда
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/y_Lesson.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
        });
    }
}


