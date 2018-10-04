package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;


public class Controller  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_fild;

    @FXML
    private PasswordField password_fild;

    @FXML
    private Button SignIn;

    @FXML
    private Button Register;

    @FXML


    void initialize() {
        Register.setOnAction(event ->{Register.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/registration.fxml"));

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
            stage.showAndWait();

        });
        SignIn.setOnAction(event ->{                         //переписал ибо нужно синхр с БД
            String loginText = login_fild.getText().trim(); //метод трим - удаляет лишние пробелы в строке
            String loginPassword = password_fild.getText().trim();


            if(!loginText.equals("") && !loginPassword.equals("")){      //
               if(loginUser(loginText, loginPassword).equals("ADMIN"))
               {
                   SignIn.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/FXML/y_AdminAccount.fxml"));
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
                stage.showAndWait();
               }
               else if(loginUser(loginText, loginPassword).equals("USER")) {
                   SignIn.getScene().getWindow().hide();
                   FXMLLoader loader = new FXMLLoader();
                   loader.setLocation(getClass().getResource("/sample/FXML/y_PersonalAccount.fxml"));
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
                   stage.showAndWait();
               }
            }
            else
                System.out.println("Login or password is empty");



        });

        }


    private String loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        Users user = new Users();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0, counter1=0;

        try {
            while(result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(counter>=1){
             result = dbHandler.getAdmin(user);
            try {
                while(result.next()) {
                    counter1++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
             if(counter1>=1)
                 return "ADMIN";
            else return "USER";
        }else return "NON_USER";

    }


}
