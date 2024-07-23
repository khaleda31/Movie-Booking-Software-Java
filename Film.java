package questionTwo;

public class Film {
	protected String filmTitle;
	protected int sessionTime;
	
	public Film (String title, int sessionTime) {
		this.filmTitle= title;
		this.sessionTime=sessionTime;
	}
	//using and if else statement to read the second character of the venue type and assign the session time 
	public String getSession() { //returns a string the session time
		String session="";
		if(sessionTime==1) {
			session += "SESSION TIME: Afternoon (1pm)" ;
		}else if (sessionTime==2) {
			session+= "SESSION TIME: Evening (5pm)";
		}else {
			session+="SESSION TIME: Night (9pm)";
		}
		return session;
	}
	public String getTitle() {  //to get the title of the film
		return "TITLE: " + filmTitle;
	}
	

}
