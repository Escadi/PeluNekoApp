package Controllers;

import Entity.*;
import Functions.*;
import Models.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;


public class ControllerPropietarios {
    Funcions funciones = new Funcions();


    public void agregarPropietario(String dni, String nombre, String apellido1, String apellido2, String direccion, String localidad, String codigoPostal) {
        Nuevosdueno nuevoDueno = new Nuevosdueno();
        nuevoDueno.setDni(dni);
        nuevoDueno.setNombre(nombre);
        nuevoDueno.setApellido1(apellido1);
        nuevoDueno.setApellido2(apellido2);
        nuevoDueno.setDireccion(direccion);
        nuevoDueno.setLocalidad(localidad);
        nuevoDueno.setCodigoPostal(codigoPostal);
        PropietariosModel.addPropietario(nuevoDueno);
        funciones.alertInfo("Registro", "El Usuario : " + dni + " se ha registrado correctamente");

    }

    public void modificarPropietarios(String dni, String nombre, String apellido1, String apellido2, String direccion, String localidad, String codigoPostal) {
        Nuevosdueno nuevoDueno = new Nuevosdueno();
        nuevoDueno.setDni(dni);
        nuevoDueno.setNombre(nombre);
        nuevoDueno.setApellido1(apellido1);
        nuevoDueno.setApellido2(apellido2);
        nuevoDueno.setDireccion(direccion);
        nuevoDueno.setLocalidad(localidad);
        nuevoDueno.setCodigoPostal(codigoPostal);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quieres modificar el Usuario con dni: " + dni);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si) {
            PropietariosModel.updatePropietario(nuevoDueno);
            funciones.alertInfo("Registro", "El Usuario : " + dni + " se ha modificado correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funciones.alertInfo("Registro", "El Usuario : " + dni + " no se ha modificado");
        }


    }

    public void eliminarPropietarios(String dni) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quiere modificar el Usuario con dni: " + dni);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si) {
            PropietariosModel.deletePropietario(dni);
            funciones.alertInfo("Registro", "El Usuario : " + dni + " se ha eliminado correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funciones.alertInfo("Registro", "El Usuario : " + dni + " no se ha eliminado");
        }
    }


}
