/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5_ejercicio7.Exceptions;

/**
 *
 * @author Santi
 */
public class IncorrectHourFormatException extends Exception {

    public IncorrectHourFormatException(String formato_de_minutos_incorrecto) {
        super(formato_de_minutos_incorrecto);
    }

}
