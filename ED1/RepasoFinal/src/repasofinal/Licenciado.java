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
public class Licenciado extends Itamita{
    private String Carrera ;//Que carrera estudia

    public Licenciado(String Carrera, int CU, double beca) {
        super(CU, beca);
        this.Carrera = Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getCarrera() {
        return Carrera;
    }

    @Override
    public String toString() {
        return "Licenciado{" + "Carrera=" + Carrera + '}';
    }

}
