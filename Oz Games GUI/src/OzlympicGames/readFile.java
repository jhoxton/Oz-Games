
package OzlympicGames;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	Scanner txt;
	
	public void openFile() {
		
		try 
		{
		txt = new Scanner (new File("info.txt"));
		} catch (Exception e) {
		System.out.println("Could not find info.txt");
		}
	}
	//TODO use a counter each loop to identify athlete id?
	
	public ArrayList<Athlete> readFile (ArrayList<Athlete> comp) {
		ArrayList<Athlete> inputText = new ArrayList<Athlete>(); 

		while (txt.hasNext()){
	
			
			int id = txt.nextInt();
			String name = txt.next();
			String type = txt.next();
			int age = txt.nextInt();
			String state = txt.next();
			int score = txt.nextInt();

			Athlete test = new Athlete(id, name,type, age, state, score);
			if(test.getType() == ("Cyclist"));{
				test = new Cyclist(score, state, state, score, state, score);
			} if (test.getType() == ("Swimmer"));{
				test = new Swimmer (score, state, state, score, state, score);
			} if (test.getType() == ("Sprinter"));{
				test = new Sprinter (score, state, state, score, state, score);
			} if  (test.getType() == ("Super"));{
				test = new SuperAthlete (score, state, state, score, state, score);				
			} 
//			TODO Fix this if statement so missing info in the text file is ignored
			
			test.setId(id);
			test.setName(name);
			test.setType(type);
			test.setAge(age);
			test.setState(state);
			test.setScore(score);
			
			System.out.println("Looped athlete is currently " + test.getName() + test.getType());
			comp.add(test);
	
		}
		
//		System.out.println("Array size is " + inputText.size());
//		for (int i=0; i < inputText.size(); i++) {			
//			Athlete currentAthlete = inputText.get(i);	
//			System.out.println(currentAthlete.getName());
//		}
		
	return inputText;			
	}
	
	public void closeFile() {
		txt.close();	
	}
}

