package application;

public class Offical {
	
	private int id;
	private String name;
	private String type;
	private int age;
	private String state;
	private int score;
	
	
	public Offical(int id, String name, String type, int age, String state, int score) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setAge(age);
		this.setState(state);
		this.setScore(score);
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


	public void setAge(int age) {
		this.age = age;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public void Announce() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		score ++;
		//TODO 
		this.score = score;
	}
}
