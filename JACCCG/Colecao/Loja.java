package JACCCG.Colecao;

import java.util.List;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Raridade;
import JACCCG.Exceptions.DinheirosInsuficientesException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoExepction;

public class Loja {

	private List<CartaDeColecao> cartas;

	public Loja(List<CartaDeColecao> cartas) {
		this.cartas = cartas;
	}

	public void vende(CartaDeColecao carta, Usuario comprador) throws DinheirosInsuficientesException{
		if(comprador.getDinheiros() >= carta.getPreco()) throw new DinheirosInsuficientesException("o pobreza");
		try{
			comprador.adicionaNaColecao(carta);
			comprador.perdeDinheiros(carta.getPreco());
		}catch(LimiteDeCartasExcedidoExepction e){
			//TODO tratar saporra
		}
	}

	public void compra(CartaDeColecao carta, Usuario vendedor) {

	}

	public List<CartaDeColecao> pesquisaCarta(String nome) {
		return null;
	}

	public List<CartaDeColecao> pesquisaCarta(Raridade raridade) {
		return null;
	}

	public List<CartaDeColecao> pesquisaCarta(int preco, boolean menorQue) {
		return null;
	}

	public List<CartaDeColecao> pesquisaCarta(int mana) {
		return null;
	}

	public List<CartaDeColecao> getCartas() {
		return null;
	}

}
