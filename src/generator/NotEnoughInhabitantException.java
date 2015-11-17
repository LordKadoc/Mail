package generator;

public class NotEnoughInhabitantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4694268306346133147L;
	
	public NotEnoughInhabitantException(){
		super("Pas assez d'habitants dans la ville.");
	}

}
