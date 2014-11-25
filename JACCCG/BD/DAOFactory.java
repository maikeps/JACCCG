package BD;

import java.sql.SQLException;

public class DAOFactory {

	private static DAOFactory factory;
	private MySqlDataSource dataSource;
	
	private DAOFactory(){
		createDataSource();
	}
	
	private void createDataSource(){

		dataSource = new MySqlDataSource();
			try {
				dataSource.connect();
			} catch (SQLException e) {
				dataSource.connectAndCreate();
				DBCreator dbc = new DBCreator(dataSource.getConnection());
			}
	}
	
	public static DAOFactory getInstance(){
		if(factory == null) factory = new DAOFactory();
		return factory;
	}
	
	public CartaDAO getCartaDAO(){
		return new CartaDAO(dataSource.getConnection());
	}
	
	public BaralhoDAO getBaralhoDAO(){
		return new BaralhoDAO(dataSource.getConnection());
	}
	
	public ColecaoDAO getColecaoDAO(){
		return new ColecaoDAO(dataSource.getConnection());
	}

	public OponenteDAO getOponenteDAO(){
		return new OponenteDAO(dataSource.getConnection());
	}
	
	public UsuarioDAO getUsuarioDAO(){
		return new UsuarioDAO(dataSource.getConnection());
	}
}
