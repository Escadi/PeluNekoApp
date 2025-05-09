package Controllers;

import Entity.Animale;
import Entity.Raza;
import Entity.Voluntarioscentro;
import Functions.Funcions;
import Models.AnimalModel;
import Models.RazasModel;

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

    public void agregarAnimales(String nombre, String tipo, String raza, String peso, String estado, String imagen, String dniVoluntario) {
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
    public void modificarAnimales(int id , String nombre, String tipo, String raza, String peso, String estado, String dniVoluntario) {
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
        animales.setDNIVoluntario(voluntarioDNI);
        AnimalModel.updateAnimal(id,animales);
        funcions.alertInfo("Registro", "El animal : " + nombre + " se ha modificado correctamente");
    }
}
