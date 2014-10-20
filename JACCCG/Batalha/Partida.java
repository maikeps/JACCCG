package JACCCG.Batalha;

public class Partida {

	private Jogador jogador;
	private Oponente oponente;
	private Juiz juiz;

	public Partida(Jogador jogador, Oponente oponente, Juiz juiz) {

	}

	public boolean acabou() {
		return false;
	}

	public Jogador getVencedor() {
		return null;
	}

	public void processaTurnoOponente() {

	}

	public void processaTurnoJogador() {

	}

	/**
	 *  
	 */
	public boolean podeAtacarDiretamente(Mesa mesa) {
		return false;
	}

	public void update() {

	}

}
