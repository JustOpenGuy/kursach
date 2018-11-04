package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class y_PersonalAccountController {

    public static String rafURL;       //Сырая строка урока
    public URL url;                    //Ссылка на файл
    public static String urlFull;         //Полная ссылка на файл в строке

    public static void setUrl(String u){
        urlFull = u;
    }
    public static String getUrl(){
        return urlFull;
    }
    public static String getRafURL() {
        return rafURL;
    }
    public static void setRafURL(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }
    protected static void inizRafUrl(){
        rafURL = new String("/sample/courses/1/les1/p1.html");
    }
    public String[] getList(){
        String[] a = new String[10];
        String u = "/sample/courses/1/les1/p1.html";
        File f = new File(u);
        if(f.exists() && !f.isDirectory())
            a[1] = "HAHAHAHA";
        return a;

    }

    @FXML
    private ChoiceBox courses;

    @FXML
    private Button GoToLesson;
    @FXML
    private Button d_ChooseT;

    @FXML
    private Button GetMarks;

    @FXML
    private MenuItem About;

    @FXML
    private MenuItem Information;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem ChangePass;

    @FXML
    void initialize() {
        String[] List = getList();
        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList(List));

        rafURL = new String("/sample/courses/1/les1/p1.html");       //Инициализация строки пути к файла
        url = this.getClass().getResource(rafURL);   //Для чтения файла урока нужна полная ссылка на урок (Эта функция обрабатывает сырую ссылку в полную
        setUrl(url.toString());                       //Эта ф-ция трансформирует нужную нам ссылку в строку

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

        GoToLesson.setOnAction(event ->{GoToLesson.getScene().getWindow().hide(); //Открывает просмотр урока
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

        ChangePass.setOnAction(event ->{        //Открывает смену пароля
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
        d_ChooseT.setOnAction(event ->{        //Открывает окно смены пароля
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/d_tree.fxml"));
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
        });
    }
}


