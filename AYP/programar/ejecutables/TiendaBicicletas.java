package ejecutables;
import libreria.Bicicleta;
import java.util.*;
public class TiendaBicicletas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lee;
		lee= new Scanner(System.in);
		char tipo;
		int numA;
		String material;
				
		Bicicleta b1, b2, b3;
		b1=new Bicicleta ('U', 1, "aluminio");
		b2=new Bicicleta ('P', 4, "fibra de carbono");
		
		System.out.println("dame tipo: ");
		tipo=lee.next().charAt(0);
		System.out.println("dame numero de accesorios: ");
		numA=lee.nextInt();
		System.out.println("dame el material: ");
		material=lee.next();
		
		b3=new Bicicleta (tipo, numA, material);
		
		System.out.println(b1.caclculaCosto());
		System.out.println(b2.caclculaCosto());
		System.out.println(b3.caclculaCosto());
		
		System.out.println(b1.calculaTiempo());
		System.out.println(b2.calculaTiempo());
		System.out.println(b3.calculaTiempo());
		
		System.out.println(b2.toString());
		
		b1.setNumA(5);
		System.out.println(b1.caclculaCosto());
	}

}
