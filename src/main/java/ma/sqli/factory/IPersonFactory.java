package ma.sqli.factory;

import ma.sqli.entities.Person;

public interface IPersonFactory {
	public Person getInstance(String role, String firstName);
}
