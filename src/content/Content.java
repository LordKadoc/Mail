package content;

/**
 * A content is the object contained in a letter.
 * 
 * @author mouradeolive
 *
 */
public interface Content {

	/**
	 * 
	 * @return the cost of shipping the content
	 */
	public double getCost();
	
	/**
	 * 
	 * @return the description of the content
	 */
	public String getDescription();
	
}
