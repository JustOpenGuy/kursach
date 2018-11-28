package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by evgen on 26.11.2018.
 */
public class openController {

    public void openScene(String s){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
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
        stage.showAndWait();
    }
    public void openShow(String s){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(s));
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

}
