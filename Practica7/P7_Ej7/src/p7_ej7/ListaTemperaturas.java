/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author santi
 */
class ListaTemperaturas {

    HashMap<String, Double> mapa;

    public ListaTemperaturas() {
        mapa = new HashMap<>();

    }

    public void inserta(String c, double t) {
        mapa.put(c, t);
    }

    public double get(String c) {
        return mapa.get(c);
    }

    public List<String> getCiudades() {
        return  new ArrayList(mapa.keySet());
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (Object object : mapa.keySet()) {
            toret.append(object.toString());
            toret.append("\t");
            toret.append(object.toString());
            toret.append("\n");
        }
        toret.append("\n");
        return toret.toString();
    }
}
