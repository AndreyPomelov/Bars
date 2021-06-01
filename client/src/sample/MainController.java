package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public WebView webView;
    private final String SERVER = "http://localhost:8080";

    public void getAllContracts(ActionEvent actionEvent) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load(SERVER);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllContracts(new ActionEvent());
    }
}
