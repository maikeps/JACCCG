package JACCCG.Cartas;

import java.util.LinkedList;
import java.util.List;

import JACCCG.ConstrutorDeBaralho;
import JACCCG.Colecao.Colecao;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Exceptions.BaralhoCompletoException;
import JACCCG.Exceptions.BaralhoNaoInicializadoException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoException;

public class Fabrica{

	public static Usuario cria(){
		Colecao c = new Colecao(criaCartas(), new LinkedList<RegistroDeBaralho>());
		Usuario u = new Usuario(c, 500);
		ConstrutorDeBaralho b = new ConstrutorDeBaralho(u);
		b.criarBaralho("B1", 15);
		try {
			b.adicionaCarta(c.getCartas().get(0));
			System.out.println("!!!");
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
			System.out.println("adicionou 0");
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
	public static List<CartaDeColecao> criaCartas() {
		List<CartaDeColecao> listaDeCartas = new LinkedList<CartaDeColecao>();

		listaDeCartas.add(new CartaDeColecao("Goblin1", 1, 1, 1, 1, Raridade.COMUM, 100));
		listaDeCartas.add(new CartaDeColecao("Goblin2", 1, 2, 1, 1, Raridade.COMUM, 110));
		listaDeCartas.add(new CartaDeColecao("Goblin3", 2, 1, 1, 1, Raridade.INCOMUM, 201));
		listaDeCartas.add(new CartaDeColecao("Goblin4", 2, 2, 2, 2, Raridade.INCOMUM, 205));
		listaDeCartas.add(new CartaDeColecao("Goblin5", 3, 2, 2, 3, Raridade.RARA, 650));
		listaDeCartas.add(new CartaDeColecao("Humanoide1", 1, 2, 1, 2, Raridade.COMUM, 50));
		listaDeCartas.add(new CartaDeColecao("Humanoide2", 1, 2, 1, 4, Raridade.COMUM, 130));
		listaDeCartas.add(new CartaDeColecao("Humanoide3", 2, 2, 2, 2, Raridade.INCOMUM, 290));
		listaDeCartas.add(new CartaDeColecao("Humanoide4", 2, 3, 2, 3, Raridade.INCOMUM, 140));
		listaDeCartas.add(new CartaDeColecao("Humanoide5", 2, 3, 3, 3, Raridade.RARA, 540));
		listaDeCartas.add(new CartaDeColecao("Humanoide6", 2, 3, 4, 3, Raridade.RARA, 540));
		listaDeCartas.add(new CartaDeColecao("Fera1", 4, 0, 4, 2, Raridade.INCOMUM, 300));
		listaDeCartas.add(new CartaDeColecao("Fera2", 5, 0, 2, 2, Raridade.RARA, 500));
		listaDeCartas.add(new CartaDeColecao("Monstruoso1", 6, 3, 6, 4, Raridade.INCOMUM, 350));
		listaDeCartas.add(new CartaDeColecao("Monstruoso2", 5, 2, 5, 4, Raridade.RARA, 600));

		return  listaDeCartas;
	}

}
