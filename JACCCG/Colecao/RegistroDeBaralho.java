package JACCCG.Colecao;

import JACCCG.Cartas.Carta;
import java.util.List;

public class RegistroDeBaralho {

	private List<Carta> cartas;
	private String nome;
	private int maxCartas;

	public RegistroDeBaralho(List<Carta> cartas, String nome, int maxCartas) {
		this.cartas = cartas;
		this.nome = nome;
		this.maxCartas = maxCartas;
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCartas(List<Carta> cartas) {
		this.cartas = cartas;
	}

	public boolean jogavel() {
		return cartas.size() == maxCartas;
	}

}
