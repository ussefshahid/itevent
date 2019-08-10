package ma.sqli.factory;

import ma.sqli.entities.Person;

public class PersonFactory implements IPersonFactory {
	
	@Override
	public Person getInstance(String role, String firstName) {
		return new Person(role, firstName);
	}
}
