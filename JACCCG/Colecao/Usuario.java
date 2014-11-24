package Colecao;

import BD.Registravel;
import Cartas.CartaDeColecao;
import Exceptions.LimiteDeCartasExcedidoException;

public class Usuario implements Registravel{

	private Colecao colecao;
	private int dinheiros;
	private int id;

	public Usuario(Colecao colecao, int dinheiros) {
		this.colecao = colecao;
		this.dinheiros = dinheiros;
	}

	public void adicionaNaColecao(CartaDeColecao carta) throws LimiteDeCartasExcedidoException {
		colecao.adicionaCarta(carta);
	}

	public void ganhaDinheiros(int qtd) {
		dinheiros+=qtd;
	}

	public void perdeDinheiros(int qtd) {
		/**if((dinheiros-=qtd) <= 0){
			dinheiros = 0;
		}**/
		dinheiros -= qtd;
		
	}

	public int getDinheiros(){
		return dinheiros;
	}
	
	public Colecao getColecao() {
		return colecao;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

}
