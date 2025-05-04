package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MenuSelection {
    @FXML
    private Button btnAnimales;
    @FXML
    private Button btnNuevos;
    @FXML
    private Button btnVoluntarios;
    @FXML
    private Button btnAdopciones;



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
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la ventana: " + e.getMessage());
        }
    }
    public void ventanaAnimales() {
        abrirVentana("/ViewFXML/AnimalList.fxml", "Animales");
        ((Stage) btnAnimales.getScene().getWindow()).close();
    }
    public void ventanaNuevos() {
        abrirVentana("/ViewFXML/NewOwners.fxml", "Nuevos Dueños");
        ((Stage) btnNuevos.getScene().getWindow()).close();

    }
    public void ventanaVoluntarios() {
        abrirVentana("/ViewFXML/VoluntariosList.fxml", "Voluntarios");

        ((Stage) btnVoluntarios.getScene().getWindow()).close();

    }
    public void ventanaAdopciones() {
        abrirVentana("/ViewFXML/Adoptions.fxml", "Adopciones");
        ((Stage) btnAdopciones.getScene().getWindow()).close();

    }
    public void ventanaLogin() {
        abrirVentana("/ViewFXML/LoginVoluntarios.fxml", "Login Voluntarios");
        ((Stage) btnAdopciones.getScene().getWindow()).close();

    }




}
