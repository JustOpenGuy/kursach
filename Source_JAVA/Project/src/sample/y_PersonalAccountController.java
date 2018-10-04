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
    public URL url = this.getClass().getResource("/sample/C++/p1.html");

    public static String urlS;
    public static void setUrl(String u){
        urlS = u;
    }
    public static String getUrl(){
        return urlS;
    }
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
        }
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
                }
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
                }
        );

        GoToLesson.setOnAction(event ->{GoToLesson.getScene().getWindow().hide();
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


