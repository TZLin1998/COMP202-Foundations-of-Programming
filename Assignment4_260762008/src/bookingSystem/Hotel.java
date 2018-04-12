package bookingSystem;
import java.util.NoSuchElementException;

public class Hotel {
	//Tianze Lin 260762008
	
	//attributes
	private String name;
	private Room[] room;
	private Reservation[] reservation = new Reservation[50];
	//The length is 50 since from the BookingSystem class, the maximum number of room is 50.
	
	//constructor
	public Hotel(String nameOfHotel, Room[] room) {
		this.name = nameOfHotel;
		int j = room.length;
		this.room = new Room[j];
		for(int i =0; i<room.length; i++) {
			Room a = room[i];
			this.room[i] = a;
		}
		
	}
	
	//some other useful methods
	private void addReservation (Reservation a) {
		for(int i = 0; i < reservation.length; i++) {
			if (reservation[i] == null) {
				reservation[i] = a;
				reservation[i].getRoom().changeAvailability();
				break;
			}
		}
	}
	
	private void removeReservation(String name, String type) {
		for(int i = 0; i < reservation.length; i++) {
			try {
				if (reservation[i].getName().equals(name) && reservation[i].getRoom().getType().equals(type)) {
					reservation[i].getRoom().changeAvailability();
					reservation[i] = null;
					break;
				}else if(i < reservation.length-1){
					continue;
				}else if(i == reservation.length-1){
					throw new NoSuchElementException("No reservation has been made under the given name for the given type of room.");
				}
			}catch(NullPointerException e) {
				if(i == reservation.length-1) {
					throw new NoSuchElementException("No reservation has been made under the given name for the given type of room.");
				}
				continue;
			}
		}
	}
	
	public void createReservation(String name, String type) {
		Room a = room[0].findAvailableRoom(room, type);
		if (a == null) {
			System.out.println("The hotel has no available rooms of the requested type.");
		}else {
			Reservation newReservation = new Reservation(a, name) ;
			addReservation(newReservation);
			System.out.println("you have successfully reserved a "+type+" room under the name of "+name+". We look forward having you at "+this.name+"!");
		}
	}
	
	public void cancelReservation(String name, String type) {
		try {
			removeReservation(name, type);
			System.out.println("The operation was successful");
		}
		catch(NoSuchElementException e){
			System.out.println("No reservation under such name has been made for the given type of room.");
		}
	}
	
	public void printInvoice(String name) {
		double counter = 0.0;
		for(int i = 0; i<reservation.length; i++) {
			try {
				if(reservation[i].getName().equals(name)) {
					counter += reservation[i].getRoom().getPrice();
				}
			}catch(NullPointerException e) {
				continue;
			}
		}
		System.out.println(name+"'s invoice is of $"+counter);
	}
	
	public String toString() {
		String info = "";
		int doubleCounter = 0;
		int queenCounter = 0;
		int kingCounter = 0;
		for (int i = 0; i<room.length; i++) {
			if(room[i].getAvailability() == true && room[i].getType().equals("double")) {
				doubleCounter++;
			}
		}
		for (int i = 0; i<room.length; i++) {
			if(room[i].getAvailability() == true && room[i].getType().equals("queen")) {
				queenCounter++;
			}
		}
		for (int i = 0; i<room.length; i++) {
			if(room[i].getAvailability() == true && room[i].getType().equals("king")) {
				kingCounter++;
			}
		}
		info += "Hotel name: " + name +"\n";
		info += "Available Rooms: " + doubleCounter + " double, ";
		info += queenCounter + " queen, ";
		info += kingCounter + " king.";
		return info;
	}
	
	
}
