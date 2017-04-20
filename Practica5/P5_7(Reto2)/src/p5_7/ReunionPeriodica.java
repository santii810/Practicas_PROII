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
public class ReunionPeriodica extends Reunion{
    public static enum Frecuencia {SEMANAL, MENSUAL, TRIMESTRAL};
    private Frecuencia frec;
    
    public ReunionPeriodica(Hora hora, Fecha fecha, String asunto, Frecuencia frec) {
        super(hora, fecha, asunto);
        this.frec = frec;
    }
    
    public ReunionPeriodica (int hora, int min, int dia, int mes, int año, String asunto, Frecuencia frec){
        //super(hora,min,dia,mes,año, asunto);
        super( new Hora(hora,min), new Fecha(dia,mes,año),asunto);
        this.frec=frec;
    }

    public Frecuencia getFrec() {
        return frec;
    }

    public void setFrec(Frecuencia frec) {
        this.frec = frec;
    }
    @Override
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        toret.append(super.toString());
        toret.append("\n");
        toret.append("Frecuencia de la reunion: ");
        toret.append(getFrec());
        
        return toret.toString();
    }
}
