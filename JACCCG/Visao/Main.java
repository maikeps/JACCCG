package JACCCG.Visao;

import java.util.List;

import JACCCG.BD.BaralhoDAO;
import JACCCG.BD.CartaDAO;
import JACCCG.BD.DAOFactory;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Colecao.RegistroDeBaralho;

public class Main {

	public static void main(String[] args){
		DAOFactory daoFactory = DAOFactory.getInstance();
		BaralhoDAO baralhoDAO = daoFactory.getBaralhoDAO();
		CartaDAO cartaDAO = daoFactory.getCartaDAO();
		
		List<CartaDeColecao> cartas = cartaDAO.loadCartas(1);
		for(CartaDeColecao c : cartas) System.out.println(c);
		RegistroDeBaralho rb = (RegistroDeBaralho) baralhoDAO.load(1);
//		System.out.println(rb);
		
		
		
		
		
		
		
		
		
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
		
//		Leitor c = new Leitor();
//		Jogo j = new Jogo(c);		
	}
}
