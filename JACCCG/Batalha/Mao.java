package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;

public class Mao {

	private List<Carta> cartasDaMao;

	public Mao() {
		cartasDaMao = new LinkedList<Carta>();

	}

	public void removeCarta(Carta carta) {
		cartasDaMao.remove(carta);
	}

	public void compraCarta(Baralho baralho) {
		cartasDaMao.add(baralho.getTopo());

	}

	public List<Carta> getCartas() {
		return cartasDaMao;
	}

}
