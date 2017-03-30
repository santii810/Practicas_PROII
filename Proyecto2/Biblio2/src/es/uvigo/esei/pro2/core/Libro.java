/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author santi
 */
public class Libro extends Referencia {

    private String Editorial;
    private String isbn;
    private TipoFormato formato;

    public enum TipoFormato {
        PAPEL, EBOOK
    };

    public Libro(String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
    }

    public Libro(String Editorial, String isbn, TipoFormato formato, String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
        this.Editorial = Editorial;
        this.isbn = isbn;
        this.formato = formato;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public TipoFormato getFormato() {
        return formato;
    }

    public void setFormato(TipoFormato formato) {
        this.formato = formato;
    }

}
