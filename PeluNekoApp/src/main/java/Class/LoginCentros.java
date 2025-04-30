package Class;

public class LoginCentros {
    private String dniVoluntario;
    private String passwordVoluntario;
    private String RolVoluntario;

    public LoginCentros(String dniVoluntario, String passwordVoluntario, String rolVoluntario) {
        this.dniVoluntario = dniVoluntario;
        this.passwordVoluntario = passwordVoluntario;
        RolVoluntario = rolVoluntario;
    }

    public String getDniVoluntario() {
        return dniVoluntario;
    }

    public void setDniVoluntario(String dniVoluntario) {
        this.dniVoluntario = dniVoluntario;
    }

    public String getPasswordVoluntario() {
        return passwordVoluntario;
    }

    public void setPasswordVoluntario(String passwordVoluntario) {
        this.passwordVoluntario = passwordVoluntario;
    }

    public String getRolVoluntario() {
        return RolVoluntario;
    }

    public void setRolVoluntario(String rolVoluntario) {
        RolVoluntario = rolVoluntario;
    }
}
