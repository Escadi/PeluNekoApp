package View;

import Controllers.ControllerMenu;
import Functions.Funcions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class SeleccionPane {
    ControllerMenu controllerMenu = new ControllerMenu();
    @FXML
    private TabPane tabPane;
    @FXML
    private VBox vboxMain;

    @FXML
    private void initialize() {
        if (vboxMain != null) {
            vboxMain.setFillWidth(true);
        }
        try {
            // Pestaña 1: Lista de Animales
            Tab tabAnimal = new Tab("Animales");
            tabAnimal.setContent(FXMLLoader.load(getClass().getResource("/ViewFXML/AnimalList.fxml")));

            // Pestaña 2: Nuevos Dueños
            Tab tabPersona = new Tab("Nuevos Dueños");
            tabPersona.setContent(FXMLLoader.load(getClass().getResource("/ViewFXML/NewOwners.fxml")));

            // Pestaña 3: Adopciones
            Tab tabAdopcion = new Tab("Adopciones");
            tabAdopcion.setContent(FXMLLoader.load(getClass().getResource("/ViewFXML/Adoptions.fxml")));

            // Pestaña 4: Voluntarios y Login Voluntario (si el rol es Administrador)
            if(controllerMenu.ventanas()){
                Tab tabVoluntarios = new Tab("Voluntarios");
                tabVoluntarios.setContent(FXMLLoader.load(getClass().getResource("/ViewFXML/VoluntariosList.fxml")));

                Tab tabLogin = new Tab("Login Voluntario");
                tabLogin.setContent(FXMLLoader.load(getClass().getResource("/ViewFXML/LoginVoluntarios.fxml")));

                tabPane.getTabs().addAll(tabAnimal, tabPersona, tabAdopcion,tabVoluntarios, tabLogin);
            }else{
                tabPane.getTabs().addAll(tabAnimal, tabPersona, tabAdopcion);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error initializing SeleccionPane: " + e.getMessage());
        }
    }
}
