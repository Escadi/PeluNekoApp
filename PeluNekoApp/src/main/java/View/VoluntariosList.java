package View;

import Controllers.*;
import Entity.Voluntarioscentro;
import Functions.FuncionCSV;
import Functions.Funcions;
import Models.VoluntariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;


public class VoluntariosList {
    private double xOffset = 0;
    private double yOffset = 0;
    ControllerVoluntario controllerVoluntario = new ControllerVoluntario();
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
    private VBox vboxMain;
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
    private VBox vboxModificarVoluntarios;
    @FXML
    private TextField textFieldModificarDNI;
    @FXML
    private TextField textFieldModificarNombre;
    @FXML
    private TextField textFieldModificarApellido1;
    @FXML
    private TextField textFieldModificarApellido2;
    @FXML
    private TextField textFieldModificarDireccion;
    @FXML
    private TextField textFieldModificarLocalidad;
    @FXML
    private TextField textFieldModificarCP;
    @FXML
    private HBox hboxModificar;

    @FXML
    public void initialize() {

        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
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

        /*
+-----------------------------------------------------------------------------------------------+
|                                MOVING FOR THE POSITION VBOX                                   |
+-----------------------------------------------------------------------------------------------+
*/
        //Movimiento de ventanas registro de voluntarios
        vboxRegistroVoluntarios.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxRegistroVoluntarios.getLayoutX();
            yOffset = event.getSceneY() - vboxRegistroVoluntarios.getLayoutY();
        });
        vboxRegistroVoluntarios.setOnMouseDragged(event -> {
            vboxRegistroVoluntarios.setLayoutX(event.getScreenX() - xOffset);
            vboxRegistroVoluntarios.setLayoutY(event.getScreenY() - yOffset);
        });
        //Movimiento de ventanas modificar de voluntarios
        vboxModificarVoluntarios.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxModificarVoluntarios.getLayoutX();
            yOffset = event.getSceneY() - vboxModificarVoluntarios.getLayoutY();
        });
        vboxModificarVoluntarios.setOnMouseDragged(event -> {
            vboxModificarVoluntarios.setLayoutX(event.getScreenX() - xOffset);
            vboxModificarVoluntarios.setLayoutY(event.getScreenY() - yOffset);
        });


        /*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup popup = new Popup();
        popup.getContent().add(hboxModificar);
        tablaVoluntario.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Voluntarioscentro voluntario = (Voluntarioscentro) tablaVoluntario.getSelectionModel().getSelectedItem();
                if (voluntario != null) {
                    popup.show(tablaVoluntario, event.getScreenX(), event.getScreenY());
                    hboxModificar.setVisible(true);
                }
            }
        });

    }


    /*
+-----------------------------------------------------------------------------------------------+
|                                       VIEW DATA UPDATE                                        |
+-----------------------------------------------------------------------------------------------+
*/
    public void getDataVoluntarios() {
        Voluntarioscentro voluntario = (Voluntarioscentro) tablaVoluntario.getSelectionModel().getSelectedItem();
        textFieldModificarDNI.setText(voluntario.getDNIVoluntario());
        textFieldModificarNombre.setText(voluntario.getNombreVoluntario());
        textFieldModificarApellido1.setText(voluntario.getApellido1Voluntario());
        textFieldModificarApellido2.setText(voluntario.getApellido2Voluntario());
        textFieldModificarDireccion.setText(voluntario.getDireccionVoluntario());
        textFieldModificarLocalidad.setText(voluntario.getLocalidadVoluntario());
        textFieldModificarCP.setText(voluntario.getCodigoPostalVoluntario());
        vboxModificarVoluntarios.setVisible(true);
        hboxModificar.setVisible(false);
    }

    /*
+-----------------------------------------------------------------------------------------------+
|                                 CRUD FOR THE VOLUNTARIOS TABLE                                |
+-----------------------------------------------------------------------------------------------+
*/
    public void agregarVoluntario() {
        String dni = textFieldDNIVoluntario.getText();
        String nombre = textFieldNombreVoluntario.getText();
        String apellido1 = textFieldApellido1Voluntario.getText();
        String apellido2 = textFieldApellido2Voluntario.getText();
        String direccion = textFieldDireccionVoluntario.getText();
        String localidad = textFieldLocalidadVoluntario.getText();
        String codigoPostal = textFieldCPVoluntario.getText();
        if (dni.isEmpty() || nombre.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() ||
                direccion.isEmpty() || localidad.isEmpty() || codigoPostal.isEmpty()) {
            funcion.alertInfo("Error", "No se han rellenado todos los campos");
        } else {
            controllerVoluntario.agregarVoluntarios(dni, nombre, apellido1, apellido2, direccion, localidad, codigoPostal);
            initialize();
            vboxRegistroVoluntarios.setVisible(false);
        }

    }

    public void modificarVoluntario() {
        String dni = textFieldModificarDNI.getText();
        String nombre = textFieldModificarNombre.getText();
        String apellido1 = textFieldModificarApellido1.getText();
        String apellido2 = textFieldModificarApellido2.getText();
        String direccion = textFieldModificarDireccion.getText();
        String localidad = textFieldModificarLocalidad.getText();
        String codigoPostal = textFieldModificarCP.getText();
        if (dni.isEmpty() || nombre.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() ||
                direccion.isEmpty() || localidad.isEmpty() || codigoPostal.isEmpty()) {
            funcion.alertInfo("Error", "No se han rellenado todos los campos");
        } else {
            controllerVoluntario.updateVoluntario(dni, nombre, apellido1, apellido2, direccion, localidad, codigoPostal);
            initialize();
            vboxModificarVoluntarios.setVisible(false);
        }

    }

    public void eliminarVoluntario() {
        Voluntarioscentro voluntario = (Voluntarioscentro) tablaVoluntario.getSelectionModel().getSelectedItem();
        if (voluntario != null) {
            controllerVoluntario.eliminarVoluntario(voluntario.getDNIVoluntario());
            initialize();
        } else {
            funcion.alertInfo("Error", "No se ha seleccionado ningun voluntario");
        }

    }
    /*
    +-----------------------------------------------------------------------------------------------+
    |                                       EXPORT CSV VOLUNTARIO                                   |
    +-----------------------------------------------------------------------------------------------+
    */
    public void exportarCSV() {
        FuncionCSV funcionCSV = new FuncionCSV();
        funcionCSV.voluntariosCSV();
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
        vboxModificarVoluntarios.setVisible(false);
    }

    public void atrasVentanas() {
        funcion.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
