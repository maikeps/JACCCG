package JACCCG.BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import JACCCG.Cartas.Carta;
import JACCCG.Cartas.CartaDeColecao;
import JACCCG.Cartas.Raridade;


public class CartaDAO {
	
	private Connection con;
	
	public CartaDAO(Connection connection){
		this.con = connection;
	}

	public Carta getCarta(int id){
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
				
				return new CartaDeColecao(nome, atk, def, custoMana, vida, raridade, preco);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
