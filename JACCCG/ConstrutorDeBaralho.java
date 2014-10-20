package JACCCG;

import java.util.LinkedList;
import java.util.List;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Exceptions.BaralhoJaExistenteException;

public class ConstrutorDeBaralho {

	private Usuario usuario;

	private RegistroDeBaralho baralhoAtual;

	private RegistroDeBaralho baralhoVazio;

	public ConstrutorDeBaralho(Usuario usuario) {
		this.usuario = usuario;
		List<CartaDeColecao> list = new LinkedList<CartaDeColecao>();
		baralhoAtual = new RegistroDeBaralho(list, "NULL", 15);
		baralhoVazio = baralhoAtual;
	}

	public RegistroDeBaralho criarBaralho(String nome) {
		List<CartaDeColecao> list = new LinkedList<CartaDeColecao>();
		return new RegistroDeBaralho(list, nome, 15);
	}

	public void adicionaCarta(CartaDeColecao carta) {
		baralhoAtual.getCartas().add(carta);
	}

	public void removeCarta(Carta carta) {
		baralhoAtual.getCartas().remove(carta);
	}

	public void salvarBaralho() {
		try {
			usuario.getColecao().addBaralho(baralhoAtual);
		} catch (BaralhoJaExistenteException e) {
			// TODO tratar
			e.printStackTrace();
		}
	}

	public boolean podeAdicionarCarta() {
		return baralhoAtual.getCartas().size() <= baralhoAtual.getMaximo();
	}

	public void editaBaralho(RegistroDeBaralho baralho) {
		baralhoAtual = baralho;
	}

	public void cancelaBaralho() {
		baralhoAtual = baralhoVazio;
	}

}
