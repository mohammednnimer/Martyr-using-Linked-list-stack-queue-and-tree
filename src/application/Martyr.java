package application;

import java.util.Objects;

public class Martyr implements Comparable<Martyr> {

	private String name;

	private int age;

	private char Gender;

	@Override
	public String toString() {
		return "Martyr [name=" + name  + ", age=" + age + ", Gender=" + Gender + "]";
	}

	public Martyr(String name, int age, char gender) {
		
		this.name = name;
		this.age = age;
		this.Gender=gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Martyr other = (Martyr) obj;
		return Objects.equals(name, other.name);
	}

	public Martyr() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		
		if(gender=='f'||gender=='m')
		Gender = gender;
		else 
		{
			System.out.println("sorry the gender is not valied");

		}
	}

	@Override
	public int compareTo(Martyr o) {
		
		if(this.age-o.age==0)
		{
			return this.getGender()-o.Gender;
		}
		return this.age-o.age;
	}

}
