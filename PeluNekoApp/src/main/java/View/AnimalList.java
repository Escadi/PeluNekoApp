package View;

import Entity.Animale;
import Models.AnimalModel;
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
import Entity.*;


import javax.persistence.Entity;
import java.io.IOException;

public class AnimalList {

    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private TextField textFieldBuscarAnimal;
    @FXML
    private VBox vboxRegistroAnimales;
    @FXML
    private Button btnAtras;
    @FXML
    private TableColumn<Animale, Integer> colNumeroAnimal;
    @FXML
    private TableColumn<Animale, String> colTipoAnimal;
    @FXML
    private TableColumn<Animale, Double> colPeso;
    @FXML
    private TableColumn<Animale, String>colEstado;
    @FXML
    private TableColumn<Animale, String> colImagen;
    @FXML
    private TableColumn<Animale, String>colRaza;
    @FXML
    private TableColumn<Animale, String>colDniVoluntario;
    @FXML
    private TableView tablaAnimales;

    public AnimalList() {

    }

    @FXML
    public void initialize() {
        colNumeroAnimal.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipoAnimal.setCellValueFactory(new PropertyValueFactory<>("tipoAnimal"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colImagen.setCellValueFactory(new PropertyValueFactory<>("imagen"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        colDniVoluntario.setCellValueFactory(new PropertyValueFactory<>("dniVoluntario"));
        ObservableList<Animale> animal = FXCollections.observableArrayList(AnimalModel.getAnimals());
        tablaAnimales.setItems(animal);





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
        vboxRegistroAnimales.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroAnimales.setVisible(false);
    }
    public void atrasVentanas(){
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
