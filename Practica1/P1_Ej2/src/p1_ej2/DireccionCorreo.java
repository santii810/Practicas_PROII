/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_ej2;

/**
 *
 * @author santi
 */
public class DireccionCorreo {

    private static final String DEFAULT_SERVER = "esei.uvigo.es";
    private String nombre;
    private String apellido;
    private String usuario;
    private String servidor;

    public DireccionCorreo(String nombre, String apellido, String usuario, String servidor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.servidor = servidor;
    }

    public DireccionCorreo(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        //this.usuario = apellido + nombre.substring(0, 1);
        this.usuario = apellido + nombre.charAt(0);
        this.servidor = DEFAULT_SERVER;
    }

    @Override
    public String toString() {
        return "DireccionCorreo{" + "nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario + ", servidor=" + servidor + '}';
    }

}
