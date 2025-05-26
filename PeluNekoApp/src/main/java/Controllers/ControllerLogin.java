package Controllers;

import Entity.Logincentro;
import Functions.Funcions;
import Models.LoginModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;


public class ControllerLogin {

    Funcions funcion = new Funcions();


    public void agregarUsuarioLogin(String dni,String rol, String passwd) {
        Logincentro logincentro = new Logincentro();
        logincentro.setIdVoluntarioString(dni);
        logincentro.setPasswd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
        logincentro.setRol(rol);
        LoginModel.addLogin(logincentro);
        funcion.alertInfo("Login", "Usuario agregado correctamente");
    }
    public void actualizarUsuarioLogin(int id,String dni, String rol, String passwd) {
        Logincentro logincentro = new Logincentro();
        logincentro.setId(id);
        logincentro.setIdVoluntarioString(dni);
        logincentro.setPasswd(passwd);
        logincentro.setRol(rol);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText("¿Está seguro de que desea actualizar el usuario?");
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            LoginModel.actualizarLogin(id,logincentro);
            funcion.alertInfo("Login", "Usuario actualizado correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funcion.alertInfo("Login", "Usuario no actualizado");

        }
    }

    public void eliminarUsuarioLogin(int id) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar");
        alert.setHeaderText("¿Está seguro de que desea eliminar el usuario?");
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            LoginModel.eliminarLogin(id);
            funcion.alertInfo("Login", "Usuario eliminado correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funcion.alertInfo("Login", "Usuario no eliminado");

        }
    }
}
