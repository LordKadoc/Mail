package city;
import letter.Letter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.LetterFactory;


public class CityTest {
	
	private City city;
	
	private Inhabitant bob;
	
	@Before
	public void initCity(){
		city = new City("test");
		bob = new Inhabitant("bob", city);
		city.addInhabitant(bob);
	}

	@Test
	public void testName() {
		Assert.assertEquals("test", city.toString());
	}
	
	@Test
	public void testAddInhabitant(){
		Assert.assertEquals(1, city.getInhabitants().size());
		city.addInhabitant(new Inhabitant("marc", city));
		Assert.assertEquals(2, city.getInhabitants().size());
	}
	
	@Test
	public void testAddLetter(){
		bob.sendLetter(LetterFactory.createSimpleLetter("letter", bob, bob));
		Assert.assertEquals(1, city.getCurrentLetters().size());
	}
	
	@Test
	public void testDistributeLetterWithNoReturn(){
		bob.sendLetter(LetterFactory.createSimpleLetter("letter", bob, bob));
		Assert.assertEquals(1, city.getCurrentLetters().size());
		city.distributeLetters();
		Assert.assertEquals(0, city.getCurrentLetters().size());
	}
	
	@Test
	public void testDistributeLetterWithReturn(){
		Letter<?> letter = LetterFactory.createSimpleLetter("letter", bob, bob).registered();
		bob.sendLetter(letter);
		Assert.assertEquals(1, city.getCurrentLetters().size());
		city.distributeLetters();
		Assert.assertEquals(1, city.getCurrentLetters().size());
		Assert.assertNotEquals(letter, city.getCurrentLetters().get(0));
	}
	
	@Test
	public void testUniqueBank(){
		Bank b = city.getBank();
		Assert.assertEquals(b, new City("city2").getBank());
	}

}
