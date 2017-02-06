/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1_ej1;

/**
 *
 * @author santi
 */
public class Punto {

    private int x;
    private int y;
    private double distancia;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        calcularDistancia();
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + ", distancia=" + distancia + '}';
    }

    private void calcularDistancia() {
        this.distancia = Math.sqrt((double) Math.pow(x, 2) + Math.pow(y, 2));
    }

}
