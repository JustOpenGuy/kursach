package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class y_PersonalAccountController {


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
    private MenuItem About;

    @FXML
    private MenuItem Information;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem ChangePass;



    private void loadData() {
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
        courses.setValue(list.get(0).toString());
        GoToLesson.setOnAction(event -> {
            GoToLesson.getScene().getWindow().hide(); //Открывает просмотр урока
            inizRafUrl();//Инициализация строки пути к файла
            setUrlFinal(courses.getValue());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/y_Lesson.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.sizeToScene();
            stage.show();
                }
        );

        LogOut.setOnAction(event -> {                       //Возврат на окно регистрации
                    GoToLesson.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXML/sample.fxml"));

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
                }
        );

        About.setOnAction(event -> {    //Про программу
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXML/About.fxml"));
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
                }
        );

        Information.setOnAction(event -> { //Про курс
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("FXML/Inf.fxml"));
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
                }
        );

        ChangePass.setOnAction(event -> {        //Открывает смену пароля
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/FXML/y_ChangePass.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setResizable(false);
                    stage.sizeToScene();
                    stage.show();
                }
        );

    }
}

