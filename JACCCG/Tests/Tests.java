package JACCCG.Tests;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.FabricaDeCartas;
import JACCCG.Colecao.Colecao;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Exceptions.CartaNaoEncontradaException;
import JACCCG.Exceptions.CartaSendoUtilizadaException;


public class Tests {

	public static void main(String[] args){
		List<CartaDeColecao> l = FabricaDeCartas.criaCartas();
		
		List<RegistroDeBaralho> r = new LinkedList<RegistroDeBaralho>();
		List<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		cartas.addAll(l);
		RegistroDeBaralho reg = new RegistroDeBaralho(cartas, "Teste", 5);
		r.add(reg);
		
		Colecao c = new Colecao(l, r);
		for(Carta carta : c.getBaralhos().get(0).getCartas()){
			System.out.println(carta.getNome());
		}
		try {
			c.removeDaColecao(l.get(0));
			System.out.println("foi");
		} catch (CartaSendoUtilizadaException e) {
			System.out.println("Carta sendo utilizada");
		} catch (CartaNaoEncontradaException e) {
			System.out.println("Carta nao encontrada");
		}
	}
}
