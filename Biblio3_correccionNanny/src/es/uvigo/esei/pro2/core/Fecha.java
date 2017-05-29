/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uvigo.esei.pro2.core;

import nu.xom.Element;
import nu.xom.Node;
import nu.xom.ParsingException;

/**
 *
 * @author Nani
 */
public class Fecha {

    private int dia;
    private int mes;
    private int anho;

    public Fecha(int dia, int mes, int anho) {
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

     public Fecha(Element e) throws ParsingException {        
        Element eltoDia = e.getFirstChildElement(DIA_TAG);
        if (eltoDia == null){
            throw new ParsingException ("Falta dia");
        }
        this.dia = Integer.parseInt(eltoDia.getValue());   

        Element eltoMes = e.getFirstChildElement(MES_TAG);
        if (eltoMes == null){
            throw new ParsingException ("Falta mes");
        }
        this.mes = Integer.parseInt(eltoMes.getValue());    

        Element eltoAnho = e.getFirstChildElement(ANO_TAG);
        if (eltoAnho == null){
            throw new ParsingException ("Falta año");
        }
        this.anho = Integer.parseInt(eltoAnho.getValue());        
    }
     
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();

        toret.append(getDia());
        toret.append("/");
        toret.append(getMes());
        toret.append("/");
        toret.append(getAnho());

        return toret.toString();
    }

    public Element toDOM() {
        Element fecha = new Element(FECHA_TAG);
        Element diaNode = new Element(DIA_TAG);
        Element mesNode = new Element(MES_TAG);
        Element anoNode = new Element(ANO_TAG);

        diaNode.appendChild(Integer.toString(dia));
        mesNode.appendChild(Integer.toString(mes));
        anoNode.appendChild(Integer.toString(anho));

        fecha.appendChild(diaNode);
        fecha.appendChild(mesNode);
        fecha.appendChild(anoNode);

        return fecha;
    }
    private static final String ANO_TAG = "ano";
    private static final String MES_TAG = "mes";
    private static final String DIA_TAG = "dia";
    public static final String FECHA_TAG = "fecha";

}
