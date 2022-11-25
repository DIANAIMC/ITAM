package Ejecutables;
import Librerias.PokemonGoITAM;
import java.util.Scanner;

public class PruebaPokemonDianaAlejandro {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokemonGoITAM p1;
		p1=new PokemonGoITAM("DianaAlejandro");
	
			p1.altaPokemon("Butterfree", 'a', 100, "aire", 300);
			p1.altaPokemon("Raichu", 'b', 150, "electrico", 200);
			p1.altaPokemon("Charizard", 'c', 200, "fuego", 100);
			
			System.out.println(p1.cuantosTipo('b'));
			System.out.println(p1.promedioDef());
	}
}

