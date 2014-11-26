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
			
			RegistroDeBaralho baralho = new RegistroDeBaralho(cartas, nome, cartas.size());
			baralho.setId(id);
			return baralho;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean store(Registravel registravel) {
		return false;
	}

	@Override
	public boolean update(Registravel registravel, int id) {
		System.out.println("Update");
		return false;
	}
	
	public boolean store(RegistroDeBaralho baralho, int idUsuario){
		if(baralho.getId() != 0) return update(baralho, baralho.getId());
//		int idUsuario = getIdDonoDoBaralho(baralho);
		
		String queryNome = "INSERT INTO baralho (nome, id_usuario) VALUES (\""+baralho.getNome()+"\", "+idUsuario+")";
		try{
			Statement st = con.createStatement();
			st.execute(queryNome);

			ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID()");
			if(rs.next()) {
				baralho.setId(rs.getInt(1));
			}
			for(CartaDeColecao carta : baralho.getCartas()){
				String queryCartas = "INSERT INTO carta_baralho (id_baralho, id_carta) VALUES ("+baralho.getId() + ", "+carta.getId()+")";
				st.execute(queryCartas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
			
			RegistroDeBaralho baralho = new RegistroDeBaralho(cartas, nome, cartas.size());
			baralho.setId(id);
			return baralho;
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
			
			RegistroDeBaralho baralho = new RegistroDeBaralho(cartas, nome, cartas.size());
			return baralho;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int getIdDonoDoBaralho(RegistroDeBaralho baralho){
		String queryId = "SELECT u.id FROM usuario AS u "
				+ "INNER JOIN baralho AS b ON u.id = b.id_usuario "
				+ "WHERE b.id = "+baralho.getId();
		
		System.out.println(queryId);
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryId);
			if(rs.next()) return rs.getInt("u.id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public boolean storeBaralho(int idColecao, RegistroDeBaralho baralho) {
		String query = "SELECT id_usuario FROM colecao AS c WHERE id = "+idColecao;
		
		int idUsuario = 0;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				idUsuario = rs.getInt("id_usuario");			
				String sql = "INSERT INTO baralho (nome, id_usuario) VALUES ("+baralho.getNome()+", "+idUsuario+")";
				st.executeUpdate(sql);
				for(CartaDeColecao carta : baralho.getCartas()){
					sql = "INSERT INTO carta_baralho (id_baralho, id_carta) VALUES ("+baralho.getId()+", "+carta.getId()+")";
					st.executeUpdate(sql);
				}
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void newBaralhos(int idUsuario){
		String sql1 = "INSERT INTO baralho (nome, id_usuario) VALUES (\"Humans and Pals\", "+idUsuario+");";
		String sql2 = "INSERT INTO baralho (nome, id_usuario) VALUES (\"Goblins and Fiends\", "+idUsuario+");";
		String sql3 = "INSERT INTO baralho (nome, id_usuario) VALUES (\"No Hands\", "+idUsuario+");";
		
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);

			//Humans and Pals
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Soldado");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Soldado");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Soldado");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Barbaro");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Companheiro da Matilha");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Lobo Atroz");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Poodim");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Poodim");
			storeCartaNoBaralho(idUsuario, "Humans and Pals", "Poodim");

			//Goblins and Fiends
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Soldado Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Soldado Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Soldado Goblin");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Goblin Enfurecido");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Filhote Feroz");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Dinobulba");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Infernal");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Poodim");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Poodim");
			storeCartaNoBaralho(idUsuario, "Goblins and Fiends", "Poodim");

			//No Hands
			storeCartaNoBaralho(idUsuario, "No Hands", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "No Hands", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "No Hands", "Recruta Goblin");
			storeCartaNoBaralho(idUsuario, "No Hands", "Soldado Goblin");
			storeCartaNoBaralho(idUsuario, "No Hands", "Soldado Goblin");
			storeCartaNoBaralho(idUsuario, "No Hands", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "No Hands", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "No Hands", "Escudeiro");
			storeCartaNoBaralho(idUsuario, "No Hands", "Soldado");
			storeCartaNoBaralho(idUsuario, "No Hands", "Soldado");
			storeCartaNoBaralho(idUsuario, "No Hands", "Companheiro da Matilha");
			storeCartaNoBaralho(idUsuario, "No Hands", "Companheiro da Matilha");
			storeCartaNoBaralho(idUsuario, "No Hands", "Lobo Atroz");
			storeCartaNoBaralho(idUsuario, "No Hands", "Dinobulba");
			storeCartaNoBaralho(idUsuario, "No Hands", "Infernal");
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void storeCartaNoBaralho(int idUsuario, String nomeBaralho, String nomeCarta){
		int idCarta = cartaDAO.getId(nomeCarta);
		int	idBaralho = getId(idUsuario, nomeBaralho);
		String sql = "INSERT INTO carta_baralho (id_baralho, id_carta) VALUES ("+idBaralho+", "+idCarta+");";
		
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	private int getId(int idUsuario, String nomeBaralho) {
		String sql = "SELECT id FROM baralho WHERE id_usuario = "+idUsuario+" AND nome = \""+nomeBaralho+"\";";
		
		int id = 0;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) id = rs.getInt("id");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return id;
	}
}
