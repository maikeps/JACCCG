package JACCCG.Batalha;

import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.MesaCheiaException;

public class Jogador {
	
	private final int MPT = 1;//mana por turno
	
	private Mao mao;
	private Baralho baralho;
	private int vida;
	private int manaPool;

	public Jogador(Baralho baralho, int vida, int manaPool) {
		this.baralho = baralho;
		mao = new Mao();
		this.vida = vida;
		this.manaPool = manaPool;
	}

	public void jogaCarta(Mesa mesa, CartaDeBatalha carta) {
		try {
			mesa.recebeCarta(carta);
		} catch (MesaCheiaException e) {
			//TODO ver se falta algo
		}
	}

	public void perdeVida(int qtd) {
		if((vida-=qtd) <= 0){
			vida = 0;
		}
	}

	public boolean estaMorto() {
		return vida == 0;
	}

	public int getVida() {
		return vida;
	}
	
	public int getManaPool() {
		return manaPool;
	}

	public Mao getMao() {
		return mao;
	}

	/**
	 *  
	 */
	public void ganhaMana() {
		manaPool+=MPT;
	}

	public void compraCarta() {
		mao.compraCarta(baralho);
	}

}
