package ejecutables;
import libreria.Rectángulo;

public class EjecutaRectángulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectángulo r1, r2, r3;
		// el rectangulo 1 será de base 6 y altura 8
		r1= new Rectángulo(6,8);
		// el rectangulo 2 será de base 2 y altura 7
		r2= new Rectángulo(2,7);
		// el rectangulo será de una base 3 y altura 7
		r3= new Rectángulo(3,7);
		// me equivoque y r2 base 9
		r2.setBase(9);
		System.out.println("hola mundo :)");
		System.out.println("el área del rectángulo 1 es: "+r1.calculaArea());
		System.out.println("el perímetro del rectángulo 2 es: "+r2.calculaPerimetro());
		System.out.println("la base del rectángulo q es: "+ r1.getBase());
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		if(r1.compareTo(r2)==0)
			System.out.println("son iguales");
			else 
				if(r1.compareTo(r2)==1)
					System.out.println("r1 es mayor a r2");
					else System.out.println("r1 es menor a r2");
	}
}
