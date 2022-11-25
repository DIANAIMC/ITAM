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
public abstract class Ingeniero extends Itamita{
    private boolean conjunta; //tiene o no carrera conjunta

    public Ingeniero(boolean conjunta, int CU, double beca) {
        super(CU, beca);
        this.conjunta = conjunta;
    }

    public boolean isConjunta() {
        return conjunta;
    }

    public void setConjunta(boolean conjunta) {
        this.conjunta = conjunta;
    }

    @Override
    public String toString() {
        return "Ingeniero{" + "conjunta=" + conjunta + '}';
    }
    
    
}
