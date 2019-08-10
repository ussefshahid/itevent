package ma.sqli.metier;

import java.util.List;

import ma.sqli.entities.Person;

public class MetierImpl implements IMetier {
	/* 
	 * check existence of a person by a person Class reference (Already override equals method in the person class)
	 * 
	 */
	@Override
	public boolean ExistePerson(Person person, List<Person> attentees) {
		Person checkedPerson = attentees.stream()
			.filter(p->p.getFirstName().equals(person.getFirstName()) && p.getRole().equals(person.getRole()))
			.findAny()
			.orElse(null);
		
		return !(checkedPerson==null);
	}
	
	/* 
	 * check existence of a person by his firstName (Already override equals method in the person class)
	 * 
	 */
	@Override
	public boolean ExistePerson(String firstName, List<Person> attentees) {
		Person checkedPerson = attentees.stream()
			.filter(p->p.getFirstName().equals(firstName))
			.findAny()
			.orElse(null);
		
		return !(checkedPerson==null);
	}
	
	/* 
	 * get the person by his firstName
	 */
	@Override
	public Person getPersonByFirstName(String firstName, List<Person> attentees) {
		Person person = attentees.stream()
				.filter(p->p.getFirstName().equals(firstName))
				.findAny()
				.orElse(null);
		
		return person;
	}
	
	/* 
	 * print the room details;
	 */
	@Override
	public String print(Person person, int roomNumber) {
		// using StringBuilder is much better than String, because string is immutable class
		StringBuilder printRoom=new StringBuilder("");
		
		if(person.getRole().equals("TRINGA")|| person.getRole().equals("STAFF")
				|| person.getRole().equals("DEEP DIVE") || person.getRole().equals("CONF"))
			if(!person.isInApart()) printRoom.append("Standard room N°"+roomNumber);
			else printRoom.append("Apart N°"+roomNumber);
		else if(person.getRole().equals("SPEAKER"))
			printRoom.append("Suite N°"+roomNumber);
		
		return printRoom.toString();
	}
}
