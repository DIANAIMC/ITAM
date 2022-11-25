package Ejecutables;
import Librerias.Fonda;
public class PruebaFonda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fonda f;
		boolean res;
		f=new Fonda("Ana","555");
		res=f.altaPlatillo("ensalada", 63.0, 5, true);
		if (res)
			System.out.println("alta exitosa");
		res=f.altaPlatillo("caldo tlalpeño", 120.0, 10, false);
		if (res)
			System.out.println("alta exitosa");
		res=f.altaPlatillo("tortilla española", 85.0, 3, true);
		if (res)
			System.out.println("alta exitosa");
		
		System.out.println("el platillo más caro es: "+ f.masCaro());
		System.out.println("información del platillo con clave 200"+f.datos(200));
	}

}
