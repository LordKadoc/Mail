package letter;

import content.Threat;
import city.Inhabitant;

public class BodyPartLetter extends TransformableRegisteredLetter<Threat> {

	public BodyPartLetter(Threat content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}

	@Override
	public double getCost() {
		return 2+content.getCost();
	}

	@Override
	public void openLetter() {
		//nothing TODO
	}

	@Override
	public String getDescription() {
		return "a bodypart letter whose content is " + content.getDescription();
	}

}
