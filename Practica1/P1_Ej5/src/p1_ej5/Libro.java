/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_ej5;

/**
 *
 * @author santi
 */
public class Libro {
    private String titulo;
    private String autores;
    private String editorial;
    private int añoEdicion;
    private String isbn;

    public Libro(String titulo, String autores, String editorial, int añoEdicion, String isbn) {
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.añoEdicion = añoEdicion;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAñoEdicion() {
        return añoEdicion;
    }

    public void setAñoEdicion(int añoEdicion) {
        this.añoEdicion = añoEdicion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + "\n autores=" + autores + "\n editorial=" + editorial + "\n añoEdicion=" + añoEdicion + "n isbn=" + isbn + '}';
    }
    
    
}
