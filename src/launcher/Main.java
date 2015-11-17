package launcher;

import generator.NotEnoughInhabitantException;
import generator.RandomMailGenerator;
import city.City;
import city.Inhabitant;

public class Main {

	public static void main(String[] args) {
		
		City city =  new City("Pawnee");
		
		System.out.println("Creating the city of " + city.toString());
		
		for(int i=0;i<100;i++){
			city.addInhabitant(new Inhabitant("inhabitant-"+(i+1), city));
		}
		System.out.println("Generating 100 inhabitants");
		
		RandomMailGenerator generator = new RandomMailGenerator(-1);
		
		System.out.println("Mailing letters for 10 days");
		
		for(int i=0;i<10;i++){
			
			System.out.println("*******************************************");
			System.out.println("Day " + (i+1));
			city.distributeLetters();
			try {
				generator.generateLettersForTheDay(city);
			} catch (NotEnoughInhabitantException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" ******************** Bank account resume ***********************");
		city.getBank().displayAccount();
		
	}

}
