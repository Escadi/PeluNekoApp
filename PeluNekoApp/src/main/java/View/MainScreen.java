package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainScreen {

    @FXML
    private TextField textFieldRefugio;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button btnAcceder;


    public MainScreen() {}



    public void initialize() {

    }

    /*
+---------------------------------------------------------------+
|                   Access to FXML Whit Buttons                 |
+---------------------------------------------------------------+
*/

    public void abrirVentana(String fxmlPath, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceso() {
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAcceder.getScene().getWindow()).close();
    }




}
