package BD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreator {

	private Connection con;
	
	public DBCreator(Connection con){
		this.con = con;
		createDB();
	}
	
	private void createDB(){
		createTableCarta();
		createTableUsuario();
		createTableOponente();
		createTableBaralho();
		createTableCartaBaralho();
		createTableCartaOponente();
		createTableColecao();
		createTableCartaColecao();
		createTableBaralhoColecao();
		createTableCartaLiberada();
		
		insertCartas();
		insertOponentes();
		insertBaralhosOponente();
	}
	
	private void createTableCarta(){
		String sql = "CREATE TABLE carta("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"nome VARCHAR(40) NOT NULL,"+
					"atk INT NOT NULL,"+
					"def INT NOT NULL,"+
					"custoMana INT NOT NULL,"+
					"vida INT NOT NULL,"+
					"raridade ENUM('COMUM', 'INCOMUM', 'RARA') NOT NULL,"+
					"preco INT NOT NULL,"+
					"PRIMARY KEY(id));";
		
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}		
	}

	private void createTableUsuario(){
		String sql = "CREATE TABLE usuario("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"nome VARCHAR(40) NOT NULL,"+
					"dinheiros INT NOT NULL,"+
					"PRIMARY KEY(id));";
				
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	private void createTableOponente(){
		String sql = "CREATE TABLE oponente("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"nome VARCHAR(40) NOT NULL,"+
					"vida INT NOT NULL,"+
					"recompensa INT NOT NULL,"+
					"numVezesDerrotado INT NOT NULL DEFAULT 0,"+
					"numVezesBatalhado INT NOT NULL DEFAULT 0,"+
					"PRIMARY KEY(id));";
		
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableBaralho(){
		String sql = "CREATE TABLE baralho("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"nome VARCHAR(40) NOT NULL,"+
					"id_usuario INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_usuario) REFERENCES usuario(id));";

		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableCartaBaralho(){
		String sql = "CREATE TABLE carta_baralho("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"id_carta INT NOT NULL,"+
					"id_baralho INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_carta) REFERENCES carta(id),"+
					"FOREIGN KEY(id_baralho) REFERENCES baralho(id));";

		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableCartaOponente(){
		String sql = "CREATE TABLE carta_oponente("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"id_oponente INT NOT NULL,"+
					"id_carta INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_oponente) REFERENCES oponente(id),"+
					"FOREIGN KEY(id_carta) REFERENCES carta(id));";
		
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableColecao(){
		String sql = "CREATE TABLE colecao("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"id_usuario INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_usuario) REFERENCES usuario(id));";
		
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableCartaColecao(){
		String sql = "CREATE TABLE carta_colecao("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"id_carta INT NOT NULL,"+
					"id_colecao INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_carta) REFERENCES carta(id),"+
					"FOREIGN KEY(id_colecao) REFERENCES colecao(id));";
				
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void createTableBaralhoColecao(){
		String sql = "CREATE TABLE baralho_colecao("+
					"id INT NOT NULL AUTO_INCREMENT,"+
					"id_baralho INT NOT NULL,"+
					"id_colecao INT NOT NULL,"+
					"PRIMARY KEY(id),"+
					"FOREIGN KEY(id_baralho) REFERENCES baralho(id),"+
					"FOREIGN KEY(id_colecao) REFERENCES colecao(id));";
		
		try{
			Statement st = con.createStatement();
			st.execute(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	private void insertCartas() {
		String sql;
		
		try {
			Statement st = con.createStatement();
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Goblin1\", 2, 1, 1, 1, 'COMUM', 100);";
			st.executeUpdate(sql);
	
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Goblin2\", 2, 2, 1, 1, 'COMUM', 110);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Goblin3\", 4, 1, 1, 1, 'INCOMUM', 201);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Goblin4\", 4, 2, 2, 2, 'INCOMUM', 205);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Goblin5\", 6, 2, 2, 3, 'RARA', 650);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide1\", 2, 1, 1, 2, 'COMUM', 50);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide2\", 2, 1, 1, 4, 'COMUM', 130);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide3\", 4, 3, 2, 2, 'INCOMUM', 290);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide4\", 4, 3, 2, 3, 'INCOMUM', 140);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide5\", 4, 3, 3, 3, 'RARA', 540);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Humanoide6\", 4, 3, 4, 3, 'RARA', 540);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Fera1\", 8, 0, 4, 2, 'INCOMUM', 300);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Fera2\", 10, 0, 2, 2, 'RARA', 400);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Monstruoso1\", 12, 3, 6, 4, 'INCOMUM', 350);";
			st.executeUpdate(sql);
			
			sql = "INSERT INTO carta (nome, atk, def, custoMana, vida, raridade, preco) VALUES (\"Monstruoso2\", 10, 2, 5, 4, 'RARA', 600);";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insertOponentes(){
		String sql;
		
		try{
			Statement st = con.createStatement();
			
			sql = "INSERT INTO oponente (nome, vida, recompensa) VALUES (\"Oponente Teste\", 20, 50);";
			st.executeUpdate(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private void insertBaralhosOponente(){
		String sql;
		
		try{
			Statement st = con.createStatement();
			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 1);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 2);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 2);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 12);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 13);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 5);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 6);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 6);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 7);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 7);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 8);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 9);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 15);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 11);";
			st.executeUpdate(sql);			
			sql = "INSERT INTO carta_oponente (id_oponente, id_carta) VALUES (1, 4);";
			st.executeUpdate(sql);
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
