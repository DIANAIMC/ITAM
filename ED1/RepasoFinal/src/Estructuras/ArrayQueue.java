/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.DEFAULT_CAPACITY;

/**
 *
 * @author dianam
 */
public class ArrayQueue<T> implements QueueADT <T> {
    private int end;
    private int front;
    private T[] stack;

    public ArrayQueue() {
        stack=(T[]) (new Object[DEFAULT_CAPACITY]); 
        front=-1;
        end=-1;
    }

    public int getEnd() {
        return end;
    }

    public int getFront() {
        return front;
    }
    
    public boolean isEmpty(){
        return front==-1;
    }
    
    public T first(){
        if(!isEmpty())
            throw new EmptyCollectionException("");
        return stack[front];
    }
    
    public void expand(){
        T[] nuevo=(T[]) new Object[stack.length*2];
        int j=0, i;
        
        for(i=front;i<stack.length;i++){
            nuevo[j]=stack[i];
            j++;
        }
        
        for(i=0;i<front;i++){
            nuevo[j]=stack[i];
            j++;
        }
        
        front=0;
        end=j-1;
        stack=nuevo;
    } 
    
    public void expandCapacity(){
        T[] larger = (T[])(new Object[stack.length *2]);
        int index;
        for(index=0; index < stack.length; index++)
        {
            larger[index] = stack[front];
            front=(front+1) % stack.length;
        }
        front = 0;
        end = stack.length-1;
        stack = larger;
    }
    //agregar un dato al final (0)
    public void enqueue (T dato){
        if  ((end+1)%stack.length == front)
              expandCapacity();
        end=(end+1)%stack.length;
        stack[end]=dato;
        if (front==-1)
            front=0;
    }   
    
    
    public T dequeue() {
        if  (isEmpty())
           throw new EmptyCollectionException("Queue underflow");
        T result = stack[front];
        stack[front] = null;
        if (front==end){
            front=-1;
            end=-1;
        } 
        else
            front=(front+1)%stack.length;
        return result;
        
    }   
    
    public void add(T dato){
        if((end+1)%stack.length==front)
            expand();
            end=(end+1)%stack.length;
            stack[end]=dato;
            if(front==-1)
                front=0;
        
    }
    
    public T remove(){
        T result;
        if(isEmpty()){
            throw new EmptyCollectionException("");
        }
        else{
            result=stack[front];
            if(front==end){
                front=-1;
                end=-1;
            }
            else
                front=(front+1)%stack.length;
        }
        return result;
    }
    
    public String imprime(){
        StringBuilder res= new StringBuilder();
        int i;
        
        i=front;
        if(!isEmpty()){
        while(i%stack.length !=end%stack.length){
            res.append(stack[i]+ " ");
            i++;
        }
        res.append(stack[i%stack.length]+"\n");      
        }
        return res.toString();
    }
    
}
