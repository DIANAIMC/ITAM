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
public class CamionVolteo extends Camión {
    
    private double capTon;
    
    public CamionVolteo( String m, String nm, String p,  double ct){
        super(m, nm, p);
        capTon=ct;
        
    }
    
    public double getCapTon(){
        return capTon;
    }
    
    public void setCapTon(double ct){
        capTon=ct;
    }
    
    public String toString(){
         StringBuilder sb=new StringBuilder("");
         sb.append(super.toString()+" Capacidad de toneladas: "+capTon);
         return sb.toString();
         
     }
    
    
}
