package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class testWriterController  {
    @FXML
    private ChoiceBox<String> courseChoice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button refreshButton;

    @FXML
    private URL location;

    @FXML
    private MenuItem saveButton;

    @FXML
    private MenuItem revertButton;

    @FXML
    private MenuItem helpButton;

    @FXML
    private TextField firstQues;

    @FXML
    private TextField secQues;

    @FXML
    private TextField thurdQues;

    @FXML
    private TextField fourthQues;

    @FXML
    private TextField fifthQues;

    @FXML
    private TextField firstFirstAnsw;

    @FXML
    private TextField firstSecondAnsw;

    @FXML
    private TextField secFirstAnsw;

    @FXML
    private TextField secSecondAnsw;

    @FXML
    private TextField thirdFirstAnsw;

    @FXML
    private TextField thirdSecondAnsw;

    @FXML
    private TextField fourthFirstAnsw;

    @FXML
    private TextField fourthSecondAnsw;

    @FXML
    private TextField fifthfFirstAnsw;

    @FXML
    private TextField fifthSecondAnsw;

    @FXML
    private TextField firstTrueThirdAnsw;

    @FXML
    private TextField secTrueThirdAnsw;

    @FXML
    private TextField thirdTrueThirdAnsw;

    @FXML
    private TextField fourthTrueThirdAnsw;

    @FXML
    private TextField fifthTrueThirdAnsw;

    @FXML
    protected Tests[] testss = new Tests[4];

    @FXML
    void initialize() {
        ArrayList<String> ids = new ArrayList<String>();
        DatabaseHandler dbt = new DatabaseHandler();
        ResultSet res= dbt.getQues();
        String str = new String();
        try {
            int num=0;
             while(res.next()){

                testss[num]=new Tests(res.getInt(1), res.getString(2),res.getString(3),
                        res.getString(4),res.getString(5),res.getString(6),
                        res.getString(7),res.getString(8),res.getString(9),res.getString(10),
                        res.getString(11), res.getString(12),res.getString(13),res.getString(14),
                        res.getString(15),res.getString(16),res.getString(17),res.getString(18),
                        res.getString(19),res.getString(20),res.getString(21));
                ids.add(res.getString(2));
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();}
        ObservableList<String> choiceBoxList = FXCollections.observableArrayList(ids);
        courseChoice.setValue("Доступные курсы");
        courseChoice.setItems(choiceBoxList);


        refreshButton.setOnAction(event -> {
            firstQues.setText(testss[0].getFirstQues());secQues.setText(testss[0].getSecQues());thurdQues.setText(testss[0].getThurdQues());
            fourthQues.setText(testss[0].getFourthQues());fifthQues.setText(testss[0].getFifthQues());firstFirstAnsw.setText(testss[0].getFifthfFirstAnsw());
            firstSecondAnsw.setText(testss[0].getFirstSecondAnsw());secFirstAnsw.setText(testss[0].getSecFirstAnsw());
            secSecondAnsw.setText(testss[0].getSecSecondAnsw());thirdFirstAnsw.setText(testss[0].getThirdFirstAnsw());
            thirdSecondAnsw.setText(testss[0].getThirdSecondAnsw());fourthFirstAnsw.setText(testss[0].getFourthFirstAnsw());
            fourthSecondAnsw.setText(testss[0].getFourthSecondAnsw());fifthfFirstAnsw.setText(testss[0].getFifthfFirstAnsw());
            fifthSecondAnsw.setText(testss[0].getFifthSecondAnsw());firstTrueThirdAnsw.setText(testss[0].getFirstTrueThirdAnsw());
            secTrueThirdAnsw.setText(testss[0].getSecTrueThirdAnsw());thirdTrueThirdAnsw.setText(testss[0].getThirdTrueThirdAnsw());
            fourthTrueThirdAnsw.setText(testss[0].getFourthTrueThirdAnsw());fifthTrueThirdAnsw.setText(testss[0].getFifthTrueThirdAnsw());
        });
    }
}
