package generator;

public class UnexistingAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508746300714753169L;
	
	public UnexistingAccountException(){
		super("Ce compte en banque n'existe pas.");
	}

}
