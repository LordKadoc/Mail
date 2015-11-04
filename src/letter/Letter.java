package letter;

import city.Inhabitant;

public class Letter<L extends Content> {

	private L content;
	
	private Inhabitant sender;
	
	private Inhabitant receiver;
	
	public Letter(L content, Inhabitant sender, Inhabitant receiver){
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
	}

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
