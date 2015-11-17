package city;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private static Bank instance = new Bank();
	
	private Map<String,Double> accounts;
	
	private Bank(){
		accounts = new HashMap<String,Double>();
	}
	
	public static Bank getInstance(){
		return instance;
	}
	
	public Double getAmount(String accountID){
		return accounts.get(accountID);
	}
	
	public void credit(String accountID, double amount){
		double d = accounts.get(accountID);
		accounts.replace(accountID, d+amount);
		System.out.println(+ amount + " euros are credited to " + accountID + "'s account whose balance is now " + accounts.get(accountID));
	}
	
	public void debit(String accountID, double amount){
		double d = accounts.get(accountID);
		accounts.replace(accountID, d-amount);
		System.out.println(+ amount + " euros are debited from " + accountID + "'s account whose balance is now " + accounts.get(accountID));
	}
	
	public void addAccount(Inhabitant i){
		accounts.put(i.getIdentifier(), 500.0);
	}

	public void displayAccount() {
		for(String s : accounts.keySet()){
			System.out.println("Account " + s + " : " + accounts.get(s));
		}
	}
	
}
