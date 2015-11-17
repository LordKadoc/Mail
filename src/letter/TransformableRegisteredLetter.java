package letter;

import city.Inhabitant;
import content.Content;

public abstract class TransformableRegisteredLetter<L extends Content> extends TransformableUrgentLetter<L>{

	public TransformableRegisteredLetter(L content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	public RegisteredLetter registered(){
		return new RegisteredLetter(this);
	}

}
