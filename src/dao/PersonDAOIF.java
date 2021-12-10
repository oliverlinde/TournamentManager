package dao;

import java.sql.SQLException;

import model.Person;

public interface PersonDAOIF {

	Person getPerson(int personId) throws SQLException;
	
	int createPerson(Person person) throws SQLException;

}
