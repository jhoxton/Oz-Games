package ozlympic;

public class Official {
	/**
	 * Advanced Programming Semester 1 2017 Assignment 2
	 *
	 * @author Jake Novak s3609685
	 *
	 * github: github.com/jhoxton/AP
	 *
	 */
	private int id;
	private String name;
	private String type;
	private int age;
	private String state;
	private int score; //Score isn't actually used, it just to help I/O files
	
	
	public Official(int id, String name, String type, int age, String state, int score) {
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
		this.score = score;
	}
}
