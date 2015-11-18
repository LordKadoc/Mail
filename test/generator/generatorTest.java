package generator;

import letter.BodyPartLetter;
import letter.PromisoryNote;
import letter.SimpleLetter;

import org.junit.Assert;
import org.junit.Test;

import city.City;
import city.Inhabitant;

public class generatorTest {
	
	@Test(expected=NotEnoughInhabitantException.class)
	public void testgenerateLettersForTheDayAlone() throws NotEnoughInhabitantException{
		City city= new City("aloneCity");
		city.addInhabitant(new Inhabitant("toto", city));
		new RandomMailGenerator(42).generateLettersForTheDay(city);
	}
	
	@Test
	public void testgenerateLettersForTheDay(){
		City city= new City("DickCity");
		city.addInhabitant(new Inhabitant("toto", city));
		city.addInhabitant(new Inhabitant("toto1", city));
		city.addInhabitant(new Inhabitant("toto2", city));
		city.addInhabitant(new Inhabitant("toto3", city));
		city.addInhabitant(new Inhabitant("toto4", city));
		city.addInhabitant(new Inhabitant("toto5", city));
		city.addInhabitant(new Inhabitant("toto6", city));

		try {
			new RandomMailGenerator(42).generateLettersForTheDay(city);
		} catch (NotEnoughInhabitantException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(city.getCurrentLetters().size()>0);
	}
	
	 @Test
	 public void testgetRandomLetter(){
		City city= new City("DickCity");
		Inhabitant sender;
		city.addInhabitant((sender=new Inhabitant("toto", city)));
		Inhabitant receiver;
		city.addInhabitant((receiver=new Inhabitant("toto1", city)));
		RandomMailGenerator rmg=new RandomMailGenerator(42);
		
		boolean simpleLetter=false, bodyPartLetter= false, promisoryNote = false;
		
		for(int i=0;i<100;i++){
				if(rmg.getRandomLetter(sender,receiver) instanceof SimpleLetter){
					simpleLetter=true;
				}else if(rmg.getRandomLetter(sender,receiver) instanceof BodyPartLetter){
					bodyPartLetter=true;
				}else if(rmg.getRandomLetter(sender,receiver) instanceof PromisoryNote){
					promisoryNote=true;
				}
 	 	}
		Assert.assertTrue(simpleLetter && bodyPartLetter && promisoryNote);
	 }

}
