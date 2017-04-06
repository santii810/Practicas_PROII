/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ejercicio7.model;

import p5_ejercicio7.Exceptions.IncorrectDateFormatException;

/**
 *
 * @author Santi
 */
public class Fecha {

    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) throws IncorrectDateFormatException {
        setDia(dia);
        setMes(mes);
        setAno(ano);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) throws IncorrectDateFormatException {
        if (dia > 0 && dia < 32) {
            this.dia = dia;
        } else {
            throw new IncorrectDateFormatException("Numero de dia incorrecto");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) throws IncorrectDateFormatException {
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        } else {
            throw new IncorrectDateFormatException("Numero de mes incorrecto");
        }

    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) throws IncorrectDateFormatException {
        if (ano > 2000 && ano < 2100) {
            this.ano = ano;
        } else {
            throw new IncorrectDateFormatException("Numero de año incorrecto");
        }
    }

}
