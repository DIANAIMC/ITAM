/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

/**
 *
 * @author dianam
 */
public class Caballo {

	protected int n;		
    protected int [][] tablero; 
    /* tablero[x][y] = 0 implica casilla no visitada
                     = i                 visitada en secuencia i */
    protected int [][] delta = {
       	{2,1}, {1,2}, {-1,2}, {-2,1}, {-2,-1}, {-1,-2}, {1,-2}, {2,-1}
    }; // hay 8 posibles saltos del caballo a partir de cualquier posiciÛn


	public Caballo(int dimension) {
		n = dimension;
		tablero = new int[n][n];	// inicializada a 0s autom·ticamente
	}	

    
    public boolean tryNextMove(int x, int y, int i) {
    	boolean done = false;

        if ( valid(x,y) ) {
        	setKnight(x, y, i); 	       	
            if ( solved(i) )        	
        		done = true;
        	else {
        		for (int salto = 0;  salto<delta.length && !done; salto++)
                	done = tryNextMove(x + delta[salto][0], y + delta[salto][1], i+1);    	
        		if (!done)
            		removeKnight(x, y);        	
            }
		}
        
        return done;
    }   
 
    protected boolean valid(int row, int column) {
      	boolean result = false;
      	if (row >= 0 && row < tablero.length && 
      	  	column >= 0 && column < tablero[row].length) 
         	if (tablero[row][column] == 0) // casilla libre
            	result = true;		
      	return result;
   	}

	protected boolean solved(int i) {
		return i==n*n;
	}

	protected void setKnight(int row, int column, int i) {
		tablero[row][column] = i;
	}

	protected void removeKnight(int row, int column) {
		tablero[row][column] = 0;
	}

   	public String toString() {
      	StringBuilder result = new StringBuilder("\n");
      	for (int row=0; row < tablero.length; row++) {
         	for (int column=0; column < tablero[row].length; column++)
            	result.append(tablero[row][column] + "\t");
         	result.append("\n");
      	}
      	return result.toString();
   	}
   
   	
	public static void main(String [] args) {
	
		int n;		// tamaÒo del tablero
		int x, y; 	// posiciÛn inicial del caballo (x,y)
		
		n = 8;
		x = 0; 	// x,y  >= 0  && <= n-1
		y = 0;
		
		Caballo  saltarin = new Caballo(n);
				
		if (saltarin.tryNextMove(x,y,1)) // posiciÛn inicial v·lida
         	System.out.println ("The chessboard was successfully traversed!");
      	else
         	System.out.println ("There is no possible path.");
         	
        System.out.println (saltarin);
	}
	
	/* If (x,y)==0 the path ends in (n-1,n-1) for n=5 */
}
