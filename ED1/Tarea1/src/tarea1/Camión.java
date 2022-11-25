/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 */
public class Camión {
    
    private String marca;
    private String numMotor;
    private String placas;
    
    
    public Camión (String m, String nm, String p){
        marca=m;
        numMotor=nm;
        placas=p;
        
    }
    
    public String getMarca(){
        return marca;
    }
    public String getnumMotor(){
        return numMotor;
    }
    public String getPlacas(){
        return placas;
    }
    
    
    public String toString(){
        StringBuilder sb=new StringBuilder(" ");
        sb.append("Marca: "+marca+" Número de motor: "+numMotor+" CPlacas: "+placas);
        return sb.toString();
        
    }

  
}
