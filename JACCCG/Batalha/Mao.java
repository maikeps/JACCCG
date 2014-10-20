package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Exceptions.BaralhoVazioException;

public class Mao {

	private List<Carta> cartasDaMao;

	public Mao() {
		cartasDaMao = new LinkedList<Carta>();

	}

	public void removeCarta(Carta carta) {
		cartasDaMao.remove(carta);
	}

	public void compraCarta(Baralho baralho) throws BaralhoVazioException{
		cartasDaMao.add(baralho.getTopo());

	}

	public List<Carta> getCartas() {
		return cartasDaMao;
	}

}
