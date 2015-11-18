package content;


public class Money implements Content {
	
	private double amount;
	
	/**
	 * Creates a new Money content with an amount of money.
	 * 
	 * @param amount the amount of money.
	 */
	public Money(double amount){
		this.amount = amount;
	}
	
	/**
	 * Returns the amount of money contained in the content.
	 * 
	 * @return the amount of money
	 */
	public double getAmount(){
		return amount;
	}

	@Override
	public double getCost() {
		return 0.01*amount;
	}

	@Override
	public String getDescription() {
		return "a money content (" + amount + " euros)"; 
	}

}
