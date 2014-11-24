package JACCCG.Cartas;

import java.util.LinkedList;
import java.util.List;

import JACCCG.ConstrutorDeBaralho;
import JACCCG.Batalha.Baralho;
import JACCCG.Batalha.Oponente;
import JACCCG.Colecao.Colecao;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Exceptions.BaralhoCompletoException;
import JACCCG.Exceptions.BaralhoNaoInicializadoException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoException;

public class Fabrica{

	public static Usuario criaUsuario(){
		Colecao c = new Colecao(criaCartasDoJogo(), new LinkedList<RegistroDeBaralho>());
		Usuario u = new Usuario(c, 500);
		ConstrutorDeBaralho b = new ConstrutorDeBaralho(u);
		b.criarBaralho("B1", 15);
		try {
			b.adicionaCarta(c.getCartas().get(0));
			b.adicionaCarta(c.getCartas().get(0));
			b.adicionaCarta(c.getCartas().get(0));
			b.adicionaCarta(c.getCartas().get(3));
			b.adicionaCarta(c.getCartas().get(3));
			b.adicionaCarta(c.getCartas().get(4));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(7));
			b.adicionaCarta(c.getCartas().get(8));
			b.adicionaCarta(c.getCartas().get(9));
			b.adicionaCarta(c.getCartas().get(12));
			b.adicionaCarta(c.getCartas().get(1));
		} catch (BaralhoNaoInicializadoException
				| LimiteDeCartasExcedidoException | BaralhoCompletoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.salvarBaralho();
		b.criarBaralho("B2", 15);
		try {
			b.adicionaCarta(c.getCartas().get(1));
			b.adicionaCarta(c.getCartas().get(1));
			b.adicionaCarta(c.getCartas().get(1));
			b.adicionaCarta(c.getCartas().get(0));
			b.adicionaCarta(c.getCartas().get(13));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(7));
			b.adicionaCarta(c.getCartas().get(8));
			b.adicionaCarta(c.getCartas().get(9));
			b.adicionaCarta(c.getCartas().get(14));
			b.adicionaCarta(c.getCartas().get(3));
			b.adicionaCarta(c.getCartas().get(3));
		} catch (BaralhoNaoInicializadoException
				| LimiteDeCartasExcedidoException | BaralhoCompletoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.salvarBaralho();
		b.criarBaralho("B3", 15);
		try {
			b.adicionaCarta(c.getCartas().get(0));
			b.adicionaCarta(c.getCartas().get(1));
			b.adicionaCarta(c.getCartas().get(1));
			b.adicionaCarta(c.getCartas().get(11));
			b.adicionaCarta(c.getCartas().get(12));
			b.adicionaCarta(c.getCartas().get(4));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(5));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(6));
			b.adicionaCarta(c.getCartas().get(7));
			b.adicionaCarta(c.getCartas().get(8));
			b.adicionaCarta(c.getCartas().get(14));
			b.adicionaCarta(c.getCartas().get(10));
			b.adicionaCarta(c.getCartas().get(3));
		} catch (BaralhoNaoInicializadoException
				| LimiteDeCartasExcedidoException | BaralhoCompletoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.salvarBaralho();

		
		return u;
	}
	
	public static Oponente criaOponente(){
		List<CartaDeColecao> todasAsCartas = criaCartasDoJogo();
		List<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		cartas.add(todasAsCartas.get(0));
		cartas.add(todasAsCartas.get(1));
		cartas.add(todasAsCartas.get(1));
		cartas.add(todasAsCartas.get(11));
		cartas.add(todasAsCartas.get(12));
		cartas.add(todasAsCartas.get(4));
		cartas.add(todasAsCartas.get(5));
		cartas.add(todasAsCartas.get(5));
		cartas.add(todasAsCartas.get(6));
		cartas.add(todasAsCartas.get(6));
		cartas.add(todasAsCartas.get(7));
		cartas.add(todasAsCartas.get(8));
		cartas.add(todasAsCartas.get(14));
		cartas.add(todasAsCartas.get(10));
		cartas.add(todasAsCartas.get(3));
		RegistroDeBaralho baralho = new RegistroDeBaralho(cartas, "Baralho do Oponente 1", 15);
		
		return new Oponente("Oponente 1", new Baralho(baralho), 20);
	}
	
	public static List<CartaDeColecao> criaCartasDoJogo() {
		List<CartaDeColecao> listaDeCartas = new LinkedList<CartaDeColecao>();

		listaDeCartas.add(new CartaDeColecao("Goblin1", 2, 1, 1, 1, Raridade.COMUM, 100));
		listaDeCartas.add(new CartaDeColecao("Goblin2", 2, 1, 1, 1, Raridade.COMUM, 110));
		listaDeCartas.add(new CartaDeColecao("Goblin3", 4, 1, 1, 1, Raridade.INCOMUM, 201));
		listaDeCartas.add(new CartaDeColecao("Goblin4", 4, 1, 2, 2, Raridade.INCOMUM, 205));
		listaDeCartas.add(new CartaDeColecao("Goblin5", 6, 2, 2, 3, Raridade.RARA, 650));
		listaDeCartas.add(new CartaDeColecao("Humanoide1", 2, 1, 1, 2, Raridade.COMUM, 50));
		listaDeCartas.add(new CartaDeColecao("Humanoide2", 2, 1, 1, 4, Raridade.COMUM, 130));
		listaDeCartas.add(new CartaDeColecao("Humanoide3", 4, 3, 2, 2, Raridade.INCOMUM, 290));
		listaDeCartas.add(new CartaDeColecao("Humanoide4", 4, 3, 2, 3, Raridade.INCOMUM, 140));
		listaDeCartas.add(new CartaDeColecao("Humanoide5", 4, 3, 3, 3, Raridade.RARA, 540));
		listaDeCartas.add(new CartaDeColecao("Humanoide6", 4, 3, 4, 3, Raridade.RARA, 540));
		listaDeCartas.add(new CartaDeColecao("Fera1", 8, 0, 4, 2, Raridade.INCOMUM, 300));
		listaDeCartas.add(new CartaDeColecao("Fera2", 10, 0, 2, 2, Raridade.RARA, 400));
		listaDeCartas.add(new CartaDeColecao("Monstruoso1", 12, 3, 6, 4, Raridade.INCOMUM, 350));
		listaDeCartas.add(new CartaDeColecao("Monstruoso2", 10, 2, 5, 4, Raridade.RARA, 600));

		return  listaDeCartas;
	}

}
