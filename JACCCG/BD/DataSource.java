package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataSource {

	public boolean connect() throws SQLException;
	public boolean close();
	public ResultSet executeQuery(PreparedStatement statement);
	public void executeUpdate(PreparedStatement statement);
	public boolean isConnected();
	public Connection getConnection();
}