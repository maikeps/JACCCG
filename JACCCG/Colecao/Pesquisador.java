package Colecao;

import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Cartas.Raridade;

public class Pesquisador {
	LinkedList<CartaDeColecao> cartas;
	
	public Pesquisador(LinkedList<CartaDeColecao> cartas){
		this.cartas = cartas;
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
}
