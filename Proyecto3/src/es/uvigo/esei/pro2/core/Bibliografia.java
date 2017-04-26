/*  Definición de la clase Bibliografia
 *  Una bibliografia esta compuesta de referencias bibliograficas
 */
package es.uvigo.esei.pro2.core;

import java.util.ArrayList;

/**
 *
 * @author nrufino
 */
public class Bibliografia {

    public static class BibliografiaException extends Exception {

        public BibliografiaException(String msg) {
            super(msg);
        }
    }

    public static class DemasiadasReferenciasBibliografiaException extends BibliografiaException {

        public DemasiadasReferenciasBibliografiaException(String msg) {
            super(msg);
        }

    }

    public static class PosicionInexistenteBibliografiaException extends BibliografiaException {

        public PosicionInexistenteBibliografiaException(String msg) {
            super(msg);
        }

    }

    private ArrayList<Referencia> referencias;
    private int maxReferencias;

    /**
     * Nueva Coleccion con un num. max. de referencias.
     *
     * @param maxReferencias el num. max. de referencias, como entero.
     */
    public Bibliografia(int maxReferencias) {
        this.maxReferencias = 0;
        referencias = new ArrayList<>();
    }

    /**
     * Devuelve la referencia en pos
     *
     * @param pos el lugar de la referencia en el vector de referencias
     * @return el objeto Referencia correspondiente.
     */
    public Referencia get(int pos) throws PosicionInexistenteBibliografiaException {

        return referencias.get(pos);
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
    public void inserta(Referencia r) throws DemasiadasReferenciasBibliografiaException {
        final int maxReferencias = getMaxReferencias();

        referencias.add(r);
        ++this.maxReferencias;
    }

    /**
     * Elimina una referencia
     *
     * @param pos el lugar de la referencia en el vector de referencias
     */
    public void elimina(int pos) throws PosicionInexistenteBibliografiaException {
        referencias.remove(pos);
    }

    /**
     * Devuelve el contenido de todas las Referenciass
     *
     * @return el String con el contenido
     */
    public String toString() {
        StringBuilder toret;

        toret = new StringBuilder();
        for (Referencia referencia : referencias) {
            toret.append(referencia.toString() + "\n");
        }

        return toret.toString();
    }

    public String listarPorTipo(char t) throws PosicionInexistenteBibliografiaException {
        StringBuilder toret = new StringBuilder();

        if (referencias.size() > 0) {
            for (Referencia r : referencias) {

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

        if (toret.length()
                == 0) {
            toret.append("No hay referencias de ese tipo.");
        }

        return toret.toString();
    }
}
