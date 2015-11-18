package content;


public class Threat implements Content {
	
	private String message;
	
	private String bodypart;
	
	private double weight;
	
	/**
	 * Creates a new Threat content.
	 * 
	 * @param message the message associated to the threat
	 * 
	 * @param bodypart the bodypart contained in the letter
	 * 
	 * @param weight the weight of the letter.
	 */
	public Threat(String message, String bodypart, double weight){
		this.message = message;
		this.bodypart = bodypart;
		this.weight = weight;
	}

	@Override
	public double getCost() {
		return 2*(weight/10);
	}

	/**
	 * Returns the threat message.
	 * @return the threat message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns a text describing the body part contained in the packet.
	 * @return the body part
	 */
	public String getBodypart() {
		return bodypart;
	}

	/**
	 * Returns the weight of the packet.
	 * @return the weight of the packet
	 */
	public double getWeight() {
		return weight;
	}

	@Override
	public String getDescription() {
		return "a body part (" + bodypart + ") with the following message (" + message + ")";
	}

}
