package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

public class LoginVoluntarios {
    @FXML
    private ComboBox comboBoxRol;
    @FXML
    private TextField textFieldBuscarUsuario;
    @FXML
    private TableView tablaLogin;
    @FXML
    private TableColumn<LoginVoluntarios,String> colDniVoluntario;
    @FXML
    private TableColumn<LoginVoluntarios,String> colPassword;
    @FXML
    private TableColumn<LoginVoluntarios,String> colRol;
    @FXML
    private Button btnAtras;
    @FXML
    private VBox vboxRegistroLogin;
    @FXML
    private TextField textFieldDNIvoluntario;
    @FXML
    private TextField textFieldPassword;
    @FXML
    private Button btnRegistrarAdopcion;
    @FXML
    private Button btnSalir;


    @FXML
    public void initialize() {
        /*
        colDniVoluntario.setCellValueFactory(cellData -> cellData.getValue().dniProperty());
        colPassword.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());
        colRol.setCellValueFactory(cellData -> cellData.getValue().rolProperty());

        // Initialize the table columns and other components here if needed

         */
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
        vboxRegistroLogin.setVisible(true);
    }

    public void salirVentanas() {
        vboxRegistroLogin.setVisible(false);
    }
    public void atrasVentanas(){
        abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        ((Stage) btnAtras.getScene().getWindow()).close();

    }
}
