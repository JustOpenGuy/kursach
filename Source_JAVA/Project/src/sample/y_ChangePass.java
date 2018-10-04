package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class y_ChangePass {
    private String temp;
    @FXML
    private Button Change;

    @FXML
    private TextField Old;

    @FXML
    private TextField New;

    @FXML
    private TextField Again;

    @FXML
    void initialize(){
        Change.setOnAction(event ->{
            if(Users.getPassword().equals(Old.getText()) && New.getText().equals(Again.getText()));
            Users.setPassword(Old.getText());
        });
    }
}
