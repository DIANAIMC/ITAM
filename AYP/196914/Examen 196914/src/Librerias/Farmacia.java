package Librerias;

public class Farmacia {

	private String nombre;
	private String tel;
	private String rfc;
	private int total;
	private Medicamento[]m;
	private final int MAX=1000;
	
	public Farmacia() {
		total=0;
		m=new Medicamento[MAX];
	}

	public Farmacia(String nombre, String tel, String rfc) {
		this.nombre = nombre;
		this.tel = tel;
		this.rfc = rfc;
		total=0;
		m=new Medicamento[MAX];
	}
	
	public boolean altaMedicamento(String nombre, double costo, int cantidad, boolean receta) {
		boolean res=false;
		Medicamento med;
		if(total<m.length) {
			med=new Medicamento(nombre, costo, cantidad, receta);
			m[total]=med;
			total++;
			res=true;
		}
		return res;
	}
	public StringBuilder noNecesitanReceta() {
		StringBuilder cad=new StringBuilder();
		for(int i=0;i<total;i++) {
			if(m[i].isReceta()==false)
				cad.append("\n no requiere receta el medicamento: "+m[i].getNombre());
		}
		return cad;
	}
	public boolean comparaPrecioCant(double costo, int cantidad) {
		boolean res=false;
		int i=0;
		while(i<total && m[i].getCosto()==costo && cantidad<=m[i].getCantidad())
			i++;
		if(i!=total)
			res=true;
		return res;
	}
	
}
