package controller;

import model.Person;

public interface PersonControllerIF {
	Person getPerson(int id);
	Person createPerson();
}
