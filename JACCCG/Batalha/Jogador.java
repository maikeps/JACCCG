package Batalha;

import Cartas.CartaDeBatalha;
import Exceptions.BaralhoVazioException;
import Exceptions.ManaInsuficienteException;
import Exceptions.MesaCheiaException;

public class Jogador {
	
	private final int MPT = 1;//mana por turno
	private final int MAX_MANA = 10;
	
	private Mao mao;
	private Baralho baralho;
	private int vida;
	private int manaPool;
	protected Mesa mesa;
	private int manaLimit;
	private int fatorFatiga;
	
	public Jogador(Baralho baralho, int vida) {
		this.baralho = baralho;
		mao = new Mao();
		this.manaLimit = 1;
		this.vida = vida;
		this.mesa = new Mesa(5);
		this.manaPool = 0;
		this.fatorFatiga = 0;
	}

	public void jogaCarta(CartaDeBatalha carta) throws MesaCheiaException, ManaInsuficienteException{
		if(carta.getCustoMana() > manaPool) throw new ManaInsuficienteException("Mana insuficiente");
		mesa.recebeCarta(carta);
		mao.removeCarta(carta);
		manaPool -= carta.getCustoMana();
	}
	
	public void iniciaTurno(){
		mesa.aprontaCartas();
		encheMana();
		ganhaMana();
		compraCarta();
	}
	
	public void encheMana(){
		manaPool = manaLimit;
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
		if(manaLimit < MAX_MANA){
			manaLimit += MPT;
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

	public void atacaDiretamente(Jogador inimigo, CartaDeBatalha atacante) {
		inimigo.perdeVida(atacante.getAtaque());
		atacante.setPronto(false);
	}

	public void iniciaPartida() {
		for(int i = 0; i < 4; i++){
			compraCarta();
		}
	}
}
