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
public class Computacion extends Ingeniero{
    private char especialidad; //I - IA, D - desarrollo, C - datasicence

    public Computacion(char especialidad, boolean conjunta, int CU, double beca) {
        super(conjunta, CU, beca);
        this.especialidad = especialidad;
    }

    public char getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(char especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Computacion{" + "especialidad=" + especialidad + '}';
    }
    
    
}

