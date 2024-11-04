package dominio;

/**
 * @author tonym
 */
public class Persona {

    private int id_persona;
    private String nombre;

    public Persona(int id_persona) {
        this.id_persona = id_persona;

    }
     public Persona(int id_persona, String nombre) {
        this.id_persona = id_persona;
        this.nombre = nombre;

    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }


    public Persona() {
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nombre=" + nombre + '}';
    }

}
