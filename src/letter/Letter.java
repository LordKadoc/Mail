package letter;

import city.Inhabitant;
import content.Content;
import factory.ILetterFactory;
import factory.LetterFactory;

public abstract class Letter<L extends Content> implements Content{
	
	protected static ILetterFactory factory = new LetterFactory();

	protected L content;
	
	protected Inhabitant sender;
	
	protected Inhabitant receiver;
	
	public Letter(L content, Inhabitant sender, Inhabitant receiver){
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
	}

	public abstract void openLetter();
		
	public L getContent() {
		return content;
	}

	public Inhabitant getSender() {
		return sender;
	}

	public Inhabitant getReceiver() {
		return receiver;
	}
}
