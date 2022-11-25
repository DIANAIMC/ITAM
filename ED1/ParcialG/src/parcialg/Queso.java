/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialg;

/**
 *
 * @author dianam
 */
public class Queso extends ProductoLacteo{
    private String tipo;

    public Queso() {
    }

    public Queso(String tipo, String marca, double precio, double presentacion, int mesVencimiento) {
        super(marca, precio, presentacion, mesVencimiento);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nQueso " + "tipo= " + tipo;
    }
}

