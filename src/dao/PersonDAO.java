package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.GGWUser;
import model.Participant;
import model.Person;

public class PersonDAO implements PersonDAOIF {
	private DbConnectionIF dbConnection;

	public PersonDAO(DbConnectionIF dbConnection) {
		// TODO Auto-generated constructor stub
		this.dbConnection = dbConnection;
	}

	@Override
	public Person getPerson(int personId) throws SQLException{
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT personId, isAdmin, personName, email, birthdate, role FROM Person "
				+ "WHERE personId = ? ";

		Person foundPerson = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, personId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean(2)) {
					foundPerson = new GGWUser(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4),
							rs.getObject(5, LocalDate.class), rs.getString(6));
				} else {
					foundPerson = new Participant(rs.getInt(1), rs.getString(3), rs.getString(4),
							rs.getObject(5, LocalDate.class));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundPerson;
	}

	public int createPerson(Person person) throws SQLException {
		String sqlQuery = "INSERT INTO Person (personId, isAdmin, personName, email, birthdate, role) "
				+ "VALUES ?, ?, ?, ?, ?, ? ";

		int rowsAffected = 0;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			ResultSet rs = statement.executeQuery();

			if (person instanceof GGWUser) {
				statement.setInt(1, person.getPersonId());
				statement.setBoolean(2, true);
				statement.setString(3, person.getPersonName());
				statement.setString(4, person.getEmail());
				statement.setObject(5, LocalDate.class);
				statement.setString(6, ((GGWUser) person).getRole());
			} else {
				statement.setInt(1, person.getPersonId());
				statement.setBoolean(2, false);
				statement.setString(3, person.getPersonName());
				statement.setString(4, person.getEmail());
				statement.setObject(5, LocalDate.class);
				statement.setString(6, "");
			}
			rowsAffected = statement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowsAffected;

	}

}
