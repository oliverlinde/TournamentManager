package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.DbConnection;
import dao.DbConnectionIF;

class DbConnectionTest {
	DbConnectionIF dbConnection;
	Connection connection;

	@BeforeEach
	void before() throws Exception {
		dbConnection = new DbConnection();
		connection = dbConnection.getConnection();
	}
	
	// After testing the connection is always closed
	@AfterEach
	void after() throws Exception {
		connection.close();
	}

	@Test
	void test() {
		try {
			assertTrue(connection.isValid(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
