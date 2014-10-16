package JACCCG.Colecao;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Exceptions.LimiteDeCartasExcedidoExepction;

public class Usuario {

	private Colecao colecao;
	private int dinheiros;

	public Usuario(Colecao colecao, int dinheiros) {
		this.colecao = colecao;
		this.dinheiros = dinheiros;
	}

	public void adicionaNaColecao(CartaDeColecao carta) throws LimiteDeCartasExcedidoExepction {
		colecao.adicionaCarta(carta);
	}

	public void ganhaDinheiros(int qtd) {
		dinheiros+=qtd;
	}

	public void perdeDinheiros(int qtd) {
		if((dinheiros-=qtd) <= 0){
			dinheiros = 0;
		}
	}

	/**
	 *  
	 */
	public Colecao getColecao() {
		return colecao;
	}

}
