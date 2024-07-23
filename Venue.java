package questionTwo;

public class Venue {

	private String id;
	private int noRows;
	private int noCols;
	private int numOfTickets;
	private int numOfSeatsOccupied=0;
	private Ticket[][] tickets;    //create the ticket variable as an array for the row and the columns
	// Note: this static method is given
	// Converts row letter (char) to index number (int)
	public static int rowLetter2Idx(char letter) {
		return (int) (letter) - 65;
	}

	// Note: this static method is given
	// Converts index number (int) to row letter (char)
	public static char rowIndex2Letter(int idx) {
		return (char) (idx + 'A');
	}
	public Venue(String id) {
		//sets the rows and columns depending on the second character of the show id
		this.id=id;
		if (id.charAt(1)=='E') {
			noRows=7;
			noCols=7;
		}else if (id.charAt(1)=='W') {
			noRows=5;
			noCols=7;
		}else if (id.charAt(1)=='N') {
			noRows=7;
			noCols=5;
		}else if (id.charAt(1)=='S') {
			noRows=9;
			noCols=9;
		}else {
			
		}
		//creating the ticket
		tickets = new Ticket[noRows][noCols];
		for(int i=0; i<noRows; i++) {    
			for(int j=0; j<noCols; j++) {
				tickets[i][j]= new Ticket(i+1, j+1, false);
			}
		}
		numOfTickets= noRows*noCols; 
	}
	
	public String getID() {
		return id;
	} 
	public int getNoRows() {
		return noRows;
	}
	public int getNoCols() {
		return noCols;
	}
	public int getNumOfSeats() {
		return numOfTickets;
	}
	public void bookASeat(int rowIdx, int seatNo) {
		tickets[rowIdx][seatNo-1].setIsOccupied(true);   //to book a seat by calling the setIsOccupied method from the ticket class 
		numOfSeatsOccupied++;                     //it will add into the numOfSeatsOccupied variable
	}
	public boolean checkOccupied (int rowIdx, int seatNo) {
		return tickets[rowIdx][seatNo-1].getIsOccupied();     
	}
	public String seatVenueDisplay() {
		String displaySeats="";
		for(int i=0; i<noRows; i++) {
			for(int j=0; j<noCols; j++) {
				if(tickets[i][j].getIsOccupied()==true)  //if the ticket is the same as a booked ticket, then the seat will appear as XX 
				{
					displaySeats += "[XX] "; //additional feature
				}else {
					displaySeats += "["+ tickets[i][j].getRowLetter()+tickets[i][j].getSeatNo()+"] ";
				}               //to display the tickets depending on the number of rows and columns as [rows, columns]
			}
			displaySeats+= "\n";
		}
		return displaySeats;
	}
	
	public boolean checkIfVenueIsFull() { //if the num of seats occupied is the same as the num of tickets, then it is true the venue is full
		if (numOfSeatsOccupied==numOfTickets) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean seatTaken() {
		if(numOfSeatsOccupied>0) {
			return true;
		}else {
			return false;
		}
	}
	public char letter(int rowIdx, int seatNo) {   //made a new method to obtain the seats that has been booked
		return tickets[rowIdx][seatNo-1].getRowLetter();
	}
	
	public String toString() {
		return getID();
	}
}
