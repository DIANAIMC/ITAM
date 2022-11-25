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
public class Yogurt extends ProductoLacteo{
    private int ingredAdicionales;  // 1- cereal, 2- chocolate, 3- miel

    public Yogurt() {
    }

    public Yogurt(int ingredAdicionales, String marca, double precio, double presentacion, int mesVencimiento) {
        super(marca, precio, presentacion, mesVencimiento);
        this.ingredAdicionales = ingredAdicionales;
    }

    public int getIngredAdicionales() {
        return ingredAdicionales;
    }

    @Override
    public String toString() {
        return super.toString() + "\nYogurt con " + ingredAdicionales + " ingredientes adicionales";
    }
    
}