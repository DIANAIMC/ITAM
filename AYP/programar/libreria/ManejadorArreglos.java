package libreria;

public class ManejadorArreglos {
	//sumar los elementos de un arreglos
	
	public static double sumaArre(double[]c, int num) {
		double suma=0;
		for(int i=0;i<num;i++)
			suma+=c[1];
		return suma;
	}
	
	//Obtener el promedio de los elementos de un arreglo de double.
	public static double promedioArre(double []c,int num) {
		return sumaArre(c,num)/num;
	}
	
	//Obtener el índice donde se encuentra el elemento mayor de un arreglo de double.
	public static int mayorIndiceArre(double []c, int num) {
		int maxInd=0;
		double maximo=c[0];
		for(int i=1;i<num;i++)
		if (maximo<c[i]){
			maximo=c[i];
			maxInd=i;
		}
		return maxInd;
	}
	//Obtener el índice donde se encuentra el elemento menor de un arreglo de double.
	public static int menorIndiceArre(double []c, int num) {
		int minInd=0;
		double min=c[0];
		for(int i=1;i<num;i++) 
		if (min>c[i]){
			min=c[i];
			minInd=i;
		}
		return minInd;
	}
	//Determinar cuántos elementos de un arreglo de double son mayores a un cierto parametro.
	public static int numElemMayor(double []c,int num, double valor) {
		int contador=0;
		for(int i=0;i<num;i++)
			if(c[i]>valor)
				contador++;
		return contador;
	}
	public static int numElemMenor(double []c,int num, double valor) {
		int contador=0;
		for(int i=0;i<num;i++)
			if(c[i]<valor)
				contador++;
		return contador;
	}
	//función estatica que regrese la suma de los elementos pares del arreglo
	public static double sumaParesArre(double[]c, int num) {
		double suma=0;
		for(int i=0;i<num;i++)
		if(c[i]%2==0)	
			suma+=c[1];
		return suma;
	}
	//función estatica que regrese la suma de los elementos de su indice impar
	public static double sumaImparesArre(double[]c, int num) {
		double suma=0;
		for(int i=1;i<num;i++)
		if(c[i]%2!=0)
			suma+=c[i];
		return suma;
	}
	//función estática que regrese un String de los elementos de los indices pares
	
	
}
