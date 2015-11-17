package content;


public class Money implements Content {
	
	private double amount;
	
	public Money(double amount){
		this.amount = amount;
	}
	
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
