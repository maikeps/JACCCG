package JACCCG.BD;

public class DAOFactory {

	private static DAOFactory factory;
	private MySqlDataSource dataSource;
	
	private DAOFactory(){
		dataSource = new MySqlDataSource();
		dataSource.connect();
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
}
