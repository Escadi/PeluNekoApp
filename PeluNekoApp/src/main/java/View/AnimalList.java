package View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AnimalList {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private VBox vboxRegistroAnimales;
    @FXML
    private Button btnAtras;

    public AnimalList() {

    }

    @FXML
    public void initialize() {





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
