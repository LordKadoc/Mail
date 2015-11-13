package launcher;

import content.Money;
import content.Text;
import letter.PromisoryNote;
import letter.SimpleLetter;
import city.Bank;
import city.City;
import city.Inhabitant;
import factory.LetterFactory;

public class Main {

	public static void main(String[] args) {
		City pawnee = new City("Pawnee");
		Inhabitant bob = new Inhabitant("Bob", pawnee, 1972, 974, true);
		Inhabitant bobetta = new Inhabitant("Bobetta", pawnee, 1980, 95, false);
		Bank bank = pawnee.getBank();
		bank.addAccount(bob);
		bank.addAccount(bobetta);
		//bob.sendLetter(new SimpleLetter(new Text("pd"), bob, bobetta));
		//bobetta.sendLetter(new PromisoryNote(new Money(100.0), bob, bobetta));
		//bobetta.sendLetter(new LetterFactory().createBodyPartNote(15.0, " pair of dog's testicules", "Je t'avais bien dit de castrer ton sale clébard !", bobetta, bob));
		bobetta.sendLetter(new LetterFactory().createSimpleLetter("Coucou", bobetta, bob).registered().urgent());
		pawnee.distributeLetters();
	}

}
