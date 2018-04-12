package bookingSystem;

public class Reservation {
	//Tianze Lin 260762008
	
	//attributes
	private String name;
	private Room roomReserved;
	
	//constructor
	public Reservation(Room room, String name) {
		this.roomReserved = room;
		this.name = name;
	}
	
	//some other useful methods
	public String getName() {
		return this.name;
	}
	
	public Room getRoom(){
		return this.roomReserved;
	}
	
}