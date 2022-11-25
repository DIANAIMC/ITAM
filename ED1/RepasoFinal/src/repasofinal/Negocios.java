/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasofinal;

/**
 *
 * @author dianam
 */
public class Negocios extends Ingeniero{
    private boolean trabajo; //Tiene trabajo o no

    public Negocios(boolean trabajo, boolean conjunta, int CU, double beca) {
        super(conjunta, CU, beca);
        this.trabajo = trabajo;
    }

    public boolean isTrabajo() {
        return trabajo;
    }

    @Override
    public String toString() {
        return "Negocios{" + "trabajo=" + trabajo + '}';
    }
    
    
}
