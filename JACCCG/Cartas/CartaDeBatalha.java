package Cartas;

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
		vidaAtual = vida;
		
	}

	public void perdeVida(int qtd) {
		qtd = (qtd < 0) ? 0 : qtd;
		vidaAtual -= qtd;
		if (vidaAtual <= 0) {
			vidaAtual = 0;
		}
	}

	public void ataca(CartaDeBatalha outra) {
		outra.perdeVida(this.getAtaque() - outra.getDefesa());
		this.perdeVida(outra.getAtaque() - this.getDefesa());
		//System.out.println(outra.getNome()+" levou "+(this.getAtaque() - outra.getDefesa())+" de dano.");
		//System.out.println(this.getNome()+" levou "+(outra.getAtaque() - this.getDefesa())+" de dano.");
		pronta = false;
	}
	
	public int calculaDanoContra(CartaDeBatalha oponente){
		int dano = this.getAtaque() - oponente.getDefesa();
		if(dano < 0) dano = 0;
		return dano;
	}
	
	public boolean estaMorta() {
		return vidaAtual <= 0;
	}
	
	public int getVidaAtual(){
		return vidaAtual;
	}
	
	public boolean podeAtacar() {
		return pronta;
	}

	public void setPronto(boolean pronto) {
		pronta = pronto;
	}

	public String toString(){
		return getNome() + " | A:" + getAtaque() + 
						   " | D:" + getDefesa() + 
						   " | V:" + getVidaAtual() + "/" + getVida() + 
						   " | C:" + getCustoMana() + 
						   " | " + (pronta ? "Pronta" : "Indisponivel");
	}
}
