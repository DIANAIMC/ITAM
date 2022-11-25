/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author dianam
 */
public class ArrayStack<T> implements StackADT<T>{
    
    private final int DEFAULT_CAPACITY = 100;
    protected int top; 
    protected T[] stack; 


    public ArrayStack(){
        top = 0;
        stack = (T[])(new Object[DEFAULT_CAPACITY]); 
    }

    public ArrayStack (int initialCapacity){
      top = 0;
      stack = (T[])(new Object[initialCapacity]);
   }
    
    public T pop() {
      T result;
      if (isEmpty())
         throw new EmptyCollectionException("Pila Vacía");
      else{
          top--;
          result = stack[top];
          stack[top] = null; 
          return result;
      }  
   }
    
    public T peek() {
       if (!isEmpty())
           return stack[top-1];
       else
           throw new EmptyCollectionException("Pila Vacía"); 
           
   }

    public boolean isEmpty(){
        return top == 0;
    }

    public int size(){
	return top;
   }
    
    public String toString(){
      String result = "";

      for (int scan=0; scan < top; scan++) 
         result = result + stack[scan].toString() + "\n";

      return result;
   }
    
    private void expandCapacity(){
      T[] larger = (T[])(new Object[stack.length*2]);

      for (int index=0; index < stack.length; index++)
         larger[index] = stack[index];

      stack = larger;
   }

    public void push (T element){
      if (size() == stack.length) 
         expandCapacity();

      stack[top] = element;
      top++;
   }

    
    
    
}
    

