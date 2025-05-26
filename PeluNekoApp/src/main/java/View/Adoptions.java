package View;

import Entity.Adopcione;


import Entity.Animale;
import Functions.Funcions;
import Models.AdopcionesModel;
import Controllers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import Entity.*;

public class Adoptions {
    private double xOffset = 0;
    private double yOffset = 0;
    ControllerAdopciones controller = new ControllerAdopciones();
    Funcions funcions = new Funcions();
    @FXML
    private TextField textFieldBuscarAdopcion;
    @FXML
    private TextField textFieldIdAnimalAdopcion;
    @FXML
    private TextField textFieldDniPropietarioAdopcion;
    @FXML
    private VBox vboxRegistroAdopciones;
    @FXML
    private VBox vboxMain;
    @FXML
    private Button btnAtras;
    @FXML
    private HBox hboxModificar;
    @FXML
    private VBox vboxModificarAdopciones;
    @FXML
    private TextField textFieldModificarIdAnimal;
    @FXML
    private TextField textFieldModificarDniPropietario;
    @FXML
    private TextField textFieldCodigoAdopcion;
    @FXML
    private TextField textFieldModificarFecha;
    @FXML
    private Button btnModificarAdopcion;
    @FXML
    private TableView tablaAdopciones;
    @FXML
    private TableColumn<Adopcione, String> colNumeroAnimal;
    @FXML
    private TableColumn<Adopcione, String> colDNIPropietario;
    @FXML
    private TableColumn<Adopcione, String> colFechaAdopcion;
    @FXML
    private TableColumn<Adopcione, String> colidAdopcion;

    @FXML
    public void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        colidAdopcion.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumeroAnimal.setCellValueFactory(new PropertyValueFactory<>("IdAdopcionAnimal"));
        colDNIPropietario.setCellValueFactory(new PropertyValueFactory<>("DniPropietario"));
        colFechaAdopcion.setCellValueFactory(new PropertyValueFactory<>("fechaAdopcion"));
        ObservableList<Adopcione> adopciones = FXCollections.observableArrayList(AdopcionesModel.getAdopciones());
        tablaAdopciones.setItems(adopciones);


          /*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Adopcione> filterVoluntarios = new FilteredList<>(adopciones, b -> true);
        textFieldBuscarAdopcion.textProperty().addListener((observable, oldValue, newValue) -> {
            filterVoluntarios.setPredicate(adopcion -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                } else if (String.valueOf(adopcion.getIdAnimal()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (adopcion.getDniPropietario().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (String.valueOf(adopcion.getFechaAdopcion()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Adopcione> sortedData = new SortedList<>(filterVoluntarios);
        sortedData.comparatorProperty().bind(tablaAdopciones.comparatorProperty());
        tablaAdopciones.setItems(sortedData);

        /*
+-----------------------------------------------------------------------------------------------+
|                                MOVING FOR THE POSITION VBOX                                   |
+-----------------------------------------------------------------------------------------------+
*/
        //Movimiento de ventanas registro de adopciones
        vboxRegistroAdopciones.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxRegistroAdopciones.getLayoutX();
            yOffset = event.getSceneY() - vboxRegistroAdopciones.getLayoutY();
        });
        vboxRegistroAdopciones.setOnMouseDragged(event -> {
            vboxRegistroAdopciones.setLayoutX(event.getScreenX() - xOffset);
            vboxRegistroAdopciones.setLayoutY(event.getScreenY() - yOffset);
        });
        //Movimiento de ventanas modificar de adopciones
        vboxModificarAdopciones.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxModificarAdopciones.getLayoutX();
            yOffset = event.getSceneY() - vboxModificarAdopciones.getLayoutY();
        });
        vboxModificarAdopciones.setOnMouseDragged(event -> {
            vboxModificarAdopciones.setLayoutX(event.getScreenX() - xOffset);
            vboxModificarAdopciones.setLayoutY(event.getScreenY() - yOffset);
        });

                /*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup popup = new Popup();
        popup.getContent().add(hboxModificar);
        tablaAdopciones.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Adopcione adopcion = (Adopcione) tablaAdopciones.getSelectionModel().getSelectedItem();
                if (adopcion != null) {
                    popup.show(tablaAdopciones, event.getScreenX(), event.getScreenY());
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
    public void getDataAdopcion() {
        Adopcione adopcion = (Adopcione) tablaAdopciones.getSelectionModel().getSelectedItem();
        textFieldCodigoAdopcion.setText(String.valueOf(adopcion.getId()));
        textFieldModificarIdAnimal.setText(String.valueOf(adopcion.getIdAdopcionAnimal()));
        textFieldModificarDniPropietario.setText(adopcion.getDniString());
        textFieldModificarFecha.setText(String.valueOf(adopcion.getFechaAdopcion()));
        vboxModificarAdopciones.setVisible(true);
        hboxModificar.setVisible(false);
    }

        /*
+-----------------------------------------------------------------------------------------------+
|                                 CRUD FOR THE ADOPTIONS TABLE                                |
+-----------------------------------------------------------------------------------------------+
*/
    public void agregarAdopcion() {
        int animal = Integer.parseInt(textFieldIdAnimalAdopcion.getText());
        String dni = textFieldDniPropietarioAdopcion.getText();
        controller.agregarAdopcion(
                animal,dni);
        initialize();
    }
    public void modificarAdopcion() {
        int id = Integer.parseInt(textFieldCodigoAdopcion.getText());
        int animal = Integer.parseInt(textFieldModificarIdAnimal.getText());
        String dni = textFieldModificarDniPropietario.getText();
        String fecha = textFieldModificarFecha.getText();
        if (dni.isEmpty()) {
            funcions.alertInfo("Error", "No se ha seleccionado ningun animal");
        }else {
            controller.modificarAdopcion(
                    id, animal, dni , fecha);
            initialize();
            hboxModificar.setVisible(false);
        }
    }

    public void eliminarAdopcion() {
        Adopcione adopcion = (Adopcione) tablaAdopciones.getSelectionModel().getSelectedItem();
        if (adopcion != null) {
            controller.eliminarAdopcion(adopcion.getId());
            initialize();
        } else {
            funcions.alertInfo("Error", "No se ha seleccionado ninguna adopcion");
        }

    }


    /*
+-----------------------------------------------------------------------------------------------+
|                                 BUTTONS FOR THE OPEN WINDOWS                                  |
+-----------------------------------------------------------------------------------------------+
*/
    public void registroVbox() {
        vboxRegistroAdopciones.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroAdopciones.setVisible(false);
        vboxModificarAdopciones.setVisible(false);
    }

    public void atrasVentanas() {
        funcions.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
