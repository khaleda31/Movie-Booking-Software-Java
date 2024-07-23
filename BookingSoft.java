package questionTwo;

/**
 * F28PA | Software Development A | Coursework
 * 
 * The Coursework specification is provided in Canvas. Please read through it in
 * full before you start work.
 * 
 * @author Nur Khaleda binti Mohd Hilmi
 */
import java.util.Scanner;
public class BookingSoft {
	public static void main(String[] args) throws InterruptedException {
		// There are currently 6 shows offered in 6 different venues.
		Show[] shows = new Show[6];
		
		// Uncomment lines 17 to 22 once the constructors have been written.
		shows[0] = new Show("1N", new Film("SING", 1));       
		shows[1] = new Show("2W", new Film("THE GRINCH", 2));
		shows[2] = new Show("3E", new Film("BOSS BABY", 3));
		shows[3] = new Show("3S", new Film("YES DAY", 3));
		shows[4] = new Show("1E", new Film("THE KARATE KID", 1));
		shows[5] = new Show("2N", new Film("THE SEA BEAST", 2));
		System.out.println("### Welcome to the Booking System ###\n");
		// DO NOT CHANGE THE ABOVE PART OF THE CODE.
		///////////////////////////////////////////////////////////////////////////////////
		System.out.println("SHOWS AVAILABLE: ");
		for (int i=0; i<shows.length; i++) {
			System.out.println(shows[i].locationInfo());
		}
		String answer="yes";
	
		do {
			//asking the user to input the show id
			int showNo=0;  
			boolean trueShow=false;  
			System.out.println("PLEASE SELECT A SHOW ID: ");
			Scanner select = new Scanner (System.in);
			String selection= select.next();
			while(trueShow==false) {//the code will repeat if the user inputs a show id that is not from the list
				for (int i=0; i<shows.length; i++) {
					if(selection.equalsIgnoreCase(shows[i].toString())) {//gets the film name according to number in the shows array
						showNo = showNo+i;                                //the toString() method is called from the Show class to get the show id
						trueShow=true;  //if the show id exists, the trueShow will declared as true
					}
				} 
				if(trueShow==false) {  //the messages will appear if the show id does not exist or is false
					System.out.println("SHOW ID DOES NOT EXIST.");
					System.out.println("PLEASE SELECT ANOTHER SHOW :");
					selection= select.next();
				}
			}
			
			shows[showNo].printHall(); //calls the printHall method from the Show class
			shows[showNo].printAvailability();//calling the printAvailability method from the Show class
			int pax=0;
			System.out.println("PAX :");
			pax=select.nextInt();
			for(int m=0;m<pax;m++) {
				boolean repeat=true;  
				while(repeat==true) {   //it will repeat the amount of times = pax number
					try {  //Exception handling using try catch
						int person= 1+m;
						System.out.println("SELECT SEAT " + person + ": ");
						boolean available = false;
						String seat ;
						while(available==false) {  //if it is not available, it will repeat
							seat = select.next();      //checking the availability of the seat
							int i= Character.getNumericValue(seat.charAt(1));  //source: TutorialsPoint
							if(shows[showNo].seatCheckAvailability(seat.charAt(0),i)==true) {
								System.out.println("Seat is unavailable.");
								System.out.println("Please choose another seat");
							}else {
								available=true;
								System.out.println("Seat is available.");
								shows[showNo].buyTicket(seat.charAt(0),i);
								repeat=false; //the code will 3not repeat when the repeat is declared false
							}
						}
					}catch (Exception e) { //the error message will prompt if the seat input is out of bounds
						System.out.println("SEAT DOES NOT EXIST");
					}
				}
			}
			System.out.println("Would you like to book another seat? (yes/no)");
			answer= select.next();
			
		}while(answer.equalsIgnoreCase("yes")); //the program will repeat if the user would like to book another seat
		
		//additional feature: movie ticket
		//this will output all the details of the film that the user booked
		System.out.println("<Booking Successful. Thank you patronage>");
		System.out.println("-----------------------------------------");
		System.out.println("             <MOVIE TICKET>              ");
		char[] array= {'A','B','C','D', 'E', 'F', 'G', 'H', 'I'};
		
		for(int i=0;i<shows.length;i++) {
			if(shows[i].hasSeats()==true) {
				System.out.println(shows[i].getName()); //to print out the film name for the movie ticket
				System.out.println(shows[i].getTime()); //to return and print the session time of the film
				System.out.print("SEAT NUMBER: ");
				for(int j=0;j<shows[i].rows();j++) { 
					for(int q=1;q<=shows[i].columns();q++) { 
						if(shows[i].seatCheckAvailability(shows[i].letter(j,q),q)==true) {
							System.out.print("["+shows[i].letter(j,q)+q+"] "); //to print out the seats that has been booked
						}
					}
				}	
				System.out.println("");
			}
		}System.out.println("-----------------------------------------");
		 
	}
}
