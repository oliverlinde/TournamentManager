package dao;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DbConnectionTest implements DbConnectionIF {
	@Override
	public Connection getConnection() throws SQLServerException {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("defaultuser");
		ds.setPassword("Password1!");
		ds.setServerName("localhost\\sqlexpress");
		ds.setDatabaseName("Test");
		return ds.getConnection();
	}
	
}
