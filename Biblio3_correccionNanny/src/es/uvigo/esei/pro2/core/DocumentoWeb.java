/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

import static es.uvigo.esei.pro2.core.Referencia.ANO_TAG;
import static es.uvigo.esei.pro2.core.Referencia.AUTORES_TAG;
import static es.uvigo.esei.pro2.core.Referencia.TITULO_TAG;
import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Nani
 */
public class DocumentoWeb extends Referencia {

    private String url;
    private Fecha fechaConsulta;

    private static final String URL_TAG = "url";
    public static final String DOCUMENTO_WEB_TAG = "documentoWeb";

    public DocumentoWeb(String url, Fecha fechaConsulta,
            String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.url = url;
        this.fechaConsulta = fechaConsulta;
    }
    
    //TODO borrar esto
    public DocumentoWeb(String url,
            //Fecha fechaConsulta,
            String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.url = url;
        this.fechaConsulta = fechaConsulta;
    }

    public DocumentoWeb(Element e) throws ParsingException {
        super(e);
        
        Element eltoUrl = e.getFirstChildElement(URL_TAG);
        if (eltoUrl == null){
            throw new ParsingException ("Falta URL");
        }
        this.url = eltoUrl.getValue();   

        Element eltoFecha = e.getFirstChildElement(Fecha.FECHA_TAG);
        if (eltoFecha == null){
            throw new ParsingException ("Falta fecha consulta");
        }
        this.fechaConsulta = new Fecha (eltoFecha);                 
    }

    public String getUrl() {
        return url;
    }

    public Fecha getFechaConsulta() {
        return fechaConsulta;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setFechaConsulta(Fecha fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Referencia Documento Web.\n");
        toret.append(super.toString());
        toret.append("\tUrl: ");
        toret.append(getUrl());
        toret.append("\tFecha Consulta: ");
        toret.append(getFechaConsulta().toString());

        return toret.toString();
    }

    public Element toDOM() {
        Element ref = super.toDOM();
        ref.setLocalName(DOCUMENTO_WEB_TAG);

        Element urlNode = new Element(URL_TAG);
        urlNode.appendChild(this.url);

        ref.appendChild(urlNode);
        ref.appendChild(fechaConsulta.toDOM());
        return ref;

    }

}
