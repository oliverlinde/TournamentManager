package controller;

import dao.DbConnectionIF;
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
	public Person getPerson(int id) {
		return this.person = personDAO.getPerson(id);
	}

	@Override
	public Person createPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
