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

public class NewOwners {
    @FXML
    private TextField textFieldBuscarPropietario;
    @FXML
    private TextField textFieldDNIPropietarios;
    @FXML
    private TextField textFieldNombrePropietarios;
    @FXML
    private TextField textFieldApellido1Propietarios;
    @FXML
    private TextField textFieldApellido2Propietarios;
    @FXML
    private TextField textFieldDireccionPropietarios;
    @FXML
    private TextField textFieldLocalidadPropietarios;
    @FXML
    private TextField textFieldCPPropietarios;
    @FXML
    private Button btnRegistrarPropietarios;
    @FXML
    private Button btnSalir;
    @FXML
    private VBox vboxRegistroPropietario;
    @FXML
    private TableColumn colDniPropietarios;
    @FXML
    private TableColumn colNombrePropietarios;
    @FXML
    private TableColumn colApellido1Propietarios;
    @FXML
    private TableColumn colApellido2Propietarios;
    @FXML
    private TableColumn colDireccionPropietarios;
    @FXML
    private TableColumn colLocalidadPropietarios;
    @FXML
    private TableColumn colCPPropietarios;
    @FXML
    private TableView tablaPropietarios;
    @FXML
    private Button btnAtras;
    @FXML
    public void initialize() {
        // Initialize the table columns and other components here if needed
        // For example, you can set cell value factories for the table columns
        // colDniPropietarios.setCellValueFactory(new PropertyValueFactory<>("dni"));
        // colNombrePropietarios.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        // colApellido1Propietarios.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
        // colApellido2Propietarios.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
        // colDireccionPropietarios.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        // colLocalidadPropietarios.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        // colCPPropietarios.setCellValueFactory(new PropertyValueFactory<>("cp"));
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
            System.out.println("Error al abrir la ventana del FXML: " + e.getMessage());
        }
    }

    public void registroVbox() {

        vboxRegistroPropietario.setVisible(true);
    }

    public void salirVentanas() {

        vboxRegistroPropietario.setVisible(false);
    }

    public void atrasVentanas() {
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
