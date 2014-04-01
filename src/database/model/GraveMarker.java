package database.model;

import java.util.ArrayList;

public class GraveMarker 
{
	private ArrayList<Person> gravePersonList;
	private boolean isReadable;
	private String location;
	private String graveInformation;
	private String typeOfGrave;
	
	public GraveMarker()
	{
		gravePersonList = new ArrayList<Person>();
		isReadable = false;
		location = "not anywhere";
		graveInformation = "blank";
		typeOfGrave = "n/a";
	}
	
	public GraveMarker(boolean isReadable, String typeOfGrave)
	{
		gravePersonList = new ArrayList<Person>();
		this.isReadable = isReadable;
		this.typeOfGrave = typeOfGrave;
		location = "not anywhere";
		graveInformation = "blank";
		typeOfGrave = "n/a";
	}

	public ArrayList<Person> getGravePersonList() {
		return gravePersonList;
	}

	public void setGravePersonList(ArrayList<Person> gravePersonList) {
		this.gravePersonList = gravePersonList;
	}

	public boolean isReadable() {
		return isReadable;
	}

	public void setReadable(boolean isReadable) {
		this.isReadable = isReadable;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGraveInformation() {
		return graveInformation;
	}

	public void setGraveInformation(String graveInformation) {
		this.graveInformation = graveInformation;
	}

	public String getTypeOfGrave() {
		return typeOfGrave;
	}

	public void setTypeOfGrave(String typeOfGrave) {
		this.typeOfGrave = typeOfGrave;
	}
	
	public String toString()
	{
		String graveInfo = "";
		
		for (Person current : gravePersonList)
		{
			graveInfo += current + " is buried here. \n";
		}
		if (isReadable)
		{
			graveInfo += "This grave is readable";
		}
		else
		{
			graveInfo += "This grave is NOT readable";
		}
		
		return graveInfo;
	}
	
}
