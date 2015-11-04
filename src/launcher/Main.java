package launcher;

import letter.Letter;
import letter.Text;
import city.Bank;
import city.City;
import city.Inhabitant;

public class Main {

	public static void main(String[] args) {
		City pawnee = new City("Pawnee");
		Inhabitant bob = new Inhabitant("Bob", pawnee, 1972, 974, true);
		Inhabitant bobetta = new Inhabitant("Bobetta", pawnee, 1980, 95, false);
		Bank bank = pawnee.getBank();
		bank.addAccount(bob);
		bank.addAccount(bobetta);
		bob.sendLetter(new Letter<Text>(new Text(), bob, bobetta));
		System.out.println(bank.getAmount(bob.getAccount()));
	}

}
