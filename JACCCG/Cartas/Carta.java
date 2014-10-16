package JACCCG.Cartas;

public class Carta {

	private String nome;
	private int ataque;
	private int defesa;
	private int custoMana;
	private int vida;
	private Raridade raridade;

	public Carta(String nome, int ataque, int defesa, int custoMana, int vida, Raridade raridade) {
		this.nome = nome;
		this.ataque = ataque;
		this.defesa = defesa;
		this.custoMana = custoMana;
		this.vida = vida;
		this.raridade = raridade;
	}

	public Raridade getRaridade() {
		return raridade;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public int getVida() {
		return vida;
	}

	public String getNome() {
		return nome;
	}

	public int getCustoMana() {
		return custoMana;
	}
	
	public String toString(){
		String string = "";
		
		string += "Nome: " + nome + "\n";
		string += "Ataque: " + ataque + "\n";
		string += "Defesa: " + defesa + "\n";
		string += "Custo de Mana: " + custoMana + "\n";
		string += "Vida: " + vida + "\n";
		string += "Raridade: " + raridade.name() + "\n";
		
		return string;
	}
}
