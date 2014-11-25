package BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Cartas.CartaDeColecao;
import Cartas.Raridade;


public class CartaDAO extends DAO{
	
	public CartaDAO(Connection connection){
		super(connection);
	}

	@Override
	public Registravel load(int id) {
		String nome;
		int atk;
		int def;
		int custoMana;
		int vida;
		Raridade raridade;
		int preco;
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM carta WHERE id = "+id);
			if(rs.next()){
				nome = rs.getString("nome");
				atk = rs.getInt("atk");
				def = rs.getInt("def");
				custoMana = rs.getInt("custoMana");
				vida = rs.getInt("vida");
				raridade = Raridade.valueOf(rs.getString("raridade"));
				preco = rs.getInt("preco");

				CartaDeColecao carta = new CartaDeColecao(nome, atk, def, custoMana, vida, raridade, preco);
				carta.setId(id);
				return carta;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean store(Registravel registravel) {
		//Não se deve fazer store de carta
//		CartaDeColecao carta = (CartaDeColecao) registravel;
//		String nome = carta.getNome();
//		int atk = carta.getAtaque();
//		int def = carta.getDefesa();
//		int custoMana = carta.getCustoMana();
//		int vida = carta.getVida();
//		String raridade = carta.getRaridade().name();
//		int preco = carta.getPreco();
//		
//		try{
//			Statement st = con.createStatement();
//			st.executeUpdate("INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES "
//					+ "("+nome+")"
//					+ "("+atk+")"
//					+ "("+def+")"
//					+ "("+custoMana+")"
//					+ "("+vida+")"
//					+ "("+raridade+")"
//					+ "("+preco+")");
//			
//			return true;
//		} catch (SQLException e) {
//			return false;
//		}
		
		return false;
	}

	@Override
	public boolean update(Registravel registravel, int id) {
		//Não se deve fazer update de carta
		return false;
	}

	public LinkedList<CartaDeColecao> loadCartas(int idUsuario){
		LinkedList<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		
		String queryCartas = "SELECT c.id FROM usuario AS u "
				+ "INNER JOIN colecao AS col ON u.id = col.id_usuario "
				+ "INNER JOIN carta_colecao AS ccol ON col.id = ccol.id_colecao "
				+ "INNER JOIN carta AS c ON c.id = ccol.id_carta "
				+ "WHERE u.id = "+idUsuario;
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(queryCartas);
			while(rs.next()){
				int id = rs.getInt("c.id");
				cartas.add((CartaDeColecao) load(id));
			}
			
			return cartas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;		
	}

	public List<CartaDeColecao> loadCartas() {
		LinkedList<CartaDeColecao> cartas = new LinkedList<CartaDeColecao>();
		
		String sql = "SELECT * FROM carta";
		
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int atk = rs.getInt("atk");
				int def = rs.getInt("def");
				int custoMana = rs.getInt("custoMana");
				int vida = rs.getInt("vida");
				Raridade raridade = Raridade.valueOf(rs.getString("raridade"));
				int preco = rs.getInt("preco");
				
				CartaDeColecao carta = new CartaDeColecao(nome, atk, def, custoMana, vida, raridade, preco);
				carta.setId(id);
				cartas.add(carta);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return cartas;
	}
}
