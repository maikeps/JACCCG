package JACCCG.Cartas;

import java.util.LinkedList;
import java.util.List;

public class FabricaDeCartas {

	public static List<CartaDeColecao> criaCartas() {
		List<CartaDeColecao> listaDeCartas = new LinkedList<CartaDeColecao>();
		
		listaDeCartas.add(new CartaDeColecao("carta1",2,3,8,2048,Raridade.COMUM, 1));
		listaDeCartas.add(new CartaDeColecao("carta2",22,32,82,22048,Raridade.COMUM, 2));
		listaDeCartas.add(new CartaDeColecao("carta3",2,3,8,20482,Raridade.COMUM, 3));
		listaDeCartas.add(new CartaDeColecao("carta4",2,3,8,2048,Raridade.COMUM, 4));
		listaDeCartas.add(new CartaDeColecao("carta5",2,3,8,2048,Raridade.COMUM, 5));
		listaDeCartas.add(new CartaDeColecao("carta6",2,3,8,2048,Raridade.COMUM, 600));
		
		return  listaDeCartas;
	}
}
