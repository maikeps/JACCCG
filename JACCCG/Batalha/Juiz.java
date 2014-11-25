package Batalha;

import java.util.List;

import BD.DAOController;
import Cartas.CartaDeColecao;
import Colecao.Loja;
import Colecao.Usuario;

public class Juiz {

	private Loja loja;

	private static Juiz instancia;

	/**
	 *  
	 */
	private Juiz() {

	}

//	private CartaDeColecao disponibilizaCarta(String carta) {
//		//TODO testar para saber se .getCartas pega uma cópia da lista ou pega a lista em si.
//		List<CartaDeColecao> c = loja.getCartas();
//		(c.get(c.indexOf(carta))).setDisponibilidade(true);
//		errado
//		
//	}
	
	private void disponibilizaCarta(CartaDeColecao carta, int idUsuario){
		List<CartaDeColecao> cartas = loja.getCartas();
		for(CartaDeColecao c : cartas){
			if(c.getId() == carta.getId()){
				c.setDisponibilidade(true);
				DAOController.getInstance().updateCartaLiberada(c.getId(), idUsuario);
				return;
			}
		}
	}

	public static Juiz getInstance() {
		if(instancia == null){
			instancia = new Juiz();
		};
		
		return instancia;
	}
	
	public void gerenciaPosJogo(Oponente oponente, Usuario usuario, boolean jogadorVenceu, int recompensa){
		atualizaOponente(oponente, jogadorVenceu);
		if(jogadorVenceu){
			daDinheiros(usuario, recompensa);
			if(!(oponente.getCartaEquivalente().estaDisponivel())) disponibilizaCarta(oponente.getCartaEquivalente(), usuario.getId());
		}
	}
	
	private void daDinheiros(Usuario usuario, int qtd){
		usuario.ganhaDinheiros(qtd);
	}

	private void atualizaOponente(Oponente oponente, boolean jogadorVenceu) {
		if(jogadorVenceu) oponente.aumentaVezesDerrotado();
		oponente.aumentaVezesBatalhado();
		DAOController.getInstance().updateOponente(oponente);
	}

}
