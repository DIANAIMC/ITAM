/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EE;

import java.util.Iterator;
import Estructuras.EmptyCollectionException;

/**
 *
 * @author dianam
 * version Guardati
 */
public class EE <T> implements Iterable{
    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public EE() {
        primero=null;
    }
    
    public boolean estaVacia(){
        return primero==null;
    }
    
    public void agregaInicio(T dato){
        Nodo <T> nuevo = new Nodo(dato);
        
        nuevo.setSig(primero);
        primero=nuevo;
    }
    
    public void agregaFinal(T dato){
        if(estaVacia())
            agregaInicio(dato);
        else{
            Nodo<T> nuevo = new Nodo(dato);
            Nodo<T> apuntador= primero;
            while(apuntador.getSig()!=null)
                apuntador=apuntador.getSig();
            apuntador.setSig(nuevo);
        }   
    }
    
    public T quitaPrimero(){
        if(estaVacia())
            throw new EmptyCollectionException("No hay datos");
        T dato= primero.getDato();
        Nodo<T> apuntador=primero;
        primero=primero.getSig();
        apuntador.setSig(null);     
        return dato; 
    }
    
    public String toString(){
//    if(estaVacia()){
//      throw new ExcepcionColeccionVacia("No hay datos");  
//    }
   
    StringBuilder cad= new StringBuilder();
    Nodo<T> apuntador=primero;
    
    while(apuntador!=null){
        cad.append(apuntador.getDato().toString() +"\n");
        apuntador=apuntador.getSig();
    }
    return cad.toString();
    }
    
    public String toStringR(){
     if(estaVacia()){
      throw new EmptyCollectionException("No hay datos");  
    }
    
     Nodo <T> apuntador=primero;
     StringBuilder cad=new StringBuilder();
     
     return toStringR(apuntador,cad);
    
    }
    
    private String toStringR(Nodo<T> apuntador, StringBuilder cad){
        if(apuntador== null){ //si es nulo, para acabar
            return cad.toString();
        }else{
            cad.append(apuntador.getDato()+ "\n"); //pego el contendio
            return toStringR(apuntador.getSig(), cad); //se recorre
        }
    }
    
    public boolean busca (T dato){
    boolean resp;
        if(estaVacia())
         throw new EmptyCollectionException("No hay datos");
        else{
            resp=false;
            Nodo<T> apuntador=primero;
            while(apuntador!=null && !resp){
                if(apuntador.getDato().equals(dato))
                    resp=true;
                else
                apuntador=apuntador.getSig(); //el apuntador se recorre
            }
        }
    return resp;    
    }
    
    public boolean buscaR(T dato){
        if(estaVacia())
      throw new EmptyCollectionException("No hay datos");  
        else{
            return buscaR(dato, primero);
        }
    }
    private boolean buscaR (T dato, Nodo<T> apuntador){
        if(apuntador==null){
            return false;
        }
        else{
            if(apuntador.getDato().equals(dato))
                return true;
            else
                return buscaR(dato,apuntador.getSig());
        }
    }
    
    public T quitaUltimo(){
      if(estaVacia())
        throw new EmptyCollectionException("No hay datos");
      else{
          Nodo <T> ant,act;
          ant=null;
          act=primero;
          while(act.getSig() !=null){
              ant=act;
              act=act.getSig();
          }
//          if(ant==null) //La EE tiene un solo nodo
//              primero= null;
//          else{ //hay dos o más nodos
//              ant.setSiguiente(null);
//          }
        try{
            ant.setSig(null);
        }catch (NullPointerException nP){
            primero=null;
        }
          return act.getDato();
      
      }
    }
    
    public T quitaDato(T dato){
        T resp = null;
        
        Nodo<T> ant,act;
        ant=null;
        act=primero;
        while(act != null && !act.getDato().equals(dato)){
            ant=act;
            act=act.getSig();
        }
        if(act!=null){ //El dato esta en la EE
            resp= act.getDato();
            if(ant == null) //El dato es el primero
                primero = primero.getSig();
            else
                ant.setSig(act.getSig());
            act.setSig(null);
        }
        
        return resp;
    }
    
    public boolean eliminaSiguienteDe(T dato){
        boolean resp = false;
        
        Nodo<T> ant,act;
        ant=primero;
        act=primero.getSig();
        
        while(ant != null && !ant.getDato().equals(dato)){
            ant=act;
            act=act.getSig();
        }
        if(act!=null && ant!=null){
        ant.setSig(act.getSig());
        act.setSig(null);
        resp=true;
        }
        
        return resp;
     
    }
    
    public boolean eliminaAnteriorDeCORREGIR(T dato){
        if(estaVacia())
            throw new EmptyCollectionException("no hay datos");
         boolean res=false;
        Nodo<T> ant,act,ant2;
        ant2=null;
        ant=null;
        act=primero;
        
            
        while (act!=null && !act.getDato().equals(dato)){
            ant2=ant;
            ant=act;
            act=act.getSig();
        }
        
        if(act!=null && act!=primero){
            res=true;
            if (ant==primero){
                primero=primero.getSig();
                ant.setSig(null);
            }
            else{
                ant2.setSig(ant.getSig());
                ant.setSig(null);
            }
                
        }
        return res;
    }

    @Override
    public Iterator iterator() {
        return new IteradorEE(primero);
        
    }
    
    public boolean insertaAntesDe(T datoNvo, T dato){
        if(estaVacia())
            throw new EmptyCollectionException("no hay datos");
        boolean res=false;
        Nodo<T> ant,act,ant2;
        Nodo<T>aux= new Nodo(datoNvo); 
        ant=null;
        act=primero;
        
            
        while (act!=null && !act.getDato().equals(dato)){
            ant=act;
            act=act.getSig();
        }
        
        if(act != null){
            res= true;  
            if(ant==null){
                aux.setSig(primero);
                primero=aux;
            } 
            else{
            aux.setSig(act);
            ant.setSig(aux);
        }
        
        }
         return res;
    }
    
    public int eliminaTodosRepetidosOrdenado(){ 
        if(estaVacia())
            throw new EmptyCollectionException("No hay datos");
                
        int eliminados=0;
        if(primero.getSig() != null){
        Nodo<T> apuntador= primero;
        Nodo<T> aux;
        
        while(apuntador!=null){
            if(apuntador.getSig()!=null && apuntador.getDato().equals(apuntador.getSig().getDato())){
                aux=apuntador.getSig();
                apuntador.setSig(aux.getSig());
                aux.setSig(null);
                eliminados++;
            }else{
                apuntador=apuntador.getSig();              
            }               
            }    
        }   
        return eliminados;    
    }
    
    public int eliminaTodosRepetidosOrdenadoR(){
        if(estaVacia())
            throw new EmptyCollectionException("No hay datos");
        
        Nodo<T> actual=primero;
        
        return eliminaTodosRepetidosOrdenadoR(actual, actual.getSig(),0);
       
    }
    private int eliminaTodosRepetidosOrdenadoR(Nodo<T> actual, Nodo<T> siguiente,int contador){
        if(siguiente==null)
            return contador;
        else{
            
                if(actual.getDato().equals(siguiente.getDato())){
                    actual.setSig(siguiente.getSig());
                    siguiente.setSig(null);
                 return   eliminaTodosRepetidosOrdenadoR(actual,actual.getSig(),contador+1);
                }
                else
                 return  eliminaTodosRepetidosOrdenadoR(siguiente,siguiente.getSig(),contador);        
        }    
    }
public int cuentaElementos(){
        int contador=0;
        
        if(!estaVacia()){
            Nodo<T> control=primero;
            contador=1;
            while(control.getSig()!=null){
                contador++;
                control=control.getSig();
            }
        }
        return contador;
    }
public int calculaTamñoR(){
        int resp=0;
        if(estaVacia())//si esta vacia regresa 0
            return resp;
        else{
            Nodo<T> nodo=primero;
            return calculaTamañoR(resp+1,nodo);
        }
        
    }
    
    private int calculaTamañoR(int resp, Nodo<T> nodo){
        if(nodo.getSig()!=null){ //antes de que acabe
           resp++; //aumenta el contador
           return calculaTamañoR(resp,nodo.getSig());//se pasa al siguiente nodo
        }
        else{
           return resp;
        }
    }


    
public int eliminaRepetidosDesordenado(){
        if(estaVacia())
            throw new EmptyCollectionException("La estructura está vacia");
        
        int resp=0;
        Nodo<T> comparar= primero;
        Nodo<T> contra= primero;
        Nodo<T> quita= null;
        if(contra.getSig()!= null){
            for(int i=0; i<cuentaElementos(); i++){
                while(contra.getSig()!=null){
                   // 
                    T dato= contra.getSig().getDato();
                    if(comparar.getDato().equals(dato)){
                        
                        quita =contra.getSig(); // el que tendria que quitar
                        contra.setSig(quita.getSig());
                       //contra.getSiguiente().setSiguiente(null);
                       quita= null;
                        resp++;
                    }else
                        contra=contra.getSig();
                        
                }
                comparar=comparar.getSig();
                contra=comparar;
            }
        }
        return resp;
    }
    
    
    public int calculaTamanioRecursivo(){
        if(estaVacia())
            return 0;
        else{
            int contador=1;
            Nodo<T> nodos=primero;
            return calculaTamanioRecursivo(nodos, contador);
        }
}
    
    private int calculaTamanioRecursivo(Nodo<T> nodos, int contador){
            if(nodos.getSig()!=null){
                return calculaTamanioRecursivo(nodos.getSig(), contador+1);
            }
            else
                return contador;     
}
    
    /*
    PROBLEMA 45

Escribe un método en la clase EE que reciba como parámetro un objeto de tipo EE (objEE)
    y modifique a la EE que llama al método (this), mezclando sus nodos con los de objEE
    de acuerdo a lo descrito a continuación. A this se le deberá intercalar un nodo de objEE
    entre cada par de ella. Es decir, quedará el primer nodo de this seguido del primero de objEE,
    luego el segundo de this seguido del segundo de objEE, y así sucesivamente. Si tienen 
    diferente cantidad de nodos, al final quedarán los nodos de la EE más larga. SE DEBEN
    USAR LOS NODOS DE LAS EE, NO SÓLO LAS INFORMACIONES QUE ALMACENAN. Prueba tu solución. 
    Una vez ejecutado el método, ¿en qué estado quedan las dos EE involucradas?
    */
    
    public void intercala(EE objEE){
        Nodo<T> actual1= primero;
        Nodo<T> actual2= objEE.primero;
        Nodo<T> aux1;
        Nodo<T> aux2;

        while(actual1 !=null && actual2!=null){
            aux1=actual1.getSig();
            aux2=actual2.getSig();
            actual1.setSig(actual2);

            if(aux1 != null)
                actual2.setSig(aux1);
                actual1=aux1;
                actual2=aux2;

            }
        }




}
    
    

    
    
    
    
    
    
    
    




