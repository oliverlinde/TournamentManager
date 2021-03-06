package controller;

import java.sql.SQLException;

import dao.PersonDAOIF;
import model.Person;

public class PersonController implements PersonControllerIF {
	private PersonDAOIF personDAO;
	
	public PersonController(PersonDAOIF personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public Person getPerson(int personId) throws SQLException {
		return personDAO.getPerson(personId);
	}
	
	@Override
	public boolean verifyPerson(int personId) {
		boolean passed = false;
		try {
			if (getPerson(personId) != null) {
				passed = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passed;
	}

}
