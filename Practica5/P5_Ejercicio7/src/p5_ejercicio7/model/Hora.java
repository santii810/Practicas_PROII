/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ejercicio7.model;

import p5_ejercicio7.Exceptions.IncorrectHourFormatException;

/**
 *
 * @author Santi
 */
public class Hora {

    private int minutos;
    private int horas;

    public Hora(int minutos, int horas) throws IncorrectHourFormatException {
        setMinutos(minutos);
        setHoras(horas);
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) throws IncorrectHourFormatException {
        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
        } else {
            throw new IncorrectHourFormatException("Formato de minutos incorrecto");
        }
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) throws IncorrectHourFormatException {
        if (horas >= 0 && horas < 24) {
            this.horas = horas;
        } else {
            throw new IncorrectHourFormatException("Formato de horas incorrecto");
        }
    }

}
