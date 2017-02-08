/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2_ej2;

/**
 *
 * @author santi
 */
class Articulo {

    private String marca;
    private String referencia;
    private String talla;
    private double costeBasico;
    private double costePorMenor;
    private double costePorMayor;

    public Articulo(String marca, String referencia, String talla, double costeBasico) {
        this.marca = marca;
        this.referencia = referencia;
        this.talla = talla;
        this.costeBasico = costeBasico;
        this.costePorMenor = calcularPrecio(1.21);
        this.costePorMayor = calcularPrecio(1.08);

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public double getCosteBasico() {
        return costeBasico;
    }

    public void setCosteBasico(double costeBasico) {
        this.costeBasico = costeBasico;
    }

    public double getCostePorMenor() {
        return costePorMenor;
    }

    public void setCostePorMenor(double costePorMenor) {
        this.costePorMenor = costePorMenor;
    }

    public double getCostePorMayor() {
        return costePorMayor;
    }

    public void setCostePorMayor(double costePorMayor) {
        this.costePorMayor = costePorMayor;
    }

    @Override
    public String toString() {
        //referencia - marca (talla): coste: EUR coste
        return referencia + " - " + marca + " (" + talla + "): " + costeBasico + "EUR";
    }

    public String toStringPorMayor() {
        //referencia - marca (talla): coste: EUR coste
        return referencia + " - " + marca + " (" + talla + "): " + costePorMayor + "EUR";
    }

    public String toStringPorMenor() {
        //referencia - marca (talla): coste: EUR coste
        return referencia + " - " + marca + " (" + talla + "): " + costePorMenor + "EUR";
    }

    private double calcularPrecio(double iva) {
        return this.costeBasico * iva;
    }
}
