package Colecao;

import java.util.LinkedList;
import java.util.List;

import BD.DAOController;
import Cartas.CartaDeColecao;
import Exceptions.CartaNaoEncontradaException;
import Exceptions.CartaSendoUtilizadaException;
import Exceptions.DinheirosInsuficientesException;
import Exceptions.LimiteDeCartasExcedidoException;

public class Loja {

	private List<CartaDeColecao> cartas;
	
	private Pesquisador pesquisador;
	
	public Loja(List<CartaDeColecao> cartas) {
		this.cartas = cartas;
		pesquisador = new Pesquisador((LinkedList<CartaDeColecao>)cartas);
	}
	/**
	 * Os nomes dos proximos dois metodos, estao do POV da Loja.
	 * @throws LimiteDeCartasExcedidoException 
	 */
	public void vende(CartaDeColecao carta, Usuario comprador) throws DinheirosInsuficientesException, LimiteDeCartasExcedidoException{
		if(comprador.getDinheiros() < carta.getPreco()) throw new DinheirosInsuficientesException("o pobreza");
//		try{
		if(comprador.getColecao().getOcorrenciasCarta(carta) >= carta.getRaridade().ordinal()+1) throw new LimiteDeCartasExcedidoException("Nao pode comprar mais dessa carta");
			comprador.adicionaNaColecao(carta);
			comprador.perdeDinheiros(carta.getPreco());
//		}catch(LimiteDeCartasExcedidoException e){
//			System.out.println("Naum Pode comprar.");
//		}
	}

	public void compra(CartaDeColecao carta, Usuario vendedor) throws CartaNaoEncontradaException {
		try{
			vendedor.getColecao().removeDaColecao(carta);
			vendedor.ganhaDinheiros(carta.getPreco());
		}catch(CartaSendoUtilizadaException a){
			System.out.println("Nao pode vender.");
		}
	}
	
	
	public Pesquisador getPesquisador(){
		return pesquisador;
	}
	
	public List<CartaDeColecao> getCartas() {
		return cartas;
	}
	
}
