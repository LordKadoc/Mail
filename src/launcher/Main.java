package launcher;

import city.City;
import town.Bank;
import town.Inhabitant;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Inhabitant bob = new Inhabitant("Bob", new City("MailTown"), 05, 9, true);
		Inhabitant bobetta = new Inhabitant("Bobetta", new City("MailTown"), 35, 95, false);
		Bank bank = Bank.getInstance();
		bank.addAccount(bob);
		bank.addAccount(bobetta);
	}

}
