package JACCCG.Colecao;

import java.util.List;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Raridade;
import JACCCG.Exceptions.BaralhoJaExistenteException;
import JACCCG.Exceptions.CartaNaoEncontradaException;
import JACCCG.Exceptions.CartaSendoUtilizadaException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoExepction;

public class Colecao {

	private List<CartaDeColecao> colecao;
	private List<RegistroDeBaralho> baralhos;

	public Colecao(List<CartaDeColecao> colecao, List<RegistroDeBaralho> baralhos) {
		this.colecao = colecao;
		this.baralhos = baralhos;
	}

	public boolean podeAdicionarCarta(CartaDeColecao carta) {
		Raridade raridade = carta.getRaridade();
		int cont = 0;
		for(CartaDeColecao c : colecao){
			if(c.equals(carta)) cont++;
			if(cont == raridade.ordinal()+1) return false;
		}
		return true;
	}

	public void adicionaCarta(CartaDeColecao carta) throws LimiteDeCartasExcedidoExepction{
		if(!podeAdicionarCarta(carta)) throw new LimiteDeCartasExcedidoExepction(":)");
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
		int cont = 0;
		for(RegistroDeBaralho baralho : baralhos){
			//TODO
			//for(CartaDeColecao c : baralho.getCartas()){
			//	if(c == carta)
			//}
			if(baralho.getCartas().contains(carta)) cont++;
			if(cont == carta.getRaridade().ordinal()+1) throw new CartaSendoUtilizadaException("heh");
		}
		if(!colecao.contains(carta)) throw new CartaNaoEncontradaException("banana");
		colecao.remove(carta);
	}

}
