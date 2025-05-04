package Entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AdopcioneId implements java.io.Serializable {
    private static final long serialVersionUID = 7279733291718979217L;
    @Column(name = "idAnimal", nullable = false)
    private Integer idAnimal;

    @Column(name = "DNI", nullable = false, length = 15)
    private String dni;

    public AdopcioneId() {}

    public AdopcioneId(Integer idAnimal, String dni) {
        this.idAnimal = idAnimal;
        this.dni = dni;
    }


    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdopcioneId entity = (AdopcioneId) o;
        return Objects.equals(this.idAnimal, entity.idAnimal) &&
                Objects.equals(this.dni, entity.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimal, dni);
    }

}