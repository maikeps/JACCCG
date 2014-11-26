package JACCCG.JACCCG;

import java.util.List;

import Cartas.CartaDeColecao;
import Colecao.Loja;
import Colecao.Usuario;

public class Jogo {

	private static Jogo jogo;
	private Usuario usuario;
	private Loja loja;
	
	private Jogo(){
		
	}
	
	public static Jogo getInstance(){
		if(jogo == null) jogo = new Jogo();
		return jogo;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void setLoja(Loja loja){
		this.loja = loja;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
