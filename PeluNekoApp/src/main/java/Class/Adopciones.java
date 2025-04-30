package Class;

public class Adopciones {

    private int idAnimal;
    private String dniPropietario;
    private String fechaAdopcion;

    public Adopciones(int idAnimal, String dniPropietario, String fechaAdopcion) {
        this.idAnimal = idAnimal;
        this.dniPropietario = dniPropietario;
        this.fechaAdopcion = fechaAdopcion;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }
}
