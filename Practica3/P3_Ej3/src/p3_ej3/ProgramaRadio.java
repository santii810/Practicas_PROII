/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3_ej3;

import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Escribe un programa que cree la clase ProgramaRadio. En esta clase se
 * guardarán los atributos acerca de la hora de emisión, el número de minutos de
 * duración, el titulo y el nombre del locutor. Una vez creado, un programa de
 * radio no se cambia. La aplicación asume que la radio emite durante 24 horas,
 * desde las 0h. La duración mínima de un programa es de sesenta minutos (debe
 * lanzarse una excepción cuando se intente introducir una duración más
 * pequeña).
 *
 * Así, continuará pidiendo programas hasta que se cumplan o se superen las 24
 * horas (utilícese la clase LocalTime y su método plusMinutes(); para crear un
 * nuevo objeto LocalTime, LocalTime.of(h, m); la duración de todos los
 * programas no puede exceder los 1440 minutos). Nótese que el programa
 * solamente debe pedir título, locutor y duración de cada programa. Al final,
 * el programa listará los programas de radio al completo, con toda la
 * información.
 *
 *
 * @author santi
 */
public class ProgramaRadio {

    private LocalTime horaEmision;
    private int duracion;
    private String titulo;
    private String nombreLocutor;

    public ProgramaRadio(LocalTime horaEmision, int duracion, String titulo, String nombreLocutor) {
        try {
            this.horaEmision = horaEmision;
            setDuracion(duracion);
            this.titulo = titulo;
            this.nombreLocutor = nombreLocutor;
        } catch (Exception ex) {
            System.err.println("Duracion del programa inferior a 1h, se ha asignado duracion = 60 min");
        }
    }

    public LocalTime getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(LocalTime horaEmision) {
        this.horaEmision = horaEmision;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) throws Exception {
        if (duracion < 60) {
            throw new Exception("Duracion menor a 60 minutos");
        }
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreLocutor() {
        return nombreLocutor;
    }

    public void setNombreLocutor(String nombreLocutor) {
        this.nombreLocutor = nombreLocutor;
    }

    @Override
    public String toString() {
        return "ProgramaRadio{" + "horaEmision=" + horaEmision + ", duracion=" + duracion + ", titulo=" + titulo + ", nombreLocutor=" + nombreLocutor + '}';
    }

    
}
