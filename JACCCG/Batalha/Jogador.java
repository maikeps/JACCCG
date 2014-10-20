package JACCCG.Batalha;

import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.BaralhoVazioException;
import JACCCG.Exceptions.MesaCheiaException;

public class Jogador {
	
	private final int MPT = 1;//mana por turno
	private final int MAX_MANA = 10;
	
	private Mao mao;
	private Baralho baralho;
	private int vida;
	private int manaPool;
	protected Mesa mesa;
	
	private int fatorFatiga;
	
	public Jogador(Baralho baralho, int vida) {
		this.baralho = baralho;
		mao = new Mao();
		this.vida = vida;
		this.mesa = new Mesa(5);
		this.manaPool = 0;
		this.fatorFatiga = 0;
	}

	public void jogaCarta(CartaDeBatalha carta) {
		try {
			mesa.recebeCarta(carta);
			mao.removeCarta(carta);
			manaPool -= carta.getCustoMana();
		} catch (MesaCheiaException e) {
			//TODO ver se falta algo
		}
	}

	public Mesa getMesa(){
		return mesa;
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

	public void ganhaMana() {
		if(manaPool < MAX_MANA){
			manaPool+=MPT;
		}
	}

	public void compraCarta() {
		try{
			mao.compraCarta(baralho);
		}catch(BaralhoVazioException e){
			fatorFatiga++;
			perdeVida(fatorFatiga);
		}
	}

}
