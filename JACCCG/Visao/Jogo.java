package JACCCG.Visao;

import java.util.List;

import JACCCG.Batalha.Baralho;
import JACCCG.Batalha.Jogador;
import JACCCG.Batalha.Juiz;
import JACCCG.Batalha.Mao;
import JACCCG.Batalha.Mesa;
import JACCCG.Batalha.Oponente;
import JACCCG.Batalha.Partida;
import JACCCG.Cartas.CartaDeBatalha;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Fabrica;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Controle.Leitor;
import JACCCG.Exceptions.ManaInsuficienteException;
import JACCCG.Exceptions.MesaCheiaException;

public class Jogo {

	private Leitor leitor;
	private Usuario usuario;
	private Juiz juiz;
	
	public Jogo(Leitor leitor){
		this.leitor = leitor;
		this.juiz = Juiz.getInstance();
		usuario = Fabrica.criaUsuario();
		update();
	}
	
	public void mostraMenuInicial(){
		System.out.println("1 - Iniciar uma nova partida!");
		System.out.println("2 - Ir para a loja");
		System.out.println("3 - Mostrar colecao");
		System.out.println("4 - Mostrar baralhos");
		System.out.println("5 - Sair");
	}
	
	public void update(){
		mostraMenuInicial();
		int input = leitor.leInt(1, 5);
		switch(input){
		case 1:
			System.out.println("Selecione um baralho");
			selecionaBaralho();
			processaPartida();
			break;
		case 2:
			System.out.println("Foi pra loja");
			break;
		case 3:
			System.out.println("Mostrando a colecao");
			for(CartaDeColecao c : usuario.getColecao().getCartas()){
				System.out.println(c);
			}
			break;
		case 4:
			System.out.println("Mostrando os baralhos");
			for(int i = 0; i < usuario.getColecao().getBaralhos().size(); i++){
				System.out.println("Baralho " + i + "\n" + usuario.getColecao().getBaralhos().get(i));
			}
			break;
		case 5:
			System.exit(1);
		}
	}
	
	private RegistroDeBaralho selecionaBaralho(){
		List<RegistroDeBaralho> baralhos = usuario.getColecao().getBaralhos();
		for(int i = 0; i < usuario.getColecao().getBaralhos().size(); i++){
			System.out.println("Baralho " + i + "\n" + baralhos.get(i).getNome());
		}
		int baralho = leitor.leInt(0, baralhos.size());
		
		return baralhos.get(baralho);
	}

	private void processaPartida() {
		Jogador jogador = new Jogador(new Baralho(selecionaBaralho()), 30);
		Oponente oponente = Fabrica.criaOponente();
		Partida partida = new Partida(jogador, oponente, juiz);
		Mao mao = jogador.getMao();
		while(!partida.acabou()){
			mostraVidas(jogador, oponente);
			jogador.iniciaTurno();
			jogaCartas(jogador);
			mostraMesas(jogador, oponente);
			ataca(jogador, oponente);
			jogaCartas(jogador);
			
			partida.processaTurnoOponente();
		}
	}

	private void mostraMesas(Jogador jogador, Oponente oponente) {
		System.out.println("Sua mesa:\n" + jogador.getMesa());
		System.out.println("Mesa do oponente:\n" + oponente.getMesa());
	}

	private void ataca(Jogador jogador, Oponente oponente) {
		while(querAtacar(jogador)){
			CartaDeBatalha atacante = selecionaCartaAtacante(jogador.getMesa());
			if(oponente.getMesa().getCartas().size() == 0){
				jogador.atacaDiretamente(oponente, atacante);
				mostraVidas(jogador, oponente);
			}else{
				CartaDeBatalha alvo = selecionaCartaAlvo(oponente.getMesa());
				atacante.ataca(alvo);	
				mostraMesas(jogador, oponente);
			}
		}
	}

	private CartaDeBatalha selecionaCartaAlvo(Mesa mesa) {
		System.out.println("Selecione a carta alvo: ");
		int selecionada = leitor.leInt(0, mesa.getCartas().size());
		return mesa.getCartas().get(selecionada);
	}

	private CartaDeBatalha selecionaCartaAtacante(Mesa mesa) {
		System.out.println("Selecione a carta para atacar: ");
		int selecionada = leitor.leInt(0, mesa.getCartas().size());
		while(mesa.getCartas().get(selecionada).podeAtacar() == false){
			System.out.println("Esta carta nao pode atacar neste turno");
			selecionada = leitor.leInt(0, mesa.getCartas().size());
		}
		return mesa.getCartas().get(selecionada);
	}

	private boolean querAtacar(Jogador jogador) {
		if(jogador.getMesa().getCartas().size() == 0) return false;
		System.out.println("Quer atacar? (sim/nao)");
		return leitor.leBoolean();
	}

	private void mostraVidas(Jogador jogador, Oponente oponente) {
		System.out.println("Voce: " + jogador.getVida() + "\t" + oponente.getNome() + ": " + oponente.getVida());
	}

	private void jogaCartas(Jogador jogador) {
		while(querJogarCarta(jogador.getMao())){
			mostraMao(jogador);				
			CartaDeBatalha escolhida = escolheCarta(jogador.getMao());
			try {
				jogador.jogaCarta(escolhida);
			} catch (MesaCheiaException e) {
				System.out.println("A mesa esta cheia");
				break;
			} catch (ManaInsuficienteException e) {
				System.out.println("Mana insuficiente, escolha outra carta");
			}
		}
	}

	private CartaDeBatalha escolheCarta(Mao mao) {
		int escolha = leitor.leInt(0, mao.getCartas().size());
		return mao.getCartas().get(escolha);
	}

	private boolean querJogarCarta(Mao mao) {
		if(mao.getCartas().size() == 0) return false;
		System.out.println("Quer jogar uma carta? (sim/nao)");
		return leitor.leBoolean();
	}

	private void mostraMao(Jogador jogador) {
		System.out.println(jogador.getMao().toString());
	}
}
