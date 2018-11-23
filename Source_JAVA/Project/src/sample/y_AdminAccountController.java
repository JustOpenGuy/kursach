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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class y_AdminAccountController  {

    public static String rafURLAdm;       //Сырая строка урока
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

    public static ObservableList list = FXCollections.observableArrayList();
    int lessonIndAdm;
    String lessonNameAdm;
    int lessonCounter;

    @FXML
    private Button addLesson;

    @FXML
    private Button deleteLesson;

    @FXML
    private Button testEdit;

    @FXML
    private ChoiceBox<String> lesson;

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


    private void loadData() {
        list.removeAll(list);
        ArrayList<String> lst = new ArrayList<String>();
        DatabaseHandler dbHandler = new DatabaseHandler();
        try {
            lessonCounter = dbHandler.TestCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= lessonCounter; i++){
            lst.add(dbHandler.getLessonName(i));
        }
        list.addAll(lst);
        lesson.setItems(list);
     //   lesson.getItems().addAll(list);
    }

    private void setUrlFinal(String s){
        String tmp;
        tmp = rafURLAdm;
        tmp = tmp.replace("/sample/course/les1", "/sample/course/les"+(list.indexOf(s)+1));
        setRafURLAdm(tmp);
        lessonIndAdm = list.indexOf(s)+1;
        lessonNameAdm = s;
    }

//        int i = 1;
//        String a = new String(urlFull);
//
//        a = a.replace("file:/", "");
//        a = a.replaceAll("/", "//");
//        File f = new File(a);
//        System.out.println(f.exists()+a);
//        System.out.println("File name: " + f.getName());
//        System.out.println("File size: " + f.length());
//        while(f.exists()){
//                System.out.println("Checked" + i);
//                f = new File(a);
//                System.out.println("Checked" + i);
//            if(f.exists()){
//                list.add(i + ") ");
//                i++;
//                a = a.replace("les1", "les"+i);
//                System.out.println("i = " + i + " url = " + url);
//            }
//        }
//        lst.add("test1");
//        lst.add("teest2");



    @FXML
    void initialize() {


        loadData();
        lesson.setValue(list.get(0).toString());
        Edit.setOnAction(event -> {
//                    String file = new String(getUrlAdm());
//                    file = file.replaceAll("file:/","");
//                    String open = new String("start notepad ");
//                    String[] startNotePad = new String[] {"CMD.EXE", "/C", "start", "notepad", file };
//                    Process runtimeProcess = null;
//                    try {
//                        runtimeProcess = Runtime.getRuntime().exec(startNotePad);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        runtimeProcess.waitFor();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                    inizRafUrlAdm();//Инициализация строки пути к файла
                    setUrlFinal(lesson.getValue());
                });


        testEdit.setOnAction( event ->{
        inizRafUrlAdm();//Инициализация строки пути к файла
        setUrlFinal(lesson.getValue());
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML/testWriter.fxml"));

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

        addLesson.setOnAction( event ->{
            String a = "set";
            lessonCounter++;
            System.out.println(lessonCounter);
            Tests tmp = new Tests(lessonCounter, a);
            DatabaseHandler dbt = new DatabaseHandler();
            dbt.SetTests(tmp);
            loadData();
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


    }
}
