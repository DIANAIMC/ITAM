package Librerias;

public class Fonda {
	private String nombre;
	private String tel;
	private int numPlatillos;
	private Platillo[]p;
	private final int MAX=20;
	
	public Fonda(String nombre, String tel) {
		this.nombre=nombre;
		this.tel=tel;
		numPlatillos=0;
		p=new Platillo[MAX];
	}
	
	public boolean altaPlatillo(String nombre, double precio, int numIngredientes,
			boolean esVegetariano) {
		boolean res=true;
		Platillo a;
		if(numPlatillos<MAX) {
			a=new Platillo(nombre,precio,numIngredientes,esVegetariano);
			p[numPlatillos]=a;
			numPlatillos++;
			res=true;
		}
		return res;
	}
	public String masCaro() {
		String res="";
		int max=0;
		for(int i=0;i<numPlatillos;i++)
			if(p[max].getPrecio()<p[i].getPrecio())
				max=1;
		res=p[max].toString();
		return res;
	}
	public String datos(int clave) {
		String res="";
		int i=0;
		while(i<numPlatillos && p[i].getClaveU()!=clave)
			i++;
		if(i<numPlatillos && p[i].getClaveU()==clave)
			res=p[i].toString();
		return res;
	}
}
