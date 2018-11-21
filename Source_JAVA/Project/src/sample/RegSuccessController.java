package sample;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RegSuccessController {

    @FXML
    private Button nextButton;

    @FXML
    private Label label;

    @FXML
    void initialize() {
        switch (RegController.ErrorCode) {              // меняем лэйбл если есть код ошибки
            case 1:
                label.setFont(Font.font(22));
                label.setLayoutX(140);
                label.setText("Ошибка! Логин и пароль не могут быть пустыми!");
                break;
            case 2:
                label.setFont(Font.font(20));
                label.setLayoutX(80);
                label.setPrefWidth(700);
                label.setText("Ошибка! Пользователь с таким логином уже зарегистрирован!");
                break;
        }
        nextButton.setOnAction(event -> {
            nextButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            if(RegController.ErrorCode == 0) {
                loader.setLocation(getClass().getResource("FXML/sample.fxml"));
            }else{
                                                                   //если была ошибка, то возвращаем юзера на окно регистрации
                loader.setLocation(getClass().getResource("FXML/Reg.fxml"));
            }
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
}
