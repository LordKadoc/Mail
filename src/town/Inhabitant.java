package town;

import letter.Letter;
import city.City;

public class Inhabitant {
	
	private City city;
	
	private String name;
	
	private int age;
	
	private int departementNaissance;
	
	private boolean man;
	
	private int accountID;
	
	public Inhabitant(String name, City city, int age, int departementNaissance, boolean man){
		this.name = name;
		this.city = city;
		this.age = age;
		this.departementNaissance = departementNaissance;
		this.man = man;
	}
	
	public void sendLetter(Letter<?> letter){
		city.sendLetter(letter);
	}
	
	public void receiveLetter(Letter<?> letter){
		//TODO
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public int getDepartementNaissance(){
		return departementNaissance;
	}
	
	public boolean isMan(){
		return man;
	}
	
	public void setAccount(int accountID){
		this.accountID = accountID;
	}
	
	public int getAccount(){
		return accountID;
	}
	
	public int getIdentifier(){
		return (man ? 1 : 2)*10000 + departementNaissance*100+age;
	}

}
