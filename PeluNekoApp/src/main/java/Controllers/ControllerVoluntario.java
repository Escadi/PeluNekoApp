package Controllers;

import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.VoluntariosModel;
import javafx.scene.control.TextField;

public class ControllerVoluntario {
    Funcions funcions = new Funcions();

    public void agregarVoluntarios(TextField dni, TextField nombre, TextField apellido1, TextField apellido2,
                                   TextField direccion, TextField localidad, TextField codigoPostal) {
        Voluntarioscentro voluntario = new Voluntarioscentro();
        voluntario.setDNIVoluntario(dni.getText());
        voluntario.setNombreVoluntario(nombre.getText());
        voluntario.setApellido1Voluntario(apellido1.getText());
        voluntario.setApellido2Voluntario(apellido2.getText());
        voluntario.setDireccionVoluntario(direccion.getText());
        voluntario.setLocalidadVoluntario(localidad.getText());
        voluntario.setCodigoPostalVoluntario(codigoPostal.getText());
        VoluntariosModel.addVoluntario(voluntario);
        funcions.alertInfo("Registro", "El voluntario : " + dni.getText() + " se ha registrado correctamente");

    }
}
