package JACCCG.Tests;

import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Construtor.Construtor;

public class Tests {

	public static void main(String[] args){
		Construtor c = new Construtor();
		List<Carta> cartas = c.pegaCartas();
		for(Carta carta : cartas){
			System.out.println(carta.toString());
		}
	}
}
