package ma.sqli.metier;

import java.util.List;

import ma.sqli.entities.Person;

public interface IMetier {
	//person methods
	public boolean ExistePerson(Person person, List<Person> attentees);
	public boolean ExistePerson(String firstName, List<Person> attentees);
	public Person getPersonByFirstName(String firstName, List<Person> attentees);
	public String print(Person person, int roomNumber);
}
