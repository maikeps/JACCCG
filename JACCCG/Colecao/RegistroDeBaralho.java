package JACCCG.Colecao;

import java.util.List;

import JACCCG.Cartas.CartaDeColecao;

public class RegistroDeBaralho {

	private List<CartaDeColecao> cartas;
	private String nome;
	private int maxCartas;

	public RegistroDeBaralho(List<CartaDeColecao> cartas, String nome, int maxCartas) {
		this.cartas = cartas;
		this.nome = nome;
		this.maxCartas = maxCartas;
	}

	public List<CartaDeColecao> getCartas() {
		return cartas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCartas(List<CartaDeColecao> cartas) {
		this.cartas = cartas;
	}

	public boolean jogavel() {
		return cartas.size() == maxCartas;
	}

	public boolean equals(Object outro){
		return nome == ((RegistroDeBaralho)outro).getNome();
	}
	
	public int getOcorrenciasCarta(CartaDeColecao carta){
		int cont = 0;
		for(CartaDeColecao c : cartas){
			if(carta.getNome().equals(c.getNome())) cont++;
		}
		return cont;
	}
}
