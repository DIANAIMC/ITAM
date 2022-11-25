package ejecutables;
import libreria.Vino;
public class Vinateria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vino v1, v2;
		v1=new Vino("Agustinos", "Chile", "gran reserva", 2007, "Pinot Noir", 266.50);
		v2=new Vino("Almaviva", "Chile", "cria", 2012, "Merlot", 156.80);
				
		System.out.println(v1.calculaVentaBotella(3));
		System.out.println(v2.calculaVentaCaja(12, "tarjeta"));
		
		v1.setPrecio(270);
		
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v2.getOrigen());
		
		if(v1.equals(v2))
			System.out.println("los vinos son iguales");
		else
			System.out.println("los vinos no son iguales");
			
	}

}
