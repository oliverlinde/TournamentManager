package DAO;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DbConnection implements DbConnectionIF {
	
	@Override
	public Connection getConnection() throws SQLServerException {
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("dmaa0221_1087651");
		ds.setPassword("Password1!");
		ds.setServerName("hildur.ucn.dk");
		ds.setDatabaseName("dmaa0221_1087651");
		return ds.getConnection();
	}
	
}
