/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej2;

/**
 * Los artículos de una tienda tienen una marca, una referencia, una talla y un
 * coste básico, al que se le calcula el 21% para obtener el precio con IVA al
 * por menor, y el 8% para obtener el precio al por mayor. Los artículos se
 * expresan como "referencia - marca (talla): coste: EUR coste". Será necesario
 * un método calculaPrecioFinal(iva) al que se le pueda pasar el porcentaje de
 * IVA adecuado. Existirán métodos que devuelvan esta información (por ejemplo,
 * toStringPorMayor() y toStringPorMenor()), mientras que el método toString()
 * estándar devolverá la información al por menor.
 *
 * @author santi
 */
public class P2_Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Articulo art = new Articulo("Tomy", "0004563hs", "M", 120);
        System.out.println(   art.toString());
        System.out.println(   art.toStringPorMenor());
        System.out.println(   art.toStringPorMayor());

    }

}
