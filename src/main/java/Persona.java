public class Persona {
    private String nombre, rut;

    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    @Override
    public String toString() {
        return "\nPersona " +
                "\nNombre: " + nombre +
                "\nRut:" + rut;
    }
}