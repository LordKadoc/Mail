package city;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	
	private City city;

	@Before
	public void initCity() {
		city = new City("city");
	}
	
	@Test
	public void testAddAccount(){
		//the account is added when the inhabitant joins the city
		city.addInhabitant(new Inhabitant("Patrick", city));
		//vérifie que l'habitant possède 500 euros sur son compte en banque
		Assert.assertEquals(new Double(500.0), city.getBank().getAmount("Patrick"));
		Assert.assertNull(city.getBank().getAmount("Unknown Citizen"));
	}

}
