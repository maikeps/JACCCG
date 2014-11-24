package Batalha;

import java.util.List;

import Cartas.CartaDeColecao;
import Colecao.Loja;

public class Juiz {

	private Loja loja;

	private static Juiz instancia;

	/**
	 *  
	 */
	private Juiz() {

	}

	public void disponibilizaCarta(String carta) {
		//TODO testar para saber se .getCartas pega uma cópia da lista ou pega a lista em si.
		List<CartaDeColecao> c = loja.getCartas();
		(c.get(c.indexOf(carta))).setDisponibilidade(true);
		
	}

	public static Juiz getInstance() {
		if(instancia == null){
			instancia = new Juiz();
		};
		
		return instancia;
	}

}
