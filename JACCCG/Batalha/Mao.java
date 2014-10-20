package JACCCG.Batalha;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Exceptions.BaralhoVazioException;

public class Mao {

	private List<Carta> cartasDaMao;

	public Mao() {
		cartasDaMao = new LinkedList<Carta>();

	}

	public void removeCarta(Carta carta) {
		cartasDaMao.remove(carta);
	}

	public void compraCarta(Baralho baralho) throws BaralhoVazioException{
		cartasDaMao.add(baralho.getTopo());

	}

	public List<Carta> getCartas() {
		return cartasDaMao;
	}

	public String toString(){
		String str = "";
		CartaDeBatalha c = (CartaDeBatalha) getCartas().get(0);
		for(int i = 0; i < getCartas().size(); i++){
			c = (CartaDeBatalha) getCartas().get(i);
			str +=  i + " - " + c.getNome() + " " + "A:" + c.getAtaque() + " D:" + c.getDefesa() + " V:" + c.getVida() + " C:" + c.getCustoMana() + "\n";
		}
		System.out.println(str);
		return str;
	}
}
