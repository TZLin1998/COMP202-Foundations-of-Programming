package bookingSystem;
import java.util.Scanner;
import java.util.Random;

public class BookingSystem {
    
    private static String[] typeOfRooms = {"double","queen","king"};
    private static Random r = new Random(123);
    
    //returns a random String from the above array. 
    private static String getRandomType(){
        int index = r.nextInt(typeOfRooms.length);
        return typeOfRooms[index];
    }
    //returns a random number of rooms between 5 and 50.
    private static int getRandomNumberOfRooms(){
        return r.nextInt(50)+1;
    }
    //End of provided code. 
    
    public static void main(String[] args){
        //Student Name: Tianze Lin
        //Student Number: 260762008
        //Your code goes here.    
    	System.out.println("Welcome to the COMP 202 booking system.");
		System.out.println("Please enter the name of the hotel you'd like to book");
		Scanner input = new Scanner(System.in);
		String nameOfHotel = input.nextLine();
		int j = getRandomNumberOfRooms();
		Room[] roomOfHotel = new Room[j];
		for(int i = 0; i<j; i++) {
				roomOfHotel[i] = new Room(getRandomType());
		}
		Hotel hotel = new Hotel(nameOfHotel, roomOfHotel);
		for(;;) {
			System.out.println("*****************************************************************");
			System.out.println("Welcome to "+ nameOfHotel +". Choose one of the following options");
			System.out.println("1) Make a reservation");
			System.out.println("2) Cancel a reservation");
			System.out.println("3) See an invoice");;
			System.out.println("4) See hotel info");
			System.out.println("5) Exit the booking system");
			System.out.println("*****************************************************************");
			Scanner input2 = new Scanner(System.in);
			int b = input2.nextInt();
			if (b == 5) {
				System.out.println("It was a pleasure doing business with you!");
				break;
			}else if(b == 1) {
				System.out.println("Please enter your name:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				System.out.println("What type of room would you like to reserve?");
				String type = input3.nextLine();
				hotel.createReservation(name, type);
			}else if(b == 2) {
				System.out.println("Please enter your name:");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				System.out.println("What type of room would you like to cancel?");
				String type = input3.nextLine();
				hotel.cancelReservation(name, type);
			}else if(b == 3) {
				System.out.println("Please enter your name: ");
				Scanner input3 = new Scanner(System.in);
				String name = input3.nextLine();
				hotel.printInvoice(name);
			}else if(b == 4) {
				System.out.println("Here is the hotel info");
				System.out.println(hotel.toString());
			}
		}
    }
}