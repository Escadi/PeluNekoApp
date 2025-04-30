package Class;

public class Animales {
    private int idAnimal;
    private String tipoAnimal;
    private double pesoAnimal;
    private String estadoAnimal;
    private String imagenAnimal;
    private String razaAnimal;
    private String dniVoluntario;

    public Animales(int idAnimal, String tipoAnimal, double pesoAnimal, String estadoAnimal, String imagenAnimal, String razaAnimal, String dniVoluntario) {
        this.idAnimal = idAnimal;
        this.tipoAnimal = tipoAnimal;
        this.pesoAnimal = pesoAnimal;
        this.estadoAnimal = estadoAnimal;
        this.imagenAnimal = imagenAnimal;
        this.razaAnimal = razaAnimal;
        this.dniVoluntario = dniVoluntario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public String getEstadoAnimal() {
        return estadoAnimal;
    }

    public void setEstadoAnimal(String estadoAnimal) {
        this.estadoAnimal = estadoAnimal;
    }

    public String getImagenAnimal() {
        return imagenAnimal;
    }

    public void setImagenAnimal(String imagenAnimal) {
        this.imagenAnimal = imagenAnimal;
    }

    public String getRazaAnimal() {
        return razaAnimal;
    }

    public void setRazaAnimal(String razaAnimal) {
        this.razaAnimal = razaAnimal;
    }

    public String getDniVoluntario() {
        return dniVoluntario;
    }

    public void setDniVoluntario(String dniVoluntario) {
        this.dniVoluntario = dniVoluntario;
    }
}
