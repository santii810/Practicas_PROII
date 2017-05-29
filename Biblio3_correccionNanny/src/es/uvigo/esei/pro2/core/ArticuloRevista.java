/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.ParsingException;

/**
 *
 * @author Nani
 */
public class ArticuloRevista extends Referencia {

    private String tituloRevista;
    private String doi;
    private int volumen;
    private int numero;
    private int paginaInicio;
    private int paginaFin;

    private static final String PAGINA_FIN_TAG = "paginaFin";
    private static final String PAGINA_INICIO_TAG = "paginaInicio";
    private static final String NUMERO_TAG = "numero";
    private static final String VOLUMEN_TAG = "volumen";
    private static final String DOI_TAG = "doi";
    private static final String TITULO_REVISTA_TAG = "tituloRevista";
    public static final String ARTICULO_REVISTA_TAG = "articuloRevista";

    public ArticuloRevista(String tituloRevista, String doi, int volumen,
            int numero, int paginaInicio, int paginaFin,
            String autores, String titulo, int ano) {
        super(autores, titulo, ano);
        this.tituloRevista = tituloRevista;
        this.doi = doi;
        this.volumen = volumen;
        this.numero = numero;
        this.paginaInicio = paginaInicio;
        this.paginaFin = paginaFin;
    }

    public ArticuloRevista(Element e) throws ParsingException {
        super(e);
        
        Element eltoTituloRevista = e.getFirstChildElement(TITULO_REVISTA_TAG);
        if (eltoTituloRevista == null){
            throw new ParsingException ("Falta titulo revista");
        }
        this.tituloRevista = eltoTituloRevista.getValue();       
        
        Element eltoDoi = e.getFirstChildElement(DOI_TAG);
        if (eltoDoi == null){
            throw new ParsingException ("Falta DOI");
        }
        this.doi = eltoDoi.getValue();

        Element eltoVolumen = e.getFirstChildElement(VOLUMEN_TAG);
        if (eltoVolumen == null){
            throw new ParsingException ("Falta volumen");
        }
        this.volumen = Integer.parseInt(eltoVolumen.getValue());
 
        Element eltoNumero = e.getFirstChildElement(NUMERO_TAG);
        if (eltoNumero == null){
            throw new ParsingException ("Falta numero");
        }
        this.numero = Integer.parseInt(eltoNumero.getValue());

        Element eltoPagInicio = e.getFirstChildElement(PAGINA_INICIO_TAG);
        if (eltoPagInicio == null){
            throw new ParsingException ("Falta pagina inicio");
        }
        this.paginaInicio = Integer.parseInt(eltoPagInicio.getValue());
        
        Element eltoPagFin = e.getFirstChildElement(PAGINA_FIN_TAG);
        if (eltoPagFin == null){
            throw new ParsingException ("Falta pagina fin");
        }
        this.paginaFin = Integer.parseInt(eltoPagFin.getValue());                        
    }

    public String getTituloRevista() {
        return tituloRevista;
    }

    public String getDoi() {
        return doi;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getNumero() {
        return numero;
    }

    public int getPaginaInicio() {
        return paginaInicio;
    }

    public int getPaginaFin() {
        return paginaFin;
    }

    public void setTituloRevista(String tituloRevista) {
        this.tituloRevista = tituloRevista;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }

    public void setPaginaFin(int paginaFin) {
        this.paginaFin = paginaFin;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append("Referencia Articulo Revista.\n");
        toret.append(super.toString());
        toret.append("\tTitulo revista: ");
        toret.append(getTituloRevista());
        toret.append("\tVolumen: ");
        toret.append(getVolumen());
        toret.append("\tNumero: ");
        toret.append(getNumero());
        toret.append("\tPaginas: ");
        toret.append(getPaginaInicio() + " - " + getPaginaFin());
        toret.append("\tDOI: ");
        toret.append(getDoi());

        return toret.toString();
    }

    public Element toDOM() {
        Element ref = super.toDOM();

        ref.setLocalName(ARTICULO_REVISTA_TAG);

        Element tituloRevistaNode = new Element(TITULO_REVISTA_TAG);
        Element doiNode = new Element(DOI_TAG);
        Element volumenNode = new Element(VOLUMEN_TAG);
        Element numeroNode = new Element(NUMERO_TAG);
        Element paginaInicioNode = new Element(PAGINA_INICIO_TAG);
        Element paginaFinNode = new Element(PAGINA_FIN_TAG);

        tituloRevistaNode.appendChild(this.tituloRevista);
        doiNode.appendChild(this.doi);
        volumenNode.appendChild(Integer.toString(volumen));
        numeroNode.appendChild(Integer.toString(numero));
        paginaInicioNode.appendChild(Integer.toString(paginaInicio));
        paginaFinNode.appendChild(Integer.toString(paginaFin));

        ref.appendChild(tituloRevistaNode);
        ref.appendChild(doiNode);
        ref.appendChild(volumenNode);
        ref.appendChild(numeroNode);
        ref.appendChild(paginaInicioNode);
        ref.appendChild(paginaFinNode);

        return ref;
    }

}
