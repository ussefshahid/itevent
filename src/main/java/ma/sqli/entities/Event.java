package ma.sqli.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ma.sqli.factory.PersonFactory;
import ma.sqli.metier.IMetier;
import ma.sqli.metier.MetierImpl;

public class Event {
	/**
	 * the hotel where this current event is lunched
	 */
	private Hotel hotel;
	/*
	 * list of person attending this current event
	 */
	private List<Person> attentees;
	
	private IMetier metier;
	private PersonFactory personFactory;
	
	/**
	 * initializing the attributes
	 * 
	 * @param hotel
	 */
	public Event(Hotel hotel) {
		this.hotel=hotel;
		this.hotel.setEvent(this);
		this.attentees=new ArrayList<>();
		
		this.metier=new MetierImpl();
		this.personFactory=new PersonFactory();
	}
	
	public Event() {
		
	}

	/**
	 * register multiple person by their firstNames and their custom role
	 * 
	 * @param role
	 * @param firstNames
	 * @return
	 */
	public boolean register(String role, String... firstNames) {
		int availableRoomAppart=hotel.getStandardRooms()-firstNames.length;
		
		if(availableRoomAppart<0) 
			hotel.setNextAppartment(true);
		
		Arrays.stream(firstNames)
			.forEach(firstName->register(role, firstName));
		
		return true;
	}
	
	/**
	 * Overloading register method, is for register a single person by his firstName 
	 * 
	 * @param role
	 * @param firstName
	 * @return
	 */
	public boolean register(String role, String firstName) {
		Person newPerson=personFactory.getInstance(role, firstName);
		boolean existPerson=metier.ExistePerson(newPerson, attentees);
		
		if(!existPerson) {
			attentees.add(newPerson);
			hotel.signInRoom(newPerson);
		}
		
		return !existPerson;
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	public List<Person> getAttentees() {
		return attentees;
	}

	public void setAttentees(List<Person> attentees) {
		this.attentees = attentees;
	}
	
}
