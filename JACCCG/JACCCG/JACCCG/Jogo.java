package JACCCG.JACCCG;

import Batalha.Jogador;
import Batalha.Juiz;
import Batalha.Mesa;
import Batalha.Oponente;
import Cartas.CartaDeBatalha;
import Cartas.CartaDeColecao;
import Colecao.Loja;
import Colecao.Usuario;
import Exceptions.DinheirosInsuficientesException;
import Exceptions.LimiteDeCartasExcedidoException;
import Exceptions.ManaInsuficienteException;
import Exceptions.MesaCheiaException;
import Exceptions.MesaVaziaException;

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
	
	public void iniciaBatalha(Oponente oponente, Jogador jogador){
		for(int i = 0; i < 5; i++){
			jogador.compraCarta();
			oponente.compraCarta();
		}
		jogador.encheMana();
//		oponente.encheMana();
	}
	
	public void jogaCarta(Jogador jogador, CartaDeBatalha carta) throws MesaCheiaException, ManaInsuficienteException{
		jogador.jogaCarta(carta);
	}
	
	public void jogadorAtacaDiretamente(Oponente oponente, CartaDeBatalha atacante){
		if(atacante.podeAtacar()){
			oponente.perdeVida(atacante.getAtaque());
			atacante.setPronto(false);
		}
	}
	
	public void jogadorAtaca(Mesa mesaJogador, Mesa mesaOponente, CartaDeBatalha atacante, CartaDeBatalha alvo){
		atacante.ataca(alvo);
		if(atacante.estaMorta())
			try {
				mesaJogador.removeCarta(atacante);
			} catch (MesaVaziaException e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace(); 
			}
		if(alvo.estaMorta())
			try {
				mesaOponente.removeCarta(alvo);
			} catch (MesaVaziaException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} 
	}
	
	public String processaTurnoOponente(Oponente oponente, Jogador jogador){
		oponente.processaTurno(jogador);
		return "";
	}

	public void iniciaTurno(Jogador jogador) {
		jogador.iniciaTurno();
	}

	public boolean verificaFimDeJogo(Jogador jogador, Oponente oponente) {
		return jogador.estaMorto() || oponente.estaMorto();
	}
	
	public boolean jogadorVenceu(Jogador jogador, Oponente oponente){
		return jogador.getVida() > 0 && oponente.getVida() <= 0;
	}
	
	public void gerenciaPosJogo(Jogador jogador, Oponente oponente){
		Juiz.getInstance().gerenciaPosJogo(oponente, usuario, jogadorVenceu(jogador, oponente), oponente.getRecompensa());
	}
}
