package Batalha;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Cartas.Carta;
import Cartas.CartaDeBatalha;
import Cartas.CartaDeColecao;
import Colecao.RegistroDeBaralho;
import Exceptions.BaralhoVazioException;

public class Baralho {

	private Stack<CartaDeBatalha> pilhaDeCartas;

	public Baralho(RegistroDeBaralho baralho) {
		List<CartaDeColecao> copia = baralho.getCartas();
		pilhaDeCartas = new Stack<CartaDeBatalha>();
		for(Carta carta : copia){
			CartaDeBatalha cb = new CartaDeBatalha(carta.getNome(), carta.getAtaque(), carta.getDefesa(), carta.getCustoMana(), carta.getVida(), carta.getRaridade());
			pilhaDeCartas.add(cb);
		}
		Collections.shuffle(pilhaDeCartas);
	}

	public CartaDeBatalha getTopo() throws BaralhoVazioException {
		if(pilhaDeCartas.size() == 0) throw new BaralhoVazioException("Baralho vazio");
		return pilhaDeCartas.pop();
	}

}
