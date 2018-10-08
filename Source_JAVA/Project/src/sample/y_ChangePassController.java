package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

public class y_ChangePassController {

    @FXML
    private Button Change;

    @FXML
    private PasswordField Old;

    @FXML
    private PasswordField New;

    @FXML
    private PasswordField Again;

    @FXML
    void initialize(){
        Change.setOnAction(event ->{
            if(Users.getPassword().equals(Old.getText()) && New.getText().equals(Again.getText())) {      //Проверка условия (Старый пароль правильный, новые совпадают)
                DatabaseHandler dbHandler = new DatabaseHandler();
                dbHandler.SetPass(Users.getUserName(), New.getText());              //Запись нового пароля в БД
                Change.getScene().getWindow().hide();                               //Закрываем окно
            }
        });
    }
}
