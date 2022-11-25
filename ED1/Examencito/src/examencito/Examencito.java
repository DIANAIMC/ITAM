/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examencito;

/**
 *
 * @author dianam
 */
public class Examencito {
/*public static void hazCosas1(int y) {
        y=-11;
        y=28;
        }
    public static void hazCosas2(int z) {
        z=-6;
    }
 */   
    public static <T> void imprimePila(PilaADT<T> pila){
        PilaADT<T> aux=new PilaA();
        
        while(!pila.isEmpty()){//Importante
            System.out.println(pila.peek().toString());
            aux.push(pila.pop());//Los datos se guardan aqui 
        }
        
        while(!aux.isEmpty()){//Regresar los datos de la aux a la original 
            pila.push(aux.pop());
        }
    }
    
    public static boolean esDouble(String value) {
        boolean convierte;
        
        try {
            Double.parseDouble(value);
            convierte = true;
        } catch (NumberFormatException e) {
            convierte = false;
        }
        return convierte;
    }
    
    public static double evaluaPostfija(String[] postfija){
      PilaADT<Double> pila = new PilaA();
      int lon, i;
      double op1, op2, res=0;
      String ev;
      
      lon=postfija.length;
      for(i=0;i<lon;i++){
          ev=postfija[i];
          System.out.println(ev);
          if(esDouble(ev)){
              pila.push(Double.parseDouble(ev));
          }else{
              op1=pila.pop();
              op2=pila.pop();
              if(ev.equals("+")){
                  pila.push(op2+op1);
              }
              else if (ev.equals("-")){
                  pila.push(op2-op1);
              }
              else if(ev.equals("*")){
                  pila.push(op2*op1);
              }
              else{
                  pila.push(op2/op1);
              }   
        }
          System.out.println("_");
           imprimePila(pila);
    }
      
//       
        
        return pila.pop();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herepublic static void main(String args[]) {

        String [] exp={"5","7","12","-","/","8","+","9","1","+","*"};
        System.out.println("= " + evaluaPostfija(exp));
    /*    int a, b, c, d;
        a=7;
        b=9;
        c=a;
        d=-7;
        System.out.println("a: "+a+" b: "+b+" c: "+c); 
        //hazCosas1(b);
        b=28;
        //hazCosas2(c);
        c=-6;
        System.out.println("a: "+a+" b: "+b+" c: "+c);
    */
    
    }
    
}
    

