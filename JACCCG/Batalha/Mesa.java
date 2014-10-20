package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.MesaCheiaException;
import JACCCG.Exceptions.MesaVaziaException;

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
		String str = "";
		for(Carta c : getCartas()){
			str += c.getNome() + " " + "A:" + c.getAtaque() + " D:" + c.getDefesa() + " V:" + c.getVida() + "\n";
		}
		System.out.println(str);
		return str;
	}

}
