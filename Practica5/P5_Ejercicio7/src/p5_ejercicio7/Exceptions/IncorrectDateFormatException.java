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
public class IncorrectDateFormatException extends Exception {

    public IncorrectDateFormatException(String numero_de_dia_incorrecto) {
        super(numero_de_dia_incorrecto);
    }

}
