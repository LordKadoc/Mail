package city;

import java.util.ArrayList;
import java.util.List;

import letter.Letter;

/**
 * 
 * A City contains a post service and a list of inhabitants.
 * 
 * @author mouradeolive
 *
 */
public class City {
	
	private String townName;
	
	private List<Letter<?>> letters;
	
	private List<Inhabitant> inhabitants;
	
	private Bank bank;
	
	/**
	 * 
	 * Creates a new city with a name.
	 * 
	 * @param name the name of the city
	 */
	public City(String name){
		this.townName = name;
		this.letters = new ArrayList<Letter<?>>();
		this.inhabitants = new ArrayList<Inhabitant>();
		this.bank = Bank.getInstance();
	}
	
	/**
	 * 
	 * Adds a letter to the post office, which will be delivered the next day.
	 * 
	 * @param letter the letter to add in the post.
	 */
	public void sendLetter(Letter<?> letter){
		System.out.println("-> " + letter.getSender().getIdentifier() + " mails " + letter.getDescription() + " to " + letter.getReceiver().getIdentifier() + " for a cost of " + letter.getCost() + " euros");
		bank.debit(letter.getSender().getIdentifier(),letter.getCost());
		letters.add(letter);
	}
	
	/**
	 * Distributes all the letters in the post to their receiver
	 */
	public void distributeLetters(){
		List<Letter<?>> tmp = new ArrayList<Letter<?>>();
		tmp.addAll(letters);
		letters.clear();
		for(Letter<?> l : tmp){
			System.out.println("-> " + l.getReceiver().getIdentifier() + " receives " + l.getDescription() + " from " + l.getSender().getIdentifier());
			l.getReceiver().receiveLetter(l);
		}
	}
	
	/**
	 * Adds an inhabitant to the city and creates his bank account.
	 * 
	 * @param inhabitant the inhabitant to add to the city
	 */
	public void addInhabitant(Inhabitant inhabitant){
		this.inhabitants.add(inhabitant);
		this.bank.addAccount(inhabitant);
	}
	
	/**
	 * Returns the list of the city's inhabitants.
	 * 
	 * @return the city's inhabitants
	 */
	public List<Inhabitant> getInhabitants(){
		return inhabitants;
	}
	
	/**
	 * Returns the letters currently in the post office.
	 * 
	 * @return the list of letters to be delivered.
	 */
	public List<Letter<?>> getCurrentLetters(){
		return letters;
	}
	
	/**
	 * Returns the bank singleton instance.
	 * 
	 * @return the city's bank
	 */
	public Bank getBank(){
		return bank;
	}
	
	@Override
	public String toString(){
		return townName;
	}

}
