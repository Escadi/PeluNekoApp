package Class;

public class NuevosDuenos {
    private String dniPropietario;
    private String nombrePropietario;
    private String apellido1Propietario;
    private String apellido2Propietario;
    private String direccionPropietario;
    private String localidadPropietario;
    private String codigoPostalPropietario;

    public NuevosDuenos(String dniPropietario, String nombrePropietario, String apellido1Propietario, String apellido2Propietario, String direccionPropietario, String localidadPropietario, String codigoPostalPropietario) {
        this.dniPropietario = dniPropietario;
        this.nombrePropietario = nombrePropietario;
        this.apellido1Propietario = apellido1Propietario;
        this.apellido2Propietario = apellido2Propietario;
        this.direccionPropietario = direccionPropietario;
        this.localidadPropietario = localidadPropietario;
        this.codigoPostalPropietario = codigoPostalPropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellido1Propietario() {
        return apellido1Propietario;
    }

    public void setApellido1Propietario(String apellido1Propietario) {
        this.apellido1Propietario = apellido1Propietario;
    }

    public String getApellido2Propietario() {
        return apellido2Propietario;
    }

    public void setApellido2Propietario(String apellido2Propietario) {
        this.apellido2Propietario = apellido2Propietario;
    }

    public String getDireccionPropietario() {
        return direccionPropietario;
    }

    public void setDireccionPropietario(String direccionPropietario) {
        this.direccionPropietario = direccionPropietario;
    }

    public String getLocalidadPropietario() {
        return localidadPropietario;
    }

    public void setLocalidadPropietario(String localidadPropietario) {
        this.localidadPropietario = localidadPropietario;
    }

    public String getCodigoPostalPropietario() {
        return codigoPostalPropietario;
    }

    public void setCodigoPostalPropietario(String codigoPostalPropietario) {
        this.codigoPostalPropietario = codigoPostalPropietario;
    }
}
