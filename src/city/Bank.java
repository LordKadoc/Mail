package city;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private static Bank instance = new Bank();
	
	private Map<Long,Double> accounts;
	
	private Bank(){
		accounts = new HashMap<Long,Double>();
	}
	
	public static Bank getInstance(){
		return instance;
	}
	
	public double getAmount(long accountID){
		return accounts.get(accountID);
	}
	
	public void credit(long accountID, double amount){
		double d = accounts.get(accountID);
		accounts.replace(accountID, d+amount);
	}
	
	public void debit(long accountID, double amount){
		credit(accountID,-amount);
	}
	
	public void addAccount(Inhabitant i){
		long fullID = generateUniqueAccountNumber(i);
		i.setAccount(fullID);
		accounts.put(fullID,5000.0);
	}
	
	private long generateUniqueAccountNumber(Inhabitant i){
		long id = i.getIdentifier();
		long fullID,random;
		do{
			random = (int)(Math.random()*9999);
			fullID = id*10000 + random;
		}while(accounts.containsKey(fullID));
		return fullID;
	}

}
