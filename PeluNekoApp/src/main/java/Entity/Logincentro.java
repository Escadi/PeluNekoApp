package Entity;

import javax.persistence.*;

@Entity
@Table(name = "logincentros")
public class Logincentro {
    @Id
    @Column(name = "idVoluntario", nullable = false, length = 15)
    private String idVoluntario;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idVoluntario", nullable = false)
    private Voluntarioscentro voluntarioscentro;

    @Column(name = "Passwd", nullable = false, length = 100)
    private String passwd;

    @Column(name = "Rol", nullable = false, length = 20)
    private String rol;
    public Logincentro() {
    }
    public Logincentro(String idVoluntario, Voluntarioscentro voluntarioscentro, String passwd, String rol) {
        this.idVoluntario = idVoluntario;
        this.voluntarioscentro = voluntarioscentro;
        this.passwd = passwd;
        this.rol = rol;
    }

    public String getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(String idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Voluntarioscentro getVoluntarioscentro() {
        return voluntarioscentro;
    }

    public void setVoluntarioscentro(Voluntarioscentro voluntarioscentro) {
        this.voluntarioscentro = voluntarioscentro;
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