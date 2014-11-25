package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Batalha.Baralho;
import Batalha.Oponente;
import Cartas.CartaDeColecao;

public class OponenteDAO extends DAO{

	private BaralhoDAO baralhoDAO;
	private CartaDAO cartaDAO;
	
	public OponenteDAO(Connection connection) {
		super(connection);
		baralhoDAO = DAOFactory.getInstance().getBaralhoDAO();
		cartaDAO = DAOFactory.getInstance().getCartaDAO();
	}

	@Override
	public Registravel load(int id) {
		String nome = "";
		int vida = 0;
		int recompensa = 0;
		int numVezesDerrotado = 0;
		int numVezesBatalhado = 0;
		
		String queryStats = "SELECT * FROM oponente WHERE id = "+id;
		CartaDeColecao cartaEquivalente = null;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryStats);
			if(rs.next()){
				nome = rs.getString("nome");
				vida = rs.getInt("vida");
				recompensa = rs.getInt("recompensa");
				numVezesDerrotado = rs.getInt("numVezesDerrotado");
				numVezesBatalhado = rs.getInt("numVezesBatalhado");
				int idCarta = rs.getInt("id_carta");
				cartaEquivalente = (CartaDeColecao) cartaDAO.load(idCarta);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Baralho baralho = new Baralho(baralhoDAO.loadBaralhoOponente(id));
		Oponente oponente = new Oponente(nome, baralho, vida, recompensa, numVezesDerrotado, numVezesBatalhado, cartaEquivalente);
		oponente.setId(id);
		return oponente;
	}

	@Override
	public boolean store(Registravel registravel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Registravel registravel, int id) {
		Oponente oponente = (Oponente) registravel;
		int derrotado = oponente.getVezesDerrotado();
		int batalhado = oponente.getVezesBatalhado();
		
		String sql = "UPDATE oponente SET numVezesDerrotado = "+derrotado+", numVezesBatalhado = "+batalhado+" WHERE id = "+id;
		System.out.println(sql);
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public List<Oponente> loadOponentes() {
		List<Oponente> oponentes = new LinkedList<Oponente>();
		
		String query = "SELECT id FROM oponente";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				oponentes.add((Oponente) load(rs.getInt("id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oponentes;
	}
	
	public List<Oponente> loadOponentesLiberados(int idUsuario){
		List<Oponente> oponentes = new LinkedList<Oponente>();
		
		String sql = "SELECT * FROM oponente_liberado WHERE id_usuario = "+idUsuario;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int idOponente = rs.getInt("id_oponente");
				oponentes.add((Oponente) load(idOponente));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return oponentes;
	}

}
