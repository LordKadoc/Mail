package generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import letter.Letter;
import letter.TransformableRegisteredLetter;
import city.Bank;
import city.City;
import city.Inhabitant;
import factory.LetterFactory;

public class RandomMailGenerator {
	
	private Random random;
	
	public RandomMailGenerator(long seed){
		this.random = new Random(seed);
	}
	
	public void generateLettersForTheDay(City city) throws NotEnoughInhabitantException{
		
		List<Inhabitant> tmp;
		
		if(city.getInhabitants().size() < 2){
			throw new NotEnoughInhabitantException();
		}
		
		for(Inhabitant i : city.getInhabitants()){
			if(random.nextInt(100) < 10){	
				tmp = new ArrayList<Inhabitant>();
				tmp.addAll(city.getInhabitants());
				tmp.remove(i);
				city.sendLetter(getRandomLetter(i, getRandomReceiver(tmp)));
			}
		}
	}
	
	public Letter<?> getRandomLetter(Inhabitant sender, Inhabitant receiver){
		int rand = random.nextInt(100);
		TransformableRegisteredLetter<?> letter;
		if(rand > 66){
			letter = LetterFactory.createSimpleLetter(getRandomMessage("messages.txt"), sender, receiver);
		}else if(rand > 33){
			letter =  LetterFactory.createPromisoryNote(getRandomAmount(sender.getIdentifier()), sender, receiver);
		}else{	
			letter =  LetterFactory.createBodyPartNote(random.nextInt(100)+10, "bloody " + getRandomMessage("bodyparts.txt"), getRandomMessage("messages.txt"), sender, receiver);
		}
		
		switch(random.nextInt(4)){
			case 0:
				return letter.registered();
			case 1:
				return letter.urgent();
			case 2:
				return letter.registered().urgent();
			default:
				return letter;
		}
		
	}
	
	public Inhabitant getRandomReceiver(List<Inhabitant> inhabitants){
		return inhabitants.get(random.nextInt(inhabitants.size()));
	}
	
	public String getRandomMessage(String filename){
		List<String> messages = new ArrayList<String>();
		BufferedReader reader = null;
		String message;
		try {
			reader = new BufferedReader(new FileReader(filename));
			while((message = reader.readLine())!= null){
				messages.add(message);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages.get(random.nextInt(messages.size()));
	}
	
	public double getRandomAmount(String id){
		return random.nextInt(Math.max(1,(int)(Bank.getInstance().getAmount(id)/10)));
	}

}
