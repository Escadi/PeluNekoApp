package Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "nuevosduenos")
public class Nuevosdueno {
    @Id
    @Column(name = "DNI", nullable = false, length = 15)
    private String dni;

    @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "Apellido1", nullable = false, length = 50)
    private String apellido1;

    @Column(name = "Apellido2", length = 50)
    private String apellido2;

    @Column(name = "Direccion", length = 100)
    private String direccion;

    @Column(name = "Localidad", length = 50)
    private String localidad;

    @Column(name = "CodigoPostal", length = 10)
    private String codigoPostal;

    @OneToMany(mappedBy = "dni")
    private Set<Adopcione> adopciones = new LinkedHashSet<>();

    @OneToMany(mappedBy = "dni" , fetch = FetchType.LAZY)
    private List<Adopcione> adopcionesList;

    public Nuevosdueno() {}

    public Nuevosdueno(String dni, String nombre, String apellido1, String apellido2, String direccion, String localidad, String codigoPostal, Set<Adopcione> adopciones) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
        this.adopciones = adopciones;
    }

    public List<Adopcione> getAdopcionesList() {
        return adopcionesList;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Set<Adopcione> getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(Set<Adopcione> adopciones) {
        this.adopciones = adopciones;
    }

}