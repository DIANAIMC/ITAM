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
public class Mantequilla extends ProductoLacteo{
    private boolean conSal;

    public Mantequilla() {
    }

    public Mantequilla(boolean conSal, String marca, double precio, double presentacion, int mesVencimiento) {
        super(marca, precio, presentacion, mesVencimiento);
        this.conSal = conSal;
    }

    public boolean isConSal() {
        return conSal;
    }

    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        cadena.append(super.toString() + "\nMantequilla ");
        if (conSal)
            cadena.append("con sal\n");
        else
            cadena.append("sin sal\n");
        return  cadena.toString();
    }
}

