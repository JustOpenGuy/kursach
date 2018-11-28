package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class y_AdminAccountController extends openController {

    public static String rafURLAdm;       //Сырая строка урока
    public static URL url;
    public static String urlFullAdm;         //Полная ссылка на файл в строке
    public static void setUrlAdm(String u){
        urlFullAdm = u;
    }
    public static void setRafURLAdm(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }
    protected static void inizRafUrlAdm(){
        rafURLAdm = new String("/sample/course/les1/p1.html");
    }

    public static ObservableList list = FXCollections.observableArrayList();
    public static int  lessonIndAdm;
    public static String lessonNameAdm;
    public static int lessonCounter;

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

    @FXML
    private Label ErrorLabel;

    public void loadData() {
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
        lesson.setValue(list.get(0).toString());
     //   lesson.getItems().addAll(list);
    }

    private void setUrlFinal(String s){
        String tmp;
        tmp = rafURLAdm;
        tmp = tmp.replace("/sample/course/les1", "/sample/course/les"+(list.indexOf(s)+1));
        setRafURLAdm(tmp);
        url = this.getClass().getResource(rafURLAdm);//Для чтения файла урока нужна полная ссылка на урок (Эта функция обрабатывает сырую ссылку в полную
        setUrlAdm(url.toString()); //Эта ф-ция трансформирует нужную нам ссылку в строку
        lessonIndAdm = list.indexOf(s)+1;
        lessonNameAdm = s;
    }

    public static void delete(File file) throws IOException {

        for (File childFile : file.listFiles()) {

            if (childFile.isDirectory()) {
                delete(childFile);
            } else {
                if (!childFile.delete()) {
                    throw new IOException();
                }
            }
        }

        if (!file.delete()) {
            throw new IOException();
        }
    }


    @FXML
    void initialize() {

        loadData();

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
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/y_Editor.fxml"));

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
            stage.setTitle(lessonNameAdm);
            stage.show();

                });

        testEdit.setOnAction( event ->{
        inizRafUrlAdm();//Инициализация строки пути к файла
        setUrlFinal(lesson.getValue());

                    super.openShow("FXML/testWriter.fxml");
        /*FXMLLoader loader = new FXMLLoader();
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
        stage.show();*/

    }
        );

        addLesson.setOnAction( event -> {
                    if (list.size() <= 19) {
                        ErrorLabel.setText("");
                        inizRafUrlAdm();//Инициализация строки пути к файла
                        setUrlFinal(list.get(lessonCounter-1).toString());
                        String a = "set"+lessonIndAdm;
                        lessonCounter++;
                        Tests tmp = new Tests(lessonCounter, a);
                        DatabaseHandler dbt = new DatabaseHandler();
                        dbt.SetDBTest(tmp);
                        loadData();
                        a = urlFullAdm;
                        a = a.replace("file:/", "");
                        a = a.replace("/sample/course/les1", "/sample/course/les" + (lessonCounter));

                        Path path = Paths.get(a);
                        try {
                            Files.createDirectories(path.getParent());
                            String b = a.replace("/sample/course/les" + (lessonCounter), "/sample/course/empties");
                            Path path2 = Paths.get(b);
                            Files.copy(path2, path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else ErrorLabel.setText("Превышен лимит создания уроков!");
                }
        );

        deleteLesson.setOnAction( event -> {
            if (list.size() != 1) {
                ErrorLabel.setText("");
                inizRafUrlAdm();//Инициализация строки пути к файла
                setUrlFinal(list.get(lessonCounter - 1).toString());
                String a = new String();
                DatabaseHandler dbt = new DatabaseHandler();
                dbt.deleteTests(lessonCounter);
                a = new String(urlFullAdm);
                a = a.replace("file:/", "");
                a = a.replace("/sample/course/les1/p1.html", "/sample/course/les" + (lessonCounter) + "/");
                a = a.replaceAll("/", "//");
                File f = new File(a);
                try {
                    delete(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loadData();
            }
                else ErrorLabel.setText("Остался всего один урок!");
                }
        );


        About.setOnAction(event -> {            //Открывает онко "Про программу"
                    super.openShow("FXML/About.fxml");
                }
        );

        Information.setOnAction(event -> {              //Открывает окно информации о программе
                    super.openShow("FXML/Inf.fxml");
                }
        );

        ChangePass.setOnAction(event ->{        //Открывает окно смены пароля
            super.openShow("/sample/FXML/y_ChangePass.fxml");
        });

        LogOut.setOnAction(event -> {               //Выход на окно регистрации
                    Edit.getScene().getWindow().hide();
                    super.openShow("FXML/sample.fxml");
                }
        );


    }
}