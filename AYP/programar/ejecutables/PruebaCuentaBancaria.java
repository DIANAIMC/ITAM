package ejecutables;
import libreria.CuentaBancaria;
import java.util.*;
public class PruebaCuentaBancaria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res;
		int res1;
		CuentaBancaria c1, c2;
		c1=new CuentaBancaria("Jose Perez", 3000);
		c2=new CuentaBancaria("Juana Garcia", 0);
		
		System.out.println(c2+"hizo un depósito de $4000"+ c1.deposito(4000));
		System.out.println(c1+"hizo un retiro de $10,000"+ c1.retiro(10000));
		System.out.println(c1+"hizo un depósito de $1000"+ c1.deposito(1000));
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		
		res=c1.equals(c2);
		System.out.println("la cuenta 1 es igual a la cuenta 2: " + res);
		res1=c1.compareTo(c2);
		System.out.println("la cuenta 1 es igual a la cuenta 2: " + res1);}

}
