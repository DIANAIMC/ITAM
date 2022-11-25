/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2;

import java.util.ArrayList;

/**
 *
 * @author Diana Muñoz, Yuliana Padilla, Camila Fernández
 */
public class BaseDatosEstacionamiento {
    
    private String nombre;
    private CochesPermitidos cochesITAM[];
    private final int MAX=10;
    private static int cont;
    private StackADT fila;
    private ArrayList existe; //se almacenarán los carros que están en la pila

    
    public BaseDatosEstacionamiento(String nombre){
        
        this.nombre=nombre;
        cochesITAM=new CochesPermitidos [MAX];
        fila= new ArrayStackLimited<CochesPermitidos>(5);
        existe= new ArrayList<CochesPermitidos>();
        cont=0;
    }
    

    public String altaCoches(CochesPermitidos c){
  
        String res="Alta fallida del coche de "+c.getNombre();
        int n=0;
        boolean aux;
        if(!carroReal(c))
            res="El carro no se encontró en el ITAM";
        else{
            aux=existeCoche(c);
            if(cont <MAX && !aux){
                cochesITAM[cont]=c;
                cont++;
                res="Alta exitosa del coche de: "+c.getNombre();
            }
        }
        return res;
    }
    
    public boolean carroReal(CochesPermitidos c){
        int i=0;
        boolean res=true;
        if(c.getNombre() == (null))
            res=false;
        return res;
    }
    
    public String buscaCoche(CochesPermitidos c){
        int i=0;
        String res="No se econtró el carro registrado";
        while(i<cont && !c.equals(cochesITAM[i]))
            i++;
        if(cochesITAM[i].equals(c))
            res=cochesITAM[i].toString();
        return res;
    }
    
    public boolean existeCoche(CochesPermitidos c){
        int i=0;
        boolean res=false;
        while(i<cont && !c.equals(cochesITAM[i]))
            i++;
        if(i!=cont && cochesITAM[i].equals(c))
            res=true;
        return res;
    }
    
    
    public String insertaCoche(CochesPermitidos c){
        String res = "El coche no pudo ser ingresado";
        int i=0;
        boolean parametro;
        parametro = existeCoche(c);
        if(parametro && !((ArrayStackLimited)fila).isFull() && !existe.contains(c) ){
            fila.push(c);
            existe.add(c);
            res= "El carro de "+ c.getNombre() +" se metió a la fila exitosamente";
        }
        return res;
    }
    
    public String sacaCoche(CochesPermitidos c){
        int i=1;
        StringBuilder cad =new StringBuilder();
        StackADT auxiliar = new ArrayStackLimited<CochesPermitidos>(5);
        CochesPermitidos caux;
        if(!carroReal(c))
            cad.append("el carro no es del ITAM");
        if(existe.contains(c)){
            cad.append("El coche de "+c.getNombre()+" se sacó correctamente \n");
            while(!fila.peek().equals(c)){
                caux=(CochesPermitidos)(fila.pop());
                cad.append("El carro "+ i +" que se sacó fue "+ caux.toString() + "\n");
                auxiliar.push(caux);//vamos metiendo los carros en un auxiliar para después regresarlos
                i++;
            }
            i=1;
            fila.pop();
            //ahora vamos a regresar los carros a la fila en el orden en el que estaban
            while(!auxiliar.isEmpty()){
                caux=(CochesPermitidos)(auxiliar.pop());
                cad.append("El carro "+ i +" que se ingresó fue "+ caux.toString() + "\n");
                existe.remove(caux);
                fila.push(caux);
                i++;
            }
        }
        else
            cad.append("El coche deseado no se encuentra estacionado en la fila");
        return cad.toString();
       
    }
    
    
    
    
}
