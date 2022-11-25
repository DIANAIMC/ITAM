package ejecutable;
import libreria.Competencia;
public class PruebaCom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Competencia c=new Competencia();
		boolean res;
		res=c.altaReceta("vegana", 2, 25, 0, 1);
		if(res)
			System.out.println("alta exitosa");
		else 
			System.out.println("falla alta");
		res=c.altaReceta("vegana", 3, 50, 3, 3);
		if(res)
			System.out.println("alta exitosa");
		else 
			System.out.println("falla alta");
		
		System.out.println("El restaurante que utilizó mas ingredientes para su receta vegana fue:"+c.RecetaConMasIngrediente("vegana"));

	}

}
