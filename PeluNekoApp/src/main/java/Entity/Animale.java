package Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "animales")
public class Animale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAnimal", nullable = false)
    private Integer id;

    @Column(name = "tipoAnimal", nullable = false, length = 50)
    private String tipoAnimal;

    @Column(name = "nombre",nullable = false, length = 50)
    private String nombre;

    @Column(name = "Peso", length = 5)
    private String peso;

    @Column(name = "Estado", length = 50)
    private String estado;

    @Column(name = "imagen", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idRaza", nullable = false)
    private Raza idRaza;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dNIVoluntario")
    private Voluntarioscentro dNIVoluntario;

    @OneToMany(mappedBy = "idAnimal")
    private Set<Adopcione> adopciones = new LinkedHashSet<>();

    public Animale() {
    }

    public Animale(Integer id, String tipoAnimal, String nombre, String peso, String estado, byte[] imagen, Raza idRaza, Voluntarioscentro dNIVoluntario) {
        this.id = id;
        this.tipoAnimal = tipoAnimal;
        this.nombre = nombre;
        this.peso = peso;
        this.estado = estado;
        this.imagen = imagen;
        this.idRaza = idRaza;
        this.dNIVoluntario = dNIVoluntario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Raza getIdRaza() {
        return idRaza;
    }

    public String getRaza() {
        return idRaza.getRaza();
    }

    public void setIdRaza(Raza idRaza) {
        this.idRaza = idRaza;
    }

    public Voluntarioscentro getDNIVoluntario() {
        return dNIVoluntario;
    }

    public String getDNIVoluntarioString() {
        return dNIVoluntario != null ? dNIVoluntario.getDNIVoluntario() : "";
    }

    public String getDniVoluntario() {
        return dNIVoluntario != null ? dNIVoluntario.getNombreVoluntario() + " " + dNIVoluntario.getApellido1Voluntario() + " " + dNIVoluntario.getApellido2Voluntario() : "";
    }

    public void setDNIVoluntario(Voluntarioscentro dNIVoluntario) {
        this.dNIVoluntario = dNIVoluntario;
    }

    public Set<Adopcione> getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(Set<Adopcione> adopciones) {
        this.adopciones = adopciones;
    }

}