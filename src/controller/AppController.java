package controller;

import java.util.ArrayList;

import database.model.GraveMarker;
import database.model.Person;
import database.view.DatabaseFrame;

public class AppController 
{
	private SQLController myDataController;
	private DatabaseFrame myDataFrame;
	private ArrayList<GraveMarker> myGraveMarkers;
	private ArrayList<Person> myGraveyardPeople;
	
	public AppController()
	{
		myDataController = new SQLController();
		myGraveMarkers = new ArrayList<GraveMarker>();
		myGraveyardPeople = new ArrayList<Person>();

		myDataFrame = new DatabaseFrame(this);
	}
	
	public SQLController getMyDataController()
	{
		return myDataController;
	}
	
	public void start()
	{
		myDataController.connectToExternal();
		myDataController.createDatabase();
	}
}
