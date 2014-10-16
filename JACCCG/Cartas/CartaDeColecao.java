package JACCCG.Cartas;

public class CartaDeColecao extends Carta {

	private boolean disponivel;
	private int preco;

	/**
	 *  
	 */
	public CartaDeColecao(String nome, int ataque, int defesa, int custoMana, int vida, Raridade raridade, int preco) {
		super(nome, ataque, defesa, custoMana, vida, raridade);
		this.preco = preco;
		disponivel = false;
	}

	public int getPreco() {
		return preco;
	}

	public boolean estaDisponivel() {
		return disponivel;
	}

	public void setDisponibilidade(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public boolean equals(Object outra){
		return this.getNome() == ((CartaDeColecao)outra).getNome();
	}
	
}
