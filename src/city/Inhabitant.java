package city;

import letter.Letter;

/**
 * An Inhabitant is a person living in a city and who can send/receive letters from/to others inhabitants.
 * 
 * @author mouradeolive
 *
 */
public class Inhabitant {
	
	private City city;
	
	private String name;

	/**
	 * Creates a new inhabitant with a name, and living in a city.
	 * 
	 * @param name the name of the inhabitant
	 * 
	 * @param city the city where the person lives
	 */
	public Inhabitant(String name, City city){
		this.name = name;
		this.city = city;
	}
	
	/**
	 * Sends a letter to the post office of his town.
	 * 
	 * @param letter the letter to send
	 */
	public void sendLetter(Letter<?> letter){
		city.sendLetter(letter);
	}
	
	/**
	 * Opens a letter and resolves its actions.
	 * 
	 * @param letter the letter to open
	 */
	public void receiveLetter(Letter<?> letter){
		letter.openLetter();
	}
	
	/**
	 * Returns the name of the inhabitant, which is also the id for his bank account.
	 * 
	 * @return the identifier of the inhabitant
	 */
	public String getIdentifier(){
		return name;
	}

}
