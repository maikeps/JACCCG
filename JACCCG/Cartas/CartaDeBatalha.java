package JACCCG.Cartas;

public class CartaDeBatalha extends Carta {

	private boolean pronta;
	private int vidaAtual;

	/**
	 *  
	 */
	public CartaDeBatalha(String nome, int ataque, int defesa, int custoMana,
			int vida, Raridade raridade) {
		super(nome, ataque, defesa, custoMana, vida, raridade);
		pronta = false;
	}

	public void perdeVida(int qtd) {
		if ((vidaAtual -= qtd) <= 0) {
			vidaAtual = 0;
		}
	}

	public void ataca(CartaDeBatalha outra) {
		outra.perdeVida(this.getAtaque() - outra.getDefesa());
	}

	public boolean estaMorta() {
		return vidaAtual == 0;
	}

	public boolean podeAtacar() {
		return pronta;
	}

	public void setPronto(boolean pronto) {
		pronta = pronto;
	}

}
