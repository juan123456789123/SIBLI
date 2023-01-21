/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class Potencia {
    int base,exponente,resultado;

    public Potencia() {
        this.base=0;
        this.exponente=0;
        this.resultado=0;
    }

    public Potencia(int base, int exponente, int resultado) {
        this.base = base;
        this.exponente = exponente;
        this.resultado = resultado;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Potencia{" + "base=" + base + ", exponente=" + exponente + ", resultado=" + resultado + '}';
    }
}
