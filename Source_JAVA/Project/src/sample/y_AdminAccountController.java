package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class y_AdminAccountController {
    public static String rafURLAdm;       //Сырая строка урока
    public URL urlAdm;                    //Ссылка на файл
    public static String urlFullAdm;         //Полная ссылка на файл в строке

    public static void setUrlAdm(String u){
        urlFullAdm = u;
    }
    public static String getUrlAdm(){
        return urlFullAdm;
    }
    public static String getRafURLAdm() {
        return rafURLAdm;
    }
    public static void setRafURLAdm(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }
    protected static void inizRafUrlAdm(){
        rafURLAdm = new String("/sample/courses/1/les1/p1.html");
    }

    @FXML
    private Button Edit;

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
        rafURLAdm = new String("/sample/courses/1/les1/p2.html");       //Инициализация строки пути к файла
        urlAdm = this.getClass().getResource(rafURLAdm);   //Для чтения файла урока нужна полная ссылка на урок (Эта функция обрабатывает сырую ссылку в полную
        setUrlAdm(urlAdm.toString());                       //Эта ф-ция трансформирует нужную нам ссылку в строку


        LogOut.setOnAction(event -> {               //Выход на окно регистрации
                    Edit.getScene().getWindow().hide();
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

        About.setOnAction(event -> {            //Открывает онко "Про программу"
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

        Information.setOnAction(event -> {              //Открывает окно информации о программе

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

        Edit.setOnAction(event -> {
            String file = new String(getUrlAdm());
            file = file.replaceAll("file:/","");
            String open = new String("start notepad ");
            String[] startNotePad = new String[] {"CMD.EXE", "/C", "start", "notepad", file };
            Process runtimeProcess = null;
            try {
                runtimeProcess = Runtime.getRuntime().exec(startNotePad);
            } catch (IOException e) {
                e.printStackTrace();
            }
                    try {
                        runtimeProcess.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        ChangePass.setOnAction(event ->{        //Открывает окно смены пароля
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
        });
    }
}
