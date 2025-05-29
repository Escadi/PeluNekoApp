package Functions;

import Entity.Adopcione;
import Entity.Animale;
import Entity.Nuevosdueno;
import Entity.Voluntarioscentro;
import Models.AdopcionesModel;
import Models.AnimalModel;
import Models.PropietariosModel;
import Models.VoluntariosModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FuncionCSV {
    Funcions funcions = new Funcions();
    public void animalesCSV() {
        List<Animale> animales = AnimalModel.getAnimals();
        String descarga = System.getProperty("user.home") + File.separator + "Downloads";
        File archivo = new File(descarga, "AnimalesRegistrados.csv");
        try (BufferedWriter ficheroCSVAnimales = new BufferedWriter(new FileWriter(archivo))) {
            ficheroCSVAnimales.write("ID;Nombre;Tipo Animal;Raza;Peso;Estado;Voluntario \n");
            for (Animale animal : animales) {
                ficheroCSVAnimales.write(
                        animal.getId() + ";" +
                                animal.getNombre() + ";" +
                                animal.getTipoAnimal() + ";" +
                                animal.getRaza() + ";" +
                                animal.getPeso() + ";" +
                                animal.getEstado() + ";" +
                                animal.getDniVoluntario() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        funcions.alertInfo("Exportar CSV", "El archivo CSV se ha exportado en : \n " + archivo.getAbsolutePath());
    }

    public void propietariosCSV() {
        List<Nuevosdueno> nuevosduenos = PropietariosModel.getPropietarios();
        String descarga = System.getProperty("user.home") + File.separator + "Downloads";
        File archivo = new File(descarga, "DueñosRegistrados.csv");
        try (BufferedWriter ficheroCSVPropietarios = new BufferedWriter(new FileWriter(archivo))) {
            ficheroCSVPropietarios.write("Dni;Nombre;Primer Apellido;Segundo Apellido;Dirección;Localidad;Codigo Postal \n");
            for (Nuevosdueno propietario : nuevosduenos) {
                ficheroCSVPropietarios.write(
                         propietario.getDni()+ ";" +
                                propietario.getNombre() + ";" +
                                propietario.getApellido1() + ";" +
                                propietario.getApellido2() + ";" +
                                propietario.getDireccion() + ";" +
                                propietario.getLocalidad() + ";" +
                                propietario.getCodigoPostal() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        funcions.alertInfo("Exportar CSV", "El archivo CSV se ha exportado en : \n " + archivo.getAbsolutePath());
    }

    public void voluntariosCSV() {
        List<Voluntarioscentro> voluntarios = VoluntariosModel.getVoluntarios();
        String descarga = System.getProperty("user.home") + File.separator + "Downloads";
        File archivo = new File(descarga, "DueñosRegistrados.csv");
        try (BufferedWriter ficheroCSVvoluntarios = new BufferedWriter(new FileWriter(archivo))) {
            ficheroCSVvoluntarios.write("Dni;Nombre;Primer Apellido;Segundo Apellido;Dirección;Localidad;Codigo Postal \n");
            for (Voluntarioscentro voluntario : voluntarios) {
                ficheroCSVvoluntarios.write(
                        voluntario.getDNIVoluntario()+ ";" +
                                voluntario.getNombreVoluntario() + ";" +
                                voluntario.getApellido1Voluntario() + ";" +
                                voluntario.getApellido2Voluntario() + ";" +
                                voluntario.getDireccionVoluntario() + ";" +
                                voluntario.getLocalidadVoluntario() + ";" +
                                voluntario.getCodigoPostalVoluntario() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        funcions.alertInfo("Exportar CSV", "El archivo CSV se ha exportado en : \n " + archivo.getAbsolutePath());
    }
    public void adopcionesCSV() {
        List<Adopcione> adopcion = AdopcionesModel.getAdopciones();
        String descarga = System.getProperty("user.home") + File.separator + "Downloads";
        File archivo = new File(descarga, "AdopcionesRegistradas.csv");
        try (BufferedWriter ficheroCSVadopciones = new BufferedWriter(new FileWriter(archivo))) {
            ficheroCSVadopciones.write("ID; Identificador Animal; DNI nuevo dueño; Fecha adopción \n");
            for (Adopcione adopciones : adopcion) {
                ficheroCSVadopciones.write(
                                adopciones.getId() + ";" +
                                adopciones.getIdAnimal() + ";" +
                                adopciones.getDniPropietario() + ";" +
                                adopciones.getFechaAdopcion() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        funcions.alertInfo("Exportar CSV", "El archivo CSV se ha exportado en : \n " + archivo.getAbsolutePath());
    }



}
