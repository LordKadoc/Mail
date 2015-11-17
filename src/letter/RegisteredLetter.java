package letter;

import factory.LetterFactory;

public class RegisteredLetter extends TransformableUrgentLetter<Letter<?>> {

	public RegisteredLetter(Letter<?> content) {
		super(content, content.getSender(), content.getReceiver());
	}

	@Override
	public double getCost() {
		return 15+content.getCost();
	}

	@Override
	public void openLetter(){
		content.openLetter();
		receiver.sendLetter(LetterFactory.createSimpleLetter("bien reçu", receiver, sender));
	}

	@Override
	public String getDescription() {
		return "a registered letter whose content is " + content.getDescription();
	}

}
