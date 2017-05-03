// Definicion de la clase Referencia
package es.uvigo.esei.pro2.core;

import java.io.FileOutputStream;
import java.io.IOException;
import nu.xom.*;

/**
 *
 * @author nrufino
 */
abstract public class Referencia {

    private String autores;
    private String titulo;
    private int ano;

    /**
     * Crea una nueva referencia, con sus autores, título y año
     *
     * @param autores los nombres de los autores de la referencia
     * @param titulo el título de la referencia
     * @param ano el ano de la referencia
     */
    public Referencia(String autores, String titulo, int ano) {
        this.setAutores(autores);
        this.setTitulo(titulo);
        this.setAno(ano);
    }

    /**
     * Devuelve el titulo de la referencia
     *
     * @return el titulo de la referencia, como String.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Cambia el titulo de la referencia
     *
     * @param t el titulo de la referencia
     */
    public void setTitulo(String t) {
        titulo = t.trim();
    }

    /**
     * Devuelve los autores de la referencia
     *
     * @return El valor como cadena
     *
     */
    public String getAutores() {
        return autores;
    }

    /**
     * Cambia los autores
     *
     * @param autores El nuevo valor, como cadena
     */
    public void setAutores(String autores) {
        this.autores = autores.trim();
    }

    /**
     * Devuelve el año de la referencia
     *
     * @return El valor como entero
     *
     */
    public int getAno() {
        return ano;
    }

    /**
     * Cambia el año
     *
     * @param ano El nuevo valor, como entero
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append(getAutores() + " ; ");
        toret.append(getTitulo() + " ; ");
        toret.append(getAno() + " ; ");

        return toret.toString();
    }

    public void toDOM(Element ref) {
        Element raiz = new Element("raiz");
      

        Element autores = new Element(this.autores);
        Element titulo = new Element(this.titulo);
        Element ano = new Element(Integer.toString(this.ano));

        // Crear el documento
        ref.appendChild(autores);
        ref.appendChild(titulo);
        ref.appendChild(ano);


        //añadir a raiz
        raiz.appendChild(ref);
        // Guardarlo
        Document doc = new Document(raiz);
        try {
            FileOutputStream f = new FileOutputStream("referencias.xml");
            Serializer serial = new Serializer(f);
            serial.write(doc);
            f.close();
            System.out.println("Referencia guardada");
        } catch (IOException exc) {
            System.err.println("ERROR de archivo: " + exc.getMessage());
        }
    }
}
