package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;

/** Класс-контроллер окна приложения
 * @author Andrey Pomelov
 * @version 1.0
 */
public class MainController implements Initializable {

    /** Переменная, содержащая ссылку на элемент окна, отображающий веб-страницу */
    public WebView webView;
    /** Переменная, содержащая адрес и порт сервера */
    private final String SERVER = "http://localhost:8080";

    /** Метод, передающий на сервер гет-запрос и отображающий полученную веб-страницу.
     * Вызывается при нажатии кнопки в окне приложения.
     */
    public void getAllContracts(ActionEvent actionEvent) {
        WebEngine webEngine = webView.getEngine();
        webEngine.load(SERVER);
    }

    /** Метод, автоматически вызывающийся при старте приложения.
     * В свою очередь вызывает метод getAllContracts для отображения
     * веб-страницы при старте приложения.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllContracts(new ActionEvent());
    }
}
