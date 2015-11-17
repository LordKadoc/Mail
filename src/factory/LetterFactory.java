package factory;

import city.Inhabitant;
import letter.BodyPartLetter;
import letter.PromisoryNote;
import letter.SimpleLetter;
import letter.ThanksLetter;
import content.Money;
import content.Text;
import content.Threat;

public class LetterFactory{
	
	public static SimpleLetter createSimpleLetter(String text, Inhabitant sender, Inhabitant receiver){
		return new SimpleLetter(new Text(text),sender,receiver);
	}
	
	public static PromisoryNote createPromisoryNote(double amount, Inhabitant sender, Inhabitant receiver){
		return new PromisoryNote(new Money(amount), sender, receiver);
	}

	public static BodyPartLetter createBodyPartNote(double weight, String bodypart, String message, Inhabitant sender, Inhabitant receiver) {
		return new BodyPartLetter(new Threat(message, bodypart, weight), sender, receiver);
	}
	
	public static ThanksLetter createThanksLetter(Inhabitant sender, Inhabitant receiver){
		return new ThanksLetter(createSimpleLetter("Merci", sender, receiver));
	}
	
}
