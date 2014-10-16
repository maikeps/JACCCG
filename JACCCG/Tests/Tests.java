package JACCCG.Tests;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Batalha.Baralho;
import JACCCG.Cartas.Carta;
import JACCCG.Cartas.Raridade;
import JACCCG.Colecao.RegistroDeBaralho;

public class Tests {

	public static void main(String[] args){
		List<Carta> cartas = new LinkedList<Carta>();
		cartas.add(new Carta("Carta 1", 1, 1, 1, 1, Raridade.COMUM));
		cartas.add(new Carta("Carta 2", 1, 1, 1, 1, Raridade.COMUM));
		cartas.add(new Carta("Carta 3", 1, 1, 1, 1, Raridade.COMUM));
		cartas.add(new Carta("Carta 4", 1, 1, 1, 1, Raridade.COMUM));
		cartas.add(new Carta("Carta 5", 1, 1, 1, 1, Raridade.COMUM));
		
		RegistroDeBaralho rb = new RegistroDeBaralho(cartas, "teste", 5);
		
		Baralho baralho = new Baralho(rb);
		
		for(int i = 0; i < 5; i++){
			System.out.println(baralho.getTopo().getNome());
		}
		System.out.println(rb.jogavel());
	}
}
