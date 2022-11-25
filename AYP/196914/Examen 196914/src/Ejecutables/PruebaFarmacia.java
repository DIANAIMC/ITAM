package Ejecutables;
import Librerias.Farmacia;
public class PruebaFarmacia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Farmacia f;
		f=new Farmacia("Diana","5529660573","unrfccualquiera");
		boolean res;
		res=f.altaMedicamento("aspirina protect", 114.2, 23, false);
		if(res)
			System.out.println("alta exitosa");
		else
			System.out.println("no se dió de alta");
		res=f.altaMedicamento("amoxicilin", 110.5, 15, false);
		if(res)
			System.out.println("alta exitosa");
		else
			System.out.println("no se dió de alta");
		res=f.altaMedicamento("aampicilina", 89.9, 12, true);
		if(res)
			System.out.println("alta exitosa");
		else
			System.out.println("no se dió de alta");
		
		System.out.println(f.noNecesitanReceta());
		res=f.comparaPrecioCant(100.20, 3);
		if(res)
		System.out.println("si hay medicamentos de esa cantidad y precio");
		else
			System.out.println("no hay medicamentos de esa cantidad y precio");
	}

}
