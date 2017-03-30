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
public class ArticuloRevista extends Referencia {

    private String tipoRevista;
    private String doi;
    private int volumen;
    private int numero;
    private int paginaInicio;
    private int paginaFin;

    public ArticuloRevista(String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
    }

    public ArticuloRevista(String tipoRevista, String doi, int volumen, int numero, int paginaInicio, int paginaFin, String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
        this.tipoRevista = tipoRevista;
        this.doi = doi;
        this.volumen = volumen;
        this.numero = numero;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
    }

    public String getTipoRevista() {
        return tipoRevista;
    }

    public void setTipoRevista(String tipoRevista) {
        this.tipoRevista = tipoRevista;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPaginaInicio() {
        return paginaInicio;
    }

    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public int getPaginaFin() {
        return paginaFin;
    }

    public void setPaginaFin(int paginaFin) {
        this.paginaFin = paginaFin;
    }

}
