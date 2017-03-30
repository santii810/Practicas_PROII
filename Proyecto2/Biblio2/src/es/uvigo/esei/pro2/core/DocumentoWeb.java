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
public class DocumentoWeb extends Referencia {

    private String url;
    private Fecha fechaConsulta;

    public DocumentoWeb(String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
    }

    public DocumentoWeb(String url, Fecha fechaConsulta, String autores, String titulo, int ano, TipoReferencia tipo) {
        super(autores, titulo, ano, tipo);
        this.url = url;
        this.fechaConsulta = fechaConsulta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Fecha getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Fecha fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

}
