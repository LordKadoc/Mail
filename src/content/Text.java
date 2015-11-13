package content;



public class Text implements Content{
	
	private String text;
	
	public Text(String text){
		this.text = text;
	}

	@Override
	public double getCost() {
		return 3.50;
	}
	
	@Override
	public String toString(){
		return text;
	}

}
