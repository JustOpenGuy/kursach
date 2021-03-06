package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class y_AdminAccountController extends openController {

    public static String rafURLAdm;          //Сырая строка урока
    public static URL url;
    public static String urlFullAdm;         //Полная ссылка на файл в строке
    public static ObservableList list = FXCollections.observableArrayList();
    public static int  lessonIndAdm;
    public static String lessonNameAdm;
    public static int lessonCounter;

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
        lessonBox.setItems(list);
        lessonBox.setValue(list.get(0).toString());
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

    public static void setUrlAdm(String u){
        urlFullAdm = u;
    }

    public static void setRafURLAdm(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }

    protected static void inizRafUrlAdm(){
        rafURLAdm = new String("/sample/course/les1/p1.html");
    }

    @FXML
    private Button testEdit;

    @FXML
    private ChoiceBox<String> lesson;

    @FXML
    private ChoiceBox<String> fioBox;

    @FXML
    private Button Edit;

    @FXML
    private Button GetMarks;

    @FXML
    private Button GetAnotherChance;

    @FXML
    private MenuItem About;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem ChangePass;

    @FXML
    private Label ErrorLabel;

    @FXML
    private Button addLesson;

    @FXML
    private Button deleteLesson;

    @FXML
    private Label markLabel;

    @FXML
    private ChoiceBox<String> lessonBox;

    @FXML
    void initialize() {
        loadData();
        lessonBox.setValue(list.get(0).toString());
        ArrayList<String> names = new ArrayList<>();
        DatabaseHandler dbt = new DatabaseHandler();
        ResultSet res = dbt.getNames();
        try {
            while (res.next()) {
                names.add(res.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        names.remove(0);
        ObservableList<String> choiceBoxList = FXCollections.observableArrayList(names);
        fioBox.setValue(choiceBoxList.get(0));
        fioBox.setItems(choiceBoxList);
        fioBox.setTooltip(new Tooltip("Выбери нужного студента"));

        GetMarks.setOnAction(event -> {
            ErrorLabel.setText("");
            DatabaseHandler dbt1 = new DatabaseHandler();
            ResultSet res1 = dbt1.getMarkFio(fioBox.getValue());
            String snf1=new String();

            try {
                res1.next();snf1 = res1.getString(4 + lessonBox.getSelectionModel().getSelectedIndex()+1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            markLabel.setText(snf1);
        });

        Edit.setOnAction(event -> {
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
        });

        addLesson.setOnAction( event -> {
            if (list.size() <= 9) {
                ErrorLabel.setText("");
                inizRafUrlAdm();//Инициализация строки пути к файла
                setUrlFinal(list.get(lessonCounter-1).toString());
                String a = "set"+lessonIndAdm;
                lessonCounter++;
                Tests tmp = new Tests(lessonCounter, a);
                DatabaseHandler dbt2 = new DatabaseHandler();
                dbt2.SetDBTest(tmp);
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
                    ErrorLabel.setText("LESSON ALREADY EXIST");
                }
            }
            else ErrorLabel.setText("Превышен лимит создания уроков!");
        });

        GetAnotherChance.setOnAction(event -> {
            dbt.SetMarksFio((list.indexOf(lessonBox.getValue())+1), 0, fioBox.getValue());
        });

        deleteLesson.setOnAction( event -> {
            if (list.size() != 1) {
                ErrorLabel.setText("");
                inizRafUrlAdm();//Инициализация строки пути к файла
                setUrlFinal(list.get(lessonCounter - 1).toString());
                String a = new String();
                DatabaseHandler dbt3 = new DatabaseHandler();
                dbt3.deleteTests(lessonCounter);
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
        });

        About.setOnAction(event -> {            //Открывает онко "Про программу"
            super.openShow("FXML/About.fxml");
        });

        ChangePass.setOnAction(event ->{        //Открывает окно смены пароля
            super.openShow("/sample/FXML/y_ChangePass.fxml");
        });

        LogOut.setOnAction(event -> {               //Выход на окно регистрации
            Edit.getScene().getWindow().hide();
            super.openShow("FXML/sample.fxml");
        });
    }
}
