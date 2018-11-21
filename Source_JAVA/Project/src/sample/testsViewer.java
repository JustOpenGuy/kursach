package sample;

/**
 * Created by evgen on 20.11.2018.
 */
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

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
    private RadioButton ffTest;

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



    @FXML
    protected Tests[] testss = new Tests[4];

    @FXML
    void initialize() throws SQLException {
    int num=0;
        ArrayList<String> ids = new ArrayList<String>();
        DatabaseHandler dbt = new DatabaseHandler();
        ResultSet res= dbt.getDirectQues("first");



        firstQuesText.setText(res.getString(2));



    }
}
