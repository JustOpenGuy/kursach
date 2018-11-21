package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class  RegController {



    /* ObservableList<String>choiceBoxList = FXCollections.observableArrayList("Мужской", "Женский");
     //для ЧекБоха М/Ж*/

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button nextButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

   /* @FXML
    private ComboBox choiceBox;*/

    @FXML
    private Button backButton;



    @FXML
    void initialize() {
        /*choiceBox.setValue("М/Ж");
        choiceBox.setItems(choiceBoxList);*/

        nextButton.setOnAction(event -> {
            RegNewUser();
            backButton.fire();

        });

        backButton.setOnAction(event ->{

            backButton.getScene().getWindow().hide();

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

    });

    }

    private void RegNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String userName = login_field.getText();
        String password = password_field.getText();

        Users user = new Users(userName, password);

        dbHandler.signUpUser(user);

    }

}