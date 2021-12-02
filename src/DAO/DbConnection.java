package DAO;

import javax.sql.DataSource;

public class DbConnection {
	private Connection connection;
	
	public Connection getConnection() {
		DataSource ds = new DataSource();
		ds.setUser("TestUser");
		ds.setPassword("test123");
		ds.setServerName("");
		ds.setDatabaseName("TournamentManager");
		return ds.getConnection();
	}
	
}
