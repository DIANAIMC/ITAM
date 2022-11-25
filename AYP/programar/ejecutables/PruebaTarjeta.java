package ejecutables;
import libreria.Tarjeta;
import java.util.*;
public class PruebaTarjeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lee;
		int categoria;
		String tipo;
		int año;
		int pin;
		lee = new Scanner(System.in);
		Tarjeta t1, t2;
		t1=new Tarjeta(1,"Titular",2005,765 );
	
		System.out.println(t1.activaTarjeta(2005));
		System.out.println("La comision de la tarjeta activada es:"+t1.calculaComision());
		System.out.println("los datos de su tarjeta son"+t1.toString());
		

		
		System.out.println("dame la categoría de la tarjeta");
			categoria=lee.nextInt();
		System.out.println("dame el tipo de tarjeta");
			tipo=lee.toString();
		System.out.println("dame el año");
			año=lee.nextInt();
		System.out.println("ingrese su pin");
			pin=lee.nextInt();
		t2=new Tarjeta(categoria, tipo, año, pin);
		System.out.println(t2.activaTarjeta(pin));
		System.out.println("La comision de la tarjeta activada es:"+t2.calculaComision());
			
			
		System.out.println("los datos de su tarjeta son"+t2.toString());

		

	}
}
