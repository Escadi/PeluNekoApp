package Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "voluntarioscentro")
public class Voluntarioscentro {
    @Id
    @Column(name = "DNIVoluntario", nullable = false, length = 15)
    private String dNIVoluntario;

    @Column(name = "NombreVoluntario", nullable = false, length = 50)
    private String nombreVoluntario;

    @Column(name = "Apellido1Voluntario", nullable = false, length = 50)
    private String apellido1Voluntario;

    @Column(name = "Apellido2Voluntario", length = 50)
    private String apellido2Voluntario;

    @Column(name = "DireccionVoluntario", length = 100)
    private String direccionVoluntario;

    @Column(name = "LocalidadVoluntario", length = 50)
    private String localidadVoluntario;

    @Column(name = "CodigoPostalVoluntario", length = 10)
    private String codigoPostalVoluntario;

    @OneToMany(mappedBy = "dNIVoluntario")
    private Set<Animale> animales = new LinkedHashSet<>();

    @OneToOne(mappedBy = "voluntarioscentro")
    private Logincentro logincentro;

    public Voluntarioscentro() {
    }
    public Voluntarioscentro(String dNIVoluntario, String nombreVoluntario, String apellido1Voluntario, String apellido2Voluntario, String direccionVoluntario, String localidadVoluntario, String codigoPostalVoluntario) {
        this.dNIVoluntario = dNIVoluntario;
        this.nombreVoluntario = nombreVoluntario;
        this.apellido1Voluntario = apellido1Voluntario;
        this.apellido2Voluntario = apellido2Voluntario;
        this.direccionVoluntario = direccionVoluntario;
        this.localidadVoluntario = localidadVoluntario;
        this.codigoPostalVoluntario = codigoPostalVoluntario;
    }

    public String getDNIVoluntario() {
        return dNIVoluntario;
    }

    public void setDNIVoluntario(String dNIVoluntario) {
        this.dNIVoluntario = dNIVoluntario;
    }

    public String getNombreVoluntario() {
        return nombreVoluntario;
    }

    public void setNombreVoluntario(String nombreVoluntario) {
        this.nombreVoluntario = nombreVoluntario;
    }

    public String getApellido1Voluntario() {
        return apellido1Voluntario;
    }

    public void setApellido1Voluntario(String apellido1Voluntario) {
        this.apellido1Voluntario = apellido1Voluntario;
    }

    public String getApellido2Voluntario() {
        return apellido2Voluntario;
    }

    public void setApellido2Voluntario(String apellido2Voluntario) {
        this.apellido2Voluntario = apellido2Voluntario;
    }

    public String getDireccionVoluntario() {
        return direccionVoluntario;
    }

    public void setDireccionVoluntario(String direccionVoluntario) {
        this.direccionVoluntario = direccionVoluntario;
    }

    public String getLocalidadVoluntario() {
        return localidadVoluntario;
    }

    public void setLocalidadVoluntario(String localidadVoluntario) {
        this.localidadVoluntario = localidadVoluntario;
    }

    public String getCodigoPostalVoluntario() {
        return codigoPostalVoluntario;
    }

    public void setCodigoPostalVoluntario(String codigoPostalVoluntario) {
        this.codigoPostalVoluntario = codigoPostalVoluntario;
    }

    public Set<Animale> getAnimales() {
        return animales;
    }

    public void setAnimales(Set<Animale> animales) {
        this.animales = animales;
    }

    public Logincentro getLogincentro() {
        return logincentro;
    }

    public void setLogincentro(Logincentro logincentro) {
        this.logincentro = logincentro;
    }

}