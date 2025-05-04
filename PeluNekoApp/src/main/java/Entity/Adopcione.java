package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
public class Adopcione {
    @EmbeddedId
    private AdopcioneId id;

    @MapsId("idAnimal")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idAnimal", nullable = false)
    private Animale idAnimal;

    @MapsId("dni")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DNI", nullable = false)
    private Nuevosdueno dni;

    @Column(name = "FechaAdopcion")
    private LocalDate fechaAdopcion;

    public Adopcione() {
    }

    public Adopcione(AdopcioneId id, Animale idAnimal, Nuevosdueno dni, LocalDate fechaAdopcion) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.dni = dni;
        this.fechaAdopcion = fechaAdopcion;

    }

    public AdopcioneId getId() {
        return id;
    }

    public void setId(AdopcioneId id) {
        this.id = id;
    }

    public Animale getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Animale idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdAdopcionAnimal() {
        return id != null ? id.getIdAnimal() : null;
    }

    public Nuevosdueno getDni() {
        return dni;
    }

    public String getDniPropietario() {
        return dni != null ? dni.getDni() + "-" +
                dni.getNombre() + " " + dni.getApellido1() + " " + dni.getApellido2() : "";
    }

    public void setDni(Nuevosdueno dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(LocalDate fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

}