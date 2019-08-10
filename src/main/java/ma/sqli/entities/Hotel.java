package ma.sqli.entities;

import java.util.HashMap;
import java.util.Map;

import configuration.Configuration;
import ma.sqli.metier.IMetier;
import ma.sqli.metier.MetierImpl;

import static configuration.Configuration.*;

public class Hotel {
	private int standardRooms;
    private int suites;
    private int apparts;
    
    private Event event;
    
    /**
     * list contains every person & his reserved room number
     */
    private Map<Person, Integer> reservedRooms;
    private IMetier metier;

    private int tringas=startStandardRoom;
    private int speakers=startSpeakerRoom;
    private int confDeepDiveRoomNumber=notFoundRoom;
    private int groupRoom=startApart;
    
    private boolean isNextAppartment=false;
    
	public Hotel(int standardRooms, int suites, int apparts) {
		super();
		this.standardRooms = standardRooms;
		this.suites = suites;
		this.apparts = apparts;
		
		reservedRooms=new HashMap<>();
		metier=new MetierImpl();
	}
    
    public Hotel() {
    	
    }
    
    /**
     * reserve a room for a person based on his role (STAFF or TRINGA or...)
     * 
     * @param person
     * @return
     */
    public int reserveRoom(Person person) {
    	int roomNumber=notFoundRoom;
    	
    	if(person.getRole().equals("TRINGA") || person.getRole().equals("STAFF")) {
    		if(isNextAppartment) {
    			roomNumber=++groupRoom;
    			person.setInApart(true);
    			apparts--;
    		}else {
    			if(tringas==endStandardRoom) {
    				standardRooms=startStandardRoom;
    	    		person.setInApart(true);
    	    		tringas=startApart;
    	    		apparts--;
    			}else standardRooms--;
    			roomNumber=++tringas;
    			
    		}
        	
    	}else if(person.getRole().equals("SPEAKER")) {
    		roomNumber=++speakers;
    		suites--;
    	}else if(person.getRole().equals("DEEP DIVE") || person.getRole().equals("CONF")) {
    		if(confDeepDiveRoomNumber!=notFoundRoom)
    			roomNumber=confDeepDiveRoomNumber;
    		else {
    			confDeepDiveRoomNumber=roomNumber=++tringas;
            	standardRooms--;
    		}
    	}
    	
    	if(roomNumber!=notFoundRoom) reservedRooms.put(person, roomNumber);
    	
    	return roomNumber;
    }

    
    /**
     * start reserve a room for a person
     * 
     * @param person
     */
    public void signInRoom(Person person) {
		if(person!=null) {
			if(!reservedRooms.containsKey(person))
				reserveRoom(person);
		}
    }
    
    /**
     * get the room of a person by his firstName
     * 
     * @param firstName
     * @return
     */
    public String getRoomFor(String firstName) {
		Person person=metier.getPersonByFirstName(firstName, event.getAttentees());
		int roomNumber=reservedRooms.get(person);
		
		return metier.print(person, roomNumber);
	}

	public int getStandardRooms() {
		return standardRooms;
	}

	public void setStandardRooms(int standardRooms) {
		this.standardRooms = standardRooms;
	}

	public Event getEvent() {
		return event;
	}
	
	public boolean isNextAppartment() {
		return isNextAppartment;
	}

	public void setNextAppartment(boolean isNextAppartment) {
		this.isNextAppartment = isNextAppartment;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getSuites() {
		return suites;
	}

	public void setSuites(int suites) {
		this.suites = suites;
	}

	public int getApparts() {
		return apparts;
	}
	

	public Map<Person, Integer> getReservedRooms() {
		return reservedRooms;
	}

	public void setReservedRooms(Map<Person, Integer> reservedRooms) {
		this.reservedRooms = reservedRooms;
	}

	public IMetier getMetier() {
		return metier;
	}

	public void setMetier(MetierImpl metier) {
		this.metier = metier;
	}

	public int getTringas() {
		return tringas;
	}

	public void setTringas(int tringas) {
		this.tringas = tringas;
	}

	public int getSpeakers() {
		return speakers;
	}

	public void setSpeakers(int speakers) {
		this.speakers = speakers;
	}
	
	public int getConfDeepDiveRoomNumber() {
		return confDeepDiveRoomNumber;
	}

	public void setConfDeepDiveRoomNumber(int confDeepDiveRoomNumber) {
		this.confDeepDiveRoomNumber = confDeepDiveRoomNumber;
	}

	public int getGroupRoom() {
		return groupRoom;
	}

	public void setGroupRoom(int groupRoom) {
		this.groupRoom = groupRoom;
	}

	public void setApparts(int apparts) {
		this.apparts = apparts;
	}
    
	public String checkAvailibility() {
		return "Standard rooms: "+this.standardRooms+"|Suites: "+suites+"|Aparts: "+apparts;
	}
}
