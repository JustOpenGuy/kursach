package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {

    private static Stage primaryStage; // **Declare static Stage**

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }
    //обращаемся к методу главного класса для установки начального Стейджа


    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }  //обращаемся к методу главного класса для получ начального Стейджа


    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage); // **Set the Stage**
        Parent root = FXMLLoader.load(getClass().getResource("FXML/sample.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.setTitle("StudHelp");
        primaryStage.setResizable(false);   //Эти строки вводим перед .show()
        primaryStage.sizeToScene();         //они не дают изменять размер сцены
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
