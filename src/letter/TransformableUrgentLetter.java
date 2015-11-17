package letter;

import city.Inhabitant;
import content.Content;

public abstract class TransformableUrgentLetter<L extends Content> extends Letter<L> {

	public TransformableUrgentLetter(L content, Inhabitant sender,Inhabitant receiver) {
		super(content, sender, receiver);
	}

	public UrgentLetter urgent(){
		return new UrgentLetter(this);
	}
}
