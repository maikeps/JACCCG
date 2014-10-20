package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

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

}
