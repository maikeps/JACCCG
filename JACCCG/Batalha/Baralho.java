package JACCCG.Batalha;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Colecao.RegistroDeBaralho;

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

	public Carta getTopo() {
		return pilhaDeCartas.pop();
	}

}
