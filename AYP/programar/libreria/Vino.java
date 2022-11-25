package libreria;

public class Vino {
	private static int claveUnica=101;
	private int cu;
	private String nombre;
	private String origen;
	private String categoria;
	private int año;
	private String tipo;
	private double precio;

	public Vino(String nombre, String origen, String categoria, int año, String t, double p) {
		this.nombre=nombre;
		this.origen=origen;
		this.categoria=categoria;
		this.año=año;
		tipo=t;
		precio=p;
		cu=claveUnica;
		claveUnica=claveUnica+10;
	}
	public Vino(String t, double p) {
		tipo=t;
		precio=p;
		cu=claveUnica;
		claveUnica=claveUnica+10;
	}
	public double getPrecio() {
		return precio;
	}
	public String getOrigen() {
		return origen;
	}
	public void setPrecio(double p) {
		precio=p;
	}
	public double calculaVentaCaja(int numBotellas, String tipoPago) {
		double res;
		res=numBotellas*precio+20;
		if(tipoPago.equals("efectivo"))
			res=res-res*.036;
		else
			res=res-res*.02;
		res=res*.16+res;
		return res;
	}
	public double calculaVentaBotella(int numBotellas) {
		double res=numBotellas*precio;
		if(tipo.equals("crianza"))
			res=numBotellas*(precio+10);
		else
			if(tipo.equals("gran reserva"))
			res=numBotellas*(precio+20);
		return res;
	}
	public boolean equals(Vino v) {
		boolean res=false;
		if(claveUnica==v.claveUnica)
			res=true;
		return res;
	}
	public int compareTo(Vino v) {
		int res=-1;
		if(claveUnica==v.claveUnica)
			res=0;
		else
			if(claveUnica>v.claveUnica)
			res=1;
		return res;
	}
	public String toString() {
		String res;
		res="clave unica: "+cu+" nombre: "+nombre+" origen: "+origen+" categoria: "+categoria+" año: "+año+" tipo: "+tipo+" precio: "+precio;
		return res;		
	}
}
