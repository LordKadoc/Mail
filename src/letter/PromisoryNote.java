package letter;

import city.Bank;
import city.Inhabitant;
import content.Money;
import factory.LetterFactory;

public class PromisoryNote extends TransformableRegisteredLetter<Money>{

	public PromisoryNote(Money content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public void openLetter() {
		Bank.getInstance().credit(receiver.getIdentifier(),content.getAmount());
		Bank.getInstance().debit(sender.getIdentifier(), content.getAmount());
		receiver.sendLetter(LetterFactory.createThanksLetter(receiver, sender));
	}

	@Override
	public double getCost() {
		return 1+content.getCost();
	}

	@Override
	public String getDescription() {
		return "a promisory note whose content is " + content.getDescription();
	}

}
