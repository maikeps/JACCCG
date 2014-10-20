package JACCCG.Visao;

import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Fabrica;
import JACCCG.Colecao.Usuario;
import JACCCG.Controle.Leitor;

public class Jogo {

	private Leitor leitor;
	private Usuario usuario;
	
	public Jogo(Leitor leitor){
		this.leitor = leitor;
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
		int input = leitor.leInput();
		switch(input){
		case 1:
			System.out.println("Comecou a partida");
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
}
