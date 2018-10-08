package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import javax.swing.text.html.HTML;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class y_EditController {
    @FXML
    private HTMLEditor Editor;

    @FXML
    private Button End;

    @FXML
    void initialize() {
        Editor.setHtmlText(HtmlToString(y_PersonalAccountController.rafURL));
        System.out.println(HtmlToString(y_PersonalAccountController.rafURL) + "test" + y_PersonalAccountController.rafURL);
        End.setOnAction(event -> {

            End.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/y_PersonalAccount.fxml"));

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
        });
    }

    private String HtmlToString(String URL) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(URL));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (IOException e) {
        }
        return contentBuilder.toString();
    }


}
