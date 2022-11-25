package ejecutables;
import libreria.CientificoMatematico;
public class PruebaCientificoMatematico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//declarar variables
		CientificoMatematico c;
		c= new CientificoMatematico ("Luis", "computación");
		
		System.out.println("el 8 está en orden creciente con respecto al 6"+ c.estaOrdenCreciennte(8,6));
		System.out.println("5,7 ordenados crecientemente"+ c.ordenCreciente(5,7));
		
		//System.out.println("el 8 es impar"+ c.esImpar(8));
		if (c.esImpar(8)==true)
			System.out.println("el número dado es impar");
		else
			System.out.println("el número dado es par");
		
		System.out.println("cuando x vale 12 el resultado es "+ c.calculaFuncion1(12));
		System.out.println("cuando x vale 23 el resultado es "+ c.calculaFuncion2(23));
		System.out.println("cuando el número es 3 y `v`vale 6, el resultado es "+ c.calculaFuncion3(3,6));
	}
}
