package DataSave;

public class SessionLogin {
    public static String dniVoluntario;
    public static boolean rol;


    public static String getDniVoluntario() {
        return dniVoluntario;
    }

    public static void setDniVoluntario(String dniVoluntario) {
        SessionLogin.dniVoluntario = dniVoluntario;
    }

    public static String setDni(String dniVoluntario) {
        SessionLogin.dniVoluntario = dniVoluntario;
        return dniVoluntario;
    }

}
