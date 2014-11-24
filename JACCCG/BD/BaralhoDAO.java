package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Colecao.RegistroDeBaralho;

public class BaralhoDAO extends DAO{

	private CartaDAO cartaDAO;
	
	public BaralhoDAO(Connection connection) {
		super(connection);
		cartaDAO = DAOFactory.getInstance().getCartaDAO();
	}

	@Override
	public Registravel load(int id) {
		List<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		String nome = "";
		
		String queryNome = "SELECT nome FROM baralho WHERE id = "+ id;
		String queryCartas = "SELECT c.id FROM usuario AS u "
				+ "INNER JOIN baralho AS b ON u.id = b.id_usuario "
				+ "INNER JOIN carta_baralho as cb ON b.id = cb.id_baralho "
				+ "INNER JOIN carta as c ON c.id = cb.id_carta "
				+ "WHERE b.id = "+ id;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryNome);
			if(rs.next()) nome = rs.getString("nome");
			
			rs = st.executeQuery(queryCartas);
			while(rs.next()){
				int idCarta = rs.getInt("c.id");
				cartas.add((CartaDeColecao) cartaDAO.load(idCarta));
			}
			
			return new RegistroDeBaralho(cartas, nome, cartas.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean store(Registravel registravel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Registravel registravel, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public RegistroDeBaralho loadBaralho(int idUsuario, int id){
		List<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		String nome = "";
		
		String queryNome = "SELECT nome FROM baralho WHERE id = "+ id +" AND id_usuario = "+idUsuario;
		String queryCartas = "SELECT c.id FROM usuario AS u "
				+ "INNER JOIN baralho AS b ON u.id = b.id_usuario "
				+ "INNER JOIN carta_baralho as cb ON b.id = cb.id_baralho "
				+ "INNER JOIN carta as c ON c.id = cb.id_carta "
				+ "WHERE u.id = "+ idUsuario + " AND b.id = "+ id;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryNome);
			if(rs.next()) nome = rs.getString("nome");
			
			rs = st.executeQuery(queryCartas);
			while(rs.next()){
				int idCarta = rs.getInt("c.id");
				cartas.add((CartaDeColecao) cartaDAO.load(idCarta));
			}
			
			return new RegistroDeBaralho(cartas, nome, cartas.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public LinkedList<RegistroDeBaralho> loadBaralhos(int idUsuario){
		LinkedList<RegistroDeBaralho> baralhos = new LinkedList<RegistroDeBaralho>();
		
		String query = "SELECT b.id FROM usuario AS u "
				+ "INNER JOIN baralho as b on u.id = b.id_usuario "
				+ "WHERE u.id = "+idUsuario;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("b.id");
				baralhos.add(loadBaralho(idUsuario, id));
			}
			
			return baralhos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}	

	public RegistroDeBaralho loadBaralhoOponente(int idOponente){
		String queryNome = "SELECT nome FROM oponente WHERE id = "+idOponente;
		String query = "SELECT c.id FROM oponente AS o "
				+ "INNER JOIN carta_oponente AS co ON o.id = co.id_oponente "
				+ "INNER JOIN carta AS c ON c.id = co.id_carta "
				+ "WHERE o.id = "+idOponente;
		
		String nome = "";
		LinkedList<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryNome);
			if(rs.next()) nome = rs.getString("nome");
			
			rs = st.executeQuery(query);
			while(rs.next()){
				cartas.add((CartaDeColecao) cartaDAO.load(rs.getInt("c.id")));
			}
			
			return new RegistroDeBaralho(cartas, nome, cartas.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
