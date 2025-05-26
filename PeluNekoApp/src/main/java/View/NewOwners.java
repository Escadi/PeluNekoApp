package View;

import Controllers.ControllerPropietarios;
import Entity.Adopcione;
import Entity.Animale;
import Entity.Nuevosdueno;
import Entity.Voluntarioscentro;
import Functions.FuncionCSV;
import Functions.Funcions;
import Models.AdopcionesModel;
import Models.PropietariosModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NewOwners {
    private double xOffset = 0;
    private double yOffset = 0;

    ControllerPropietarios controllerPropietarios = new ControllerPropietarios();
    Funcions funcions = new Funcions();
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
    private VBox vboxRegistroPropietario;
    @FXML
    private HBox hboxModificar;
    @FXML
    private VBox vboxMain;
    @FXML
    private VBox vboxModificarPropietario;
    @FXML
    private TextField textFieldModificarDNI;
    @FXML
    private TextField textFieldModificarNombrePropietarios;
    @FXML
    private TextField textFieldModificarApellido1Propietarios;
    @FXML
    private TextField textFieldModificarApellido2Propietarios;
    @FXML
    private TextField textFieldModificarDireccionPropietarios;
    @FXML
    private TextField textFieldModificarLocalidadPropietarios;
    @FXML
    private TextField textFieldModificarCPPropietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colDniPropietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colNombrePropietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colApellido1Propietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colApellido2Propietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colDireccionPropietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colLocalidadPropietarios;
    @FXML
    private TableColumn<Nuevosdueno, String> colCPPropietarios;
    @FXML
    private TableView tablaPropietarios;
    @FXML
    private Button btnAtras;

    @FXML
    public void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }

        colDniPropietarios.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNombrePropietarios.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido1Propietarios.setCellValueFactory(new PropertyValueFactory<>("apellido1"));
        colApellido2Propietarios.setCellValueFactory(new PropertyValueFactory<>("apellido2"));
        colDireccionPropietarios.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colLocalidadPropietarios.setCellValueFactory(new PropertyValueFactory<>("localidad"));
        colCPPropietarios.setCellValueFactory(new PropertyValueFactory<>("codigoPostal"));
        ObservableList<Nuevosdueno> propietarios = FXCollections.observableArrayList(PropietariosModel.getPropietarios());
        tablaPropietarios.setItems(propietarios);


        /*
+-----------------------------------------------------------------------------------------------+
|                                MOVING FOR THE POSITION VBOX                                   |
+-----------------------------------------------------------------------------------------------+
*/
        //Movimiento de ventanas registro de propietarios
        vboxRegistroPropietario.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxRegistroPropietario.getLayoutX();
            yOffset = event.getSceneY() - vboxRegistroPropietario.getLayoutY();
        });
        vboxRegistroPropietario.setOnMouseDragged(event -> {
            vboxRegistroPropietario.setLayoutX(event.getScreenX() - xOffset);
            vboxRegistroPropietario.setLayoutY(event.getScreenY() - yOffset);
        });
        //Movimiento de ventanas modificar propietarios
        vboxModificarPropietario.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxModificarPropietario.getLayoutX();
            yOffset = event.getSceneY() - vboxModificarPropietario.getLayoutY();
        });
        vboxModificarPropietario.setOnMouseDragged(event -> {
            vboxModificarPropietario.setLayoutX(event.getScreenX() - xOffset);
            vboxModificarPropietario.setLayoutY(event.getScreenY() - yOffset);
        });

         /*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Nuevosdueno> filterPropietarios = new FilteredList<>(propietarios, b -> true);
        textFieldBuscarPropietario.textProperty().addListener((observable, oldValue, newValue) -> {
            filterPropietarios.setPredicate(propietario -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                } else if (propietario.getDni().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (propietario.getNombre().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (propietario.getApellido1().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Nuevosdueno> sortedData = new SortedList<>(filterPropietarios);
        sortedData.comparatorProperty().bind(tablaPropietarios.comparatorProperty());
        tablaPropietarios.setItems(sortedData);


/*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup pop = new Popup();
        pop.getContent().add(hboxModificar);
        tablaPropietarios.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Nuevosdueno nuevosdueno = (Nuevosdueno) tablaPropietarios.getSelectionModel().getSelectedItem();
                if (nuevosdueno != null) {
                    pop.show(tablaPropietarios.getScene().getWindow(), event.getSceneX(), event.getSceneY());
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

    public void getDataModificar() {
        Nuevosdueno nuevoDueno = (Nuevosdueno) tablaPropietarios.getSelectionModel().getSelectedItem();
        textFieldModificarDNI.setText(nuevoDueno.getDni());
        textFieldModificarNombrePropietarios.setText(nuevoDueno.getNombre());
        textFieldModificarApellido1Propietarios.setText(nuevoDueno.getApellido1());
        textFieldModificarApellido2Propietarios.setText(nuevoDueno.getApellido2());
        textFieldModificarDireccionPropietarios.setText(nuevoDueno.getDireccion());
        textFieldModificarLocalidadPropietarios.setText(nuevoDueno.getLocalidad());
        textFieldModificarCPPropietarios.setText(nuevoDueno.getCodigoPostal());
        vboxModificarPropietario.setVisible(true);
        hboxModificar.setVisible(false);
    }

            /*
    +-----------------------------------------------------------------------------------------------+
    |                               CRUD FOR THE NEW OWNERS TABLE                                |
    +-----------------------------------------------------------------------------------------------+
    */

    public void agregarUsuario() {
        String dni = textFieldDNIPropietarios.getText();
        String nombre = textFieldNombrePropietarios.getText();
        String apellido1 = textFieldApellido1Propietarios.getText();
        String apellido2 = textFieldApellido2Propietarios.getText();
        String direccion = textFieldDireccionPropietarios.getText();
        String localidad = textFieldLocalidadPropietarios.getText();
        String codigoPostal = textFieldCPPropietarios.getText();
        controllerPropietarios.agregarPropietario(
                dni,
                nombre,
                apellido1,
                apellido2,
                direccion,
                localidad,
                codigoPostal
        );
        initialize();
    }

    public void modificarUsuario() {
        String dni = textFieldModificarDNI.getText();
        String nombre = textFieldModificarNombrePropietarios.getText();
        String apellido1 = textFieldModificarApellido1Propietarios.getText();
        String apellido2 = textFieldModificarApellido2Propietarios.getText();
        String direccion = textFieldModificarDireccionPropietarios.getText();
        String localidad = textFieldModificarLocalidadPropietarios.getText();
        String codigoPostal = textFieldModificarCPPropietarios.getText();
        controllerPropietarios.modificarPropietarios(
                dni,
                nombre,
                apellido1,
                apellido2,
                direccion,
                localidad,
                codigoPostal
        );
        initialize();
    }
    public void eliminarUsuario() {
        Nuevosdueno nuevoDueno = (Nuevosdueno) tablaPropietarios.getSelectionModel().getSelectedItem();
        if (AdopcionesModel.tieneAdopcion(nuevoDueno.getDni())) {
            funcions.alertInfo("Error","No se puede eliminar el propietario porque tiene un animal en adopción");
        }else {
            controllerPropietarios.eliminarPropietarios(nuevoDueno.getDni());
            initialize();

        }
        hboxModificar.setVisible(false);
    }

    /*
    +-----------------------------------------------------------------------------------------------+
    |                                    EXPORT CSV PROPIETARIOS                                    |
    +-----------------------------------------------------------------------------------------------+
    */
    public void exportarCSV() {
        FuncionCSV funcionCSV = new FuncionCSV();
        funcionCSV.propietariosCSV();
    }


    /*
    +-----------------------------------------------------------------------------------------------+
    |                                 BUTTONS FOR THE OPEN WINDOWS                                  |
    +-----------------------------------------------------------------------------------------------+
    */
    public void registroVbox() {
        vboxRegistroPropietario.setVisible(true);
    }

    public void salirVentanas() {
        vboxModificarPropietario.setVisible(false);
        vboxRegistroPropietario.setVisible(false);
    }

    public void atrasVentanas() {
        funcions.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
