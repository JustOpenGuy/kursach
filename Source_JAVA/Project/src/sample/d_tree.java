package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class d_tree {


    @FXML
    private MenuItem ChangePass;

    @FXML
    private MenuItem LogOut;

    @FXML
    private MenuItem Information;

    @FXML
    private MenuItem About;

    @FXML
    private Button exitButton;

    @FXML
    private Button testButton;


    @FXML
    void initialize() {
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



       /* exitButton.setOnAction(event ->{
             exitButton.getScene().getWindow().hide();
            exitButton.getScene().getWindow().hide();                                                    
            FXMLLoader loader = new FXMLLoader();                                                        
            loader.setLocation(getClass().getResource("/sample/FXML/y_PersonalAccount.fxml"));           
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
        });*/

        LogOut.setOnAction(event -> {               //Выход на окно регистрации
                    exitButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/FXML/sample.fxml"));
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




        testButton.setOnAction(event ->{        //Открывает окно смены пароля
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/FXML/d_CooseTest.fxml"));
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
