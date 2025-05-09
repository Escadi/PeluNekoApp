package View;

import Controllers.ControllerAnimal;
import Entity.Animale;
import Functions.Funcions;
import Models.AnimalModel;
import Models.RazasModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Entity.*;


import javax.persistence.Entity;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AnimalList {
    @FXML
    private VBox vboxModificar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    Funcions funciones = new Funcions();
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private TextField textFieldNombreAnimal;
    @FXML
    private ComboBox comboBoxTipoAnimal;
    @FXML
    private ComboBox comboBoxRaza;
    @FXML
    private TextField textFieldPesoAnimal;
    @FXML
    private TextArea textAreaEstadoAnimal;
    @FXML
    private TextField textFieldDniVoluntario;
    @FXML
    private TextField textFieldModificarNombre;
    @FXML
    private ComboBox comboBoxModificarTipo;
    @FXML
    private ComboBox comboBoxModificarRaza;
    @FXML
    private TextField textFieldModificarPeso;
    @FXML
    private TextArea textAreaModificarEstado;
    @FXML
    private TextField textFieldModificarDNIVoluntario;
    @FXML
    private Button btnSubirImagen;
    @FXML
    private Button btnRegistrarAnimal;
    @FXML
    private Button btnSalir;
    @FXML
    private TextField textFieldBuscarAnimal;
    @FXML
    private VBox vboxRegistroAnimales;
    @FXML
    private VBox vboxModificarView;
    @FXML
    private Button btnAtras;
    @FXML
    private TableColumn<Animale, Integer> colNumeroAnimal;
    @FXML
    private TableColumn<Animale, String> colTipoAnimal;
    @FXML
    public TableColumn<Animale, String> colNombreAnimal;
    @FXML
    private TableColumn<Animale, Double> colPeso;
    @FXML
    private TableColumn<Animale, String> colEstado;
    @FXML
    private TableColumn<Animale, String> colImagen;
    @FXML
    private TableColumn<Animale, String> colRaza;
    @FXML
    private TableColumn<Animale, String> colDniVoluntario;
    @FXML
    private TableView tablaAnimales;
    private int idAnimales;

    public AnimalList() {

    }

    @FXML
    public void initialize() {
        initializeComboBoxTipoAnimal();
        initializeComboBoxRaza();
        colNumeroAnimal.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipoAnimal.setCellValueFactory(new PropertyValueFactory<>("tipoAnimal"));
        colNombreAnimal.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colImagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        colDniVoluntario.setCellValueFactory(new PropertyValueFactory<>("dniVoluntario"));
        ObservableList<Animale> animal = FXCollections.observableArrayList(AnimalModel.getAnimals());
        tablaAnimales.setItems(animal);

         /*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Animale> filterAnimales = new FilteredList<>(animal, b -> true);
        textFieldBuscarAnimal.textProperty().addListener((observable, oldValue, newValue) -> {
            filterAnimales.setPredicate(animales -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                } else if (String.valueOf(animales.getId()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (animales.getDniVoluntario().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (String.valueOf(animales.getRaza()).toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else if (animales.getNombre().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Animale> sortedData = new SortedList<>(filterAnimales);
        sortedData.comparatorProperty().bind(tablaAnimales.comparatorProperty());
        tablaAnimales.setItems(sortedData);






        /*
+-----------------------------------------------------------------------------------------------+
|                                MOVING FOR THE POSITION VBOX                                   |
+-----------------------------------------------------------------------------------------------+
*/

        //Movimiento de ventanas registro de animales
        vboxRegistroAnimales.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxRegistroAnimales.getLayoutX();
            yOffset = event.getSceneY() - vboxRegistroAnimales.getLayoutY();
        });
        vboxRegistroAnimales.setOnMouseDragged(event -> {
            vboxRegistroAnimales.setLayoutX(event.getScreenX() - xOffset);
            vboxRegistroAnimales.setLayoutY(event.getScreenY() - yOffset);
        });

        /*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup pop = new Popup();
        pop.getContent().add(vboxModificar);
        tablaAnimales.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Animale animale = (Animale) tablaAnimales.getSelectionModel().getSelectedItem();
                if (animale != null) {
                    pop.show(
                            tablaAnimales.getScene().getWindow(),
                            event.getSceneX(),
                            event.getSceneY()
                    );
                    vboxModificar.setVisible(true);

                }
            }
        });
    }


    /*
+-----------------------------------------------------------------------------------------------+
|                                    COMBOBOX CONFIGURATIONS                                    |
+-----------------------------------------------------------------------------------------------+
*/
    public void initializeComboBoxTipoAnimal() {
        ObservableList<String> tiposAnimales = FXCollections.observableArrayList("Perro", "Gato", "Conejo", "Hámster", "Tortuga", "Pájaro", "Reptil", "Otro");
        comboBoxTipoAnimal.setItems(tiposAnimales);
    }

    public void initializeComboBoxRaza() {
        List<Raza> razaList = RazasModel.getRazas();
        ObservableList<String> razas = FXCollections.observableArrayList();
        for (Raza raza : razaList) {
            razas.add(raza.getRaza());
        }
        comboBoxRaza.setItems(razas);
    }

     /*
+-----------------------------------------------------------------------------------------------+
|                                       VIEW DATA UPDATE                                        |
+-----------------------------------------------------------------------------------------------+
*/
    public void dataUpdate() {
        Animale animal = (Animale) tablaAnimales.getSelectionModel().getSelectedItem();
        idAnimales = animal.getId();
        textFieldModificarNombre.setText(animal.getNombre());
        comboBoxModificarTipo.setValue(animal.getTipoAnimal());
        textFieldModificarPeso.setText(String.valueOf(animal.getPeso()));
        textAreaModificarEstado.setText(animal.getEstado());
        textFieldModificarDNIVoluntario.setText(animal.getDniVoluntario());
        comboBoxModificarRaza.setValue(animal.getRaza());
        vboxModificarView.setVisible(true);
        vboxModificar.setVisible(false);
    }

    /*
+-----------------------------------------------------------------------------------------------+
|                                 CRUD FOR THE ANIMALSLIST TABLE                                |
+-----------------------------------------------------------------------------------------------+
*/
    public void agregarAnimal() {
        String nombre = textFieldNombreAnimal.getText();
        String tipoAnimal = (String) comboBoxTipoAnimal.getSelectionModel().getSelectedItem();
        String raza = (String) comboBoxRaza.getSelectionModel().getSelectedItem();
        String peso = textFieldPesoAnimal.getText();
        String estado = textAreaEstadoAnimal.getText();
        String imagen = "";
        String dniVoluntario = textFieldDniVoluntario.getText();
        ControllerAnimal controllerAnimal = new ControllerAnimal();
        controllerAnimal.agregarAnimales(nombre,
                tipoAnimal,
                raza,
                peso,
                estado,
                imagen,
                dniVoluntario);
        initialize();
    }

    public void actualizarAnimal() {
        String nombre = textFieldModificarNombre.getText().toLowerCase();
        String tipoAnimal = (String) comboBoxModificarTipo.getSelectionModel().getSelectedItem();
        String raza = (String) comboBoxModificarRaza.getSelectionModel().getSelectedItem();
        String peso = textFieldModificarPeso.getText();
        String estado = textAreaModificarEstado.getText();
        String dniVoluntario = textFieldModificarDNIVoluntario.getText();
        ControllerAnimal controllerAnimal = new ControllerAnimal();
        controllerAnimal.modificarAnimales(
                idAnimales,
                nombre,
                tipoAnimal,
                raza,
                peso,
                estado,
                dniVoluntario);
        initialize();

    }



    /*
+-----------------------------------------------------------------------------------------------+
|                                 BUTTONS FOR THE OPEN WINDOWS                                  |
+-----------------------------------------------------------------------------------------------+
*/
    public void registroVbox() {
        vboxRegistroAnimales.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroAnimales.setVisible(false);
        vboxModificarView.setVisible(false);
    }

    public void atrasVentanas() {
        funciones.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
