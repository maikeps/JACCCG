package JACCCG.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DataSource {

	public boolean connect();
	public boolean close();
	public ResultSet executeQuery(PreparedStatement statement);
	public void executeUpdate(PreparedStatement statement);
	public boolean isConnected();
	public Connection getConnection();
}