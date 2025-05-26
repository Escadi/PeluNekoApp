package Controllers;


import Entity.Adopcione;
import Functions.Funcions;
import Models.AdopcionesModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.time.LocalDate;
import java.util.Optional;

public class ControllerAdopciones {
    Funcions funcion = new Funcions();

    public void agregarAdopcion(int idAnimal , String dniPropietario ){
        Adopcione adopcion = new Adopcione();
        adopcion.setIdAdopcionAnimal(idAnimal);
        adopcion.setDniString(dniPropietario);
        AdopcionesModel.addAdopcion(adopcion);
        funcion.alertInfo("Adopcion registrada", "La adopcion ha sido registrada correctamente");

    }

    public void modificarAdopcion(int id, int idAnimal, String dniPropietario, String fecha){
        Adopcione adopcion = new Adopcione();
        adopcion.setId(id);
        adopcion.setIdAdopcionAnimal(idAnimal);
        adopcion.setDniString(dniPropietario);
        adopcion.setFechaAdopcion(LocalDate.parse(fecha));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quiere modificar la adopcion con numero: " + id);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            AdopcionesModel.updateAdopcion(adopcion);
            funcion.alertInfo("Adopcion modificada", "La adopcion ha sido modificada correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funcion.alertInfo("Adopcion no modificada", "La adopcion no ha sido modificada");

        }

    }

    public void eliminarAdopcion(int id){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quieres eliminar la adopcion con id: " + id);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            AdopcionesModel.deleteAdopcion(id);
            funcion.alertInfo("Adopcion eliminada", "La adopcion ha sido eliminada correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funcion.alertInfo("Adopcion eliminada", "La adopcion no ha sido eliminada");

        }

    }
}
