package letter;

public class UrgentLetter extends Letter<Letter<?>> {

	public UrgentLetter(Letter<?> content) {
		super(content, content.getSender(), content.getReceiver());
	}

	@Override
	public double getCost() {
		return 2*content.getCost();
	}

	@Override
	public void openLetter() {
		content.openLetter();
	}

	@Override
	public String getDescription() {
		return "an urgent letter whose content is " + content.getDescription();
	}

}
