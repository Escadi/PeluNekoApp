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

    @Column(name = "Peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "Estado", length = 50)
    private String estado;

    @Column(name = "imagen")
    private String imagen;

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

    public Animale(Integer id, String tipoAnimal, BigDecimal peso, String estado, String imagen, Raza idRaza, Voluntarioscentro dNIVoluntario) {
        this.id = id;
        this.tipoAnimal = tipoAnimal;
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

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Raza getIdRaza() {
        return idRaza;
    }

    public String getRaza() {
        return idRaza != null ? idRaza.getRaza() : "";
    }

    public void setIdRaza(Raza idRaza) {
        this.idRaza = idRaza;
    }

    public Voluntarioscentro getDNIVoluntario() {
        return dNIVoluntario;
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