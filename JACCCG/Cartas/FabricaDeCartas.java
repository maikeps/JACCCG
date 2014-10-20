package JACCCG.Cartas;

import java.util.LinkedList;
import java.util.List;

public class FabricaDeCartas {

	public static List<Carta> criaCartas() {
		List<Carta> listaDeCartas = new LinkedList<Carta>();
		
		listaDeCartas.add(new CartaDeColecao("Goblin1", 1, 1, 1, 1, Raridade.COMUM, 100));
		listaDeCartas.add(new CartaDeColecao("Goblin2", 1, 2, 1, 1, Raridade.COMUM, 110));
		listaDeCartas.add(new CartaDeColecao("Goblin3", 2, 1, 1, 1, Raridade.INCOMUM, 201));
		listaDeCartas.add(new CartaDeColecao("Goblin4", 2, 2, 2, 2, Raridade.INCOMUM, 205));
		listaDeCartas.add(new CartaDeColecao("Goblin5", 3, 2, 2, 3, Raridade.RARA, 650));
		listaDeCartas.add(new CartaDeColecao("Humanoide1", 1, 2, 1, 2, Raridade.COMUM, 50));
		listaDeCartas.add(new CartaDeColecao("Humanoide2", 1, 2, 1, 4, Raridade.COMUM, 130));
		listaDeCartas.add(new CartaDeColecao("Humanoide3", 2, 2, 2, 2, Raridade.INCOMUM, 290));
		listaDeCartas.add(new CartaDeColecao("Humanoide4", 2, 3, 2, 3, Raridade.INCOMUM, 140));
		listaDeCartas.add(new CartaDeColecao("Humanoide5", 2, 3, 3, 3, Raridade.RARA, 540));
		listaDeCartas.add(new CartaDeColecao("Fera1", 4, 0, 4, 2, Raridade.INCOMUM, 300));
		listaDeCartas.add(new CartaDeColecao("Fera2", 5, 0, 2, 2, Raridade.RARA, 500));
		listaDeCartas.add(new CartaDeColecao("Monstruoso1", 6, 3, 6, 4, Raridade.INCOMUM, 350));
		listaDeCartas.add(new CartaDeColecao("Monstruoso2", 5, 2, 5, 4, Raridade.RARA, 600));

		return  listaDeCartas;
	}
}
