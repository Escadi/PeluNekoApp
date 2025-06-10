package View;

import Controllers.ControllerMenu;
import Functions.Funcions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class MainScreen {
    Funcions funcion = new Funcions();
    ControllerMenu controllerMenu = new ControllerMenu();
    @FXML
    private TextField textFieldVoluntario;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private VBox vboxMain;
    @FXML
    private Button btnAcceder;


    public MainScreen() {
    }


    public void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        btnAcceder.setDefaultButton(true);
    }

    public void inicio() {
        controllerMenu.showDni(textFieldVoluntario.getText(), textFieldPassword.getText());

    }

}
