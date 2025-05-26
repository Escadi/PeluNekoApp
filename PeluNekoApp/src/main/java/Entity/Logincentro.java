package Entity;

import javax.persistence.*;

@Entity
@Table(name = "logincentros")
public class Logincentro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLogin", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idVoluntario" ,nullable = false)
    private Voluntarioscentro idVoluntario;

    @Column(name = "Passwd", nullable = false, length = 100)
    private String passwd;

    @Column(name = "Rol", nullable = false, length = 20)
    private String rol;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Voluntarioscentro getIdVoluntario() {
        return idVoluntario;
    }

    public String getVoluntarioid() {
        return idVoluntario.getDNIVoluntario();
    }

    public void setIdVoluntario(Voluntarioscentro idVoluntario) {
        this.idVoluntario = idVoluntario;
    }


    public void setIdVoluntarioString(String dni) {
        Voluntarioscentro voluntario = new Voluntarioscentro();
        voluntario.setDNIVoluntario(dni);
        this.idVoluntario = voluntario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}