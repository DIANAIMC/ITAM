/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasofinal;

import EE.EE;
import EE.Nodo;
import Estructuras.ArraySet;
import Estructuras.ArrayStack;
import Estructuras.ConjuntoADT;
import Estructuras.EmptyCollectionException;
import java.util.Iterator;
import java.util.LinkedList;

//Fórmulas para recursividad
/*
    public static noVoid metodo(Param){
        *instrucciones 1*
        for(declaracion = instancia; condicion; cambio/avance){
            *instrucciones 2*
        }        
        *instrucciones 3*
    }

    public static noVoid metodo(Param){
        *instrucciones 1*
        declaracion = instancia;
        While(condicion){
            *instrucciones 2*
            cambo/avance
        }        
        *instrucciones 3*
    }

    //RECURSIVIDAD NOVOID
    public static noVoid metodoR(param){
        *instrucciones 1*
        return metodoR(param, instancia);
    }
    private static noVoid metodoR(param, declaracion){
        if(!condicion){
            *instrucciones 3*
        }else {
            *instrucciones 2*
            return metodoR(param, avance/cambio);
        }
    }

    //RECURSIVIDAD VOID
    public static Void metodoR(param){
        if(condicion){
            *instrucciones 2*
            return metodoR(param, avance/cambio);
        }
    }
*/

public class RepasoFinal {
    
    //Dada una estructura enlazada de tipo itamita, escribe un método 
    //estático recursivo que regrese cuantos ingenieros tienen carrera conjunta

    public static int cuantosConjunta(LinkedList<Itamita> ee) {
        if (ee == null) {
            throw new EmptyCollectionException("EE");
        }
        Iterator<Itamita> it = ee.iterator();
        int cont = 0;
        while (it.hasNext()) {
            Itamita aux = it.next();
            if (aux instanceof Ingeniero) {
                if (((Ingeniero) aux).isConjunta()) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    //RECURSIVA

    public static int cuantosConjuntaR(LinkedList<Itamita> ee) {
        if (ee == null) {
            throw new EmptyCollectionException("EE");
        }
        return cuantosConjuntaR(ee, ee.iterator(), 0);
    }

    private static int cuantosConjuntaR(LinkedList<Itamita> ee, Iterator<Itamita> it, int cont) {
        if (!it.hasNext()) {
            return cont;
        } else {
            Itamita aux = it.next();
            if (aux instanceof Ingeniero) {
                if (((Ingeniero) aux).isConjunta()) {
                    cont++;
                }
            }
            return cuantosConjuntaR(ee, it, cont);
        }
    }

    //Dada una EE de tipo ITAMITA regresar una EE con los itamitas con beca 
    //mayor a 50%; además que sean licenciados que estudien ECO o los ingenieros
    //en negocios que tengan trabajo (recursivo)
    
    public static LinkedList<Itamita> becados(LinkedList<Itamita> ee) {
        if (ee == null) {
            throw new EmptyCollectionException("EE");
        }
        Iterator<Itamita> it = ee.iterator();
        LinkedList<Itamita> resp = new LinkedList();
        Itamita aux;
        while (it.hasNext()) {
            aux = it.next();
            if (aux.getBeca() > 0.5) {
                if (aux instanceof Licenciado) {
                    if (((Licenciado) aux).getCarrera().equalsIgnoreCase("eco")) {
                        resp.add(aux);
                    }
                } else if (aux instanceof Negocios) {
                    if (((Negocios) aux).isTrabajo()) {
                        resp.add(aux);
                    }
                }
            }
        }
        return resp;
    }
    
    //RECURSIVA
    
//    public static LinkedList<Itamita> becadosR (LinkedList<Itamita> ee){
//        *instrucciones 1*
//        for(declaracion = instancia; condicion; cambio/avance){
//            *instrucciones 2*
//        }        
//        *instrucciones 3*
//    }

    public static LinkedList<Itamita> becadosR (LinkedList<Itamita> ee){
        if (ee == null) {
            throw new EmptyCollectionException("EE");
        }
        Iterator<Itamita> it = ee.iterator();
        LinkedList<Itamita> resp = new LinkedList();
        return becadosR(ee, it, resp);
    }
    private static LinkedList<Itamita> becadosR(LinkedList<Itamita> ee, Iterator<Itamita> it, LinkedList<Itamita> resp){
        if(!it.hasNext()){
            return resp;
        }else {
            Itamita aux = it.next();
            if (aux.getBeca() > 0.5) {
                if (aux instanceof Licenciado) {
                    if (((Licenciado) aux).getCarrera().equalsIgnoreCase("eco")) {
                        resp.add(aux);
                    }
                } else if (aux instanceof Negocios) {
                    if (((Negocios) aux).isTrabajo()) {
                        resp.add(aux);
                    }
                }
            }
            return becadosR(ee, it, resp);
        }
    }
    

    //Dados dos conjuntos de itamitas (Cine ITAM, Cheerleading) 
    //regresar un conjunto que tenga ITAMITAS que estén en ambos 
    //conjuntos(OEs) y que no tengan beca (beca = 0)
    
    public static ArraySet<Itamita> ejerConjuntos(ArraySet<Itamita> cine, ArraySet<Itamita> cheer) {
        if (cine == null || cheer == null) {
            throw new EmptyCollectionException("Conjunto");
        }

        return ejerConjuntos(cheer, new ArraySet<Itamita>(), cine.iterator());
    }

    private static ArraySet<Itamita> ejerConjuntos(ArraySet<Itamita> cheer, ArraySet<Itamita> resp, Iterator<Itamita> it) {
        if (!it.hasNext()) {
            return resp;
        } else {
            Itamita aux = it.next();
            if (cheer.contains(aux) && aux.getBeca() == 0) {
                resp.add(aux);
            }
            return ejerConjuntos(cheer, resp, it);
        }
    }
    //Dada una pila de ITAMITAS jsjsjjs, haz un método que elimine a los alumnos repetidos
    
    public static <T> void quitaRepetidos(ArrayStack<T> pila){
         ArrayStack<T> aux= new ArrayStack();
         if(!pila.isEmpty()){
              aux.push(pila.pop());
        
         while(!pila.isEmpty()){
             if(pila.peek().equals(aux.peek())){
                 aux.pop();
             }
             aux.push(pila.pop());
             
         }
         
         while(!aux.isEmpty())
             pila.push(aux.pop());
         
             }
         else
             throw new EmptyCollectionException("No hay datos");      
    }
    
    //RECURSIVA, está mal
    
    public static <T> void quitaRepetidosR(ArrayStack<T> pila){
	if(pila.isEmpty()){
		throw new EmptyCollectionException("No hay datos");
	} else {
		 quitaRepetidosR(pila, new ArrayStack<T>());
	}
}

    private static <T> void quitaRepetidosR(ArrayStack<T> pila, ArrayStack<T> aux){
	if(pila.isEmpty()){
		regresaDatos(aux,pila);	
	} else {
		if(aux.isEmpty()){
			aux.push(pila.pop());
		} else {
			if(aux.peek().equals(pila.peek())){
				pila.pop();
			} else {
				aux.push(pila.pop());
			}
		}
		quitaRepetidosR(pila, aux);
	}
}

    private static <T> void regresaDatos(ArrayStack<T> pila, ArrayStack<T> aux){
	if(!aux.isEmpty()){
		pila.push(aux.pop());
		regresaDatos(aux,pila);	
	}
    }
    //CONJUNTOS 
    public <T> boolean subConjunto(ConjuntoADT<T> conjunto, ConjuntoADT<T> conjMINI){
        int i=0;
        boolean resp=true;
        Iterator it = conjMINI.iterator();
        while(it.hasNext() && !resp)
            if(!conjunto.contiene((T) it.next()))
                resp=false;
        return resp;
    }
   
    
    
    public static void main(String[] args) {
        //Contar cosas, buscar cosas, cambiar cosas
        EE<Integer> est2= new EE();
        EE<Integer> est3= new EE();
        EE<Itamita>alums = new EE();
        boolean resp;
        double suma;
        int contador;

        est2.agregaFinal(12);
        est2.agregaFinal(45);
        est2.agregaFinal(18);

        est3.agregaFinal(1);
        est3.agregaFinal(1);
        est3.agregaFinal(2);
        est3.agregaFinal(2);
        est3.agregaFinal(2);
        est3.agregaFinal(3);

        System.out.println(est2);
        System.out.println(est3);

        est2.intercala(est3);
        System.out.println(est2);
        Itamita it;
        LinkedList<Itamita> ee = new LinkedList();
        ArrayStack<Itamita> pila = new ArrayStack();

        it = new Licenciado("Eco", 123432, 0.5);
        ee.add(it);
        it = new Licenciado("CPOL", 163232, 0.7);
        ee.add(it);
        it = new Licenciado("Eco", 189492, 0.8);
        ee.add(it);
        it = new Licenciado("Cpol", 153432, 0.4);
        ee.add(it);
        it = new Computacion('I', true, 202352, 0.5);
        ee.add(it);
        it = new Computacion('I', false, 192352, 0.7);
        ee.add(it);
        it = new Negocios(true, false, 182352, 0.6);
        ee.add(it);
        it = new Negocios(false, true, 152352, 0.8);
        ee.add(it);
        it = new Negocios(false, false, 189953, 0.8);
        ee.add(it);
        
        
        System.out.println(becadosR(ee));
        System.out.println(cuantosConjuntaR(ee));
        
        it = new Licenciado("Eco", 123432, 0.5);
        pila.push(it);
        it = new Licenciado("CPOL", 163232, 0.7);
        pila.push(it);
        it = new Licenciado("Eco", 123432, 0.5);
        pila.push(it);
        it = new Licenciado("Cpol", 153432, 0.4);
        pila.push(it);
        it = new Computacion('I', true, 202352, 0.5);
        pila.push(it);
        it = new Computacion('I', false, 192352, 0.7);
        pila.push(it);
        it = new Negocios(true, false, 182352, 0.6);
        pila.push(it);
        it = new Negocios(true, true, 152352, 0.8);
        pila.push(it);
        it = new Negocios(true, true, 152352, 0.8);
        pila.push(it);
        
        System.out.println(pila.toString());
        quitaRepetidosR(pila);
        System.out.println(pila.toString());

    }
}

