package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class  RegController {

public static int ErrorCode;

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
            nextButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/RegSuccess.fxml"));
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

    private int RegNewUser() {
            if (login_field.getText().isEmpty() || password_field.getText().isEmpty()) {
                                            //проверка на то, пустые ли поля, если да - устанавливаем код ошибки 1
                ErrorCode = 1;
                return 0;                   //выход при наличии ошибки
            }
            if (loginUser(login_field.getText()).equals("USER")) {
                                            //проверка на то, зарегистрирован ли пользователь с таким же логином
                ErrorCode = 2;
                return 0;                   //выход при наличии ошибки
            }
            DatabaseHandler dbHandler = new DatabaseHandler();
            String userName = login_field.getText();
            String password = password_field.getText();
            Users user = new Users(userName, password);
            dbHandler.signUpUser(user);
            ErrorCode = 0;
        return 0;
    }
    private String loginUser(String loginText) { //оставил функцию с обычного входа, но немного изменил, чтоб чекала только логин
        DatabaseHandler dbHandler = new DatabaseHandler();
        Users user = new Users();
        user.setUserName(loginText);
        ResultSet result = dbHandler.getLogin(user);
        int counter = 0;

        try {
            while(result.next()) {//проходим по всем юзерам и считаем их кол-во
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(counter>=1){
            return "USER";
        }else return "NON_USER";

    }

}