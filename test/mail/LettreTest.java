package mail;

import letter.BodyPartLetter;
import letter.PromisoryNote;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.ThanksLetter;
import letter.UrgentLetter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import city.City;
import city.Inhabitant;

import factory.LetterFactory;

public class LettreTest{
	
	private Inhabitant sender;
	private Inhabitant receiver;
	private City city;
	
	@Before
	public void init(){
		city=new City("piltover");
		sender=new Inhabitant("cait", city);
		receiver=new Inhabitant("vi", city);
		city.addInhabitant(sender);
		city.addInhabitant(receiver);
	}
	
	@Test
	public void testSimpleLetter(){
		SimpleLetter simpleLetter=LetterFactory.createSimpleLetter("coucou", sender, receiver);
		RegisteredLetter registeredLetter=simpleLetter.registered();
		UrgentLetter urgentLetter=simpleLetter.urgent();
		UrgentLetter urgentLetter2=registeredLetter.urgent();
		
		Assert.assertEquals(new Double(simpleLetter.getCost()), new Double(1));
		Assert.assertEquals(new Double(registeredLetter.getCost()), new Double(16));
		Assert.assertEquals(new Double(urgentLetter.getCost()), new Double(2));
		Assert.assertEquals(new Double(urgentLetter2.getCost()), new Double(32));
		
		sender.sendLetter(simpleLetter);
		Assert.assertEquals(new Double(city.getBank().getAmount(sender.getIdentifier())), new Double(500-1));
			
	}
	
	@Test
	public void testPromisoryNote(){
		PromisoryNote promisoryNote=LetterFactory.createPromisoryNote(1000, sender, receiver);
		RegisteredLetter registeredLetter=promisoryNote.registered();
		UrgentLetter urgentLetter=promisoryNote.urgent();
		UrgentLetter urgentLetter2=registeredLetter.urgent();
		
		Assert.assertEquals(new Double(promisoryNote.getCost()), new Double(11));
		Assert.assertEquals(new Double(registeredLetter.getCost()), new Double(26));
		Assert.assertEquals(new Double(urgentLetter.getCost()), new Double(22));
		Assert.assertEquals(new Double(urgentLetter2.getCost()), new Double(52));
		
		sender.sendLetter(promisoryNote);
		Assert.assertEquals(new Double(city.getBank().getAmount(sender.getIdentifier())), new Double(500-11));
		city.distributeLetters();
		Assert.assertEquals(new Double(city.getBank().getAmount(sender.getIdentifier())), new Double(500-11-1000));
		Assert.assertEquals(new Double(city.getBank().getAmount(receiver.getIdentifier())), new Double(500+1000-1));
	}
	
	@Test
	public void testThanksLetter(){
		ThanksLetter thanksLetter=LetterFactory.createThanksLetter(sender, receiver);
		
		Assert.assertEquals(new Double(thanksLetter.getCost()), new Double(1));
		
		sender.sendLetter(thanksLetter);
		Assert.assertEquals(new Double(city.getBank().getAmount(sender.getIdentifier())), new Double(500-1));
		
	}
	
	@Test
	public void testBodyPartLetter(){
		BodyPartLetter bodyPartLetter=LetterFactory.createBodyPartNote(300, "text","text", sender, receiver);
		RegisteredLetter registeredLetter=bodyPartLetter.registered();
		UrgentLetter urgentLetter=bodyPartLetter.urgent();
		UrgentLetter urgentLetter2=registeredLetter.urgent();
		
		Assert.assertEquals(new Double(bodyPartLetter.getCost()), new Double(62));
		Assert.assertEquals(new Double(registeredLetter.getCost()), new Double(62+15));
		Assert.assertEquals(new Double(urgentLetter.getCost()), new Double(2*62));
		Assert.assertEquals(new Double(urgentLetter2.getCost()), new Double((62+15)*2));
		
		sender.sendLetter(bodyPartLetter);
		Assert.assertEquals(new Double(city.getBank().getAmount(sender.getIdentifier())), new Double(500-62));
	}

}
