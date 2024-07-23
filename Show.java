package questionTwo;

public class Show {
	private Film filmname;
	private Venue venueID;
	
	public Show (String venueID, Film filmname) {
		this.venueID= new Venue(venueID);
		this.filmname= filmname;
	}
	public void buyTicket(char row, int seatNo) {
		//calling the bookASeat method from the venue class
		venueID.bookASeat(Venue.rowLetter2Idx(row), seatNo);
		System.out.println("Seat is booked!");
	}
	public boolean seatCheckAvailability(char row, int seatNo) {
		return venueID.checkOccupied(Venue.rowLetter2Idx(row), seatNo);
	}
	
	public void printHall() {
		System.out.println("Hall "+ venueID.getID() + ":");
		System.out.println(" ");
		System.out.println("__________[SCREEN]_________");
		System.out.println(venueID.seatVenueDisplay());
	}
	public void printAvailability() { //if the venue is full, the first statement will be printed out
		if (venueID.checkIfVenueIsFull()==true) {
			System.out.println("X VENUE IS FULL X");
		}else {
			System.out.println("SEATS AVAILABLE");
		}
	}
	public String locationInfo() {
		String location=""; //declared a variable called location
		location+="SHOW ID: " + venueID.getID();  //to call the getID method from venue class
		location+= "\n";
		if (venueID.getID().charAt(0)=='1') {   //this will get the session from the film class according to the first character of the show id
			location+=filmname.getSession();
		}else if (venueID.getID().charAt(0)=='2') {
			location += filmname.getSession();
		}else if (venueID.getID().charAt(0)=='3') {
			location+= filmname.getSession();
		}else {
			
		}
		location+= "\n";
		location+=filmname.getTitle(); //to get the title of the films
		location+= "\n";
		if (venueID.getID().charAt(1)=='E') {  //to display the number of seats according to the second character of the show id (the venue type)
			location+="Total Number of Seats: " + venueID.getNumOfSeats();
		}else if (venueID.getID().charAt(1)=='W') {
			location+="Total Number of Seats: " + venueID.getNumOfSeats();
		}else if (venueID.getID().charAt(1)=='N') {
			location+="Total Number of Seats: " + venueID.getNumOfSeats();
		}else if (venueID.getID().charAt(1)=='S') {
			location+="Total Number of Seats: " + venueID.getNumOfSeats();
		}else {
			
		}
		location+= "\n";
		return location;
	}
	public boolean hasSeats() {
		return venueID.seatTaken();
	}
	public String getName() {
		return filmname.getTitle();
	}
	public String getTime() {
		return filmname.getSession();
	}
	public String toString() {
		return venueID.toString();
	}
	public int columns() {
		return venueID.getNoCols();
	}
	public int rows() {
		return venueID.getNoRows();
	}
	//i created a new method for the movie ticket feature in the booking soft class
	public char letter(int rowIdx, int seatNo) {
		return venueID.letter(rowIdx, seatNo);
	}
	
	
	
}
