package city;

import letter.Letter;

public class Inhabitant {
	
	private City city;
	
	private String name;

	public Inhabitant(String name, City city){
		this.name = name;
		this.city = city;
	}
	
	public void sendLetter(Letter<?> letter){
		city.sendLetter(letter);
	}
	
	public void receiveLetter(Letter<?> letter){
		letter.openLetter();
	}
	
	public String getIdentifier(){
		return name;
	}

}
