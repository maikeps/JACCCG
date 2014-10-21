package JACCCG.Batalha;

public class Partida {

	private Jogador jogador;
	private Oponente oponente;
	private Juiz juiz;

	public Partida(Jogador jogador, Oponente oponente, Juiz juiz) {
		this.jogador = jogador;
		this.oponente = oponente;
	}

	public boolean acabou() {
		return jogador.estaMorto() || oponente.estaMorto();
	}

	public Jogador getVencedor() {
		if(acabou()){
			if(jogador.estaMorto()) return oponente;
			else return jogador;
		}
		return null;
	}

	public void processaTurnoOponente() {
		oponente.processaTurno(jogador);
	}

	public boolean podeAtacarDiretamente(Jogador atacante) {
		if(atacante instanceof Jogador){
			return oponente.getMesa().getCartas().isEmpty();
		}
		return jogador.getMesa().getCartas().isEmpty();
	}

	public void update() {

	}

	public Oponente getOponente() {
		return oponente;
	}

}
