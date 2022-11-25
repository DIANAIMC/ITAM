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
public abstract class Itamita {
    private int CU; //clave unica
    private double beca; //porcentaje de beca

    public Itamita(int CU, double beca) {
        this.CU = CU;
        this.beca = beca;
    }

    public int getCU() {
        return CU;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Itamita other = (Itamita) obj;
        if (this.CU != other.CU) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itamita{" + "CU=" + CU + ", beca=" + beca + '}';
    }

    public double getBeca() {
        return beca;
    }

    public void setBeca(double beca) {
        this.beca = beca;
    }
    
    
}
