/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej4;

/**
 *
 * Un polinomio se representa como sigue x^3 + 2x^2 + 5x + 9 = 0, y es muy
 * sencillo de almacenar teniendo en cuenta que solamente es necesario recordar,
 * para cada elemento, la constante por la que se multiplica (el coeficiente), y
 * el factor al que elevar (el grado). Así, en el caso anterior, los pares (1,
 * 3), (2, 2), (5, 1) y (9, 0) representarían el polinomio x^3 + 2x^2 + 5x + 9 =
 * 0. Crea la clase Polinomio empleando las siguientes estrategias:
 *
 * a) Utiliza dos vectores paralelos. En el primer vector, almacenarás el
 * coeficiente, mientras en el segundo almacenarás el grado. Para construir el
 * polinomio, dado el elemento n, tomarás el coeficiente de coeficientes[ n ]
 * (llamémosle c), y el grado de grados[ n ] (llamémosle g), con lo que el
 * elemento n será cx^g.
 *
 * b) En realidad, los grados podrían ser simplemente la posición en un solo
 * vector. Así, para un elemento n del polinomio, el coeficiente sería
 * coeficientes[ n ] (llamémosle c) y el grado el propio valor de n. Así,
 * resultaría en cx^n. Nótese que aquellas posiciones del vector en las que no
 * existe un elemento correspondiente en el polinomio estarían a 0. Así, para
 * x^3 + 9, el vector sería [1, 0, 0, 9].
 *
 * c) Por último, podrías crear, además de la clase Polinomio, la clase
 * Elemento, y que esta última guardase el coeficiente y el grado. Así, el
 * polinomio sería un vector de objetos de la clase Elemento
 *
 *
 * @author Santi
 */
public class P2_Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Elemento[] elementos;

        Elemento el1 = new Elemento(4, 4);
        Elemento el2 = new Elemento(4, 3);
        Elemento el3 = new Elemento(4, 2);
        Elemento el4 = new Elemento(4, 1);
        Elemento el5 = new Elemento(4, 0);

        elementos = new Elemento[]{el1, el2, el3, el4, el5};
        Polinomio poli = new Polinomio(elementos);
        System.out.println(poli.toString());

    }

}
