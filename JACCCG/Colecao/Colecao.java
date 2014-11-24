package Colecao;

import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Exceptions.BaralhoJaExistenteException;
import Exceptions.CartaNaoEncontradaException;
import Exceptions.CartaSendoUtilizadaException;
import Exceptions.LimiteDeCartasExcedidoException;

public class Colecao {

	private List<CartaDeColecao> colecao;
	private List<RegistroDeBaralho> baralhos;
	private Pesquisador pesquisador;

	public Colecao(List<CartaDeColecao> colecao, List<RegistroDeBaralho> baralhos) {
		this.colecao = colecao;
		this.baralhos = baralhos;
		this.pesquisador = new Pesquisador((LinkedList<CartaDeColecao>)colecao);
	}

	/**public boolean podeAdicionarCarta(CartaDeColecao carta) {
		Raridade raridade = carta.getRaridade();
		int cont = 0;
		for(CartaDeColecao c : colecao){
			if(c.equals(carta)) cont++;
			if(cont == raridade.ordinal()+1) return false;
		}
		return true;
	}
	 **/
	public void adicionaCarta(CartaDeColecao carta) throws LimiteDeCartasExcedidoException{
	//	if(!podeAdicionarCarta(carta)) throw new LimiteDeCartasExcedidoException(":)");
		colecao.add(carta);
	}

	public List<CartaDeColecao> getCartas() {
		return colecao;
	}
	
	public List<RegistroDeBaralho> getBaralhos(){
		return baralhos;
	}

	public void addBaralho(RegistroDeBaralho baralho) throws BaralhoJaExistenteException{
		if(baralhos.contains(baralho)) throw new BaralhoJaExistenteException("caralho do seu avo ja existente");
		baralhos.add(baralho);
	}
	
	public void removeDaColecao(CartaDeColecao carta) throws CartaSendoUtilizadaException, CartaNaoEncontradaException{
		if(!colecao.contains(carta)) throw new CartaNaoEncontradaException("banana");
		int numOcorrenciaCarta = getOcorrenciasCarta(carta);
		for(RegistroDeBaralho baralho : baralhos){
			if(baralho.getOcorrenciasCarta(carta) == numOcorrenciaCarta){
				throw new CartaSendoUtilizadaException("heh");
			}
		}
		colecao.remove(carta);
	}
	

	public Pesquisador getPesquisador(){
		return pesquisador;
	}
	
	public int getOcorrenciasCarta(CartaDeColecao carta){
		int cont = 0;
		for(CartaDeColecao c : colecao){
			if(carta.getNome().equals(c.getNome())) cont++;
		}
		return cont;
	}
}