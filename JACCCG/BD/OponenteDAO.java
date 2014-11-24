package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Batalha.Baralho;
import Batalha.Oponente;

public class OponenteDAO extends DAO{

	private BaralhoDAO baralhoDAO;
	
	public OponenteDAO(Connection connection) {
		super(connection);
		baralhoDAO = DAOFactory.getInstance().getBaralhoDAO();
	}

	@Override
	public Registravel load(int id) {
		String nome = "";
		int vida = 0;
		int recompensa = 0;
		
		String queryStats = "SELECT nome, vida, recompensa FROM oponente WHERE id = "+id;
		
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryStats);
			if(rs.next()){
				nome = rs.getString("nome");
				vida = rs.getInt("vida");
				recompensa = rs.getInt("recompensa");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Baralho baralho = new Baralho(baralhoDAO.loadBaralhoOponente(id));
		return new Oponente(nome, baralho, vida, recompensa);
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

}
