package Batalha;

import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeBatalha;
import Exceptions.MesaCheiaException;
import Exceptions.MesaVaziaException;

public class Mesa {

	private int maxCartas;	
	private List<CartaDeBatalha> cartasNaMesa;

	public Mesa(int maxCartas) {
		cartasNaMesa = new LinkedList<CartaDeBatalha>();
		this.maxCartas = maxCartas;
	}

	public void recebeCarta(CartaDeBatalha carta) throws MesaCheiaException{
		if(!podeReceberCarta()) throw new MesaCheiaException("A mesa ja esta cheia");
		cartasNaMesa.add(carta);
	}

	public void removeCarta(CartaDeBatalha carta) throws MesaVaziaException{
		if(cartasNaMesa.size() == 0) throw new MesaVaziaException("A mesa nao possui cartas");
		cartasNaMesa.remove(carta);
	}

	public boolean podeReceberCarta(){
		return cartasNaMesa.size() < maxCartas;
	}
	
	public List<CartaDeBatalha> getCartas() {
		return cartasNaMesa;
	}
	
	public int getMaxCartas(){
		return maxCartas;
	}

	public void aprontaCartas() {
		for(CartaDeBatalha c : cartasNaMesa){
			c.setPronto(true);
		}
	}

	public boolean temCartaPronta() {
		for(CartaDeBatalha c : cartasNaMesa){
			if(c.estaMorta()) return true;
		}
		return false;
	}
	
	public String toString(){
		if(cartasNaMesa.size() == 0) return "Mesa vazia";
		String str = "";
		for(int i = 1; i <= getCartas().size(); i++){
			str += i + " - " + getCartas().get(i-1) + "\n";
		}
//		CartaDeBatalha c = getCartas().get(0);
//		for(int i = 0; i < this.getCartas().size(); i++){
//			c = getCartas().get(i);
//			str += (i+1) + " - "+ c.getNome() + " " + "A:" + c.getAtaque() + " D:" + c.getDefesa() + " V:" + c.getVidaAtual()+"\t";
//			str += (c.podeAtacar()) ? "(Pronta)\n" : "(Indisponivel)\n";
//		}
		return str;
	}

}
