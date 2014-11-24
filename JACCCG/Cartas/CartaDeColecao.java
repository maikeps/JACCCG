package Cartas;

import BD.Registravel;

public class CartaDeColecao extends Carta implements Registravel{

	private boolean disponivel;
	private int preco;
	private int id;

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
	
	public String toString(){
		//String string = "";
		return getNome() + " - " + "A:" + getAtaque() + " | D:" + getDefesa() + " | V:" + getVida() + " | C:" + getCustoMana() + " | Preco: " + getPreco();
		//string = super.toString();
		//string += "Pre�o: " + preco + "\n";
		
		//return string;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
}
