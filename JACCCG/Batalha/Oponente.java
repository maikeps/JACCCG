package JACCCG.Batalha;

import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.MesaVaziaException;

public class Oponente extends Jogador {

	private String nome;

	public Oponente(String nome, Baralho baralho, int vida) {
		super(baralho, vida);
	}

	public boolean querJogar(){
		if(mesa.podeReceberCarta()){			
			for(int i = 0; i < getMao().getCartas().size(); i++){
				if(getMao().getCartas().get(i).getCustoMana() <= getManaPool()){
					return true;
				}
			}
		}
		return false;
	}
	
	public CartaDeBatalha selecionaCartaDaMao() {
		CartaDeBatalha c = (CartaDeBatalha) getMao().getCartas().get(0);
		for(int i = 0; i < getMao().getCartas().size(); i++){
			if(getMao().getCartas().get(i).getCustoMana() <= getManaPool()){
				c = (CartaDeBatalha) this.getMao().getCartas().get(i);
			}
		}return c;
	}

	
	public CartaDeBatalha selecionaAlvo(CartaDeBatalha atacante, Mesa mesaDoOponente) {
		if(mesaDoOponente.getCartas().isEmpty()) return null;
		CartaDeBatalha alvo = mesaDoOponente.getCartas().get(0);
		for(int i = 0; i < mesaDoOponente.getCartas().size(); i++){
			if(atacante.calculaDanoContra(alvo) < atacante.calculaDanoContra(mesaDoOponente.getCartas().get(i))){
				alvo = mesaDoOponente.getCartas().get(i);
			}
		}
		return alvo;
	}
		
	public CartaDeBatalha selecionaCartaAtacante() {
		CartaDeBatalha carta = this.getMesa().getCartas().get(0);
		for(int i = 0; i < getMesa().getCartas().size(); i++){
				if(carta.getAtaque() > getMesa().getCartas().get(i).getAtaque()){
					carta = getMesa().getCartas().get(i);
			}
		}
		return carta;
	}

	public void atacaDiretamente(Jogador jogador) {
		CartaDeBatalha atacante = selecionaCartaAtacante();
		jogador.perdeVida(atacante.getAtaque());
		atacante.setPronto(false);
	}

	public void ataca(Mesa mesaDoJogador) {
		CartaDeBatalha atacante = selecionaCartaAtacante();
		CartaDeBatalha alvo = selecionaAlvo(atacante, mesaDoJogador);
		atacante.ataca(alvo);
		if(alvo.estaMorta()){
			try {
				mesaDoJogador.removeCarta(alvo);
			} catch (MesaVaziaException e) {
				e.printStackTrace();
			}
		}
		if(atacante.estaMorta()){
			try {
				mesa.removeCarta(atacante);
			} catch (MesaVaziaException e) {
				e.printStackTrace();
			}
		}
	}

	public void processaTurno(Jogador jogador) {
		mesa.aprontaCartas();
		ganhaMana();
		compraCarta();
		while(querJogar()){
			jogaCarta(selecionaCartaDaMao());
		}
		while(mesa.temCartaPronta()){
			if(jogador.getMesa().getCartas().isEmpty()){
				atacaDiretamente(jogador);
			}else{
				ataca(jogador.getMesa());
			}
		}
		while(querJogar()){
			jogaCarta(selecionaCartaDaMao());
		}
	}

}
