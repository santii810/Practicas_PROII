/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p7_ej6;

import java.util.HashMap;

/**
 *
 * @author santi
 */
public class Diccionario<K, V> {

    private K k;
    private V v;
    private HashMap map;

    public Diccionario(K k, V v) {
        this.k = k;
        this.v = v;
        map = new HashMap();
    }

    public V get(K k) {
        return (V) map.get(k);
    }

    public void put(K k, V v) {
        map.put(k, v);
    }

    public void clear(K k) {
        map.remove(k);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder toret = new StringBuilder();
        for (Object object : map.keySet()) {
            toret.append(object.toString());
        }
        return toret.toString();
    }

}
