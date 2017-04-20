/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_7;

/**
 *
 * @author Soumase
 */
public class Fecha {
    //public static enum Meses {ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE};
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public static String firstLetterCaps ( String data ){
      String firstLetter = data.substring(0,1).toUpperCase();
      String restLetters = data.substring(1).toLowerCase();
      return firstLetter + restLetters;
    }
    
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        toret.append(getDia());
        toret.append(" de ");
        toret.append(getMes());
        toret.append(" de ");
        toret.append(getAño());
        
        return toret.toString();
    }
}
