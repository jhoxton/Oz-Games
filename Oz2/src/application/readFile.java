
package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
	Scanner txt;
	
	public void openFile() {
		try {
			txt = new Scanner (new File("participants.txt"));
		} catch (Exception e) {
			System.out.println("Could not find info.txt");
		}
	}
	
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
				Cyclist cycleIn = new Cyclist(id, name,type, age, state, score);
//				System.out.println("Cyclist");
//				System.out.println("Test 2 added " + cycleIn.getName());
				comp.add(cycleIn);				
			}
			
			else if (test.getType().equals("Swimmer")) {
				Swimmer SwimIn = new Swimmer(id, name,type, age, state, score);
//				System.out.println("Swimmer");
//				System.out.println("Test 3 added " + SwimIn.getName());
				comp.add(SwimIn);				
			}
			
			else if (test.getType().equals("Sprinter")) {				
				Sprinter SprintIn = new Sprinter(id, name,type, age, state, score);
//				System.out.println("Sprinter");
//				System.out.println("Test 4 added " + SprintIn.getName());
				comp.add(SprintIn);				
			}
			else if (test.getType().equals("Super")) {
				Sprinter SuperIn = new Sprinter(id, name,type, age, state, score);
//				System.out.println("Super");
//				System.out.println("Test 5 added " + SuperIn.getName());
				comp.add(SuperIn);				
			}	
		}
	return inputText;
	}
	
	public ArrayList<Official> readOffsFile(ArrayList<Official> offs) {
		ArrayList<Official> inputOffs = new ArrayList<Official>();
		while (txt.hasNext()){
			
			int id = txt.nextInt();
			String name = txt.next();
			String type = txt.next();
			int age = txt.nextInt();
			String state = txt.next();
			int score = txt.nextInt();
			
			Official test = new Official(id, name,type, age, state, score);
		
		if (test.getType().equals("Official")) {
			Official OffIn = new Official(id, name,type, age, state, score);
//			System.out.println("Official");
//			System.out.println("Off added " + OffIn.getName());
			offs.add(OffIn);				
		}
		
		
		}
		return inputOffs;
	}
	public void closeFile() {
		txt.close();	
	}
}

