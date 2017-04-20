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
public class Reunion {
    private Hora hora;
    private Fecha fecha;
    private String asunto;
    
    public Reunion(Hora hora, Fecha fecha, String asunto) {
        this.hora = hora;
        this.fecha = fecha;
        this.asunto = asunto;
    }
    
    public Reunion(int hora, int min, int dia, int mes, int año, String asunto){
        fecha= new Fecha(dia, mes, año);
        this.hora=new Hora(hora,min);
        this.asunto = asunto;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        
        toret.append("Reunión");
        toret.append("\n");
        toret.append("Hora: ");
        toret.append(getHora());
        toret.append(", ");
        toret.append("Fecha: ");
        toret.append(getFecha());
        toret.append("\n");
        toret.append("Motivo de reunión: ");
        toret.append(getAsunto());
        
        return toret.toString();
    }
}
