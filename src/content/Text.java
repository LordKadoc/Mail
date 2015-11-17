package content;



public class Text implements Content{
	
	private String text;
	
	public Text(String text){
		this.text = text;
	}

	@Override
	public double getCost() {
		return 1;
	}

	@Override
	public String getDescription() {
		return "a text content (" + text + ")";
	}
	

}
