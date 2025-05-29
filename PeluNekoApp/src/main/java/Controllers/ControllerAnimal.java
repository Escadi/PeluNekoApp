package Controllers;

import Entity.Animale;
import Entity.Raza;
import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.AnimalModel;
import Models.PropietariosModel;
import Models.RazasModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class ControllerAnimal {
    Funcions funcions = new Funcions();

    public Raza idRazaAnimal(String raza){
        for (Raza razas : RazasModel.getRazas()) {
            if (razas.getRaza().equalsIgnoreCase(raza)) {
               return razas;
            }
        }
        return null;
    }

    public void agregarAnimales(String nombre, String tipo, String raza, String peso, String estado, byte[] imagen, String dniVoluntario) {
        //-----Buscamos el dni del voluntario--------
        Voluntarioscentro voluntarioDNI = new Voluntarioscentro();
        voluntarioDNI.setDNIVoluntario(dniVoluntario);
        //-----Buscamos la id de la raza-------
        Raza miRaza = idRazaAnimal(raza);
            //-----------Creamos el objeto animal-------
            Animale animales = new Animale();
            animales.setTipoAnimal(tipo);
            animales.setNombre(nombre);
            animales.setPeso(peso);
            animales.setEstado(estado);
            animales.setImagen(imagen);
            animales.setIdRaza(miRaza);
            animales.setDNIVoluntario(voluntarioDNI);
            AnimalModel.addAnimal(animales);
            funcions.alertInfo("Registro", "El animal : " + nombre + " se ha registrado correctamente");
    }
    public void modificarAnimales(int id , String nombre, String tipo, String raza, String peso, String estado,byte[] imagen, String dniVoluntario) {
        //-----Buscamos el dni del voluntario--------
        Voluntarioscentro voluntarioDNI = new Voluntarioscentro();
        voluntarioDNI.setDNIVoluntario(dniVoluntario);
        //-----Buscamos la id de la raza-------
        Raza miRaza = idRazaAnimal(raza);
        //-----------Creamos el objeto animal-------
        Animale animales = new Animale();
        animales.setId(id);
        animales.setNombre(nombre);
        animales.setTipoAnimal(tipo);
        animales.setPeso(peso);
        animales.setIdRaza(miRaza);
        animales.setEstado(estado);
        animales.setImagen(imagen);
        animales.setDNIVoluntario(voluntarioDNI);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quieres modificar el Animal : " + nombre);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si ) {
            AnimalModel.updateAnimal(id, animales);
            funcions.alertInfo("Registro", "El animal : " + nombre + " se ha modificado correctamente");
        }else if (result.isPresent() && result.get() == no) {
            funcions.alertInfo("Registro", "El animal : " + nombre + " no se ha modificado");
        }
    }
    public void eliminarAnimales(int id) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Quiere eliminar el animal con ID : " + id);
        ButtonType si = new ButtonType("Sí");
        ButtonType no = new ButtonType("No");
        alert.getButtonTypes().setAll(si, no);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == si) {
            AnimalModel.deleteAnimal(id);
            funcions.alertInfo("Eliminar", "El Animal : " + id + " se ha eliminado correctamente");
        } else if (result.isPresent() && result.get() == no) {
            funcions.alertInfo("Registro", "El Animal : " + id + " no se ha eliminado");
        }
    }
}
