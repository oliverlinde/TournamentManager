package controller;

import dao.DbConnectionIF;

import java.sql.SQLException;

import dao.DAOFactory;
import dao.DbConnection;
import dao.PersonDAOIF;
import model.Person;

public class PersonController implements PersonControllerIF {
	private Person person;
	private PersonDAOIF personDAO;
	
	public PersonController() {
		this.personDAO = DAOFactory.createPersonDAO(new DbConnection());
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
	
	@Override
	public boolean verifyPerson(int personId) {
		boolean passed = false;
		try {
			if (getPerson(personId) != null) {
				passed = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passed;
	}

}
