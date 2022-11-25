package ejecutables;
import libreria.Servicio;
public class EjecutableUber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servicio s1,s2;
		s1=new Servicio(345,2000,3523,'M',5,22,true);
		s2=new Servicio(102,2015,12856,'N',2,40,false);
		
		System.out.println("El monto a pagar es: "+s1.calculaMontoPagar());
		System.out.println("El monto a pagar es: "+s2.calculaMontoPagar());
		
		System.out.println("El servicio fué extenso: "+s2.servicioExtenso());
		
		System.out.println("El servicio fué pool: "+s2.getPool());
		System.out.println("Los servicios fueron iguales: "+s1.equals(s2));
		
		System.out.println(s1.StringTo());
		
		
	}

}
