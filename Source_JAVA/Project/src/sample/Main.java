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

    static public Stage getPrimaryStage() {
        return Main.primaryStage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        setPrimaryStage(primaryStage); // **Set the Stage**
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.setTitle("StudHelp");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*  Ставить перед выводом окна заменив сцены
primaryStage.setResizable(false);
        primaryStage.sizeToScene();*/
