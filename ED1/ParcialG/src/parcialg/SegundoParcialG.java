/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialg;

/**
 *
 * @author dianam
 */
public class SegundoParcialG {
    
    //pregunta 1
    public static <T> boolean elementosConsecutivos(ColaADT<T> cola){
        ColaA<T> auxiliar= new ColaA();
        boolean resp=false;
        T variable;
        
        
        while(!cola.estaVacia()&& resp==false){
            variable=cola.quita(); //aquí esta dando el valor de elemento que está revisando en un variable para después usarla
            if(!cola.estaVacia()){ //si la cola está vacía
            if(variable.equals(cola.consultaPrimero())) //comparo el valor que ya evalué con el siguiente
                resp=true;
            }
            auxiliar.agrega(variable); //el valor que ya comparamos, lo agregamos a la cola auxiliar
        }
        
        while(!cola.estaVacia())    //Esta parte del código está para que ya no siga comparando cuando ya es true
            auxiliar.agrega(cola.quita());
        
        while(!auxiliar.estaVacia()) //regresa los elementos a la cola
            cola.agrega(auxiliar.quita());
        
        return resp; 
    }
    //Pregunta 2
    public static <T> int cuentaElementosCola(ColaADT<T> cola){
        ColaA<T> auxiliar= new ColaA();
        int n;
        
         n=0;
        while(!cola.estaVacia()){
            auxiliar.agrega(cola.quita());
            n++;
        }
        
        while(!auxiliar.estaVacia())
            cola.agrega(auxiliar.quita());
        
        return n;
    }
    
    public static ColaA<ProductoLacteo>  eliminaQuesos(ColaADT<ProductoLacteo> cola, String tipo, double precio){
        ColaA<ProductoLacteo> auxiliar= new ColaA();
        ColaA<ProductoLacteo> resultado= new ColaA();
        
        int n=cuentaElementosCola(cola);
                
        return eliminaQuesos(cola, tipo, precio, 0, resultado, auxiliar, n);
     
    }
    
    private static ColaA<ProductoLacteo>  eliminaQuesos(ColaADT<ProductoLacteo> cola, String tipo, double precio, int i, ColaA<ProductoLacteo> resultado, ColaA<ProductoLacteo> auxiliar, int n){
        if(i==n && auxiliar.estaVacia()) //estado base
            return resultado;
        
        if(i<n){
        if(cola.consultaPrimero() instanceof Queso && ((Queso)cola.consultaPrimero()).getTipo().equals(tipo) && cola.consultaPrimero().getPrecio()>=precio)
            resultado.agrega(cola.quita());
        else
            auxiliar.agrega(cola.quita());
        return eliminaQuesos(cola, tipo, precio, i+1, resultado, auxiliar, n);
        }
        
        cola.agrega(auxiliar.quita());
        
        
        return eliminaQuesos(cola, tipo, precio, i, resultado, auxiliar, n);     
    }
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean resp;
        ColaADT<String> colores =new ColaA();
        ColaADT<Integer> numeros =new ColaA();
        
        
        colores.agrega("rojo");
        colores.agrega("blanco");
        colores.agrega("azul");
        colores.agrega("blanco");
        colores.agrega("rojo");
        
        numeros.agrega(2);
        numeros.agrega(5);
        numeros.agrega(8);
        numeros.agrega(8);
        numeros.agrega(4);
        numeros.agrega(3);
        numeros.agrega(2);
        numeros.agrega(4);
        
        System.out.println(colores.imprimeCola());
        System.out.println(numeros.imprimeCola());     
        
        System.out.println("¿Hay colores consecutivos?"+"\n");
        resp=elementosConsecutivos(colores);
        if(resp)
            System.out.println("Si hay elementos consecutivos"+"\n");
        else
            System.out.println("No hay elementos consecutivos"+"\n");
        System.out.println("¿Hay números consecutivos?"+"\n");
        resp=elementosConsecutivos(numeros);
        if(resp)
            System.out.println("Si hay elementos consecutivos"+"\n");
        else
            System.out.println("No hay elementos consecutivos"+"\n");
        
        System.out.println(colores.imprimeCola());
        System.out.println(numeros.imprimeCola());
        
        //-----------------------------------
        
        ColaADT<ProductoLacteo> lacteos =new ColaA();  
        ColaADT<ProductoLacteo> resultado =new ColaA();
        
        
        ProductoLacteo producto1;
        producto1= new Queso("manchego", "Liconsa", 23.2, 2.0, 20);
        
        ProductoLacteo producto2;
        producto2= new Queso("crema", "Lala", 33.0, 1.0, 10);
        
        ProductoLacteo producto3;
        producto3= new Yogurt(4, "Greek", 19.2, 2.0, 4);
        
        ProductoLacteo producto4;
        producto4= new Queso("panela", "Mimi", 22.2, 1.0, 5);
        
        ProductoLacteo producto5;
        producto5= new Mantequilla(true, "Alpura", 8.0, 2.0, 4);
        
        ProductoLacteo producto6;
        producto6= new Queso("oaxaca", "Mimi", 22.2, 1.0, 5);
        
        lacteos.agrega(producto1);
        lacteos.agrega(producto2);
        lacteos.agrega(producto3);
        lacteos.agrega(producto4);
        lacteos.agrega(producto5);
        
        System.out.println("lista lacteos: "+lacteos.imprimeCola());
        
        resultado=eliminaQuesos(lacteos,"manchego",15); //debería de eliminar un queso
        System.out.println("Quesos eliminados: " +resultado.imprimeCola()+"\n");
        
        System.out.println("lista lacteos: "+lacteos.imprimeCola());        
        
        resultado=eliminaQuesos(lacteos,"panela",30); // no debería de eliminar ninguno 
        System.out.println("Quesos eliminados: " +resultado.imprimeCola()+"\n");
        
        resultado=eliminaQuesos(lacteos,"panela",20); //debería de eliminar un queso
        System.out.println("Quesos eliminados: " +resultado.imprimeCola()+"\n");
        
        resultado=eliminaQuesos(lacteos,"mozzarella",15); // no debería de eliminar ninguno
        System.out.println("Quesos eliminados: " +resultado.imprimeCola()+"\n");
        
        resultado=eliminaQuesos(lacteos,"Greek",15); // no debería de eliminar ninguno
        System.out.println("Quesos eliminados: " +resultado.imprimeCola()+"\n");
        
        System.out.println("lista lacteos: "+lacteos.imprimeCola());
    
    }
    
}

