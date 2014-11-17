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
import JACCCG.Cartas.Raridade;
import JACCCG.Colecao.Loja;
import JACCCG.Colecao.RegistroDeBaralho;
import JACCCG.Colecao.Usuario;
import JACCCG.Controle.Leitor;
import JACCCG.Exceptions.CartaNaoEncontradaException;
import JACCCG.Exceptions.DinheirosInsuficientesException;
import JACCCG.Exceptions.ManaInsuficienteException;
import JACCCG.Exceptions.MesaCheiaException;
import JACCCG.Exceptions.MesaVaziaException;

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
		System.out.println("#############################");
		System.out.println("1 - Iniciar uma nova partida!");
		System.out.println("2 - Ir para a loja");
		System.out.println("3 - Mostrar colecao");
		System.out.println("4 - Mostrar baralhos");
		System.out.println("5 - Sair");
		System.out.println("#############################");
	}
	
	public void update(){
		int input;
		while(true){
			mostraMenuInicial();
			input = leitor.leInt(1, 5);
			switch(input){
			case 1:
				System.out.println("Selecione um baralho");
				processaPartida();
				break;
			case 2:
				updateLoja();
				break;
			case 3:
				System.out.println("Mostrando a colecao");
				for(CartaDeColecao c : usuario.getColecao().getCartas()){
					System.out.println(c);
				}
				break;
			case 4:
				System.out.println("Mostrando os baralhos");
				for(int i = 1; i <= usuario.getColecao().getBaralhos().size(); i++){
					System.out.println("Baralhods " + i + "\n" + usuario.getColecao().getBaralhos().get(i-1));
				}
				break;
			case 5:
				System.exit(1);
			}
		}
	}
	
	private RegistroDeBaralho selecionaBaralho(){
		List<RegistroDeBaralho> baralhos = usuario.getColecao().getBaralhos();
		System.out.println("0 - Cancelar");
		for(int i = 0; i < usuario.getColecao().getBaralhos().size(); i++){
			System.out.println((i+1) + " - " + baralhos.get(i).getNome());
		}
		int baralho = leitor.leInt(0, baralhos.size())-1;
		if(baralho == -1) return null;
		return baralhos.get(baralho);
	}

	private void processaPartida() {
		RegistroDeBaralho baralhoSelecionado = selecionaBaralho();
		if(baralhoSelecionado == null) return;
		Jogador jogador = new Jogador(new Baralho(baralhoSelecionado), 30);
		Oponente oponente = Fabrica.criaOponente();
		Partida partida = new Partida(jogador, oponente, juiz);
		jogador.iniciaPartida();
		oponente.iniciaPartida();
		while(!partida.acabou()){
			jogador.iniciaTurno();
			mostraVidas(jogador, oponente);
			mostraMana(jogador);
			jogaCartas(jogador);
			mostraMesas(jogador, oponente);
			ataca(jogador, oponente);
			jogaCartas(jogador);
			
			partida.processaTurnoOponente();
			mostraMesas(jogador, oponente);
		}
		anunciaVencedor(partida);
	}

	private void anunciaVencedor(Partida partida) {
		if(partida.acabou()){
			Jogador vencedor = partida.getVencedor();
			if(vencedor instanceof Jogador){
				System.out.println("Parabens, voce venceu!\nA carta do " + partida.getOponente().getNome() + " foi liberada na loja para compra.");
			}else{
				System.out.println("Voce perdeu :(");
			}
		}
	}

	private void mostraMana(Jogador jogador) {
		System.out.println("#############");
		System.out.println("Sua mana: " + jogador.getManaPool());
	}

	private void mostraMesas(Jogador jogador, Oponente oponente) {
		System.out.println("#############");
		System.out.println("Sua mesa:\n" + jogador.getMesa());
		System.out.println("Mesa do oponente:\n" + oponente.getMesa());
	}

	private void ataca(Jogador jogador, Oponente oponente) {
		while(querAtacar(jogador.getMesa())){
			CartaDeBatalha atacante = selecionaCartaAtacante(jogador.getMesa());
			if(atacante == null) return;
			if(oponente.getMesa().getCartas().size() == 0){
				if(atacante.podeAtacar()){
				jogador.atacaDiretamente(oponente, atacante);
				mostraVidas(jogador, oponente);
				}
			}else{
				CartaDeBatalha alvo = selecionaCartaAlvo(oponente.getMesa());
				if(alvo == null) return;
				atacante.ataca(alvo);
				System.out.println(atacante.getNome()+"(A: "+atacante.getAtaque()+", D: "+atacante.getDefesa()+")" + " Atacou " + 
									alvo.getNome()+"(A: "+alvo.getAtaque()+", D: "+alvo.getDefesa()+")");
				System.out.println(alvo.getNome()+" levou "+ atacante.calculaDanoContra(alvo) + " de dano.");
				System.out.println(atacante.getNome()+" levou "+ alvo.calculaDanoContra(atacante) + " de dano.");
				if(alvo.estaMorta()){
					try {
						oponente.getMesa().removeCarta(alvo);
						System.out.println(alvo.getNome()+" morreu");
					} catch (MesaVaziaException e) {
						e.printStackTrace();
					}
				}
				if(atacante.estaMorta()){
					try {
						jogador.getMesa().removeCarta(atacante);
						System.out.println(atacante.getNome()+" morreu");
					} catch (MesaVaziaException e) {
						e.printStackTrace();
					}
				}
				mostraMesas(jogador, oponente);
			}
		}
	}

	private CartaDeBatalha selecionaCartaAlvo(Mesa mesa) {
		System.out.println("Selecione a carta alvo: ");
		System.out.println("0 - Cancelar");
		System.out.println(mesa);
		int selecionada = leitor.leInt(0, mesa.getCartas().size())-1;
		if(selecionada == -1) return null;
		return mesa.getCartas().get(selecionada);
	}

	private CartaDeBatalha selecionaCartaAtacante(Mesa mesa) {
		System.out.println("Selecione a carta para atacar: ");
		System.out.println("0 - Cancelar");
		System.out.println(mesa);
		int selecionada = leitor.leInt(0, mesa.getCartas().size())-1;
		if(selecionada == -1) return null;
		if(mesa.getCartas().get(selecionada).podeAtacar() == false){
			System.out.println("Esta carta nao pode atacar neste turno");
			if(querAtacar(mesa)){
				return selecionaCartaAtacante(mesa);
			}
		}
		return mesa.getCartas().get(selecionada);
	}

	private boolean querAtacar(Mesa mesa) {
		if(mesa.getCartas().size() == 0) return false;
		System.out.println("Quer atacar? (sim/nao)");
		return leitor.leBoolean();
	}

	private void mostraVidas(Jogador jogador, Oponente oponente) {
		System.out.println("#############");
		System.out.println("Voce: " + jogador.getVida() + " HP\t" + oponente.getNome() + ": " + oponente.getVida()+" HP");
	}

	private void jogaCartas(Jogador jogador) {
		while(querJogarCarta(jogador.getMao())){
			mostraMana(jogador);
			System.out.println("0 - Cancelar");	
			mostraMao(jogador);
			CartaDeBatalha escolhida = escolheCarta(jogador.getMao());
			if(escolhida == null) return;
			try {
				jogador.jogaCarta(escolhida);
				System.out.println("Voce jogou: "+escolhida.getNome());
			} catch (MesaCheiaException e) {
				System.out.println("A mesa esta cheia");
				break;
			} catch (ManaInsuficienteException e) {
				System.out.println("Mana insuficiente, escolha outra carta");
			}
		}
	}

	private CartaDeBatalha escolheCarta(Mao mao) {
		int escolha = leitor.leInt(0, mao.getCartas().size())-1;
		if(escolha == -1) return null;
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
	
	private void mostraMenuLoja(){
		System.out.println("#############################");
		System.out.println("1 - Pesquisar por Nome");
		System.out.println("2 - Pesquisar por Raridade");
		System.out.println("3 - Pesquisar por Valor");
		System.out.println("4 - Pesquisar por Custo de Mana");
		System.out.println("5 - Sair");
		System.out.println("#############################");
	}
	
	private void updateLoja(){
		int input;
		while(true){
			mostraMenuLoja();
			System.out.println("Voce possui "+usuario.getDinheiros()+" dinheiros.");
			input = leitor.leInt(1, 5);
			Loja j = new Loja(Fabrica.criaCartasDoJogo());
			
			switch(input){
			case 1:
				pesquisaPorNome(j);
				break;
			case 2:
				pesquisaPorRaridade(j);
				break;
			case 3:
				pesquisaPorValor(j);
				break;
			case 4:
				pesquisarPorMana(j);
				break;
			case 5:
				return;
			}
		}
	}

	private void pesquisarPorMana(Loja j) {
		System.out.println("Digite o custo de mana que voce quer procurar");
		int man = leitor.leInt(1, 10);
		List<CartaDeColecao> cartas = j.pesquisaCarta(man);
		System.out.println("Qual carta deseja comprar?");
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexM = leitor.leInt(0, cartas.size())-1;
		if(indexM == -1) return;
		try {
			j.vende(cartas.get(indexM), usuario);
			System.out.println("Voce comprou a carta "+cartas.get(indexM).getNome()+" por "+cartas.get(indexM).getPreco()+" dinheiros.");
		} catch (DinheirosInsuficientesException e) {
			System.out.println("Desculpe, voce nao tem dinheiros suficientes.");
		}
	}

	private void pesquisaPorValor(Loja j) {
		System.out.println("Digite o valor que voce quer procuar");
		int c = leitor.leInt();
		System.out.println("Voce quer as cartas que custam menos que isso?");
		boolean hm = leitor.leBoolean();
		List<CartaDeColecao> cartas = j.pesquisaCarta(c, hm);
		System.out.println("Qual carta deseja comprar?");
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexN = leitor.leInt(0, cartas.size())-1;
		if(indexN == -1) return;
		try {
			j.vende(cartas.get(indexN), usuario);
			System.out.println("Voce comprou a carta "+cartas.get(indexN).getNome()+" por "+cartas.get(indexN).getPreco()+" dinheiros.");
		} catch (DinheirosInsuficientesException e) {
			System.out.println("Desculpe, voce nao tem dinheiros suficientes.");
		}
	}

	private void pesquisaPorRaridade(Loja j) {
		System.out.println("Digite a raridade da carta a ser procurada");
		System.out.println("0 - Cancelar");
		System.out.println("1 - COMUM");
		System.out.println("2 - INCOMUM");
		System.out.println("3 - RARA");
		int b = leitor.leInt(0, 3);
		List<CartaDeColecao> cartas;
		if(b == 0) return;
		if(b == 1){
		cartas = j.pesquisaCarta(Raridade.COMUM);
		}
		if(b == 2){
		cartas = j.pesquisaCarta(Raridade.INCOMUM);
		}
		else{
		cartas = j.pesquisaCarta(Raridade.RARA);
		}
		System.out.println("Qual carta deseja comprar?");
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexNaCol = leitor.leInt(0, cartas.size())-1;
		if(indexNaCol == -1) return;
		try {
			j.vende(cartas.get(indexNaCol), usuario);
			System.out.println("Voce comprou a carta "+cartas.get(indexNaCol).getNome()+" por "+cartas.get(indexNaCol).getPreco()+" dinheiros.");
		} catch (DinheirosInsuficientesException e) {
			System.out.println("Desculpe, voce nao tem dinheiros suficientes.");
		}
	}

	private void pesquisaPorNome(Loja loja) {
		System.out.println("Digite o nome da carta a ser procurada");
		String nome = leitor.leString();
		List<CartaDeColecao> cartas = loja.pesquisaCarta(nome);
		System.out.println("Qual carta deseja comprar?");
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		//leitor.leBoolean();
		int x = leitor.leInt(0, cartas.size())-1;
		if(x == -1) return;
		try {
			loja.vende(cartas.get(x), usuario);
			System.out.println("Voce comprou a carta "+cartas.get(x).getNome()+" por "+cartas.get(x).getPreco()+" dinheiros.");
		} catch (DinheirosInsuficientesException e) {
			System.out.println("Desculpe, voce nao tem dinheiros suficientes.");
		}
	}
}
