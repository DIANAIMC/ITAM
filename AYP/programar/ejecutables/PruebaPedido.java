package ejecutables;
import libreria.Pedido;
import java.util.Scanner;
public class PruebaPedido {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lee;
		lee=new Scanner(System.in);
		
		int res;
		
		Pedido p1, p2;
		p1=new Pedido(4,'N',3,"PayPal",true);
		p2=new Pedido(6,'D',9,"tarjeta de crédito",true);
		
		System.out.println("el monto a pagar es: "+p1.calculaMontoPagar());
		System.out.println("el monto a pagar es: "+p2.calculaMontoPagar());
		
		System.out.println("el número de cubiertos es: "+p2.calculaCubiertos());
		
		p1.setNumA(35);
		
		System.out.println("el número único es: "+p1.getNumU());
		res=p1.compareTo(p2);
		System.out.println("si el resultado es 1 o -1, entonces un pedido es mayor a otro"+res);
				
	
					
		
		System.out.println(p1.toString());
		
		
	}

}
