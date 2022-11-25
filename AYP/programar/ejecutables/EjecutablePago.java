package ejecutables;
import libreria.Pago;
public class EjecutablePago {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pago p1;
		p1=new Pago(567.5,"PP",3.5,5699,true);
		System.out.print(p1.toString());	
		System.out.print(p1.calculaComision());
		System.out.print(p1.calculaIva());
		System.out.print(p1.montoTotal());
	
	}

}
