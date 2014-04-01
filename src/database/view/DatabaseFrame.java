package database.view;

import javax.swing.JFrame;

import controller.AppController;

public class DatabaseFrame extends JFrame 
{
	private DatabasePanel myDatabasePanel;
	public DatabaseFrame(AppController baseController)
	{
		myDatabasePanel = new DatabasePanel(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(myDatabasePanel);
		this.setSize(500, 500);
		this.setVisible(true);
	}
}
