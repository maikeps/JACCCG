package Batalha;

import java.text.DecimalFormat;

import BD.Registravel;
import Cartas.CartaDeBatalha;
import Cartas.CartaDeColecao;
import Controle.Logger;
import Exceptions.ManaInsuficienteException;
import Exceptions.MesaCheiaException;
import Exceptions.MesaVaziaException;

public class Oponente extends Jogador implements Registravel{

	private String nome;
	private int recompensa;
	private int id;
	private int vezesDerrotado;
	private int vezesBatalhado;
	private CartaDeColecao cartaEquivalente;

	public Oponente(String nome, Baralho baralho, int vida, int recompensa, int vezesDerrotado, int vezesBatalhado, CartaDeColecao cartaEquivalente) {
		super(baralho, vida);
		this.nome = nome;
		this.recompensa = recompensa;
		this.vezesBatalhado = vezesBatalhado;
		this.vezesDerrotado = vezesDerrotado;
		this.addObserver(Logger.getInstance());
		this.cartaEquivalente = cartaEquivalente;
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
		if(mesaDoOponente.getCartas().isEmpty()) 
			return null;
		CartaDeBatalha alvo = mesaDoOponente.getCartas().get(0);
		for(int i = 0; i < mesaDoOponente.getCartas().size(); i++){
			if(atacante.calculaDanoContra(alvo) < atacante.calculaDanoContra(mesaDoOponente.getCartas().get(i))){
				alvo = mesaDoOponente.getCartas().get(i);
			}
		}
		return alvo;
	}
		
	public CartaDeBatalha selecionaCartaAtacante() {
		CartaDeBatalha carta = null;
		CartaDeBatalha temp = getMesa().getCartas().get(0);
		for(CartaDeBatalha c : getMesa().getCartas()){
			if(temp.getAtaque() >= c.getAtaque() && c.podeAtacar()){
					carta = c;
					temp = c;
			}
		}
		return carta;
	}

	public void ataca(Mesa mesaDoJogador) {
		CartaDeBatalha atacante = selecionaCartaAtacante();
		CartaDeBatalha alvo = selecionaAlvo(atacante, mesaDoJogador);
		atacante.ataca(alvo);
		this.setChanged();
		this.notifyObservers(atacante.getNome() + "("+atacante.getAtaque()+") atacou "+alvo.getNome()+"("+alvo.getDefesa()+")");
		if(alvo.estaMorta()){
			try {
				mesaDoJogador.removeCarta(alvo);
				this.setChanged();
				this.notifyObservers("Alvo " +alvo.getNome()+" morreu");
			} catch (MesaVaziaException e) {
				e.printStackTrace();
			}
		}
		if(atacante.estaMorta()){
			try {
				mesa.removeCarta(atacante);
				this.setChanged();
				this.notifyObservers("Atacante" +atacante.getNome()+" morreu");
			} catch (MesaVaziaException e) {
				e.printStackTrace();
			}
		}
	}

	public void processaTurno(Jogador jogador) {
		iniciaTurno();
		while(querJogar()){
			try {
				jogaCarta(selecionaCartaDaMao());
			} catch (MesaCheiaException | ManaInsuficienteException e){}
		}
		while(mesa.temCartaPronta()){
			CartaDeBatalha carta = selecionaCartaAtacante();
			if(carta == null) break;
			if(jogador.getMesa().getCartas().isEmpty()){
				atacaDiretamente(jogador, carta );
			}else{
				ataca(jogador.getMesa());
			}
		}
		while(querJogar()){
			try {
				jogaCarta(selecionaCartaDaMao());
			} catch (MesaCheiaException | ManaInsuficienteException e){}
		}
	}
	
	public String getNome(){
		return nome;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getRecompensa(){
		return recompensa;
	}
	
	public int getVezesDerrotado(){
		return vezesDerrotado;
	}
	
	public int getVezesBatalhado(){
		return vezesBatalhado;
	}
	
	public String toString(){
		double vitoria = ((double)vezesDerrotado/vezesBatalhado)*100;
		vitoria = (vitoria > 0) ? vitoria : 0;
		DecimalFormat f = new DecimalFormat();
		return "Oponente "+nome+": \t"+(int)vitoria+"% de vitorias ("+vezesDerrotado+"/"+vezesBatalhado+") \t Recompensa: "+recompensa+" dinheiros";
	}

	public void aumentaVezesDerrotado() {
		vezesDerrotado++;
	}
	
	public void aumentaVezesBatalhado() {
		vezesBatalhado++;
	}
	
	public CartaDeColecao getCartaEquivalente(){
		return cartaEquivalente;
	}
}
