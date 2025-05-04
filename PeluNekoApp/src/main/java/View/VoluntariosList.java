package View;

import Entity.Voluntarioscentro;
import Models.VoluntariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class VoluntariosList {
    @FXML
    private TextField textFieldBuscarVoluntario;
    @FXML
    private TableView tablaVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colDniVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colNombreVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colApellido1Voluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colApellido2Voluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colDireccionVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colLocalidadVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro,String> colCPVoluntario;
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
        colDniVoluntario.setCellValueFactory(new PropertyValueFactory<>("dNIVoluntario"));
        colNombreVoluntario.setCellValueFactory(new PropertyValueFactory<>("nombreVoluntario"));
        colApellido1Voluntario.setCellValueFactory(new PropertyValueFactory<>("apellido1Voluntario"));
        colApellido2Voluntario.setCellValueFactory(new PropertyValueFactory<>("apellido2Voluntario"));
        colDireccionVoluntario.setCellValueFactory(new PropertyValueFactory<>("direccionVoluntario"));
        colLocalidadVoluntario.setCellValueFactory(new PropertyValueFactory<>("localidadVoluntario"));
        colCPVoluntario.setCellValueFactory(new PropertyValueFactory<>("codigoPostalVoluntario"));
        ObservableList<Voluntarioscentro> voluntarioscentros = FXCollections.observableArrayList(VoluntariosModel.getVoluntarios());
        tablaVoluntario.setItems(voluntarioscentros);
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
