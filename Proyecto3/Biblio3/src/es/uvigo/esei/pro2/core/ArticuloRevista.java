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

    public void toDOM() {
        Element ref = new Element("referencia");

        Element tituloRevistaNode = new Element(this.tituloRevista);
        Element doiNode = new Element(this.doi);
        Element volumenNode = new Element(Integer.toString(volumen));
        Element numeroNode = new Element(Integer.toString(numero));
        Element paginaInicioNode = new Element(Integer.toString(paginaInicio));
        Element paginaFinNode = new Element(Integer.toString(paginaFin));

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

        this.toDOM(ref);

    }

}
