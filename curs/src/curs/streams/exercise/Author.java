package curs.streams.exercise;

public class Author {
	private String firstNAme;
	private String lastName;
	private Integer age;
	private String nationality;
	
	public Author(String firstNAme, String lastName, Integer age, String nationality) {
		super();
		this.firstNAme = firstNAme;
		this.lastName = lastName;
		this.age = age;
		this.nationality = nationality;
	}

	public String getFirstNAme() {
		return firstNAme;
	}

	public void setFirstNAme(String firstNAme) {
		this.firstNAme = firstNAme;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return "Author [firstNAme=" + firstNAme + ", lastName=" + lastName + ", age=" + age + ", nationality="
				+ nationality + "]";
	}
	
	
}
