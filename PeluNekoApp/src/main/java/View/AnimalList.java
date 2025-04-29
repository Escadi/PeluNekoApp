package View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AnimalList {
    private double xOffset = 0;
    private double yOffset = 0;
    @FXML
    private VBox vboxRegistroAnimales;

    public AnimalList() {

    }

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
    public void registroVbox(ActionEvent event) {

        vboxRegistroAnimales.setVisible(true);
    }

    public void salirVentanas(ActionEvent event) {
        vboxRegistroAnimales.setVisible(false);
    }
}
