package Entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adopciones")
public class Adopcione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdopcion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idAnimal", nullable = false)
    private Animale idAnimal;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "DNI", nullable = false)
    private Nuevosdueno dni;

    @Column(name = "FechaAdopcion")
    private LocalDate fechaAdopcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Animale getIdAnimal() {
        return idAnimal;
    }

    public String getDniPropietario() {
        return dni != null ? dni.getDni() + " - " +
                dni.getNombre() + " " + dni.getApellido1() + " " + dni.getApellido2() : "";
    }
    public Integer getIdAdopcionAnimal() {
        return idAnimal != null ? idAnimal.getId() : null;
    }
    public void setDniString(String DNI) {
        if (this.dni == null) {
            this.dni = new Nuevosdueno();
        }
        this.dni.setDni(DNI);
    }
    public String getDniString() {
        return dni != null ? dni.getDni() : "";
    }
    public void setIdAdopcionAnimal(Integer idAdopcionAnimal) {
        if(this.idAnimal == null){
            this.idAnimal = new Animale();
        }
        this.idAnimal.setId(idAdopcionAnimal);
    }
    public void setIdAnimal(Animale idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Nuevosdueno getDni() {
        return dni;
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