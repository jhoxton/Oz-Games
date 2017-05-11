
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
				comp.add(cycleIn);				
			}
			
			else if (test.getType().equals("Swimmer")) {
				Swimmer SwimIn = new Swimmer(id, name,type, age, state, score);
				comp.add(SwimIn);				
			}
			
			else if (test.getType().equals("Sprinter")) {				
				Sprinter SprintIn = new Sprinter(id, name,type, age, state, score);
				comp.add(SprintIn);				
			}
			else if (test.getType().equals("Super")) {
				SuperAthlete SuperIn = new SuperAthlete(id, name,type, age, state, score);
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
			offs.add(OffIn);				
		}
		
		
		}
		return inputOffs;
	}
	public void closeFile() {
		txt.close();	
	}
}

