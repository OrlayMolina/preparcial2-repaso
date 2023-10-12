package uniquindio.preparcial2.model;

public class Estudiante {

    private String codigo;
    private String nombre;
    private String notas;

    public Estudiante(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return codigo + "--" + codigo + "--" + nombre
                + "--" + notas;
    }
}
