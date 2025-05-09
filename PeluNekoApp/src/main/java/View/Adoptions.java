package View;

import Entity.Adopcione;


import Functions.Funcions;
import Models.AdopcionesModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Adoptions {
    Funcions funcions = new Funcions();
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
    private TableColumn<Adopcione, String> colNumeroAnimal;
    @FXML
    private TableColumn<Adopcione, String> colDNIPropietario;
    @FXML
    private TableColumn<Adopcione, String> colFechaAdopcion;

    @FXML
    public void initialize() {
        colNumeroAnimal.setCellValueFactory(new PropertyValueFactory<>("IdAdopcionAnimal"));
        colDNIPropietario.setCellValueFactory(new PropertyValueFactory<>("dniPropietario"));
        colFechaAdopcion.setCellValueFactory(new PropertyValueFactory<>("fechaAdopcion"));
        ObservableList<Adopcione> adopciones = FXCollections.observableArrayList(AdopcionesModel.getAdopciones());
        tablaAdopciones.setItems(adopciones);



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
    }

    public void atrasVentanas() {
        funcions.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
