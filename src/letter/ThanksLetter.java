package letter;

public class ThanksLetter extends Letter<SimpleLetter> {

	public ThanksLetter(SimpleLetter content) {
		super(content, content.getSender(), content.getReceiver());
	}

	@Override
	public double getCost() {
		return content.getCost();
	}

	@Override
	public String getDescription() {
		return "a thanks letter which is " + content.getDescription();
	}

	@Override
	public void openLetter() {
		//nothing TODO
	}

}
