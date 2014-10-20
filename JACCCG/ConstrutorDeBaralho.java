package JACCCG;

import java.util.LinkedList;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Exceptions.BaralhoCompletoException;
import JACCCG.Exceptions.BaralhoJaExistenteException;
import JACCCG.Exceptions.BaralhoNaoInicializadoException;
import JACCCG.Exceptions.CartaNaoEncontradaException;
import JACCCG.Exceptions.LimiteDeCartasExcedidoException;

public class ConstrutorDeBaralho {

	private Usuario usuario;
	private RegistroDeBaralho baralhoAtual;

	public ConstrutorDeBaralho(Usuario usuario) {
		this.usuario = usuario;
	}

	public RegistroDeBaralho criarBaralho(String nome, int maxCartas) {
		return baralhoAtual = new RegistroDeBaralho(new LinkedList<CartaDeColecao>(), nome,
				maxCartas);
	}

	public void adicionaCarta(CartaDeColecao carta)
			throws BaralhoNaoInicializadoException,
			LimiteDeCartasExcedidoException, BaralhoCompletoException {
		if (baralhoAtual == null)
			throw new BaralhoNaoInicializadoException(
					"Baralho nao inicializado");
		if (podeAdicionarCarta()) {
			throw new BaralhoCompletoException(
					"Numero de cartas no baralho excedido");
		}
		int ocorrencias = baralhoAtual.getOcorrenciasCarta(carta);
		if (ocorrencias == carta.getRaridade().ordinal() + 1) {
			throw new LimiteDeCartasExcedidoException(
					"Limite de cartas no baralho excedido");
		}
		baralhoAtual.getCartas().add(carta);
	}

	public void removeCarta(CartaDeColecao carta)
			throws BaralhoNaoInicializadoException, CartaNaoEncontradaException {
		if (baralhoAtual == null)
			throw new BaralhoNaoInicializadoException(
					"Baralho nao inicializado");
		if (!baralhoAtual.contem(carta))
			throw new CartaNaoEncontradaException("Carta nao encontrada");
		baralhoAtual.getCartas().remove(carta);
	}

	public void salvarBaralho() {
		try {
			usuario.getColecao().addBaralho(baralhoAtual);
		} catch (BaralhoJaExistenteException e) {
			System.out.println("Baralho com esse nome ja existe");
		}
	}

	public boolean podeAdicionarCarta() {
		return baralhoAtual.jogavel();
	}

	public void editaBaralho(RegistroDeBaralho baralho) {
		this.baralhoAtual = baralho;
	}

	public void cancelaBaralho() {
		baralhoAtual = null;
	}

}
