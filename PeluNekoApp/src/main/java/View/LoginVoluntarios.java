package View;

import Controllers.ControllerLogin;
import Entity.Logincentro;
import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.LoginModel;

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

import java.util.List;

public class LoginVoluntarios {
    private double xOffset = 0;
    private double yOffset = 0;

    Funcions funcions = new Funcions();
    ControllerLogin controllerLogin = new ControllerLogin();
    @FXML
    private HBox hboxModificar;
    @FXML
    private ComboBox comboBoxRol;
    @FXML
    private ComboBox comboBoxVoluntario;
    @FXML
    private TextField textFieldBuscarUsuario;
    @FXML
    private TableView tablaLogin;
    @FXML
    private TableColumn<LoginVoluntarios, String> colDniVoluntario;
    @FXML
    private TableColumn<LoginVoluntarios, String> colPassword;
    @FXML
    private TableColumn<LoginVoluntarios, String> colRol;
    @FXML
    private Button btnAtras;
    @FXML
    private VBox vboxRegistroLogin;
    @FXML
    private VBox vboxMain;
    @FXML
    private PasswordField textFieldPassword;
    @FXML
    private VBox vboxModificarLogin;
    @FXML
    private ComboBox comboBoxModificarVoluntario;
    @FXML
    private ComboBox comboBoxModificarRol;
    @FXML
    private PasswordField textFieldModificarPassword;


    @FXML
    public void initialize() {
        initializeComboBoxTipoRol();
        initializeComboBoxVoluntario();
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        colDniVoluntario.setCellValueFactory(new PropertyValueFactory<>("voluntarioid"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("passwd"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        ObservableList<Logincentro> logins = FXCollections.observableArrayList(LoginModel.getLogin());
        tablaLogin.setItems(logins);



        /*
+-----------------------------------------------------------------------------------------------+
|                                MOVING FOR THE POSITION VBOX                                   |
+-----------------------------------------------------------------------------------------------+
*/
        //Movimiento de ventanas registro de propietarios
        vboxRegistroLogin.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxRegistroLogin.getLayoutX();
            yOffset = event.getSceneY() - vboxRegistroLogin.getLayoutY();
        });
        vboxRegistroLogin.setOnMouseDragged(event -> {
            vboxRegistroLogin.setLayoutX(event.getScreenX() - xOffset);
            vboxRegistroLogin.setLayoutY(event.getScreenY() - yOffset);
        });
        //Movimiento de ventanas modificar propietarios
        vboxModificarLogin.setOnMousePressed(event -> {
            xOffset = event.getSceneX() - vboxModificarLogin.getLayoutX();
            yOffset = event.getSceneY() - vboxModificarLogin.getLayoutY();
        });
        vboxModificarLogin.setOnMouseDragged(event -> {
            vboxModificarLogin.setLayoutX(event.getScreenX() - xOffset);
            vboxModificarLogin.setLayoutY(event.getScreenY() - yOffset);
        });

        /*
+-----------------------------------------------------------------------------------------------+
|                                       FILTER USERS                                            |
+-----------------------------------------------------------------------------------------------+
*/
        FilteredList<Logincentro> filterdni = new FilteredList<>(logins, b -> true);
        textFieldBuscarUsuario.
                textProperty().addListener((observable, oldValue, newValue) -> {
                    filterdni.setPredicate(logincentro -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        } else if (logincentro.getVoluntarioid().toLowerCase().contains(newValue.toLowerCase())) {
                            return true;
                        } else if (logincentro.getRol().toLowerCase().contains(newValue.toLowerCase())) {
                            return true;
                        }
                        return false;
                    });
                });
        SortedList<Logincentro> sortedData = new SortedList<>(filterdni);
        sortedData.comparatorProperty().bind(tablaLogin.comparatorProperty());
        tablaLogin.setItems(sortedData);

        /*
+-----------------------------------------------------------------------------------------------+
|                             CONFING VISIBLE THE UPDATE AND DELETE VBOX                        |
+-----------------------------------------------------------------------------------------------+
*/
        Popup pop = new Popup();
        pop.getContent().add(hboxModificar);
        tablaLogin.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Logincentro logincentro = (Logincentro) tablaLogin.getSelectionModel().getSelectedItem();
                if (logincentro != null) {
                    pop.show(tablaLogin.getScene().getWindow(), event.getSceneX(), event.getSceneY());
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
    public void initializeComboBoxTipoRol() {
        ObservableList<String> rol = FXCollections.observableArrayList(
                "Administrador", "Voluntario", "Veterinario");
        comboBoxRol.setItems(rol);
        comboBoxModificarRol.setItems(rol);
    }

    public void initializeComboBoxVoluntario() {
        List<Voluntarioscentro> voluntarioList = VoluntariosModel.getVoluntarios();
        ObservableList<String> voluntarios = FXCollections.observableArrayList();

        for (Voluntarioscentro v : voluntarioList) {
            voluntarios.add(v.getDNIVoluntario());
        }
        comboBoxVoluntario.setItems(voluntarios);
        comboBoxModificarVoluntario.setItems(voluntarios);

    }


    /*
    +-----------------------------------------------------------------------------------------------+
    |                                       VIEW DATA UPDATE                                        |
    +-----------------------------------------------------------------------------------------------+
    */
    public void getDataLogin() {
        Logincentro logincentro = (Logincentro) tablaLogin.getSelectionModel().getSelectedItem();
        comboBoxModificarVoluntario.setValue(logincentro.getVoluntarioid());
        textFieldModificarPassword.setText(logincentro.getPasswd());
        comboBoxModificarRol.setValue(logincentro.getRol());
        vboxModificarLogin.setVisible(true);
    }

    /*
   +-----------------------------------------------------------------------------------------------+
   |                                 CRUD FOR THE LOGIN TABLE                                |
   +-----------------------------------------------------------------------------------------------+
   */
    public void agregarLogin() {
        String dni = (String) comboBoxVoluntario.getSelectionModel().getSelectedItem();
        String rol = (String) comboBoxRol.getSelectionModel().getSelectedItem();
        String password = textFieldPassword.getText();
        controllerLogin.agregarUsuarioLogin(
                dni,
                rol,
                password
        );
        initialize();
    }

    public void updateLogin() {
        int id = ((Logincentro) tablaLogin.getSelectionModel().getSelectedItem()).getId();
        String dni = (String) comboBoxModificarVoluntario.getSelectionModel().getSelectedItem();
        String rol = (String) comboBoxModificarRol.getSelectionModel().getSelectedItem();
        String password = textFieldModificarPassword.getText();
        controllerLogin.actualizarUsuarioLogin(
                id,
                dni,
                rol,
                password
        );
        initialize();

    }

    public void eliminarLogin() {
        Logincentro logincentro = (Logincentro) tablaLogin.getSelectionModel().getSelectedItem();
        controllerLogin.eliminarUsuarioLogin(logincentro.getId());
        initialize();

    }


    /*
        +-----------------------------------------------------------------------------------------------+
        |                                 BUTTONS FOR THE OPEN WINDOWS                                  |
        +-----------------------------------------------------------------------------------------------+
        */
    public void registroVbox() {
        vboxRegistroLogin.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroLogin.setVisible(false);
        vboxModificarLogin.setVisible(false);
    }

    public void atrasVentanas() {
        funcions.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
