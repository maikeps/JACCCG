package Visao;

import Controle.Leitor;

public class Main {

	public static void main(String[] args){
//		DAOFactory daoFactory = DAOFactory.getInstance();
//		BaralhoDAO baralhoDAO = daoFactory.getBaralhoDAO();
//		CartaDAO cartaDAO = daoFactory.getCartaDAO();
//		ColecaoDAO colecaoDAO = daoFactory.getColecaoDAO();
//		UsuarioDAO usuarioDAO = daoFactory.getUsuarioDAO();
//		OponenteDAO oponenteDAO = daoFactory.getOponenteDAO();
//		
//		Oponente oponente = (Oponente) oponenteDAO.load(1);
//		System.out.println(oponente.getNome());
//		
//		Usuario usuario = (Usuario) usuarioDAO.load(1);
//		Colecao colecaoUsuario = usuario.getColecao();
////		for(CartaDeColecao c : colecaoUsuario.getCartas()) System.out.println(c);
////		System.out.println();
////		for(RegistroDeBaralho rb : colecaoUsuario.getBaralhos()) System.out.println(rb+"\n");
//		
//		
//		Colecao colecao = colecaoDAO.loadColecao(1);
////		for(CartaDeColecao c : colecao.getCartas()) System.out.println(c);
////		System.out.println();
////		for(RegistroDeBaralho rb : colecao.getBaralhos()) System.out.println(rb);
//		
//		List<CartaDeColecao> cartas = cartaDAO.loadCartas(1);
////		for(CartaDeColecao c : cartas) System.out.println(c);
//		RegistroDeBaralho rb = (RegistroDeBaralho) baralhoDAO.load(1);
////		System.out.println(rb);
//		
//		
		
		
		
		
		
		
		
//		MySqlDataSource mysql = new MySqlDataSource();
//		mysql.connect();
//		
//		CartaDAO cartaDAO = new CartaDAO(mysql.getConnection());
////		Carta carta = (Carta) cartaDAO.load(3);
////		System.out.println(carta);
//		
////		LinkedList<CartaDeColecao> list = cartaDAO.loadCartas(1);
////		for(CartaDeColecao rb : list) System.out.println(rb);
//		
//		Colecao colecao = cartaDAO.loadColecao(1);
//		System.out.println("\nCartas:");
//		for(CartaDeColecao carta : colecao.getCartas()) System.out.println(carta);
//		System.out.println("\nBaralhos:");
//		for(RegistroDeBaralho rb: colecao.getBaralhos()) System.out.println(rb+"\n");
//		
		
		Leitor c = new Leitor();
		Jogo j = new Jogo(c);		
	}
}
