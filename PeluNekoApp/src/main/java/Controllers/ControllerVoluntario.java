package Controllers;

import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.VoluntariosModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ControllerVoluntario {
    Funcions funcions = new Funcions();

    public void agregarVoluntarios(String dni , String nombre, String apellido1, String apellido2, String direccion, String localidad, String codigoPostal) {
        Voluntarioscentro voluntario = new Voluntarioscentro();
        voluntario.setDNIVoluntario(dni);
        voluntario.setNombreVoluntario(nombre);
        voluntario.setApellido1Voluntario(apellido1);
        voluntario.setApellido2Voluntario(apellido2);
        voluntario.setDireccionVoluntario(direccion);
        voluntario.setLocalidadVoluntario(localidad);
        voluntario.setCodigoPostalVoluntario(codigoPostal);
        VoluntariosModel.addVoluntario(voluntario);
        funcions.alertInfo("Registro", "El voluntario : " + dni + " se ha registrado correctamente");
    }
    public void updateVoluntario(String dni , String nombre, String apellido1, String apellido2, String direccion, String localidad, String codigoPostal){
        Voluntarioscentro voluntario = new Voluntarioscentro();
        voluntario.setDNIVoluntario(dni);
        voluntario.setNombreVoluntario(nombre);
        voluntario.setApellido1Voluntario(apellido1);
        voluntario.setApellido2Voluntario(apellido2);
        voluntario.setDireccionVoluntario(direccion);
        voluntario.setLocalidadVoluntario(localidad);
        voluntario.setCodigoPostalVoluntario(codigoPostal);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quieres modificar el Voluntario con dni: " + dni);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            VoluntariosModel.updateVoluntario(voluntario);
            funcions.alertInfo("Registro", "El voluntario : " + dni + " se ha modificado correctamente");
        }else if (result.isPresent() && result.get() == no){
            funcions.alertInfo("Registro", "El voluntario : " + dni + " no se ha modificado");
        }

    }
    public void eliminarVoluntario(String dni ){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quiere modificar el Voluntario con dni: " + dni);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
        VoluntariosModel.deleteVoluntario(dni);
        funcions.alertInfo("Registro", "El voluntario : " + dni + " se ha eliminado correctamente");
        }else if (result.isPresent() && result.get() == no){
            funcions.alertInfo("Registro", "El voluntario : " + dni + " no se ha eliminado");
        }
    }
}
