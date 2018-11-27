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

public class testsViewer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private RadioButton radioB;

    @FXML
    private RadioButton sample;

    @FXML
    private CheckBox checkF;

    @FXML
    private ToggleGroup first;

    @FXML
    private RadioButton fsTest;

    @FXML
    private RadioButton ftTest;

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
//        radioB.setText(testss.getFirstFirstAnsw());


        endButton.setOnAction(event ->{endButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/y_PersonalAccount.fxml"));

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

        });
    }
}
