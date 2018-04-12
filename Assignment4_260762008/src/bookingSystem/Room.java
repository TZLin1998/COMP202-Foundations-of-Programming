package bookingSystem;

public class Room {
	//Tianze Lin 260762008
	
	//attributes
	private String type;
	private double price;
	private boolean availability;
	
	//constructor
	public Room(String type) {
		if(type.equals("double")){
			this.type = type;
			this.price = 90.0;
			this.availability = true;
		}else if(type.equals("queen")){
			this.type = type;
			this.price = 110.0;
			this.availability = true;
		}else if(type.equals("king")){
			this.type = type;
			this.price = 150.0;
			this.availability = true;
		}else {
			throw new IllegalArgumentException("No room of such type can be created.");
		}
	}
	
	//some other useful methods
	public String getType() {
		return this.type;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public boolean getAvailability() {
		return this.availability;
	}
	
	public void changeAvailability() {
		if(getAvailability() == true) {
			this.availability = false;
		}else {
			this.availability = true;
		}
	}
	
	public Room findAvailableRoom(Room[] arr, String s) {
		int m = arr.length;
		for (int i = 0; i < m; i++) {
			if (arr[i].availability == true && arr[i].getType().equals(s)) {
				return arr[i];
			}
		}
		return null;
	}
}
