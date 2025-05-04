package Entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "raza")
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRaza", nullable = false)
    private Integer id;

    @Column(name = "raza", nullable = false, length = 50)
    private String raza;

    @OneToMany(mappedBy = "idRaza")
    private Set<Animale> animales = new LinkedHashSet<>();
    public Raza() {
    }
    public Raza(String raza) {
        this.raza = raza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Set<Animale> getAnimales() {
        return animales;
    }

    public void setAnimales(Set<Animale> animales) {
        this.animales = animales;
    }

}