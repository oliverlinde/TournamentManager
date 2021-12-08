package controller;

import dao.DbConnectionIF;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.PersonDAOIF;
import model.Person;

public class PersonController implements PersonControllerIF {
	private Person person;
	private PersonDAOIF personDAO;
	
	public PersonController(DbConnectionIF dbConnection) {
		this.personDAO = DAOFactory.createPersonDAO(dbConnection);
	}

	@Override
	public Person getPerson(int personId) throws SQLException {
		return this.person = personDAO.getPerson(personId);
	}

	@Override
	public Person createPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
