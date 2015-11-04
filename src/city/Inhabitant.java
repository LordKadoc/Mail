package city;

import letter.Letter;

public class Inhabitant {
	
	private City city;
	
	private String name;
	
	private int anneeNaissance;
	
	private int departementNaissance;
	
	private boolean man;
	
	private long accountID;
	
	public Inhabitant(String name, City city, int anneeNaissance, int departementNaissance, boolean man){
		this.name = name;
		this.city = city;
		this.anneeNaissance = anneeNaissance;
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
		return anneeNaissance;
	}
	
	public int getDepartementNaissance(){
		return departementNaissance;
	}
	
	public boolean isMan(){
		return man;
	}
	
	public void setAccount(long accountID){
		this.accountID = accountID;
	}
	
	public long getAccount(){
		return accountID;
	}
	
	/**
	 * Retourne l'identifiant du citoyen, une suite de 6 chiffres composé de la sorte :
	 * <ul>
	 * <li>1 pour un homme, 2 pour une femme</li>
	 * <li>le numéro du département dans lequel le citoyen est né (3 chiffres)</li>
	 * <li>l'année de naissance du citoyen (2 chiffres)</li>
	 * </ul>
	 * @return l'identifiant personnel du citoyen
	 */
	public long getIdentifier(){
		return (man ? 1 : 2)*100_000 + departementNaissance*100+anneeNaissance%100;
	}

}
