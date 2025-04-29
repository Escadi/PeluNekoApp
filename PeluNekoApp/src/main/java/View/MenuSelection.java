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
        abrirVentana("/ViewFXML/AnimalList.fxml", "Lista de Animales");
        ((Stage) btnAnimales.getScene().getWindow()).close();
    }
    public void ventanaNuevos() {

        ((Stage) btnNuevos.getScene().getWindow()).close();

    }
    public void ventanaVoluntarios() {

        ((Stage) btnVoluntarios.getScene().getWindow()).close();

    }
    public void ventanaAdopciones() {

        ((Stage) btnAdopciones.getScene().getWindow()).close();

    }




}
