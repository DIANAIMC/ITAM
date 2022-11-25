package libreria;

import java.util.ArrayList;

public class Competencia {

	private Receta[][]re;
	private final int MAXR=5;
	private final int MAXC=7;
	private int totalc=0;
	private int totalr=0;
	
	public Competencia() {
		re=new Receta[MAXR][MAXC];
	}
	 

	public boolean altaReceta(String tipo, int numIngredientes, double costoEstimado, int col, int ren) {
		boolean res=false;
		if(col<MAXC && ren<MAXR) {
			Receta x;
			if(re[ren-1][col-1] == null  ) {
				x=new Receta(tipo, numIngredientes, costoEstimado);
				re[ren-1][col-1]=x;
				res=true;
		}
	}
		return res;
	}
	
	public int RecetaConMasIngrediente(String tipo){
		int restaurante=0;
		int max= re[0][0].getNumIngredientes();
		for (int i = 0; i < MAXR; i++) {
			for (int j = 0; j < MAXC; j++) {
				if(re[i][j].getTipo().equals(tipo) && re[i][j].getNumIngredientes()>max) {
					restaurante=j;
					
				}
			}
		}
		return restaurante;
}

	
}
