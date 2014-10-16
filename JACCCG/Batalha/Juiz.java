package JACCCG.Batalha;

import JACCCG.Colecao.Loja;

public class Juiz {

	private Loja loja;

	private static Juiz instancia;

	/**
	 *  
	 */
	private Juiz() {
		//loja = new Loja();
	}

	public void disponibilizaCarta(String carta) {
		//lo
	}

	public static Juiz getInstance() {
		if(instancia == null){
			instancia = new Juiz();
		};
		
		return instancia;
	}

}
