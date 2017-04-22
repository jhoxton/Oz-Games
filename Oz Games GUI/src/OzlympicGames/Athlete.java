package OzlympicGames;


public class Athlete {
	
//	Add a "type" parameter for the text file. This can designate the type of object.	
	private int id;
	private String name;
	private String type;
	private int age;
	private String state;
	private int score;
	
	public Athlete(int id, String name, String type, int age, String state, int score) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.age = age;
		this.state = state;
		this.score = score;
	}
		
	public int compete(String superName) {
		return 0;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}	
	
	public void setScore(int i) {
		score = score + i;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
