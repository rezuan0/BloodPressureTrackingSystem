package bd.edu.seu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LastPage  {

    @FXML private void homePage() throws IOException {
        App.setRoot("firstPage");
    }

}
