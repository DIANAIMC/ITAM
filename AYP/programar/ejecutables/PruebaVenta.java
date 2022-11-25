package ejecutables;
import libreria.Venta;
import java.util.Scanner;
public class PruebaVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double res;
		boolean res1;
		double guante;
		Scanner lee;
		lee= new Scanner(System.in);
		Venta v1, v2;
		v1= new Venta(850, "venta1");
		v2= new Venta(2350, "venta2");
		
		res1=v1.equals(v2);
		v2.equals(v1);
		System.out.println("la venta 1 es igual a la venta 2 " + res1);
		
		v1.compareTo(v2);
	
		
		res=v1.calculaComicion();
		System.out.println("la comisión de la venta 1 es: " + res);
		
		System.out.println("dame un monto de venta para que te calcule la comisión:  ");
		guante=lee.nextDouble();
		
		v1.setMonto(guante);
		res=v1.calculaComicion();
		System.out.println("la comisión de la venta 1 es: " + res);
	}

}
