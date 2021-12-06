package dao;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public interface DbConnectionIF {
	
	Connection getConnection() throws SQLServerException;

}
