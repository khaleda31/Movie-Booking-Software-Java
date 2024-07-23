package questionTwo;

public class Ticket {
	private char rowLetter;
	private int seatNo;
	private boolean isOccupied;
	
	public Ticket(int rowIdx, int colIdx, boolean isOccupied) {
		char[] row = {'A','B','C','D','E','F','G','H','I'}; //created a row array for up until 9 (max) letters 
		this.rowLetter= row[rowIdx-1]; //getting the row letter according to the index
		this.seatNo=colIdx;
		this.isOccupied=isOccupied;
	}
	public char getRowLetter() {
		return rowLetter;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public boolean getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied (boolean isOccupied) {
		this.isOccupied= isOccupied;
	}
	public String toString() {
		//source: w3Schools
		return "row letter :" + rowLetter + "seat number :" + seatNo;
	}
}
