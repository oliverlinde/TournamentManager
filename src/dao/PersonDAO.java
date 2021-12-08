package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		String sqlQuery = "SELECT personId, isAdmin, personName, email, birthdate, role FROM Person "
				+ "WHERE personId = ? ";

		Person foundPerson = null;

		try {
			Connection connection = dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (rs.getBoolean(2)) {
					foundPerson = new GGWUser(rs.getInt(1), rs.getBoolean(2), rs.getString(3), rs.getString(4),
							rs.getObject(5, LocalDate.class), rs.getString(6));
				} else {
					foundPerson = new Participant(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getObject(5, LocalDate.class));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return foundPerson;
	}

}
