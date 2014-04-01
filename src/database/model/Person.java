package database.model;

public class Person 
{
	//name
	private String name;
	private String birthDate;
	private String deathDate;
	private boolean isMarried;
	private boolean hasChildren;
	private int age;
	
	public Person()
	{
		name = "";
		birthDate = "unknown";
		deathDate = "unknown";
		isMarried = false;
		hasChildren = false;
		age = -50;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public boolean isHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString()
	{
		String personInfo = "";
		
		personInfo += "This is: " + name;
		personInfo += "; died around: " + deathDate;
		personInfo += " at age: " + age;
		
		return personInfo;
	}
	//gravestone
	//date of birth
	//date of death
	//married
	//children
	//age
}
