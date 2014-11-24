package BD;

import java.sql.Connection;

public abstract class DAO {

	protected Connection con;
	
	public DAO(Connection connection){
		this.con = connection;
	}
	
	public abstract Registravel load(int id);
	public abstract boolean store(Registravel registravel);
	public abstract boolean update(Registravel registravel, int id);
}
