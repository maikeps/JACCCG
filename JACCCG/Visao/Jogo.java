package Visao;

import java.util.List;

import BD.DAOController;
import Batalha.Baralho;
import Batalha.Jogador;
import Batalha.Juiz;
import Batalha.Mao;
import Batalha.Mesa;
import Batalha.Oponente;
import Batalha.Partida;
import Cartas.CartaDeBatalha;
import Cartas.CartaDeColecao;
import Cartas.Raridade;
import Colecao.Colecao;
import Colecao.Loja;
import Colecao.RegistroDeBaralho;
import Colecao.Usuario;
import Controle.Leitor;
import Exceptions.DinheirosInsuficientesException;
import Exceptions.LimiteDeCartasExcedidoException;
import Exceptions.ManaInsuficienteException;
import Exceptions.MesaCheiaException;
import Exceptions.MesaVaziaException;

public class Jogo {
	private final int HP = 30;
	private Leitor leitor;
	private Usuario usuario;
	private Juiz juiz;
	private Loja loja;
	
	public Jogo(Leitor leitor){
		this.leitor = leitor;
		this.juiz = Juiz.getInstance();
		usuario = DAOController.getInstance().getUsuario(1);
		loja = DAOController.getInstance().getLoja(usuario.getId());
		juiz.setLoja(loja);
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
				System.out.println("Selecione um oponente para batalhar!");
				Oponente oponente = selecionaOponente();
				if(oponente == null) break;
				System.out.println("Selecione um baralho para usar!");
				RegistroDeBaralho baralho = selecionaBaralho();
				if(baralho == null) break;
				Jogador jogador = new Jogador((new Baralho(baralho)), HP);
				processaPartida(jogador, oponente);
				break;
			case 2:
				updateLoja();
				break;
			case 3:
				updateColecao();
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
	
	private Oponente selecionaOponente() {
		List<Oponente> oponentes = DAOController.getInstance().getOponentesLiberados(usuario.getId());
		System.out.println("0 - Cancelar");
		for(int i = 0; i < oponentes.size(); i++){
			Oponente o = oponentes.get(i);
			System.out.println((i+1)+" - "+o);
		}
		
		int oponente = leitor.leInt(0, oponentes.size())-1;
		if(oponente == -1) return null;
		return oponentes.get(oponente);
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

	private void processaPartida(Jogador jogador, Oponente oponente) {
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
			juiz.gerenciaPosJogo(partida.getOponente(), usuario, !(vencedor instanceof Oponente), partida.getOponente().getRecompensa());
			if(vencedor instanceof Oponente){
				System.out.println("Voce perdeu :(");
//				juiz.gerenciaPosJogo(partida.getOponente(), usuario, false, partida.getOponente().getRecompensa());
//				juiz.atualizaOponente(partida.getOponente(), false);
			}else{
				System.out.println("Parabens, voce venceu!\nA carta do " + partida.getOponente().getNome() + " foi liberada na loja para compra.");
//				juiz.gerenciaPosJogo(partida.getOponente(), usuario, true, partida.getOponente().getRecompensa());
//				juiz.atualizaOponente(partida.getOponente(), true);
//				juiz.disponibilizaCarta(carta)
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
		System.out.println("5 - Mostrar Todas as Cartas Disponveis");
		System.out.println("6 - Sair.");
		System.out.println("#############################");
	}
	
	private void mostraMenuColecao(){
		System.out.println("#############################");
		System.out.println("1 - Pesquisar por Nome");
		System.out.println("2 - Pesquisar por Raridade");
		System.out.println("3 - Pesquisar por Valor");
		System.out.println("4 - Pesquisar por Custo de Mana");
		System.out.println("5 - Mostrar Toda a Colecao");
		System.out.println("6 - Sair.");
		System.out.println("#############################");
	}
	
	
	private void updateLoja(){
		int input;
		while(true){
			mostraMenuLoja();
			System.out.println("Voce possui "+usuario.getDinheiros()+" dinheiros.");
			input = leitor.leInt(1, 6);
//			Loja j = new Loja(Fabrica.criaCartasDoJogo());
			
			switch(input){
			case 1:
				pesquisaPorNome(loja);
				break;
			case 2:
				pesquisaPorRaridade(loja);
				break;
			case 3:
				pesquisaPorValor(loja);
				break;
			case 4:
				pesquisarPorMana(loja);
				break;
			case 5:
				System.out.println("Todas as Cartas Disponiveis");
				for(CartaDeColecao c : loja.getCartas()){
					System.out.println(c);
				}
				break;
			case 6:
				return;
			}
		}
	}
	
	private void updateColecao(){
		Colecao j = DAOController.getInstance().getColecao(1);
		while(true){
		mostraMenuColecao();
		int input = leitor.leInt(1, 6);
		
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
			System.out.println("Mostrando a colecao");
			for(CartaDeColecao c : usuario.getColecao().getCartas()){
				System.out.println(c);
			}
			break;
		case 6:
			return;
		}
		}
		}

	private void pesquisarPorMana(Loja j) {
		System.out.println("Digite o custo de mana que voce quer procurar");
		int man = leitor.leInt(1, 10);
		List<CartaDeColecao> cartas = j.getPesquisador().pesquisaCarta(man);
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
		} catch (LimiteDeCartasExcedidoException e) {
			System.out.println("Limite de cartas excedido.");
		}
	}

	private void pesquisaPorValor(Loja j) {
		System.out.println("Digite o valor que voce quer procuar");
		int c = leitor.leInt();
		System.out.println("Voce quer as cartas que custam menos que isso?");
		boolean hm = leitor.leBoolean();
		List<CartaDeColecao> cartas = j.getPesquisador().pesquisaCarta(c, hm);
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
		} catch (LimiteDeCartasExcedidoException e) {
			System.out.println("Limite de cartas excedido.");
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
		cartas = j.getPesquisador().pesquisaCarta(Raridade.COMUM);
		}
		if(b == 2){
		cartas = j.getPesquisador().pesquisaCarta(Raridade.INCOMUM);
		}
		else{
		cartas = j.getPesquisador().pesquisaCarta(Raridade.RARA);
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
		} catch (LimiteDeCartasExcedidoException e) {
			System.out.println("Limite de cartas excedido.");
		}
	}

	private void pesquisaPorNome(Loja loja) {
		System.out.println("Digite o nome da carta a ser procurada");
		String nome = leitor.leString();
		List<CartaDeColecao> cartas = loja.getPesquisador().pesquisaCarta(nome);
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
		} catch (LimiteDeCartasExcedidoException e) {
			System.out.println("Limite de cartas excedido.");
		}
	}

	private void pesquisarPorMana(Colecao j) {
		System.out.println("Digite o custo de mana que voce quer procurar");
		int man = leitor.leInt(1, 10);
		List<CartaDeColecao> cartas = j.getPesquisador().pesquisaCarta(man);
		System.out.println("0 - sair");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexM = leitor.leInt(0, cartas.size())-1;
		if(indexM == -1) return;
	}

	private void pesquisaPorValor(Colecao j) {
		System.out.println("Digite o valor que voce quer procuar");
		int c = leitor.leInt();
		System.out.println("Voce quer as cartas que custam menos que isso?");
		boolean hm = leitor.leBoolean();
		List<CartaDeColecao> cartas = j.getPesquisador().pesquisaCarta(c, hm);
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexN = leitor.leInt(0, cartas.size())-1;
		if(indexN == -1) return;
	}

	private void pesquisaPorRaridade(Colecao j) {
		System.out.println("Digite a raridade da carta a ser procurada");
		System.out.println("0 - Cancelar");
		System.out.println("1 - COMUM");
		System.out.println("2 - INCOMUM");
		System.out.println("3 - RARA");
		int b = leitor.leInt(0, 3);
		List<CartaDeColecao> cartas;
		if(b == 0) return;
		if(b == 1){
		cartas = j.getPesquisador().pesquisaCarta(Raridade.COMUM);
		}
		if(b == 2){
		cartas = j.getPesquisador().pesquisaCarta(Raridade.INCOMUM);
		}
		else{
		cartas = j.getPesquisador().pesquisaCarta(Raridade.RARA);
		}
		System.out.println("0 - Cancelar");
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		int indexNaCol = leitor.leInt(0, cartas.size())-1;
		if(indexNaCol == -1) return;
	}

	private void pesquisaPorNome(Colecao j) {
		System.out.println("Digite o nome da carta a ser procurada");
		String nome = leitor.leString();
		List<CartaDeColecao> cartas = j.getPesquisador().pesquisaCarta(nome);
		System.out.println(cartas.size());
		System.out.println(j.getCartas().size());
		for(int i = 1; i <= cartas.size(); i++){
			System.out.println(i + " - " + cartas.get(i-1));
		}
		System.out.println("0 - Cancelar");
		int x = leitor.leInt(0, 0);
		if(x == -1) return;
		}
}




