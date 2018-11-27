package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import javafx.scene.web.HTMLEditor;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class y_EditorController {
    public static ObservableList list = FXCollections.observableArrayList();
    public static ObservableList amountList = FXCollections.observableArrayList();
    public static String rafURLAdm;       //Сырая строка урока
    public static URL url;
    public static String urlFullAdm;         //Полная ссылка на файл в строке


    public static void setUrlAdm(String u){
        urlFullAdm = u;
    }
    public static void setRafURLAdm(String rafURL) {
        y_PersonalAccountController.rafURL = rafURL;
    }
    private static void inizRafUrlAdm(){
        rafURLAdm = new String("/sample/course/les1/p1.html");
    }
    public void loadData() {
        list.removeAll(list);
        int i = 1;
        String a = new String(y_AdminAccountController.urlFullAdm);
        a = a.replace("file:/", "");
        a = a.replaceAll("/", "//");
        a = a.replace("les1", "les"+y_AdminAccountController.lessonIndAdm);
        File f = new File(a);
        while(f.exists()){
            list.add(i + " часть");
            i++;
            a = a.replace("p"+(i-1)+".html", "p"+i+".html");
            f = new File(a);
        }
        part.setItems(list);
        part.setValue(list.get(0).toString());
    }

    private void setUrlFinal(){
        String tmp;
        tmp = rafURLAdm;
        setRafURLAdm(tmp);
        url = this.getClass().getResource(rafURLAdm);//Для чтения файла урока нужна полная ссылка на урок (Эта функция обрабатывает сырую ссылку в полную
        setUrlAdm(url.toString()); //Эта ф-ция трансформирует нужную нам ссылку в строку
    }

    @FXML
    private HTMLEditor Editor;

    @FXML
    private ChoiceBox<String> part;

    @FXML
    private Button Edit;

    @FXML
    private Button setAmount;

    @FXML
    private Button Save;

    @FXML
    private Button Open;

    @FXML
    private ChoiceBox<Integer> amount;



    @FXML
    void initialize() {
        loadData();
        amountList.removeAll(amountList);
        for(int i = 0; i < 10; i ++){
            amountList.add(i+1);
        }
        amount.setItems(amountList);
        amount.setValue(1);
        setAmount.setOnAction( event -> {
                        inizRafUrlAdm();
                        setUrlFinal();
                        String a;
                        loadData();
                        a = new String(urlFullAdm);
                        a = a.replace("file:/", "");
                        a = a.replace("/sample/course/les1/p1.html", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm) + "/");
                        a = a.replaceAll("/", "//");
                        File f = new File(a);
                        try {
                           y_AdminAccountController.delete(f);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        a = urlFullAdm;
                        a = a.replace("file:/", "");
                        a = a.replace("/sample/course/les1/p1.html", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm)+"/p1.html");
                        Path path = Paths.get(a);
                        try {
                            String b = a;
                            b = b.replace("/sample/course/les" + (y_AdminAccountController.lessonIndAdm), "/sample/course/empties");
                            Path path2 = Paths.get(b);
                            a = urlFullAdm;
                            a = a.replace("file:/", "");
                            a = a.replace("/sample/course/les1/p1.html", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm)+"/p1.html");
                            for(int i = 0; i < amount.getValue(); i++) {
                                if (i != amount.getValue() - 1) {
                                    Files.createDirectories(path.getParent());
                                    Files.copy(path2, path);
                                    a = a.replace("p" + (i + 1) + ".html", "p" + (i + 2) + ".html");
                                    b = b.replace("p" + (i + 1) + ".html", "p" + (i + 2) + ".html");
                                    path2 = Paths.get(b);
                                    path = Paths.get(a);
                                }
                                else {
                                    b = b.replace("p" + (i + 1) + ".html", "last (" + (i + 1) + ").html");
                                    path2 = Paths.get(b);
                                    Files.createDirectories(path.getParent());
                                    Files.copy(path2, path);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        loadData();
                }
        );
        Edit.setOnAction(event->{
            String tmp = "";
            inizRafUrlAdm();
            setUrlFinal();
            String a;
            a = new String(urlFullAdm);
            a = a.replace("file:/", "");
            a = a.replace("/sample/course/les1/", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm) + "/");
            a = a.replaceAll("/", "//");
            String tmpp = part.getValue().replace(" часть", "");
            a = a.replace("p1.html", "p"+tmpp+".html");
            File f = new File(a);
            try {
                FileReader fr = new FileReader(f);
                Scanner scan = new Scanner(fr);
                while(scan.hasNextLine()){
                    tmp = tmp+scan.nextLine();
                }
                fr.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Editor.setHtmlText(tmp);
        });
        Save.setOnAction(event -> {
            String tmp = "";
            inizRafUrlAdm();
            setUrlFinal();
            String a;
            a = new String(urlFullAdm);
            a = a.replace("file:/", "");
            a = a.replace("/sample/course/les1/", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm) + "/");
            a = a.replaceAll("/", "//");
            String tmpp = part.getValue().replace(" часть", "");
            a = a.replace("p1.html", "p"+tmpp+".html");
            File f = new File(a);
            tmp = Editor.getHtmlText();
            FileWriter nFile = null;
            try {
                nFile = new FileWriter(f);
                nFile.flush();
                nFile.write(tmp);
                nFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Open.setOnAction(event -> {
            inizRafUrlAdm();
            setUrlFinal();
            String a = urlFullAdm;
            a = a.replace("file:/", "");
            a = a.replace("/sample/course/les1/p1.html", "/sample/course/les" + (y_AdminAccountController.lessonIndAdm)+"/p1.html");
            Path path = Paths.get(a);
            try {
                Runtime.getRuntime().exec("explorer.exe /select," + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    }

