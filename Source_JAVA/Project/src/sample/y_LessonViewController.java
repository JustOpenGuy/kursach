package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.text.html.HTML;
import java.io.FileReader;
import java.io.IOException;


public class y_LessonViewController {
    @FXML
    private WebView webView;

    @FXML
    private Button Exit;

    @FXML
    public void initialize(){
        WebEngine engine = webView.getEngine();
  //       engine.loadContent(HtmlToString(y_PersonalAccountController.urlS),"UTF-8");
        engine.load(y_PersonalAccountController.urlS);
        Exit.setOnAction(event ->{

            Exit.getScene().getWindow().hide();

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

  /*  private String HtmlToString(String url){
        String str = new String();
        try(FileReader reader = new FileReader(url))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                str += (char)c;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(str);
        return str;
    }
*/
}
