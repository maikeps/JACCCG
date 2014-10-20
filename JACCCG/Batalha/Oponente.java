package JACCCG.Batalha;

import JACCCG.Cartas.CartaDeBatalha;

public class Oponente extends Jogador {

	private String nome;

	/**
	 *  
	 *  
	 *  
	 *  
	 *  
	 */
	public Oponente(String nome, Baralho baralho, int vida, int manaPool) {
		super(baralho, vida, manaPool);
	}

	public boolean querJogar(Mesa mesa){
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

	
	public CartaDeBatalha selecionaAlvo(Mesa mesaDoOponente) {
		CartaDeBatalha atacante = selecionaCartaAtacante();
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

}
