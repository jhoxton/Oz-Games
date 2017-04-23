
package OzlympicGames;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	Scanner txt;
	
	public void openFile() {
		
		try 
		{
		txt = new Scanner (new File("participants.txt"));
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

			if (test.getType().equals("Cyclist")) {
				System.out.println("Cyclist");
				
				Cyclist cycleIn = new Cyclist(id, name,type, age, state, score);
				System.out.println("Test 2 added " + cycleIn.getName());
				comp.add(cycleIn);
				
			}
			
			else if (test.getType().equals("Swimmer")) {
				System.out.println("Swimmer");
				
				Swimmer SwimIn = new Swimmer(id, name,type, age, state, score);
				System.out.println("Test 3 added " + SwimIn.getName());
				comp.add(SwimIn);
				
			}
			
			else if (test.getType().equals("Sprinter")) {
				System.out.println("Sprinter");
				
				Sprinter SprintIn = new Sprinter(id, name,type, age, state, score);
				System.out.println("Test 4 added " + SprintIn.getName());
				comp.add(SprintIn);
				
			}
			else if (test.getType().equals("Super")) {
				System.out.println("Super");
				
				Sprinter SuperIn = new Sprinter(id, name,type, age, state, score);
				System.out.println("Test 5 added " + SuperIn.getName());
				comp.add(SuperIn);
				
			}
			
			
//			if(test.getType().equals("Fuck")); {	
//				Cyclist test2 = new Cyclist(id, name,type, age, state, score);
//				System.out.println("Cyclist added " + test.getName());
//				comp.add(test2);
//			} 
			
			
//			if(test.getType() == "Swimmer"); {	
//			
//			System.out.println("Swimmer added " + test.getName());
//			test3.setId(id);
//			test3.setName(name);
//			test3.setType(type);
//			test3.setAge(age);
//			test3.setState(state);
//			test3.setScore(score);
//			comp.add(test3);
//		} 
			
//			} if (test.getType() == ("Sprinter"));{
//				test = new Sprinter (score, state, state, score, state, score);
//			} if  (test.getType() == ("Super"));{
//				test = new SuperAthlete (score, state, state, score, state, score);				
//			} 
//			TODO Fix this if statement so missing info in the text file is ignored
			
//			test.setId(id);
//			test.setName(name);
//			test.setType(type);
//			test.setAge(age);
//			test.setState(state);
//			test.setScore(score);
			
//			System.out.println("Looped athlete is currently " + test.getName() + test.getType());
//			comp.add(test2);
	
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

