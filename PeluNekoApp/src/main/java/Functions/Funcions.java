package Functions;

import Hibernate.HibernateUntil;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Funcions {

    public static void closedSession(Stage stage) {
        stage.setOnCloseRequest(event -> {
            HibernateUntil.shutdown();
            System.out.println("Cerrando la aplicacion");
            Platform.exit();
            System.exit(0);
        });
    }

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
            System.out.println("Error al abrir la ventana: " + e.getMessage());
        }
    }
    public void alertInfo(String title,String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
