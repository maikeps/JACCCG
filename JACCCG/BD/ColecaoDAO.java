package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Cartas.Raridade;
import Colecao.Colecao;
import Colecao.RegistroDeBaralho;

public class ColecaoDAO extends DAO {
	
	private CartaDAO cartaDAO;
	private BaralhoDAO baralhoDAO;

	public ColecaoDAO(Connection connection) {
		super(connection);
		cartaDAO = DAOFactory.getInstance().getCartaDAO();
		baralhoDAO = DAOFactory.getInstance().getBaralhoDAO();
	}

	@Override
	public Registravel load(int id) {
		int idUsuario = -1;
		
		String query = "SELECT u.id FROM colecao AS c "
				+ "INNER JOIN usuario AS u ON u.id = c.id_usuario";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) idUsuario = rs.getInt("u.id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LinkedList<CartaDeColecao> cartas = cartaDAO.loadCartas(idUsuario);
		LinkedList<RegistroDeBaralho> baralhos = baralhoDAO.loadBaralhos(idUsuario);
		
		if(cartas == null || baralhos == null) return null;
		Colecao colecao = new Colecao(cartas, baralhos);
		colecao.setId(id);
		return colecao;
	}

	@Override
	public boolean store(Registravel registravel) {
		Colecao colecao = (Colecao) registravel;
		List<CartaDeColecao> cartas = colecao.getCartas();
		List<RegistroDeBaralho> baralhos = colecao.getBaralhos();
		
//		cartaDAO.
		
		return false;
	}

	@Override
	public boolean update(Registravel registravel, int id) {
		// TODO Auto-generated method stub
		return false;
	}


	public Colecao loadColecao(int idUsuario){
		LinkedList<CartaDeColecao> cartas = cartaDAO.loadCartas(idUsuario);
		LinkedList<RegistroDeBaralho> baralhos = baralhoDAO.loadBaralhos(idUsuario);
		
		String sql = "SELECT id FROM colecao WHERE id_usuario = "+idUsuario;
		int id = 0;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) id = rs.getInt("id"); 
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		if(cartas == null || baralhos == null) return null;
		Colecao colecao = new Colecao(cartas, baralhos);
		colecao.setId(id);
		return colecao;
	}
	
	public boolean storeCartaNaColecao(int idColecao, int idCarta){
//		String query = "SELECT cc.id FROM carta_colecao AS cc "
//				+ "INNER JOIN colecao AS c ON c.id = cc.id_colecao "
//				+ "WHERE c.id_usuario = "+ idUsuario + " AND cc.id_carta = "+idCarta;
//		 
		String query = "SELECT * FROM carta_colecao WHERE id_colecao = "+idColecao+" AND id_carta = "+idCarta;		
		String sql = "INSERT INTO carta_colecao (id_colecao, id_carta) VALUES ("+idColecao+", "+idCarta+")";
		
		CartaDeColecao carta = (CartaDeColecao) cartaDAO.load(idCarta);
		Raridade raridade = carta.getRaridade();
		int max = raridade.ordinal()+1;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int qtd = 0;
			while(rs.next()) qtd++;
//			int qtd = rs.getFetchSize();
			if(qtd < max) st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean storeNewCartaNaColecao(int idColecao, String nomeCarta){
		String query = "SELECT id FROM carta WHERE nome = \""+nomeCarta+"\"";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()){
				int idCarta = rs.getInt("id");
				cartaDAO.storeCartaLiberada(idCarta, idColecao);
				return storeCartaNaColecao(idColecao, idCarta);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteCartaColecao(int idColecao, int idCarta) {
		String sql = "DELETE FROM carta_colecao WHERE id_colecao = "+idColecao+" AND id_carta = "+idCarta;
		
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public void newColecao(int idUsuario) {
		String sqlColecao = "INSERT INTO colecao (id_usuario) VALUES ("+idUsuario+");";
		
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sqlColecao);
			
			String queryId = "SELECT LAST_INSERT_ID()";
			ResultSet rs = st.executeQuery(queryId);
			if(rs.next()){
				int idColecao = rs.getInt(1);
				storeNewCartaNaColecao(idColecao, "Poodim");
				storeNewCartaNaColecao(idColecao, "Recruta Goblin");
				storeNewCartaNaColecao(idColecao, "Soldado Goblin");
				storeNewCartaNaColecao(idColecao, "Goblin Enfurecido");
				storeNewCartaNaColecao(idColecao, "Escudeiro");
				storeNewCartaNaColecao(idColecao, "Soldado");
				storeNewCartaNaColecao(idColecao, "Barbaro");
				storeNewCartaNaColecao(idColecao, "Filhote Feroz");
				storeNewCartaNaColecao(idColecao, "Companheiro da Matilha");
				storeNewCartaNaColecao(idColecao, "Lobo Atroz");
				storeNewCartaNaColecao(idColecao, "Dinobulba");
				storeNewCartaNaColecao(idColecao, "Infernal");
				
				baralhoDAO.newBaralhos(idUsuario);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
