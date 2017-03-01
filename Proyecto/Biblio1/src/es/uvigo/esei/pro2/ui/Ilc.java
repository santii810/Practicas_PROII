package es.uvigo.esei.pro2.ui;

import es.uvigo.esei.pro2.core.Bibliografia;
import es.uvigo.esei.pro2.core.Referencia;

import java.util.Scanner;

/**
 * Interfaz de lin. de comando
 */
public class Ilc {

    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int op;

        // Lee el num. max. de referencias
        int maxReferencias = leeNum("Num. max. referencias: ");

        // Prepara
        Bibliografia coleccion = new Bibliografia(maxReferencias + 1);

        // Bucle ppal
        do {
            System.out.println("\nGestión bibliográfica");

            op = menu(coleccion);

            switch (op) {
                case 0:
                    System.out.println("Fin.");
                    break;
                case 1:
//                    ejemplos:
//                    coleccion.inserta(new Referencia("a", "a", 1));
//                    coleccion.inserta(new Referencia("b", "a", 1));
//                    coleccion.inserta(new Referencia("c", "a", 1));
//                    coleccion.inserta(new Referencia("d", "a", 1));
//                    coleccion.inserta(new Referencia("e", "a", 1));

                    insertaReferencia(coleccion);
                    break;
                case 2:
                    modificaReferencia(coleccion);
                    break;
                case 3:
                    eliminaReferencia(coleccion);
                    break;
                case 4:
                    visualiza(coleccion);
                    break;
                default:
                    System.out.println("No es correcta esa opción ( " + op + " )");
            }
        } while (op != 0);

    }

    /**
     * Lee un num. de teclado
     *
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    private int leeNum(String msg) {
        boolean repite;
        int toret = 0;
        Scanner teclado = new Scanner(System.in);

        do {
            repite = false;
            System.out.print(msg);

            try {
                toret = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException exc) {
                repite = true;
            } catch (Exception ex){
                repite = true;
            }
        } while (repite);

        return toret;
    }

    /**
     * Presenta un menu con las opciones, y permite seleccionar una.
     *
     * @return la opcion seleccionada, como entero
     */
    private int menu(Bibliografia coleccion) {
        int toret;
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Actualmente hay ");
        toPrint.append(coleccion.getNumReferencias());
        toPrint.append(" referencias de ");
        toPrint.append(coleccion.getMaxReferencias());
        toPrint.append("\n1. Inserta nueva referencia\n");
        toPrint.append("2. Modifica referencia\n");
        toPrint.append("3. Elimina referencia\n");
        toPrint.append("4. Listar referencias\n");
        toPrint.append("0. Salir\n");
        do {
            try {
                
            System.out.println(toPrint);
            toret = leeNum("Selecciona: ");
            } catch (Exception e) {
                toret = -1;
            }
        } while (toret < 0
                && toret > 4);

        System.out.println();
        return toret;
    }

    private int menu() {
        int toret;
        StringBuilder toPrint = new StringBuilder();
        toPrint.append("\n1. Inserta nueva referencia\n");
        toPrint.append("2. Modifica referencia\n");
        toPrint.append("3. Elimina referencia\n");
        toPrint.append("4. Listar referencias\n");
        toPrint.append("0. Salir\n");

        do {
            System.out.println(toPrint.toString());
            toret = leeNum("Selecciona: ");
        } while (toret < 0
                && toret > 4);

        System.out.println();
        return toret;
    }

    /**
     * Crea una nueva referencia y la inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta la referencia.
     */
    private void insertaReferencia(Bibliografia coleccion) {
        Referencia r = new Referencia("", "", 0);

        modificaReferencia(r);
        coleccion.inserta(r);
    }

    /**
     * Borra una referencia por su num.
     *
     * @param coleccion La coleccion en el que se elimina la referencia
     */
    private void eliminaReferencia(Bibliografia coleccion) {
        if (coleccion.getNumReferencias() > 0) {
            coleccion.elimina(leeNumReferencia(coleccion));
        } else {
            System.out.println("La coleccion no contiene referencias.");
        }
    }

    /**
     * Modifica una referencia existente.
     *
     * @param coleccion La coleccion de la cual modificar una referencia.
     */
    private void modificaReferencia(Bibliografia coleccion) {
        if (coleccion.getNumReferencias() > 0) {
            this.modificaReferencia(coleccion.get(leeNumReferencia(coleccion)));
        } else {
            System.out.println("La coleccion no contiene referencias.");
        }
    }

    private void modificaReferencia(Referencia r) {
        String info;
        char tipoReferencia;
        Scanner teclado = new Scanner(System.in);

        // Autores
        System.out.print("Autores de la referencia ");
        if (r.getAutores().length() > 0) {
            System.out.print("[" + r.getAutores() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setAutores(info);
        }

        // Titulo
        System.out.print("Titulo de la referencia ");
        if (r.getTitulo().length() > 0) {
            System.out.print("[" + r.getTitulo() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setTitulo(info);
        }

        // Año
        System.out.print("Año de la referencia ");
        if (r.getAno() > 0) {
            System.out.print("[" + r.getAno() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setAno(Integer.parseInt(info));
        }

        // Tipo de referencia
        System.out.println("La referencia es: " + r.getTipo());

        do {
            tipoReferencia = leeCaracter("Introduce el tipo de referencia (L: libro, A: artículo revista, D: documento web): ");
        } while ((tipoReferencia != 'L') && (tipoReferencia != 'A') && (tipoReferencia != 'D'));

        switch (tipoReferencia) {
            case 'L':
                r.setTipo(Referencia.Tiporeferencia.LIBRO.toString());
                break;
            case 'A':
                r.setTipo(Referencia.Tiporeferencia.ARTICULOREVISTA.toString());
                break;
            case 'D':
                r.setTipo(Referencia.Tiporeferencia.DOCUMNETOWEB.toString());
                break;
        }

    }

    /**
     * Lee del teclado un nuevo num. de referencia
     *
     * @param coleccion La colección de la que se obtiene el max.
     * @return el num. de referencias, como entero.
     */
    private int leeNumReferencia(Bibliografia coleccion) {
        final int numReferencias = coleccion.getNumReferencias();
        int toret;

        do {
            toret = leeNum("Introduzca num. de referencia (1..." + numReferencias + "): ");
        } while (toret < 1
                || toret > numReferencias);

        return toret - 1;
    }

    /**
     * Lee un caracter del teclado
     *
     * @param men Mensaje a visualizar
     * @return el caracter introducido por el usuario
     */
    private char leeCaracter(String men) {
        Scanner teclado = new Scanner(System.in);

        System.out.print(men);
        return (teclado.nextLine().trim().charAt(0));
    }

    /**
     * Visualiza las referencias almacenadas en la coleccion por la salida std.
     *
     * @param coleccion El objeto Bibliografia del que visualizar sus
     * referencias.
     */
    private void visualiza(Bibliografia coleccion) {
        final int numReferencias = coleccion.getNumReferencias();
        String cadena = "";
        if (numReferencias > 0) {
            cadena = coleccion.toString(coleccion);
            System.out.println(cadena);
        } else {
            System.out.println("No hay referencias.");
        }

    }
}
