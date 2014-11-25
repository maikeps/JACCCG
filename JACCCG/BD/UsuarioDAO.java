package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Colecao.Colecao;
import Colecao.Usuario;

public class UsuarioDAO extends DAO{

	private ColecaoDAO colecaoDAO;
	
	public UsuarioDAO(Connection connection) {
		super(connection);
		colecaoDAO = DAOFactory.getInstance().getColecaoDAO();
	}

	@Override
	public Registravel load(int id) {
		String queryNome = "SELECT nome, dinheiros FROM usuario WHERE id = "+id;
		
		String nome = "";
		int dinheiros = 0;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryNome);
			if(rs.next()) {
				nome = rs.getString("nome");
				dinheiros = rs.getInt("dinheiros");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("DFDF UsuarioDAO");
			return null;
		}
		
		Colecao colecao = colecaoDAO.loadColecao(id);
		Usuario usuario = new Usuario(colecao, dinheiros);
		usuario.setId(id);
		return usuario;
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
