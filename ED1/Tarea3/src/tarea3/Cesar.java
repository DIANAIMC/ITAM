/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea3;

/**
 *
 * @author dianam
 */
public class Cesar {
    // Atributos 
    private ArrayQueue<Integer> key; 
    private String [] alphabet= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    
    // Constructores 
    public Cesar() {
        key= new ArrayQueue<Integer>(); 
    }
    
    // Cifrar 
    public String encrypt(int [] key, String message) {
        String result=""; 
        
        for (int i=0; i<key.length; i++) 
            this.key.enqueue(key[i]);
        
        int tam=message.length(); 
        
        for (int i=0; i<tam; i++) {
            
            if (message.charAt(i)!=' '){
                
                int value=this.key.dequeue();
                
                int corr=searchIndex(message.charAt(i))+value; 
                
                if (corr>=0){
                    result=result+alphabet[corr%26]; 
                }else {
                    corr=corr%26; // Das las vueltas que necesitas
                    result=result+alphabet[corr+26]; 
                } 
                
                this.key.enqueue(value);// Lo sacas y los vuelves a meter 
                
            }else 
                result=result+" "; 
            
        }
        this.key=new ArrayQueue(); // AGUAS
        
        return result; 
    }
    
    // Descifrar 
    public String decrypt(int [] key, String message) {
        String result=""; 
        
        for (int i=0; i<key.length; i++) {
            this.key.enqueue(key[i]);
        }
        
        int tam=message.length(); 
        
        for (int i=0; i<tam; i++) {
            
            if (message.charAt(i)!=' '){// Si es diferente de espacio 
                
              int value=this.key.dequeue(); 
              
              int corr=searchIndex(message.charAt(i))-value; 
              // PREGUNTAR 
              if (corr>=0){
                    result=result+alphabet[corr%26]; 
                }else {
                    corr=corr%26; // Das las vueltas que necesitas
                    result=result+alphabet[corr+26]; 
                } 
                
                this.key.enqueue(value);// Lo sacas y los vuelves a meter 
                
            }else 
                result=result+" ";
            
        }
        this.key=new ArrayQueue(); // AGUAS 
        return result; 
    }
    
    private int searchIndex(char letter) {
        int res=-1; 
        int i=0; 
        while (i<26 && !alphabet[i].equals(""+letter)){
            i++; 
        }
        if (i<26){
            res=i;
        }
        return res; 
    }
    
}

/*
-Es super importante que cada vez que quieras hacer un cifrado o un descifrado, limipar la cola (empezar desde cero). 
- 
*/
