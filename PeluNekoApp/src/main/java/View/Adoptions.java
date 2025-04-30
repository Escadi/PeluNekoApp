package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Adoptions {
    @FXML
    private TextField textFieldBuscarAdopcion;
    @FXML
    private TextField textFieldIdAnimalAdopcion;
    @FXML
    private TextField textFieldDniPropietarioAdopcion;
    @FXML
    private Button btnRegistrarAdopcion;
    @FXML
    private Button btnSalir;
    @FXML
    private VBox vboxRegistroAdopciones;
    @FXML
    private Button btnAtras;
    @FXML
    private TableView tablaAdopciones;
    @FXML
    private TableColumn colNumeroAnimal;
    @FXML
    private TableColumn colDNIPropietario;
    @FXML
    private TableColumn colFechaAdopcion;

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
            System.out.println("Error al abrir la ventana: " + e.getMessage());
        }
    }

    public void registroVbox() {
        vboxRegistroAdopciones.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroAdopciones.setVisible(false);
    }

    public void atrasVentanas() {
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
