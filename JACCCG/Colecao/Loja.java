package JACCCG.Colecao;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Raridade;
import JACCCG.Exceptions.CartaNaoEncontradaException;
import JACCCG.Exceptions.CartaSendoUtilizadaException;
import JACCCG.Exceptions.DinheirosInsuficientesException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoException;

public class Loja {

	private List<CartaDeColecao> cartas;

	public Loja(List<CartaDeColecao> cartas) {
		this.cartas = cartas;
	}
	/**
	 * Os nomes dos pr�ximos dois m�todos, est�o do POV da Loja.
	 */
	public void vende(CartaDeColecao carta, Usuario comprador) throws DinheirosInsuficientesException{
		if(comprador.getDinheiros() >= carta.getPreco()) throw new DinheirosInsuficientesException("o pobreza");
		try{
			comprador.adicionaNaColecao(carta);
			comprador.perdeDinheiros(carta.getPreco());
		}catch(LimiteDeCartasExcedidoException e){
			System.out.println("N�o pode comprar.");
		}
	}

	public void compra(CartaDeColecao carta, Usuario vendedor) throws CartaNaoEncontradaException {
		try{
			System.out.println("O Vendedor tinha: " + vendedor.getDinheiros());
			vendedor.getColecao().removeDaColecao(carta);
			vendedor.ganhaDinheiros(carta.getPreco());
			System.out.println("A Loja comprou a carta: " + carta.getNome() +";"+ " O usu�rio agora tem: " + vendedor.getDinheiros());
		}catch(CartaSendoUtilizadaException a){
			System.out.println("N�o pode vender.");
		}
	}

	public List<CartaDeColecao> pesquisaCarta(String nome) {
		List<CartaDeColecao> temporario = new LinkedList<CartaDeColecao>();
		for (int i = 0; i < cartas.size(); i++) {
			if (cartas.get(i).getNome().toLowerCase()
					.contains(nome.toLowerCase())) {
				temporario.add(cartas.get(i));
			}
		}
		return temporario;
	}

	public List<CartaDeColecao> pesquisaCarta(Raridade raridade) {
		List<CartaDeColecao> temporario = new LinkedList<CartaDeColecao>();
		for (int i = 0; i < cartas.size(); i++) {
			if (cartas.get(i).getRaridade() == raridade) {
				temporario.add(cartas.get(i));
			}
		}
		return temporario;
	}

	public List<CartaDeColecao> pesquisaCarta(int preco, boolean menorQue) {
		List<CartaDeColecao> temporario = new LinkedList<CartaDeColecao>();
		for(int i = 0; i < cartas.size(); i ++){
			if(menorQue && cartas.get(i).getPreco() <= preco){
				temporario.add(cartas.get(i));
			}else if(!menorQue && cartas.get(i).getPreco() >= preco){
				temporario.add(cartas.get(i));
			}
		}
		return temporario;
	}

	public List<CartaDeColecao> pesquisaCarta(int mana) {
		List<CartaDeColecao> temporario = new LinkedList<CartaDeColecao>();
		for(int i = 0; i < cartas.size(); i++){
			if(cartas.get(i).getCustoMana() == mana){
				temporario.add(cartas.get(i));
			}
		}
		return temporario;
	}

	public List<CartaDeColecao> getCartas() {
		return cartas;
	}

}
