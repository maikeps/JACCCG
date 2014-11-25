package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
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
}
