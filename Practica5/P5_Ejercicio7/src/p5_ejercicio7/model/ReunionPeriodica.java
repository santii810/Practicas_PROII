/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ejercicio7.model;

/**
 *
 * @author Santi
 */
public class ReunionPeriodica extends Reunion {

    private Periodicidad periodicidad;

    public enum Periodicidad {
        DIARIA, SEMANAL, MENSUAL, ANUAL
    };

    public ReunionPeriodica(Periodicidad periodicidad, Hora hora, Fecha fecha) {
        super(hora, fecha);
        this.periodicidad = periodicidad;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

}
