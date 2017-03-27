/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author santi
 */
public class Universidad {

    private String nombre;
    private Persona[] personas;
    private int numPersonas;

    public Universidad(String nombre, int maxPersonas) {
        this.nombre = nombre;
        personas = new Persona[maxPersonas];
        numPersonas = 0;
    }

    public void insertar(Persona per) throws DemasiadasPersonasException {
        if (numPersonas >= personas.length) {
            throw new DemasiadasPersonasException("Numero de personas sobrepasado");
        }
        this.personas[numPersonas] = per;
        numPersonas++;
    }

    @Override
    public String toString() {

        StringBuilder toret = new StringBuilder("Nombre: ");
        toret.append(nombre);
        for (int i = 0; i < numPersonas; i++) {
            toret.append(personas[i]);
            toret.append("\n");
        }
        return toret.toString();
    }

}
