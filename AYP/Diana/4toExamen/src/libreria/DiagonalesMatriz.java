package libreria;
/*
 * Nombre:Diana muñoz
 * Fecha:18.nov.20
 */
public class DiagonalesMatriz {

	public static <T> String matrizDiagEs(T[][]mat, int nr, int nc) {
		int renglones=0, columnas=0;
		StringBuilder lista=new StringBuilder();
		if(nr==nc){
			//diagonal abajo
			while(renglones<nr) {
				if(mat[renglones+1][columnas].toString().startsWith("es")) {
					lista.append(mat[renglones+1][columnas]+" ");
					renglones++;
					columnas++;
				}
			//diagonal arriba
				if(mat[renglones][columnas+1].toString().startsWith("es")) {
					lista.append(mat[renglones][columnas+1]+" ");
					renglones++;
					columnas++;
				}
			}
		}
		return lista.toString();
	}
}

