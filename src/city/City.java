package city;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;

public class City {
	
	private String townName;
	
	private List<Letter<?>> letters;
	
	public City(String name){
		this.townName = name;
		this.letters = new ArrayList<Letter<?>>();
	}
	
	public void sendLetter(Letter<?> letter){
		letters.add(letter);
	}
	
	public void distributeLetters(){
		for(Letter<?> l : letters){
			l.getReceiver().receiveLetter(l);
		}
	}
	
	@Override
	public String toString(){
		return "City of " + townName;
	}

}
