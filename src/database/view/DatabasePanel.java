package database.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


import controller.AppController;
import database.model.Person;

public class DatabasePanel extends JPanel 
{
	private AppController baseController;
	private JButton button1, updateButton, testConnection;
	private JTextField field1, field2, field3, field4, field5;
	private SpringLayout baseLayout;
	private JTextArea textArea;
	
	public DatabasePanel(AppController baseController)
	{
		this.baseController = baseController;
		
		baseLayout = new SpringLayout();
		
		button1 = new JButton("Button1");
		updateButton = new JButton("Button2");
		testConnection = new JButton("TestConnection");
		
		field1 = new JTextField();
		field2 = new JTextField();
		baseLayout.putConstraint(SpringLayout.WEST, field2, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.SOUTH, field2, -6, SpringLayout.NORTH, field1);
		baseLayout.putConstraint(SpringLayout.EAST, field2, 0, SpringLayout.EAST, updateButton);
		field3 = new JTextField();
		baseLayout.putConstraint(SpringLayout.NORTH, field2, 6, SpringLayout.SOUTH, field3);
		field4 = new JTextField();
		field5 = new JTextField();
		
		textArea = new JTextArea();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		
		this.setLayout(baseLayout);
		this.add(testConnection);
		this.add(button1);
		this.add(updateButton);
		this.add(field1);
		this.add(field2);
		this.add(field3);
		this.add(field4);
		this.add(field5);
		this.add(textArea);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	private boolean checkInteger(String current)
	{
		boolean isInteger = false;
		
		try
		{
			Integer.parseInt(current);
			isInteger = true;
		}
		catch(NumberFormatException currentException)
		{
			JOptionPane.showMessageDialog(this, "Make sure you typed in a number for the age :D");
		}
		return isInteger;
	}
	
	private void gatherInput()
	{
		
	}
	
	private Person createPersonFromInput()
	{
		Person deadPerson = null;
		int deadPersonAge = 0;
		
		
		return deadPerson;
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, field4, 49, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, field1, -6, SpringLayout.NORTH, textArea);
		baseLayout.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.EAST, field1, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.WEST, field4, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.SOUTH, field4, -6, SpringLayout.NORTH, field3);
		baseLayout.putConstraint(SpringLayout.EAST, field4, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.WEST, field3, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.EAST, field3, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, field5, -26, SpringLayout.NORTH, field4);
		baseLayout.putConstraint(SpringLayout.WEST, field5, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.SOUTH, field5, -6, SpringLayout.NORTH, field4);
		baseLayout.putConstraint(SpringLayout.EAST, field5, 0, SpringLayout.EAST, updateButton);
		baseLayout.putConstraint(SpringLayout.NORTH, textArea, 153, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textArea, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.SOUTH, textArea, -6, SpringLayout.NORTH, button1);
		baseLayout.putConstraint(SpringLayout.NORTH, updateButton, 0, SpringLayout.NORTH, button1);
		baseLayout.putConstraint(SpringLayout.WEST, updateButton, 6, SpringLayout.EAST, button1);
		baseLayout.putConstraint(SpringLayout.WEST, field1, 0, SpringLayout.WEST, button1);
		baseLayout.putConstraint(SpringLayout.SOUTH, field3, -405, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, field3, 75, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, button1, 194, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, button1, 72, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});

		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.getMyDataController().connectToExternal();
			}
		});
		
		testConnection.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.start();
			}
		});
	}
}
