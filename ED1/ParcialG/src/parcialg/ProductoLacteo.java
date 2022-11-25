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
public class ProductoLacteo {
    private String marca;
    private double precio;
    private double presentacion; // Dada en gramos
    private int mesVencimiento; // 1-enero, 2-febrero, etc.

    public ProductoLacteo() {
    }

    public ProductoLacteo(String marca, double precio, double presentacion, int mesVencimiento) {
        this.marca = marca;
        this.precio = precio;
        this.presentacion = presentacion;
        this.mesVencimiento = mesVencimiento;
    }
    
    

    public int getMesVencimiento() {
        return mesVencimiento;
    }
    
    public double getPresentación() {
        return presentacion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
    
    

    @Override
    public String toString() {
        return "\n Marca= " + marca + ", precio= " + precio + ", presentación= " + presentacion + ", mes de vencimiento= " + mesVencimiento;
    }   
}

