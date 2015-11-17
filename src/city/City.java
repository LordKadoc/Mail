package city;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;

public class City {
	
	private String townName;
	
	private List<Letter<?>> letters;
	
	private List<Inhabitant> inhabitants;
	
	private Bank bank;
	
	public City(String name){
		this.townName = name;
		this.letters = new ArrayList<Letter<?>>();
		this.inhabitants = new ArrayList<Inhabitant>();
		this.bank = Bank.getInstance();
	}
	
	public void sendLetter(Letter<?> letter){
		System.out.println("-> " + letter.getSender().getIdentifier() + " mails " + letter.getDescription() + " to " + letter.getReceiver().getIdentifier() + " for a cost of " + letter.getCost() + " euros");
		bank.debit(letter.getSender().getIdentifier(),letter.getCost());
		letters.add(letter);
	}
	
	public void distributeLetters(){
		List<Letter<?>> tmp = new ArrayList<Letter<?>>();
		tmp.addAll(letters);
		letters.clear();
		for(Letter<?> l : tmp){
			System.out.println("-> " + l.getReceiver().getIdentifier() + " receives " + l.getDescription() + " from " + l.getSender().getIdentifier());
			l.getReceiver().receiveLetter(l);
		}
	}
	
	public void addInhabitant(Inhabitant inhabitant){
		this.inhabitants.add(inhabitant);
		this.bank.addAccount(inhabitant);
	}
	
	public List<Inhabitant> getInhabitants(){
		return inhabitants;
	}
	
	public List<Letter<?>> getCurrentLetters(){
		return letters;
	}
	
	public Bank getBank(){
		return bank;
	}
	
	@Override
	public String toString(){
		return townName;
	}

}
