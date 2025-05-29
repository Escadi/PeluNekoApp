package Controllers;

import Entity.Logincentro;
import Functions.Funcions;
import DataSave.SessionLogin;
import Models.LoginModel;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class ControllerMenu {
    Funcions funcion = new Funcions();

    public void showDni(String dni, String Password) {
        List<Logincentro> logins = LoginModel.getLogin();
        Boolean encontrado = false;
        for (Logincentro login : logins) {
            if (login.getVoluntarioid().equals(dni)) {
                if(BCrypt.checkpw(Password, login.getPasswd())) {
                    SessionLogin.setDni(login.getVoluntarioid());
                    encontrado = true;
                    break;
                }
            }
        }
        if (encontrado) {
            funcion.alertInfo("Login", "Usuario correcto");
            funcion.abrirVentana("/ViewFXML/MenuSelection.fxml", "Menu Principal");
        } else {
            funcion.alertInfo("Login", "Usuario incorrecto , intentelo de nuevo");
        }
    }

    public boolean ventanas() {
        String rol = LoginModel.admin(SessionLogin.getDniVoluntario());
        System.out.println("El rol que tiene es " + rol);
        if (rol != null && rol.equalsIgnoreCase("Administrador")) {
            return true;
        } else {
            return false;
        }
    }


}
