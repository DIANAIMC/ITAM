package libreria;

public class CientificoMatematico {
	private String nombre;
	private String areaEspecialidad;
public CientificoMatematico() {
}
public CientificoMatematico (String nombre, String areaEspecialidd) {
	this.nombre=nombre;
	this.areaEspecialidad=areaEspecialidad;
}
	public String getnombre(){
		return nombre;
	}
	public String getareaEspecialidad(){
		return areaEspecialidad;
	}
	public void setareaEspecialidad (String a){
		areaEspecialidad=a;
	}
	public String toString(){
		String cad; 
		cad="nombre es"+ nombre + "área de especialidad es" + areaEspecialidad;
		return cad;
	}
	//funciones propias de la clase
	public boolean estaOrdenCreciennte(int numero1, int numero2) {
		boolean res=false;
				if(numero2>numero1)
					res=true;
					return res;
	}
	public String ordenCreciente(int numero1, int numero2) {
		String res;
		if(numero1<numero2)
			res=numero1+"-"+numero2;
		else
			res=numero2+"-"+numero1;
		return res;
	}
	public boolean esImpar (int numero) {
		boolean res;
			if(numero%2!=0)
				res=true;
			else
				res=false;
		return res;
	}
	public double calculaFuncion1 (double x){
		double res;
		if (x<=11)
			res=3*x+36;
		else
			if (x<=33)
				res=x*x-10;
			else 
				if (x<64)
					res=x+6;
				else
					res=0;
		return res;
		
	}
	public double calculaFuncion2 (int x){
		double res;
		if (x%4==0)
			res=x*x;
		else
			if (x%4==1)
				res=x/6;
			else 
				if (x%4==2)
					res=Math.sqrt(x);
				else
					res=Math.pow(x, 3)+5;
		return res;
		
	}
	public double calculaFuncion3 (int num, int v){
		double res;
		if (num==1)
			res=100*v;
		else
			if (num==2)
				res=Math.pow(100, v);
			else 
				if (num==3)
					res=100/v;
				else
					res=0;
		return res;
		
	}
}
