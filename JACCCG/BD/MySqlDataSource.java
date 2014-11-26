package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlDataSource implements DataSource {

	private Connection connection = null;
	private final String driverName = "com.mysql.jdbc.Driver";
	private String dbServer;
	private String dbUser;
	private String dbPass;
	private String dbPort;
	private String dbName;
	
	public MySqlDataSource() {
		dbServer = "localhost";
		dbUser = "root";
		dbPass = "";
		dbName = "jacccg";
		dbPort = "3306";
	}
	
	public MySqlDataSource(String server, String user, String pass, String database, String port){
		this.dbServer = server;
		this.dbUser = user;
		this.dbPass = pass;
		this.dbName = database;
		this.dbPort = port;
	}
	
	@Override
	public boolean connect() throws SQLException {
		if(connection == null){
//			try{
				String stringConexao = "jdbc:mysql://"+dbServer+":"+dbPort+"/"+dbName+"?user="+dbUser+"&password="+dbPass;
				try {
					Class.forName(driverName).newInstance();
				connection = DriverManager.getConnection(stringConexao);
				System.out.println("Conectou.");
				
				return true;
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			}catch(SQLException e){
//				e.printStackTrace();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
		}else{
			try {
				if(connection.isClosed()){
					connection = null;
					return connect();
					//...
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean connectAndCreate(){
		if(connection == null){
//			try{
				String stringConexao = "jdbc:mysql://"+dbServer+":"+dbPort+"/"+dbName+"?user="+dbUser+"&password="+dbPass;
				try {
					Class.forName(driverName).newInstance();
//					connection = DriverManager.getConnection(stringConexao);
					connection = DriverManager.getConnection("jdbc:mysql://"+dbServer, dbUser, dbPass);
					
					Statement st = connection.createStatement();
					String sql = "CREATE DATABASE jacccg;";
					st.executeUpdate(sql);
					st.execute("USE jacccg;");
					System.out.println("Conectou.");
					
					return true;
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
		}else{
			try {
				if(connection.isClosed()){
					connection = null;
					return connect();
					//...
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet executeQuery(PreparedStatement statement) {
//		Statement st = connection.createStatement();
//		ResultSet rs = st.executeQuery(query);
//		//como usar
//		while(rs.next()){
//			rs.getString("Nome da coluna");
//			rs.getInt("Nome da coluna int");
//		}
		return null;
	}

	@Override
	public void executeUpdate(PreparedStatement statement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

}
