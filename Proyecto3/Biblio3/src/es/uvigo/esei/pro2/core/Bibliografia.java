/*  Definición de la clase Bibliografia
 *  Una bibliografia esta compuesta de referencias bibliograficas
 */
package es.uvigo.esei.pro2.core;

import es.uvigo.esei.pro2.exceptions.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 *
 * @author nrufino
 */
public class Bibliografia {

    private final static String RAIZ_TAG = "raiz";

    private ArrayList<Referencia> referencias;
    private int maxReferencias;

    /**
     * Nueva Coleccion con un num. max. de referencias.
     *
     * @param maxReferencias el num. max. de referencias, como entero.
     */
    public Bibliografia(int maxReferencias) {
        this.maxReferencias = maxReferencias;
        referencias = new ArrayList<>();
    }

    /**
     * Devuelve la referencia en pos
     *
     * @param pos el lugar de la referencia en el vector de referencias
     * @return el objeto Referencia correspondiente.
     */
    public Referencia get(int pos) throws PosicionInexistenteBibliografiaException {
        if (pos >= getNumReferencias()) {
            throw new PosicionInexistenteBibliografiaException("get(): sobrepasa la pos: "
                    + (pos + 1) + " / " + getMaxReferencias());
        }

        return referencias.get(pos);
    }

    /**
     * Devuelve el num. de referencias creadas.
     *
     * @return el num. de referencias disponibles, como entero.
     */
    public int getNumReferencias() {
        return referencias.size();
    }

    /**
     * Devuelve el max. de numReferenciass
     *
     * @return el num. de referencias max,, como entero
     */
    public int getMaxReferencias() {
        return maxReferencias;
    }

    /**
     * Inserta una nueva referencia
     *
     * @param r el nuevo objeto Referencia
     */
//    public void inserta(Referencia r) throws DemasiadasReferenciasBibliografiaException {
//        final int maxReferencias = getMaxReferencias();
//
//        if (getNumReferencias() >= maxReferencias) {
//            throw new DemasiadasReferenciasBibliografiaException("inserta(): sobrepasa max.: " + getMaxReferencias());
//        }
//
//        referencias[this.maxReferencias] = r;
//        ++this.maxReferencias;
//    }
    public void inserta(Referencia r) {
        referencias.add(r);
    }

    /**
     * Elimina una referencia
     *
     * @param pos el lugar de la referencia en el vector de referencias
     */
    public void elimina(int pos) throws PosicionInexistenteBibliografiaException {
        if (pos >= getNumReferencias()) {
            throw new PosicionInexistenteBibliografiaException("elimina(): sobrepasa el número de referencias : "
                    + getNumReferencias());
        }
        referencias.remove(pos);
    }

    /**
     * Devuelve el contenido de todas las Referenciass
     *
     * @return el String con el contenido
     */
    public String toString() {
        StringBuilder toret;
        final int numReferencias = getNumReferencias();

        toret = new StringBuilder();
        if (numReferencias > 0) {
            for (int i = 0; i < numReferencias; i++) {
                toret.append((i + 1) + ". ");
                toret.append(referencias.get(i) + "\n");
            }
        } else {
            toret.append("No hay referencias.");
        }

        return toret.toString();
    }

    public String listarPorTipo(char t) throws PosicionInexistenteBibliografiaException {
        final int numReferencias = getNumReferencias();
        StringBuilder toret = new StringBuilder();
        Referencia r;

        if (numReferencias > 0) {
            for (int i = 0; i < numReferencias; i++) {
                r = get(i);
                switch (t) {
                    case 'L':
                        if (r instanceof Libro) {
                            toret.append(r.toString() + "\n");
                        }
                        break;
                    case 'A':
                        if (r instanceof ArticuloRevista) {
                            toret.append(r.toString() + "\n");
                        }
                        break;
                    case 'D':
                        if (r instanceof DocumentoWeb) {
                            toret.append(r.toString() + "\n");
                        }
                        break;
                }
            }
        } else {
            toret.append("No hay referencias.");
        }

        if (toret.length() == 0) {
            toret.append("No hay referencias de ese tipo.");
        }

        return toret.toString();
    }

    public void toXML(String nombreArchivo) throws IOException {
        Element raiz = new Element(RAIZ_TAG);

        for (Referencia referencia : referencias) {
            raiz.appendChild(referencia.toDOM());
        }

        // Escribir en un archivo
        FileOutputStream f = new FileOutputStream(nombreArchivo);
        Document doc = new Document(raiz);
        Serializer serial = new Serializer(f);
        serial.write(doc);
        f.close();
    }

}
