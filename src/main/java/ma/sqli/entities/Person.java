package ma.sqli.entities;

public class Person {
	private String firstName;
	private String role;
	private boolean inApart;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String role, String firstName) {
		super();
		this.role=role;
		this.firstName = firstName;
		this.inApart=false;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public boolean isInApart() {
		return inApart;
	}
	public void setInApart(boolean inGroup) {
		this.inApart = inGroup;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * It facilites me to search for a person in a list
	 */
	@Override
	public boolean equals(Object obj) {
		Person person=(Person) obj;
		
		return person.getFirstName().equals(firstName) && person.getRole().equals(role);
	}
	
	/**
	 * to avoid printing person's reference when debugging. Ex: sout(person)
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name: "+firstName+"|Role: "+role;
	}
}
