package View;

import Functions.Funcions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainScreen {
    Funcions funcions = new Funcions();
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


    public void acceso() {
        funcions.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAcceder.getScene().getWindow()).close();
    }




}
