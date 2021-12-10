package controller;

import java.sql.SQLException;

import model.Person;

public interface PersonControllerIF {
	Person getPerson(int personId) throws SQLException;
	Person createPerson();
	boolean verifyPerson(int personId);
}
