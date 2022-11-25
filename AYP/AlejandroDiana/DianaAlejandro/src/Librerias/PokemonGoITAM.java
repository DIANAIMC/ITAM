//package Librerias;
//
//public class PokemonGoITAM {
//	private String nombre;
//    private String[] pokemones;
//    private final int MAX=500;
//    private PokemonGoITAM []p;
//    private int ocupados;
//    private int np;
//    
//     public PokemonGoITAM(){
//         p = new PokemonGoITAM[MAX];
//         np++;
//     }
//    public PokemonGoITAM(String nombre) {
//        this();
//        this.nombre = nombre;
//        np=0;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String[] getPokemon() {
//        return pokemones;
//    }
//
//    public void setPokemon(String[] pokemon) {
//        this.pokemones = pokemon;
//    }
//
//    public int getMAX() {
//        return MAX;
//    }
//
//    public int getOcupados() {
//
//         return ocupados;
//    }
//
//    public void setOcupados(int ocupados) {
//        this.ocupados = ocupados;
//    }
//    public boolean altaPokemon(String nombre,char tipo, int defensa, String especie, int ataque) {
//        boolean res=false;
//        PokemonGoITAM pin;
//        if(np<p.length) {
//            pin = new PokemonGoITAM();
//            p[np]=pin;
//            np++;
//            res=true;
//        }
//        return res;
//    }
//
//    public double promedioDef(){
//         double promedio;
//         double suma=0;
//         for (int i=0; i<np; i++){
//             suma += p.getDefensa[i];
//         }
//         promedio= suma/np;
//         return promedio;
//    }
//	public int cuantosTipo(char tipo) {
//		int res=0;
//		for(int i=0; i<ocupados; i++)
//			if(tipo==p.getTipo());
//				res++;
//		return res;
//	
//	}
//}
//
package Librerias;


public class PokemonGoITAM {
	private String nombre;
	private Pokemon[]pokemones;
	private int ocupados;
	private final int MAX=500;
	
	public PokemonGoITAM() {
		super();
		pokemones=new Pokemon[MAX];
	}
	public PokemonGoITAM(String nombre) {
		super();
		this.nombre = nombre;
		pokemones=new Pokemon[MAX];
		this.ocupados=ocupados;
	}
	
	public static boolean darAltaPokemon(String nombre, char tipo, String especie, int valorAtaque, int valorDefensa, int numAtaque,int clave) {
		boolean res=false;
		int np=0;
		Pokemon pok;
		//debe ser menor a 
		if(np<ocupados) {
			pok= new Pokemon(nombre,tipo,especie,valorAtaque,valorDefensa,numAtaque,clave);
			np++;
			res=true;
		}
		return res;
	}
	
	public static int buscaSecuenciaDes(Pokemon[]a, int numA, char valor) {
		int i=0;
		while (i<numA && a[i]!=valor)
		i++;
		if(i==numA || a[i] !=valor)
		i=-i-1;
		return i;
		}
	
	public static int numPokemonesTipo(char tipo) {
		int res=buscaSecuencaDes(pokemones,ocupados,tipo);
		int i=0;
		if(res>=0)
			i++;
		return i;
			
	}
	public static double sumaArre(Pokemon[]c, int num) {
		double suma=0;
		for (int i=0; i<num;i++)
		suma+=c[i];
		return suma;
	}
	
	public static double promedioArre(double []c, int num) {
		return sumaArre (c,num)/num;
		}
	
	public static double promDefensa() {
		double res=promedioArre(pokemones,ocupados);
	}
	
	
	

}


