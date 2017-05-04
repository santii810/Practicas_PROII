package es.uvigo.esei.pro2.ui;

import es.uvigo.esei.pro2.core.Bibliografia;
import es.uvigo.esei.pro2.core.Libro;
import es.uvigo.esei.pro2.core.Referencia;
import es.uvigo.esei.pro2.core.Libro;
import es.uvigo.esei.pro2.core.ArticuloRevista;
import es.uvigo.esei.pro2.core.DocumentoWeb;
import es.uvigo.esei.pro2.core.Fecha;
import es.uvigo.esei.pro2.exceptions.*;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;

/**
 * Interfaz de lin. de comando
 */
public class Ilc {

    private static final String NOMBRE_ARCHIVO = "referencias.xml";

    /**
     * Realiza el reparto de la funcionalidad ler = lee, evalua, repite
     */
    public void ler() {
        int op;

        // Lee el num. max. de referencias
        int maxReferencias = leeNum("Num. max. referencias: ");

        // Prepara
//        Bibliografia coleccion = new Bibliografia(maxReferencias);
        Bibliografia coleccion = leerXML(maxReferencias);

        // Bucle ppal
        do {
            System.out.println("\nGestión bibliográfica");

            op = menu(coleccion);

            try {
                switch (op) {
                    case 0:
                        //Guarda xml antes de salir
                        coleccion.toXML(NOMBRE_ARCHIVO);
                        System.out.println("Fin.");
                        break;
                    case 1:
                        insertaReferencia(coleccion);
                        break;
                    case 2:
                        modificaReferencia(coleccion);
                        break;
                    case 3:
                        eliminaReferencia(coleccion);
                        break;
                    case 4:
                        System.out.println(coleccion.toString());
                        break;
                    case 5:
                        System.out.println(coleccion.listarPorTipo(leeTipoReferencia()));
                        break;
                    default:
                        System.out.println("No es correcta esa opción ( "
                                + op + " )");
                }
            } catch (DemasiadasReferenciasBibliografiaException e) {
                System.err.println("\nERROR: " + e.getMessage());
            } catch (PosicionInexistenteBibliografiaException e) {
                System.err.println("\nERROR: " + e.getMessage());
            } catch (NumberFormatException exc) {
                System.err.println("\nError. Formato numérico inválido.");
            } catch (Exception e) {
                System.err.println("\nERROR inesperado: " + e.getMessage());
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

        do {
            System.out.println("Número de referencias bibliográficas: "
                    + coleccion.getNumReferencias()
                    + " / " + coleccion.getMaxReferencias());
            System.out.println(
                    "\n1. Inserta nueva referencia\n"
                    + "2. Modifica referencia\n"
                    + "3. Elimina referencia\n"
                    + "4. Listar referencias\n"
                    + "5. Listar referencias por tipo\n"
                    + "0. Salir\n"
            );
            toret = leeNum("Selecciona: ");
        } while (toret < 0
                && toret > 5);

        System.out.println();
        return toret;
    }

    /**
     * Crea una nueva referencia y la inserta en la coleccion
     *
     * @param coleccion La coleccion en la que se inserta la referencia.
     */
    private void insertaReferencia(Bibliografia coleccion) throws DemasiadasReferenciasBibliografiaException {
        char tipoFor;
        Referencia r = new ArticuloRevista("", "", 0, 0, 0, 0, "", "", 0);
        Fecha fe = new Fecha(0, 0, 0);

        switch (leeTipoReferencia()) {
            case 'L':
                r = new Libro("", "", Libro.tipoFormato.ELECTRONICO, "", "", 0);
                break;
            case 'A':
                r = new ArticuloRevista("", "", 0, 0, 0, 0, "", "", 0);
                break;
            case 'D':
                r = new DocumentoWeb("", fe, "", "", 0);
                break;
        }

        modificaReferencia(r);
        coleccion.inserta(r);
    }

    /**
     * Borra una referencia por su num.
     *
     * @param coleccion La coleccion en el que se elimina la referencia
     */
    private void eliminaReferencia(Bibliografia coleccion) throws PosicionInexistenteBibliografiaException {
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
    private void modificaReferencia(Bibliografia coleccion) throws PosicionInexistenteBibliografiaException {
        if (coleccion.getNumReferencias() > 0) {
            this.modificaReferencia(coleccion.get(leeNumReferencia(coleccion)));
        } else {
            System.out.println("La coleccion no contiene referencias.");
        }
    }

    /**
     * Obtiene los datos de una referencia.
     *
     * @param r La referencia a modificar.
     */
    private void modificaReferencia(Referencia r) {
        modificaReferenciaBasica(r);
        if (r instanceof Libro) {
            Libro l = (Libro) r;
            modificaLibro(l);
        } else if (r instanceof ArticuloRevista) {
            ArticuloRevista a = (ArticuloRevista) r;
            modificaArticuloRevista(a);
        } else if (r instanceof DocumentoWeb) {
            DocumentoWeb d = (DocumentoWeb) r;
            modificaDocumentoWeb(d);
        }

    }

    /**
     * Modifica los datos comunes a cualquier tipo de referencia de una
     * referencia.
     *
     * @param r La referencia a modificar.
     */
    private void modificaReferenciaBasica(Referencia r) {
        String info;
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

        // Ano
        System.out.print("Ano de la referencia ");
        if (r.getAno() > 0) {
            System.out.print("[" + r.getAno() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            r.setAno(Integer.parseInt(info));
        }
    }

    /**
     * Modifica los datos propios de una referencia de tipo Libro.
     *
     * @param l La referencia a modificar.
     */
    private void modificaLibro(Libro l) {
        String info;
        Scanner teclado = new Scanner(System.in);

        // Editorial
        System.out.print("Editorial del libro");
        if (l.getEditorial().length() > 0) {
            System.out.print("[" + l.getEditorial() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            l.setEditorial(info);
        }

        // ISBN
        System.out.print("ISBN del libro");
        if (l.getIsbn().length() > 0) {
            System.out.print("[" + l.getIsbn() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            l.setIsbn(info);
        }

        // Formato libro (papel o electrónico)
        switch (leeTipoFormatoLibro()) {
            case 'P':
                l.setFormato(Libro.tipoFormato.PAPEL);
                break;
            case 'E':
                l.setFormato(Libro.tipoFormato.ELECTRONICO);
                break;
        }
    }

    /**
     * Modifica los datos propios de una referencia de tipo ArticuloRevista.
     *
     * @param a La referencia a modificar.
     */
    private void modificaArticuloRevista(ArticuloRevista a) {
        String info;
        Scanner teclado = new Scanner(System.in);

        // titulo de revista
        System.out.print("Titulo de revista");
        if (a.getTituloRevista().length() > 0) {
            System.out.print("[" + a.getTituloRevista() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setTituloRevista(info);
        }

        // DOI
        System.out.print("DOI");
        if (a.getDoi().length() > 0) {
            System.out.print("[" + a.getDoi() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setDoi(info);
        }

        // Volumen
        System.out.print("Volumen");
        if (a.getVolumen() > 0) {
            System.out.print("[" + a.getVolumen() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setVolumen(Integer.parseInt(info));
        }

        // Numero
        System.out.print("Numero");
        if (a.getNumero() > 0) {
            System.out.print("[" + a.getNumero() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setNumero(Integer.parseInt(info));
        }

        // pagina de inicio
        System.out.print("Pagina de inicio");
        if (a.getPaginaInicio() > 0) {
            System.out.print("[" + a.getPaginaInicio() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setPaginaInicio(Integer.parseInt(info));
        }

        // pagina de fin
        System.out.print("Pagina de fin");
        if (a.getPaginaFin() > 0) {
            System.out.print("[" + a.getPaginaFin() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            a.setPaginaFin(Integer.parseInt(info));
        }

    }

    /**
     * Modifica los datos propios de una referencia de tipo docuemento web.
     *
     * @param d La referencia a modificar.
     */
    private void modificaDocumentoWeb(DocumentoWeb d) {
        String info;
        Scanner teclado = new Scanner(System.in);
        Fecha feMod = new Fecha(0, 0, 0);

        // URL
        System.out.print("URL");
        if (d.getUrl().length() > 0) {
            System.out.print("[" + d.getUrl() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            d.setUrl(info);
        }

        // Fecha consulta
        // dia
        System.out.print("Dia");
        if (d.getFechaConsulta().getDia() > 0) {
            System.out.print("[" + d.getFechaConsulta().getDia() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            feMod.setDia(Integer.parseInt(info));
        }
        // mes
        System.out.print("Mes");
        if (d.getFechaConsulta().getMes() > 0) {
            System.out.print("[" + d.getFechaConsulta().getMes() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            feMod.setMes(Integer.parseInt(info));
        }
        // año
        System.out.print("Año");
        if (d.getFechaConsulta().getAnho() > 0) {
            System.out.print("[" + d.getFechaConsulta().getAnho() + "]");
        }
        System.out.print(": ");
        info = teclado.nextLine().trim();

        if (info.length() > 0) {
            feMod.setAnho(Integer.parseInt(info));
        }
        d.setFechaConsulta(feMod);
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

        toret = leeNum("Introduzca num. de referencia (1..." + numReferencias + "): ");

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

    private char leeTipoFormatoLibro() {
        char tipoFor;

        do {
            tipoFor = leeCaracter("De que tipo es el libro (P: Papel y E: Electrónico): ");
            tipoFor = String.valueOf(tipoFor).toUpperCase().charAt(0);
        } while ((tipoFor != 'P') && (tipoFor != 'E'));

        return tipoFor;
    }

    private char leeTipoReferencia() {
        char tipoRef;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.print("Introduce tipo de referencia (L: Libro, A: Articulo revista y D: Documento Web): ");
            tipoRef = entrada.nextLine().toUpperCase().trim().charAt(0);
        } while ((tipoRef != 'L') && (tipoRef != 'A') && (tipoRef != 'D'));

        return tipoRef;
    }

    private Bibliografia leerXML(int maxReferencias) throws ParsingException {
        Bibliografia coleccion = new Bibliografia(maxReferencias);
        Document doc = null;
// Leer el archivo XML
        try {
            Builder parser = new Builder();
            doc = parser.build(new File(NOMBRE_ARCHIVO));
        } catch (ParsingException ex) {
            System.err.println("ERROR en el formato XML: " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("ERROR de lectura del archivo" + ex.getMessage());
        }
// Leer los platos del DOM
        Elements elements = doc.getRootElement().getChildElements();

        for (int i = 0; i < elements.size(); i++) {
            Element elemento = elements.get(i);
            switch (elemento.getLocalName()) {
                case "libro":
                    coleccion.inserta(new Libro(elemento));
                    break;
                default:
            }
        }
        return coleccion;
    }
}
