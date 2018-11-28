package sample;

/**
 * Created by evgen on 20.11.2018.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class testsViewer extends openController{

    @FXML
    private RadioButton ffTest;

    @FXML
    private ToggleGroup first;

    @FXML
    private RadioButton fsTest;

    @FXML
    private RadioButton ftTest;

    @FXML
    private Text firstQuesText;

    @FXML
    private Text secQuesText;

    @FXML
    private Text thirdQuesText;

    @FXML
    private Text fourthQuesText;

    @FXML
    private Text fifthQuesText;

    @FXML
    private RadioButton sfTest;

    @FXML
    private ToggleGroup second;

    @FXML
    private RadioButton ssTest;

    @FXML
    private RadioButton tfTest;

    @FXML
    private ToggleGroup third;

    @FXML
    private RadioButton tsTest;

    @FXML
    private RadioButton ttTest;

    @FXML
    private RadioButton fofTest;

    @FXML
    private ToggleGroup fourth;

    @FXML
    private RadioButton fosTest;

    @FXML
    private RadioButton fotTest;

    @FXML
    private RadioButton fifTest;

    @FXML
    private ToggleGroup fifth;

    @FXML
    private RadioButton fisTest;

    @FXML
    private RadioButton fitTest;

    @FXML
    private RadioButton stTest;

    @FXML
    private Button endButton;

    private Tests testss = new Tests();

    @FXML
    void initialize(){
    int num=0;


        /*rrayList<String> ids = new ArrayList<String>();*/
        DatabaseHandler dbt = new DatabaseHandler();
        ResultSet res= dbt.getDirectQues("set");

        try {

            res.next();{

                testss=new Tests(res.getInt(1), res.getString(2),res.getString(3),
                        res.getString(4),res.getString(5),res.getString(6),
                        res.getString(7),res.getString(8),res.getString(9),res.getString(10),
                        res.getString(11), res.getString(12),res.getString(13),res.getString(14),
                        res.getString(15),res.getString(16),res.getString(17),res.getString(18),
                        res.getString(19),res.getString(20),res.getString(21), res.getString(22));
           }
        } catch (SQLException e) {
            e.printStackTrace();}

            firstQuesText.setText(testss.getFirstQues());
        secQuesText.setText(testss.getSecQues());
        thirdQuesText.setText(testss.getThurdQues());
        fourthQuesText.setText(testss.getFourthQues());
        fifthQuesText.setText(testss.getFifthQues());

        ffTest.setText(testss.getFirstFirstAnsw());
        fsTest.setText(testss.getFirstSecondAnsw());
       sfTest.setText(testss.getSecFirstAnsw());

        ftTest.setText(testss.getFirstTrueThirdAnsw());

        ssTest.setText(testss.getSecSecondAnsw());
        stTest.setText(testss.getSecTrueThirdAnsw());
        tfTest.setText(testss.getThirdFirstAnsw());
        tsTest.setText(testss.getThirdSecondAnsw());
        ttTest.setText(testss.getThirdTrueThirdAnsw());
        fofTest.setText(testss.getFourthFirstAnsw());
        fosTest.setText(testss.getFourthSecondAnsw());
        fotTest.setText(testss.getFourthTrueThirdAnsw());
        fifTest.setText(testss.getFifthfFirstAnsw());
        fisTest.setText(testss.getFifthSecondAnsw());
        fitTest.setText(testss.getFifthTrueThirdAnsw());




        endButton.setOnAction(event ->{endButton.getScene().getWindow().hide();

        super.openScene("FXML/y_PersonalAccount.fxml");

        });
    }
}
