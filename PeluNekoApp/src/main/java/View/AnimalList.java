package View;

import Controllers.ControllerAnimal;
import Entity.Animale;
import Functions.FicheroNombre;
import Functions.FuncionCSV;
import Functions.Funcions;
import Models.AdopcionesModel;
import Models.AnimalModel;
import Models.RazasModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import Entity.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

public class AnimalList {
    ControllerAnimal controllerAnimal = new ControllerAnimal();

    Funcions funciones = new Funcions();
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private VBox vboxImagen;
    @FXML
    private ImageView imagenViewFoto;
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
    private Button btnModificarImagen;
    @FXML
    private TextField textFieldBuscarAnimal;
    @FXML
    private VBox vboxRegistroAnimales;
    @FXML
    private VBox vboxModificarView;
    @FXML
    private HBox hboxModificar;
    @FXML
    private VBox vboxMain;
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
    private TableColumn<Animale, String> colRaza;
    @FXML
    private TableColumn<Animale, String> colDniVoluntario;
    @FXML
    private TableView tablaAnimales;
    private int idAnimales;
    private byte[] imagen;
    private boolean columnaExportar = false;
    private boolean columnaVer = false;

    public AnimalList() {

    }

    @FXML
    public void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        initializeComboBoxTipoAnimal();
        initializeComboBoxRaza();
        colNumeroAnimal.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTipoAnimal.setCellValueFactory(new PropertyValueFactory<>("tipoAnimal"));
        colNombreAnimal.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
        colDniVoluntario.setCellValueFactory(new PropertyValueFactory<>("dniVoluntario"));
        TableColumn<Animale, Void> botonFoto = new TableColumn<>("Exportar Imagen");
        TableColumn<Animale, Void> botonver = new TableColumn<>("Ver Imagen");
        // Añadir boton para exportar y ver la imagen de los animales
        if (!columnaExportar) {
            botonFoto.setCellFactory(col -> new TableCell<>() {

                private final Button boton = new Button("Descargar");
                {
                    boton.setStyle("-fx-background-color: transparent; -fx-border-color: Black; -fx-border-radius: 5px;");

                    ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/Images/Iconos/Descargar.png")));
                    icon.setFitHeight(25);
                    icon.setFitWidth(25);
                    boton.setGraphic(icon);
                    boton.setOnAction(event -> {
                        Animale animal = getTableView().getItems().get(getIndex());
                        byte[] imagenBytes = animal.getImagen();

                        if (imagenBytes != null) {
                            FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle("Guardar imagen como...");
                            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagen", "*.png", "*.jpg", "*.jpeg"));
                            fileChooser.setInitialFileName("imagen_exportada.png");

                            File destino = fileChooser.showSaveDialog(getTableView().getScene().getWindow());

                            if (destino != null) {
                                try {
                                    Files.write(destino.toPath(), imagenBytes);
                                    System.out.println("Imagen exportada con éxito.");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    System.out.println("Error al exportar la imagen.");
                                }
                            }
                        } else {
                            funciones.alertInfo("Imagen no disponible", "Este animal no tiene imagen.");
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : boton);
                }
            });

            tablaAnimales.getColumns().add(botonFoto);
            columnaExportar = true;
        }

        if (!columnaVer){
            botonver.setCellFactory(col -> new TableCell<>() {
                private final Button boton2 = new Button("Ver");
                {
                    boton2.setStyle("-fx-background-color: transparent; -fx-border-color: Black; -fx-border-radius: 5px;");
                    ImageView icon = new ImageView(new Image(getClass().getResourceAsStream("/Images/Iconos/vista.png")));
                    icon.setFitHeight(25);
                    icon.setFitWidth(25);
                    boton2.setGraphic(icon);
                    boton2.setOnAction(event -> {
                        Animale animal = getTableView().getItems().get(getIndex());
                        byte[] imagenBytes = animal.getImagen();
                        if (imagenBytes != null) {
                            InputStream s = new ByteArrayInputStream(imagenBytes);
                            Image image = new Image(s);
                            vboxImagen.setVisible(true);
                            imagenViewFoto.setImage(image);
                        } else {
                            funciones.alertInfo("Imagen no disponible", "Este animal no tiene imagen.");
                        }
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : boton2);
                }
            });
        }

        tablaAnimales.getColumns().add(botonver);
        columnaVer = true;

        ObservableList<Animale> animal = FXCollections.observableArrayList(AnimalModel.getAnimals());
        tablaAnimales.setItems(animal);

/*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Animale> filterAnimales = new FilteredList<>(animal, b -> true);
        textFieldBuscarAnimal.
                textProperty().addListener((observable, oldValue, newValue) -> {
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
        //Movimiento de ventanas modificacion de animales
        vboxModificarView.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxModificarView.getLayoutX();
            yOffset = event.getSceneY() - vboxModificarView.getLayoutY();
        });
        vboxModificarView.setOnMouseDragged(event -> {
            vboxModificarView.setLayoutX(event.getScreenX() - xOffset);
            vboxModificarView.setLayoutY(event.getScreenY() - yOffset);
        });
        //Movimiento de ventanas de imagenes de animales
        vboxImagen.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxImagen.getLayoutX();
            yOffset = event.getSceneY() - vboxImagen.getLayoutY();
        });
        vboxImagen.setOnMouseDragged(event -> {
            vboxImagen.setLayoutX(event.getScreenX() - xOffset);
            vboxImagen.setLayoutY(event.getScreenY() - yOffset);
        });

/*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup pop = new Popup();
        pop.getContent().add(hboxModificar);
        tablaAnimales.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Animale animale = (Animale) tablaAnimales.getSelectionModel().getSelectedItem();
                if (animale != null) {
                    pop.show(tablaAnimales.getScene().getWindow(), event.getSceneX(), event.getSceneY());
                    hboxModificar.setVisible(true);
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
        ObservableList<String> tiposAnimales = FXCollections.observableArrayList(
                "Perro", "Gato", "Conejo", "Roedor", "Tortuga", "Pájaro", "Reptil", "Otro");
        comboBoxTipoAnimal.setItems(tiposAnimales);
        comboBoxModificarTipo.setItems(tiposAnimales);
    }


    public void initializeComboBoxRaza() {
        List<Raza> razaList = RazasModel.getRazas();
        ObservableList<String> razas = FXCollections.observableArrayList();
        for (Raza raza : razaList) {
            razas.add(raza.getRaza());
        }

        comboBoxRaza.setItems(razas);
        comboBoxModificarRaza.setItems(razas);

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
        textFieldModificarDNIVoluntario.setText(animal.getDNIVoluntarioString());
        comboBoxModificarRaza.setValue(animal.getRaza());
        vboxModificarView.setVisible(true);
        hboxModificar.setVisible(false);
    }
    /*
    +-----------------------------------------------------------------------------------------------+
    |                                       RANDOM NAME ANIMALS                                     |
    +-----------------------------------------------------------------------------------------------+
    */
    public void randomNameAnimal() {
        FicheroNombre ficheroNombre = new FicheroNombre();
        String nombre = ficheroNombre.getNombreAnimal();
        textFieldNombreAnimal.setText(nombre);
    }
    public void randomNameAnimalModificar() {
        FicheroNombre ficheroNombre = new FicheroNombre();
        String nombre = ficheroNombre.getNombreAnimal();
        textFieldModificarNombre.setText(nombre);
    }

    /*
    +-----------------------------------------------------------------------------------------------+
    |                                 CRUD FOR THE ANIMALSLIST TABLE                                |
    +-----------------------------------------------------------------------------------------------+
    */

    public void subirImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Subir Imagen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagen", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(btnSubirImagen.getScene().getWindow());
        if (file != null) {
            try {
                byte[] imagenBytes = Files.readAllBytes(file.toPath());
                this.imagen = imagenBytes;
                System.out.println("Imagen cargada.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarAnimal() {
        String nombre = textFieldNombreAnimal.getText();
        String tipoAnimal = (String) comboBoxTipoAnimal.getSelectionModel().getSelectedItem();
        String raza = (String) comboBoxRaza.getSelectionModel().getSelectedItem();
        String peso = textFieldPesoAnimal.getText();
        String estado = textAreaEstadoAnimal.getText();
        String dniVoluntario = textFieldDniVoluntario.getText();
        controllerAnimal.agregarAnimales(
                nombre,
                tipoAnimal,
                raza,
                peso,
                estado,
                imagen,
                dniVoluntario);
        initialize();
    }

    public void modificarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Subir Imagen");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagen", "*.png", "*.jpg", "*.jpeg"));
        File file = fileChooser.showOpenDialog(btnModificarImagen.getScene().getWindow());
        if (file != null) {
            try {
                byte[] imagenBytes = Files.readAllBytes(file.toPath());
                this.imagen = imagenBytes;
                System.out.println("Imagen cargada.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void actualizarAnimal() {
        String nombre = textFieldModificarNombre.getText().toLowerCase();
        String tipoAnimal = (String) comboBoxModificarTipo.getSelectionModel().getSelectedItem();
        String raza = (String) comboBoxModificarRaza.getSelectionModel().getSelectedItem();
        String peso = textFieldModificarPeso.getText();
        String estado = textAreaModificarEstado.getText();
        String dniVoluntario = textFieldModificarDNIVoluntario.getText();
        initializeComboBoxRaza();
        initializeComboBoxTipoAnimal();
        controllerAnimal.modificarAnimales(
                idAnimales,
                nombre,
                tipoAnimal,
                raza,
                peso,
                estado,
                imagen,
                dniVoluntario);
        initialize();

    }

    public void eliminarAnimal() {
        Animale animal = (Animale) tablaAnimales.getSelectionModel().getSelectedItem();
        idAnimales = animal.getId();
        if (AdopcionesModel.existeAdopcionParaAnimal(idAnimales)) {
            funciones.alertInfo("Error", "No se puede eliminar el animal, ya que esta asociado a una adopcion");
        }else {
            controllerAnimal.eliminarAnimales(idAnimales);
            initialize();
        }

    }

     /*
    +-----------------------------------------------------------------------------------------------+
    |                                       EXPORT CSV ANIMAL                                       |
    +-----------------------------------------------------------------------------------------------+
    */
    public void exportarCSV() {
        FuncionCSV funcionCSV = new FuncionCSV();
        funcionCSV.animalesCSV();
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
        vboxImagen.setVisible(false);
    }

    public void atrasVentanas() {
        funciones.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
