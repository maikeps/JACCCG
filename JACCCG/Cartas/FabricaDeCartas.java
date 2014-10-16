package JACCCG.Cartas;

import java.util.LinkedList;
import java.util.List;

public class FabricaDeCartas {

	public static List<Carta> criaCartas() {
		List<Carta> listaDeCartas = new LinkedList<Carta>();
		
		listaDeCartas.add(new Carta("assovio",2,3,8,2048,Raridade.COMUM));
		listaDeCartas.add(new Carta("assovio2",22,32,82,22048,Raridade.COMUM));
		listaDeCartas.add(new Carta("assovi3o",2,3,8,20482,Raridade.COMUM));
		listaDeCartas.add(new Carta("assov3io",2,3,8,2048,Raridade.COMUM));
		listaDeCartas.add(new Carta("assovi4o",2,3,8,2048,Raridade.COMUM));
		listaDeCartas.add(new Carta("assovi5o",2,3,8,2048,Raridade.COMUM));
		
		return  listaDeCartas;
	}
}
