package Cartas;
import java.util.LinkedList;

import BD.DAOController;
import Colecao.RegistroDeBaralho;
import Colecao.Usuario;
import Exceptions.BaralhoCompletoException;
import Exceptions.BaralhoJaExistenteException;
import Exceptions.BaralhoNaoInicializadoException;
import Exceptions.CartaNaoEncontradaException;
import Exceptions.LimiteDeCartasExcedidoException;

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
		if (!podeAdicionarCarta()) {
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
			DAOController.getInstance().deleteBaralho(baralhoAtual, usuario.getId());
			try {
				usuario.getColecao().addBaralho(baralhoAtual);
			} catch (BaralhoJaExistenteException e1) {
			}
//			System.out.println("Baralho com esse nome ja existe");
		}
	}

	public boolean podeAdicionarCarta() {
		return !baralhoAtual.jogavel();
	}

	public void editaBaralho(RegistroDeBaralho baralho) {
		this.baralhoAtual = baralho;
	}

	public void cancelaBaralho() {
		baralhoAtual = null;
	}

	public RegistroDeBaralho getBaralhoAtual(){
		return baralhoAtual;
	}
}
