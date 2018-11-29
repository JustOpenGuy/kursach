package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class y_PersonalAccountController extends openController {


    public static int lessonInd;
    public static String lessonName;

    public static String rafURL;       //Сырая строка урока
    public URL url;                    //Ссылка на файл
    public static String urlFull;         //Полная ссылка на файл в строке
    public static void setUrl(String u) {
        urlFull = u;
    }
    public static String getUrl() {
        return urlFull;
    }
    public static String getRafURL() {
        return rafURL;
    }
    public static void setRafURL(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }
    protected static void inizRafUrl() {
        rafURL = new String("/sample/course/les1/p1.html");
    }

    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private ChoiceBox<String> courses;

    @FXML
    private Button GoToLesson;

    @FXML
    private RadioButton Radio;

    @FXML
    private MenuItem About;

    @FXML
    private MenuItem Information;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem ChangePass;

    @FXML
    private Button GetMarks;


    @FXML
    private ChoiceBox<String> LessonBox;

    @FXML
    private Label markLable;




    public void loadData() {
        list.removeAll(list);
        ArrayList<String> lst = new ArrayList<String>();
        int a = 0;
        DatabaseHandler dbHandler = new DatabaseHandler();
        try {
            a = dbHandler.TestCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= a; i++){
            lst.add(dbHandler.getLessonName(i));
        }
        list.addAll(lst);
        courses.getItems().addAll(list);
        LessonBox.getItems().addAll(list);
    }

    private void setUrlFinal(String s){
        String tmp;
        tmp = rafURL;
        tmp = tmp.replace("/sample/course/les1", "/sample/course/les"+(list.indexOf(s)+1));
        setRafURL(tmp);
        url = this.getClass().getResource(rafURL);   //Для чтения файла урока нужна полная ссылка на урок (Эта функция обрабатывает сырую ссылку в полную
        setUrl(url.toString()); //Эта ф-ция трансформирует нужную нам ссылку в строку
        lessonInd = list.indexOf(s)+1;
        lessonName = s;
    }

    @FXML
    void initialize() {


        loadData();
        LessonBox.setValue(list.get(0).toString());
        courses.setValue(list.get(0).toString());
        GoToLesson.setOnAction(event -> {
            GoToLesson.getScene().getWindow().hide(); //Открывает просмотр урока
            inizRafUrl();//Инициализация строки пути к файла
            setUrlFinal(courses.getValue());

            super.openShow("/sample/FXML/y_Lesson.fxml");

                }
        );

        GetMarks.setOnAction(event -> {

            DatabaseHandler dbt = new DatabaseHandler();
            ResultSet res = dbt.getMark(Users.getUserName());
            String snf = new String();
            try {
                res.next();snf = res.getString(4+LessonBox.getSelectionModel().getSelectedIndex()+1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            markLable.setText(snf);



            /*;lessonInd*/


                }
        );




        LogOut.setOnAction(event -> {                       //Возврат на окно регистрации
                    GoToLesson.getScene().getWindow().hide();
                    super.openShow("FXML/sample.fxml");
                }
        );

        About.setOnAction(event -> {    //Про программу

                    super.openScene("FXML/About.fxml");

                }
        );

        Information.setOnAction(event -> { //Про курс
                    super.openScene("FXML/Inf.fxml");
                }
        );

        ChangePass.setOnAction(event -> {        //Открывает смену пароля
                    super.openScene("/sample/FXML/y_ChangePass.fxml");
                }
        );



    }

}

