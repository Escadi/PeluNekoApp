package Class;

public class VoluntariosCentro {
    private String dniVoluntario;
    private String nombreVoluntario;
    private String apellido1Voluntario;
    private String apellido2Voluntario;
    private String direccionVoluntario;
    private String localidadVoluntario;
    private String codigoPostalVoluntario;


    public VoluntariosCentro(String dniVoluntario, String nombreVoluntario, String apellido1Voluntario, String apellido2Voluntario, String direccionVoluntario, String localidadVoluntario, String codigoPostalVoluntario) {
        this.dniVoluntario = dniVoluntario;
        this.nombreVoluntario = nombreVoluntario;
        this.apellido1Voluntario = apellido1Voluntario;
        this.apellido2Voluntario = apellido2Voluntario;
        this.direccionVoluntario = direccionVoluntario;
        this.localidadVoluntario = localidadVoluntario;
        this.codigoPostalVoluntario = codigoPostalVoluntario;
    }

    public String getDniVoluntario() {
        return dniVoluntario;
    }

    public void setDniVoluntario(String dniVoluntario) {
        this.dniVoluntario = dniVoluntario;
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
}
