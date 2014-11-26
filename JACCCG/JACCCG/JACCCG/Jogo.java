package JACCCG.JACCCG;

import java.util.List;

import Cartas.CartaDeColecao;
import Colecao.Loja;
import Colecao.Usuario;
import Exceptions.DinheirosInsuficientesException;
import Exceptions.LimiteDeCartasExcedidoException;

public class Jogo {

	private static Jogo jogo;
	private Usuario usuario;
	private Loja loja;
	private final int VIDA = 30;
	
	private Jogo(){
		
	}
	
	public static Jogo getInstance(){
		if(jogo == null) jogo = new Jogo();
		return jogo;
	}
	
	public int getVidaDefault(){
		return VIDA;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	public void comprarCarta(CartaDeColecao carta, Usuario vendedor) throws DinheirosInsuficientesException, LimiteDeCartasExcedidoException{
		this.loja.vende(carta, vendedor);
	}
	
	public void setLoja(Loja loja){
		this.loja = loja;
	}

	public Loja getLoja(){
		return this.loja;
	}
	public Usuario getUsuario() {
		return usuario;
	}
}
