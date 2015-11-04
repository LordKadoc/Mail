package city;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;

public class City {
	
	private String townName;
	
	private List<Letter<?>> letters;
	
	private Bank bank;
	
	public City(String name){
		this.townName = name;
		this.letters = new ArrayList<Letter<?>>();
		this.bank = Bank.getInstance();
	}
	
	public void sendLetter(Letter<?> letter){
		letters.add(letter);
		bank.debit(letter.getSender().getAccount(),letter.getContent().getCost());
	}
	
	public void distributeLetters(){
		for(Letter<?> l : letters){
			l.getReceiver().receiveLetter(l);
		}
	}
	
	public Bank getBank(){
		return bank;
	}
	
	@Override
	public String toString(){
		return "City of " + townName;
	}

}
