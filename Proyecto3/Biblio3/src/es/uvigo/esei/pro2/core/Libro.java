/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

import java.io.FileOutputStream;
import java.io.IOException;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 *
 * @author Nani
 */
public class Libro extends Referencia {

    public static enum tipoFormato {
        ELECTRONICO, PAPEL
    };
    private String editorial;
    private String isbn;
    private tipoFormato formato;

    public Libro(String editorial, String isbn, tipoFormato formato, String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.editorial = editorial;
        this.isbn = isbn;
        this.formato = formato;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public tipoFormato getFormato() {
        return formato;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setFormato(tipoFormato formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Referencia Libro.\n");
        toret.append(super.toString());
        toret.append("\tEditorial: ");
        toret.append(getEditorial());
        toret.append("\tISBN: ");
        toret.append(getIsbn());
        toret.append("\tFormato: ");
        toret.append(getFormato());

        return toret.toString();
    }

    public void toDOM() {
        Element ref = new Element("referencia");

        Element editorial = new Element(this.editorial);
        Element isbn = new Element(this.isbn);
        Element formato = new Element(formato.name());

        // Crear el documento
        ref.appendChild(editorial);
        ref.appendChild(isbn);
        ref.appendChild(formato);

        this.toDOM(ref);

    }

}
