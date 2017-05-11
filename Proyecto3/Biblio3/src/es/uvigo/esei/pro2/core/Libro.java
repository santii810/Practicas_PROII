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
    public static final String LIBRO_TAG = "libro";

    public Libro(String editorial, String isbn, tipoFormato formato, String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.editorial = editorial;
        this.isbn = isbn;
        this.formato = formato;
    }

    public Libro(String editorial, String isbn, String formato, String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.editorial = editorial;
        this.isbn = isbn;
        this.formato = getEnumValue(titulo);
    }

    public Libro(Element e) throws ParsingException {
        this(
                e.getFirstChildElement(EDITORIAL_TAG).getValue(),
                e.getFirstChildElement(ISBN_TAG).getValue(),
                e.getFirstChildElement(FORMATO_TAG).getValue(),
                e.getFirstChildElement(AUTORES_TAG).getValue(),
                e.getFirstChildElement(TITULO_TAG).getValue(),
                Integer.parseInt(e.getFirstChildElement(ANO_TAG).getValue())
        );

        if (e.getFirstChildElement(EDITORIAL_TAG) == null
                || e.getFirstChildElement(ISBN_TAG) != null
                || e.getFirstChildElement(FORMATO_TAG) == null
                || e.getFirstChildElement(AUTORES_TAG) == null
                || e.getFirstChildElement(TITULO_TAG) == null
                || e.getFirstChildElement(ANO_TAG) == null) {
            throw new ParsingException("XML incorrecto");

        }
    }

    private tipoFormato getEnumValue(String value) {
        tipoFormato toret = null;
        switch (value.toLowerCase()) {
            case "electronico":
                toret = tipoFormato.ELECTRONICO;
                break;
            case "papel":
                toret = tipoFormato.PAPEL;
                break;
        }
        return toret;
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
        Element ref = super.toDOM();

        ref.setLocalName(LIBRO_TAG);

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
