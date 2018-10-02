package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegController {

    ObservableList<String>choiceBoxList = FXCollections.observableArrayList("Преподаватель", "Студент");

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

    @FXML
    private ComboBox choiceBox;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        choiceBox.setValue("Преподаватель");
        choiceBox.setItems(choiceBoxList);
    }
}
