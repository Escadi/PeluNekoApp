package View;

import Controllers.ControllerVoluntario;
import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.VoluntariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VoluntariosList {
    Funcions funcion = new Funcions();
    @FXML
    private TextField textFieldBuscarVoluntario;
    @FXML
    private TableView tablaVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colDniVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colNombreVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colApellido1Voluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colApellido2Voluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colDireccionVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colLocalidadVoluntario;
    @FXML
    private TableColumn<Voluntarioscentro, String> colCPVoluntario;
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

        /*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Voluntarioscentro> filterVoluntarios = new FilteredList<>(voluntarioscentros, b -> true);
        textFieldBuscarVoluntario.textProperty().addListener((observable, oldValue, newValue) -> {
            filterVoluntarios.setPredicate(voluntario -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                } else if (voluntario.getNombreVoluntario().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (voluntario.getApellido1Voluntario().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (voluntario.getDNIVoluntario().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Voluntarioscentro> sortedData = new SortedList<>(filterVoluntarios);
        sortedData.comparatorProperty().bind(tablaVoluntario.comparatorProperty());
        tablaVoluntario.setItems(sortedData);

    }

     /*
+-----------------------------------------------------------------------------------------------+
|                                 CRUD FOR THE VOLUNTARIOS TABLE                                |
+-----------------------------------------------------------------------------------------------+
*/
    public void agregarVoluntario() {
        ControllerVoluntario controllerVoluntario = new ControllerVoluntario();
        controllerVoluntario.agregarVoluntarios(textFieldDNIVoluntario,
                textFieldNombreVoluntario,
                textFieldApellido1Voluntario,
                textFieldApellido2Voluntario,
                textFieldDireccionVoluntario,
                textFieldLocalidadVoluntario,
                textFieldCPVoluntario);
        initialize();
    }


    /*
+-----------------------------------------------------------------------------------------------+
|                                 BUTTONS FOR THE OPEN WINDOWS                                  |
+-----------------------------------------------------------------------------------------------+
*/

    public void registroVbox() {
        vboxRegistroVoluntarios.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroVoluntarios.setVisible(false);
    }

    public void atrasVentanas() {
        funcion.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
