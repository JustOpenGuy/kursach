package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_fild;

    @FXML
    private PasswordField password_fild;

    @FXML
    private Button SignIn;

    @FXML
    private Button Register;

    @FXML
    void initialize() {
        SignIn.setOnAction(event -> {
            System.out.println("Попытка входа");
        });
    }
}
