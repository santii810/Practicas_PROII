/*  Definición de la clase Bibliografia
 *  Una bibliografia esta compuesta de referencias bibliograficas
 */
package es.uvigo.esei.pro2.core;

/**
 *
 * @author nrufino
 */
public class Bibliografia {

    private Referencia[] referencias;
    private int numReferencias;

    /**
     * Nueva Coleccion con un num. max. de referencias.
     *
     * @param maxReferencias el num. max. de referencias, como entero.
     */
    public Bibliografia(int maxReferencias) {
        numReferencias = 0;
        referencias = new Referencia[maxReferencias];
    }

    /**
     * Devuelve la referencia en pos
     *
     * @param pos el lugar de la referencia en el vector de referencias
     * @return el objeto Referencia correspondiente.
     */
    public Referencia get(int pos) {
        if (pos >= getNumReferencias()) {
            System.err.println("get(): sobrepasa la pos: " + (pos + 1) + " / " + getMaxReferencias());
            System.exit(-1);
        }

        return referencias[pos];
    }

    /**
     * Devuelve el num. de referencias creadas.
     *
     * @return el num. de referencias disponibles, como entero.
     */
    public int getNumReferencias() {
        return numReferencias;
    }

    /**
     * Devuelve el max. de numReferenciass
     *
     * @return el num. de referencias max,, como entero
     */
    public int getMaxReferencias() {
        return referencias.length - 1;
    }

    /**
     * Inserta una nueva referencia
     *
     * @param r el nuevo objeto Referencia
     */
    public void inserta(Referencia r) {
        final int maxReferencias = getMaxReferencias();

        if (getNumReferencias() >= maxReferencias) {
            System.err.println("inserta(): sobrepasa max.: " + maxReferencias);
            System.exit(-1);
        }

        referencias[numReferencias] = r;
        ++numReferencias;
    }

    public void elimina(int pos) {
        for (int i = pos; i < referencias.length-1; i++) {
            this.referencias[i] = this.referencias[i+1];
        }
        this.referencias[referencias.length-1] = new Referencia("", "", 0);
//        
//        
//        
//        int cont = 0;
//        for (int i = 0; i < referencias.length; i++) {
//
//            if (pos == i) {
//                for (int j = pos; j < referencias.length; j++) {
//                    if (j != referencias.length - 1) {
//                        if (referencias[j + 1] == null && cont == 0) {
//                            referencias[j].setAno(0);
//                            referencias[j].setAutores("");
//                            referencias[j].setTipo("");
//                            referencias[j].setTitulo("");
//                            cont++;
//                        } else {
//                            if (cont == 0) {
//                                referencias[j].setAno(referencias[j + 1].getAno());
//                                referencias[j].setAutores(referencias[j + 1].getAutores());
//                                referencias[j].setTipo(referencias[j + 1].getTipo());
//                                referencias[j].setTitulo(referencias[j + 1].getTitulo());
//                            }
//
//                        }
//                    }
//
//                }
//            }
//        }
//        System.out.println("a");
    }

    public String toString(Bibliografia coleccion) {
        StringBuilder toprint = new StringBuilder("");
        for (int i = 0; i < numReferencias; i++) {
            System.out.println(i);
            toprint.append(coleccion.get(i).toString());
        }
        return toprint.toString();
    }

}
