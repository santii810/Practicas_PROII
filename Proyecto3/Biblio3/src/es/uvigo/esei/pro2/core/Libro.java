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
import nu.xom.ParsingException;
import nu.xom.Serializer;

/**
 *
 * @author Nani
 */
public class Libro extends Referencia {

    public Libro(Element elemento) throws ParsingException{
        super(elemento);
        
        this.editorial = elemento.getAttributeValue(EDITORIAL_TAG);
        this.isbn = elemento.getAttributeValue(ISBN_TAG);

    }

    public static enum tipoFormato {
        ELECTRONICO, PAPEL
    };
    private String editorial;
    private String isbn;
    private tipoFormato formato;

    /**
     * XML tags
     */
    private static final String ISBN_TAG = "isbn";
    private static final String FORMATO_TAG = "formato";
    private static final String EDITORIAL_TAG = "editorial";
    private static final String LIBRO_TAG = "libro";

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

    public Element toDOM() {
        Element ref = new Element(LIBRO_TAG);

        Element editorialNode = new Element(EDITORIAL_TAG);
        editorialNode.appendChild(this.editorial);
        Element isbnNode = new Element(ISBN_TAG);
        isbnNode.appendChild(this.isbn);
        Element formatoNode = new Element(FORMATO_TAG);
        formatoNode.appendChild(this.formato.name());

        // Crear el documento
        ref.appendChild(editorialNode);
        ref.appendChild(isbnNode);
        ref.appendChild(formatoNode);

        return ref;

    }

}
