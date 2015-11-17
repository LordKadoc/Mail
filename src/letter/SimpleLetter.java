package letter;

import content.Text;
import city.Inhabitant;

public class SimpleLetter extends TransformableRegisteredLetter<Text> {

	public SimpleLetter(Text content, Inhabitant sender, Inhabitant receiver) {
		super(content, sender, receiver);
	}
	
	@Override
	public double getCost(){
		return content.getCost();
	}

	@Override
	public void openLetter() {
		//nothing TODO
	}

	@Override
	public String getDescription() {
		return "a simple letter whose content is " + content.getDescription();
	}

}
