package city;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * The bank is a singleton object containing a bank account for each inhabitant registered in a city.
 * Each bank account is represented by a a string (the name of the citizen) and an amount of money.
 * 
 * 
 * @author mouradeolive
 *
 */
public class Bank {
	
	private static Bank instance = new Bank();
	
	private Map<String,Double> accounts;
	
	/**
	 * Initializes the bank accounts
	 */
	private Bank(){
		accounts = new HashMap<String,Double>();
	}
	
	/**
	 * Returns the singleton instance of Bank
	 * 
	 * @return a bank instance
	 */
	public static Bank getInstance(){
		return instance;
	}
	
	/**
	 * Returns the amount of money on a citizen's account.
	 * 
	 * @param accountID the id of the citizen.
	 * 
	 * @return the amount of money on the citizen's account, null if the id is not valid
	 */
	public Double getAmount(String accountID){
		return accounts.get(accountID);
	}
	
	/**
	 * Adds a certain amount of money to a citizen's account.
	 * 
	 * @param accountID the id of the citizen
	 * 
	 * @param amount the amount of money to be credited
	 */
	public void credit(String accountID, double amount){
		double d = accounts.get(accountID);
		accounts.replace(accountID, d+amount);
		System.out.println(+ amount + " euros are credited to " + accountID + "'s account whose balance is now " + accounts.get(accountID));
	}
	
	/**
	 * Removes a certain amount of money from a citizen's account.
	 * 
	 * @param accountID the id of the citizen
	 * 
	 * @param amount the amount of money to be debited
	 */
	public void debit(String accountID, double amount){
		double d = accounts.get(accountID);
		accounts.replace(accountID, d-amount);
		System.out.println(+ amount + " euros are debited from " + accountID + "'s account whose balance is now " + accounts.get(accountID));
	}
	
	/**
	 * Opens an account for an inhabitant and credit it with 500 euros.
	 * 
	 * @param i the inhabitant to add.
	 */
	public void addAccount(Inhabitant i){
		accounts.put(i.getIdentifier(), 500.0);
	}

	/**
	 * Displays the amount of every bank account with the name of their owner.
	 */
	public void displayAccount() {
		for(String s : accounts.keySet()){
			System.out.println("Account " + s + " : " + accounts.get(s));
		}
	}
	
}
