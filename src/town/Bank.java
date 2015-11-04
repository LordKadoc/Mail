package town;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	
	private static Bank instance = new Bank();
	
	private Map<Integer,Double> accounts;
	
	private Bank(){
		accounts = new HashMap<Integer,Double>();
	}
	
	public static Bank getInstance(){
		return instance;
	}
	
	public double getAmount(int accountID){
		return accounts.get(accountID);
	}
	
	public void addAccount(Inhabitant i){
		int id = i.getIdentifier();
		int fullID;
		int r;
		do{
			r = (int)(Math.random()*9999);
			fullID = id*10000 + r;
		}while(accounts.containsKey(fullID));
		i.setAccount(fullID);
		accounts.put(fullID,5000.0);
	}

}
