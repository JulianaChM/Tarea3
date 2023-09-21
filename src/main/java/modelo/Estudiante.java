package modelo;

public class Estudiante {

    // Atributos de la clase Estudiante
    private String id;
    private String nombre;
    private String apellido;

    public Estudiante(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
