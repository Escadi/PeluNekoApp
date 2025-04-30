package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Class.*;

import java.io.IOException;

public class VoluntariosList {
    @FXML
    private TextField textFieldBuscarVoluntario;
    @FXML
    private TableView tablaVoluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colDniVoluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colNombreVoluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colApellido1Voluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colApellido2Voluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colDireccionVoluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colLocalidadVoluntario;
    @FXML
    private TableColumn<VoluntariosCentro,String> colCPVoluntario;
    @FXML
    private Button btnAtras;
    @FXML
    private VBox vboxRegistroVoluntarios;
    @FXML
    private TextField textFieldDNIVoluntario;
    @FXML
    private TextField textFieldNombreVoluntario;
    @FXML
    private TextField textFieldApellido1Voluntario;
    @FXML
    private TextField textFieldApellido2Voluntario;
    @FXML
    private TextField textFieldDireccionVoluntario;
    @FXML
    private TextField textFieldLocalidadVoluntario;
    @FXML
    private TextField textFieldCPVoluntario;
    @FXML
    private Button btnRegistrarVoluntario;
    @FXML
    private Button btnSalir;
    @FXML
    public void initialize() {
        /*
        colDniVoluntario.setCellValueFactory(cellData -> cellData.getValue().dniProperty());
        colNombreVoluntario.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        colApellido1Voluntario.setCellValueFactory(cellData -> cellData.getValue().apellido1Property());
        colApellido2Voluntario.setCellValueFactory(cellData -> cellData.getValue().apellido2Property());
        colDireccionVoluntario.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
        colLocalidadVoluntario.setCellValueFactory(cellData -> cellData.getValue().localidadProperty());
        colCPVoluntario.setCellValueFactory(cellData -> cellData.getValue().cpProperty());
        // Add any additional initialization logic here
         */
    }




    /*
+-----------------------------------------------------------------------------------------------+
|                                 BUTTONS FOR THE OPEN WINDOWS                                  |
+-----------------------------------------------------------------------------------------------+
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
    public void registroVbox() {
        vboxRegistroVoluntarios.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroVoluntarios.setVisible(false);
    }
    public void atrasVentanas(){
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
