package JACCCG.Cartas;

public class CartaDeBatalha extends Carta {

	private boolean pronta;

	/**
	 *  
	 */
	public CartaDeBatalha(String nome, int ataque, int defesa, int custoMana, int vida, Raridade raridade) {
		super(nome, ataque, defesa, custoMana, vida, raridade);
	}

	public void perdeVida(int qtd) {

	}

	public void ataca(Carta outra) {

	}

	public boolean estaMorta() {
		return false;
	}

	public boolean podeAtacar() {
		return false;
	}

	public void CartaDeBatalha() {

	}

	public void setPronto(boolean pronto) {

	}

}
