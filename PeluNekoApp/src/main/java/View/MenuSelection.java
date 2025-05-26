package View;

import Controllers.ControllerMenu;
import Functions.Funcions;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MenuSelection {
    Funcions funcion = new Funcions();
    ControllerMenu controllerMenu = new ControllerMenu();
    @FXML
    private Button btnAnimales;
    @FXML
    private Button btnNuevos;
    @FXML
    private Button btnVoluntarios;
    @FXML
    private Button btnAdopciones;
    @FXML
    private Button btnLoginVoluntarios;
    @FXML
    private HBox hboxBotonesVoluntarios;
    @FXML
    private VBox vboxMain;


    public void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        // Hacemos visible el HBox de los botones de voluntarios y login si el rol es Administrador
        hboxBotonesVoluntarios.setVisible(controllerMenu.ventanas());
    }


    /*
+---------------------------------------------------------------+
|                   Access to FXML Whit Buttons                 |
+---------------------------------------------------------------+
*/

    public void ventanaAnimales() {
        funcion.abrirVentana("/ViewFXML/AnimalList.fxml", "Animales");
        ((Stage) btnAnimales.getScene().getWindow()).close();
    }

    public void ventanaNuevos() {
        funcion.abrirVentana("/ViewFXML/NewOwners.fxml", "Nuevos Dueños");
        ((Stage) btnNuevos.getScene().getWindow()).close();

    }

    public void ventanaVoluntarios() {
        funcion.abrirVentana("/ViewFXML/VoluntariosList.fxml", "Voluntarios");
        ((Stage) btnVoluntarios.getScene().getWindow()).close();

    }

    public void ventanaAdopciones() {
        funcion.abrirVentana("/ViewFXML/Adoptions.fxml", "Adopciones");
        ((Stage) btnAdopciones.getScene().getWindow()).close();

    }

    public void ventanaLogin() {
        funcion.abrirVentana("/ViewFXML/LoginVoluntarios.fxml", "Login Voluntarios");
        ((Stage) btnLoginVoluntarios.getScene().getWindow()).close();

    }


}
