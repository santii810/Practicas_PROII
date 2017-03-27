// Definicion de la clase Referencia
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Referencia {

    public static enum TipoReferencia {
        LIBRO, ARTICULOREVISTA, DOCUMENTOWEB
    };
    private String autores;
    private String titulo;
    private int ano;
    private TipoReferencia tipo;

    /**
     * Crea una nueva referencia, con sus autores, título y año
     *
     * @param autores los nombres de los autores de la referencia
     * @param titulo el título de la referencia
     * @param ano el ano de la referencia
     */
    public Referencia(String autores, String titulo, int ano, TipoReferencia tipo) {
        this.setAutores(autores);
        this.setTitulo(titulo);
        this.setAno(ano);
        this.setTipo(tipo);
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

    /**
     * Devuelve el valor del tipo de referencia
     *
     * @return El valor como TipoReferencia
     */
    public TipoReferencia getTipo() {
        return tipo;
    }

    /**
     * Cambia la etiqueta de la referencia
     *
     * @param tipo El nuevo valor, como TipoReferencia
     */
    public void setTipo(TipoReferencia tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append(getAutores() + " ; ");
        toret.append(getTitulo() + " ; ");
        toret.append(getAno() + " ; ");
        toret.append(getTipo().toString() + "\n");

        return toret.toString();
    }
}
