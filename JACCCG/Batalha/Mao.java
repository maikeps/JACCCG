package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.BaralhoVazioException;

public class Mao {

	private List<CartaDeBatalha> cartasDaMao;

	public Mao() {
		cartasDaMao = new LinkedList<CartaDeBatalha>();

	}

	public void removeCarta(CartaDeBatalha carta) {
		cartasDaMao.remove(carta);
	}

	public void compraCarta(Baralho baralho) throws BaralhoVazioException{
		cartasDaMao.add(baralho.getTopo());

	}

	public List<CartaDeBatalha> getCartas() {
		return cartasDaMao;
	}

}
