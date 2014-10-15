package JACCCG.Cartas;

public class CartaDeColecao extends Carta {

	private boolean disponivel;

	private int preco;

	/**
	 *  
	 */
	public CartaDeColecao(String nome, int ataque, int defesa, int custoMana, int vida, Raridade raridade, int preco) {
		super(nome, ataque, defesa, custoMana, vida, raridade);
	}

	public int getPreco() {
		return 0;
	}

	public boolean estaDisponivel() {
		return false;
	}

	public void setDisponibilidade(boolean disponivel) {

	}

}
