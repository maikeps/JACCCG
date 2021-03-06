package Colecao;

import BD.DAOController;
import BD.Registravel;
import Cartas.CartaDeColecao;
import Exceptions.LimiteDeCartasExcedidoException;

public class Usuario implements Registravel{

	private Colecao colecao;
	private int dinheiros;
	private int id;
	private String nome;

	public Usuario(Colecao colecao, int dinheiros, String nome) {
		this.colecao = colecao;
		this.dinheiros = dinheiros;
		this.nome = nome;
	}

	public void adicionaNaColecao(CartaDeColecao carta) throws LimiteDeCartasExcedidoException {
		colecao.adicionaCarta(carta);
	}

	public void ganhaDinheiros(int qtd) {
		dinheiros+=qtd;
		DAOController.getInstance().updateDinheirosUsuario(getId(), getDinheiros());
	}

	public void perdeDinheiros(int qtd) {
		/**if((dinheiros-=qtd) <= 0){
			dinheiros = 0;
		}**/
		dinheiros -= qtd;
		if(dinheiros < 0) dinheiros = 0;
		
		DAOController.getInstance().updateDinheirosUsuario(getId(), getDinheiros());		
	}

	public int getDinheiros(){
		return dinheiros;
	}
	
	public Colecao getColecao() {
		return colecao;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getNome(){
		return nome;
	}
}
