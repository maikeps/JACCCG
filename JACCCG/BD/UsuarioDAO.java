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
			return null;
		}
		
		Colecao colecao = colecaoDAO.loadColecao(id);
		Usuario usuario = new Usuario(colecao, dinheiros, nome);
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

	public boolean updateDinheiros(int idUsuario, int dinheiros) {
		String sql = "UPDATE usuario SET dinheiros = "+dinheiros+" WHERE id = "+idUsuario;
		
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			return true;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return false;
	}

	public int newUsuario(String nome, int dinheiros) {
		String sqlUsuario = "INSERT INTO usuario (nome, dinheiros) VALUES (\""+nome+"\", "+dinheiros+");";
		System.out.println(sqlUsuario);
		try{
			Statement st = con.createStatement();
			st.executeUpdate(sqlUsuario);
			
			String queryId = "SELECT LAST_INSERT_ID()";
			ResultSet rs = st.executeQuery(queryId);
			if(rs.next()){
				int idUsuario = rs.getInt(1);
				colecaoDAO.newColecao(idUsuario);
				st.executeUpdate("INSERT INTO oponente_liberado (id_oponente, id_usuario) VALUES (1, "+idUsuario+")");
				return idUsuario;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
//		colecaoDAO.newColecao();
//		Usuario usuario;
	}

	public int getNumUsuarios() {
		String sql = "SELECT * FROM usuario;";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i = 0;
			while(rs.next()) {
				i ++;
			}
			return i;
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
