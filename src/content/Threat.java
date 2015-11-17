package content;


public class Threat implements Content {
	
	private String message;
	
	private String bodypart;
	
	private double weight;
	
	public Threat(String message, String bodypart, double weight){
		this.message = message;
		this.bodypart = bodypart;
		this.weight = weight;
	}

	@Override
	public double getCost() {
		return 2*(weight/10);
	}

	public String getMessage() {
		return message;
	}

	public String getBodypart() {
		return bodypart;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String getDescription() {
		return "a body part (" + bodypart + ") with the following message (" + message + ")";
	}

}
