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
import javafx.scene.control.*;
import javafx.stage.Stage;

public class testWriterController  {
    int num=0, ex=0;



    @FXML
    private ChoiceBox<String> courseChoice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button refreshButton;

    @FXML
    private URL location;

    @FXML
    private Button saveButton;

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
    private TextField nameField;


    protected Tests[] testss = new Tests[20];




    @FXML
    void initialize() {
        ArrayList<String> ids = new ArrayList<String>();
        DatabaseHandler dbt = new DatabaseHandler();
        ResultSet res= dbt.getQues();
        try {

             while(res.next()){

                testss[num]=new Tests(res.getInt(1), res.getString(2),res.getString(3),
                        res.getString(4),res.getString(5),res.getString(6),
                        res.getString(7),res.getString(8),res.getString(9),res.getString(10),
                        res.getString(11), res.getString(12),res.getString(13),res.getString(14),
                        res.getString(15),res.getString(16),res.getString(17),res.getString(18),
                        res.getString(19),res.getString(20),res.getString(21), res.getString(22));
                ids.add(res.getString(22));
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();}
        ObservableList<String> choiceBoxList = FXCollections.observableArrayList(ids);
        courseChoice.setValue("Доступные курсы");
        courseChoice.setItems(choiceBoxList);
        courseChoice.getSelectionModel().selectFirst();
        refreshButton.fire();
        courseChoice.setTooltip(new Tooltip("Выбери нужную лекцию"));


        refreshButton.setOnAction(event -> {
          int a=courseChoice.getSelectionModel().getSelectedIndex(); ex=a;
            firstQues.setText(testss[ex].getFirstQues());secQues.setText(testss[ex].getSecQues());thurdQues.setText(testss[ex].getThurdQues());
            fourthQues.setText(testss[ex].getFourthQues());fifthQues.setText(testss[ex].getFifthQues());firstFirstAnsw.setText(testss[ex].getFirstFirstAnsw());
            firstSecondAnsw.setText(testss[ex].getFirstSecondAnsw());secFirstAnsw.setText(testss[ex].getSecFirstAnsw());
            secSecondAnsw.setText(testss[ex].getSecSecondAnsw());thirdFirstAnsw.setText(testss[ex].getThirdFirstAnsw());
            thirdSecondAnsw.setText(testss[ex].getThirdSecondAnsw());fourthFirstAnsw.setText(testss[ex].getFourthFirstAnsw());
            fourthSecondAnsw.setText(testss[ex].getFourthSecondAnsw());fifthfFirstAnsw.setText(testss[ex].getFifthfFirstAnsw());
            fifthSecondAnsw.setText(testss[ex].getFifthSecondAnsw());firstTrueThirdAnsw.setText(testss[ex].getFirstTrueThirdAnsw());
            secTrueThirdAnsw.setText(testss[ex].getSecTrueThirdAnsw());thirdTrueThirdAnsw.setText(testss[ex].getThirdTrueThirdAnsw());
            fourthTrueThirdAnsw.setText(testss[ex].getFourthTrueThirdAnsw());fifthTrueThirdAnsw.setText(testss[ex].getFifthTrueThirdAnsw());
            nameField.setText(testss[ex].getCourseName());
                    });

        saveButton.setOnAction(event -> {

       String  firstQu= firstQues.getText();String  secQue= secQues.getText();
       String  thurdQu= thurdQues.getText();String  fourthQ= fourthQues.getText();
       String  fifthQu= fifthQues.getText();String  firstFi= firstFirstAnsw.getText();
       String  firstSe= firstSecondAnsw.getText();String  secFirs= secFirstAnsw.getText();
       String  secSeco= secSecondAnsw.getText();String  thirdFi= thirdFirstAnsw.getText();
       String  thirdSe= thirdSecondAnsw.getText();String  fourthF= fourthFirstAnsw.getText();
       String  fourthS= fourthSecondAnsw.getText();String  fifthfF= fifthfFirstAnsw.getText();
       String  fifthSe= fifthSecondAnsw.getText();String  firstTr= firstTrueThirdAnsw.getText();
       String  secTrue= secTrueThirdAnsw.getText();String  thirdTr= thirdTrueThirdAnsw.getText();
       String  fourthT= fourthTrueThirdAnsw.getText();String  fifthTr= fifthTrueThirdAnsw.getText();
       String  courseNa=nameField.getText();

            DatabaseHandler dbt1 = new DatabaseHandler();

            Tests NEW1 = new Tests( ex+1, firstQu, secQue,thurdQu,fourthQ,fifthQu,firstFi, firstSe,secFirs,
                    secSeco,thirdFi,thirdSe,fourthF,fourthS,fifthfF,fifthSe,firstTr,secTrue,thirdTr,fourthT,fifthTr, courseNa);

            dbt1.SetTests(NEW1);

        });
    }
}
