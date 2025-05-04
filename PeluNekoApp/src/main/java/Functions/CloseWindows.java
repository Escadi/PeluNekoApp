package Functions;
import Conection.ConectionDB;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class CloseWindows {
    public static void cerrarVentanas(Stage stage) {
        stage.setOnCloseRequest((WindowEvent e) -> {
            System.out.println("Ha salido del programa");
            ConectionDB.closeConn();
            Platform.exit();
            System.exit(0);
        });
    }
}
