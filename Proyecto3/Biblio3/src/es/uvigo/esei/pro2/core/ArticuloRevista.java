/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

import nu.xom.Element;

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
    private static final String ARTICULO_REVISTA_TAG = "articuloRevista";

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
        Element ref = new Element(ARTICULO_REVISTA_TAG);

        Element tituloRevistaNode = new Element(TITULO_REVISTA_TAG);
        Element doiNode = new Element(DOI_TAG);
        Element volumenNode = new Element(VOLUMEN_TAG);
        Element numeroNode = new Element(NUMERO_TAG);
        Element paginaInicioNode = new Element(PAGINA_INICIO_TAG);
        Element paginaFinNode = new Element(PAGINA_FIN_TAG);

        tituloRevistaNode.appendChild(new Element(this.tituloRevista));
        doiNode.appendChild(new Element(this.doi));
        volumenNode.appendChild(new Element(Integer.toString(volumen)));
        numeroNode.appendChild(new Element(Integer.toString(numero)));
        paginaInicioNode.appendChild(new Element(Integer.toString(paginaInicio)));
        paginaFinNode.appendChild(new Element(Integer.toString(paginaFin)));

        ref.appendChild(tituloRevistaNode);
        ref.appendChild(doiNode);
        ref.appendChild(volumenNode);
        ref.appendChild(numeroNode);
        ref.appendChild(paginaInicioNode);
        ref.appendChild(paginaFinNode);

        return ref;
    }

}
