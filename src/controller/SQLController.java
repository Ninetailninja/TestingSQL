package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

import database.model.Person;

public class SQLController 
{
	
	private String connectionString;
	private Connection dataConnection;
	
	/*
	 * Constructor for controller
	 */
	public SQLController()
	{
		connectionString = "jdbc:mysql://localhost/group_project?user=root";
		
		checkDriver();
		setupConnection();
	}
	
	/*
	 * Returns the connection String
	 */
	public String getConnectionString()
	{
		return connectionString;
	}
	
	/*
	 * sets a value for the Connection string
	 * param: connectionString to change the value to.
	 */
	public void setConnectionString(String connectionString)
	{
		this.connectionString = connectionString;
	}
	
	/*
	 * builds a website URL path for the connectionString
	 * Param: server path, name of database, username, password
	 */
	public void buildConnectionString(String serverPath, String database, String userName, String password)
	{
		connectionString = "jdbc:mysql://" + serverPath + "/" + database + "?user=" + userName + "&password=" + password;
	}
	
	/*
	 * displays errors for message, state, and java error code
	 */
	public void displaySQLErrors(SQLException current)
	{
		JOptionPane.showMessageDialog(null, "SQL Message is: " + current.getMessage());
		JOptionPane.showMessageDialog(null, "SQL State is: " + current.getSQLState());
		JOptionPane.showMessageDialog(null, "Java error code is: " + current.getErrorCode());
	}
	
	/*
	 * checks the driver to see if it is up to date.
	 */
	private void checkDriver()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception currentException)
		{
			System.err.println("Unable to load the driver");
			System.err.println("Check that the ConnectorJ .jar file is loaded as an external JAR in the build path");
			System.err.println("The original .jar should be in the ~/MySQL/ folder");
		}
	}
	
	/*
	 * sets up a data connection to the server.
	 */
	public void setupConnection()
	{
		try
		{
			dataConnection = DriverManager.getConnection(connectionString);
		}
		catch (SQLException currentException)
		{
			displaySQLErrors(currentException);
		}
	}
	
	/*
	 * closes the connection to the server.
	 */
	public void closeConnection()
	{
		try
		{
			dataConnection.close();
		}
		catch(SQLException currentSQLError)
		{
			displaySQLErrors(currentSQLError);
		}
	}
	
	/*
	 * closes the connection the server, and then re-connects.
	 */
	private void clearConnection()
	{
		closeConnection();
		setupConnection();
	}
	
	/*
	 * Creates a database on the server connected to.
	 */
	public void createDatabase()
	{
		clearConnection();
		try
		{
			Statement createDatabaseStatement = dataConnection.createStatement();
			
			int result = createDatabaseStatement.executeUpdate("CREATE DATABASE michael;");
			createDatabaseStatement.close();
		}
		catch(SQLException error)
		{
			displaySQLErrors(error);
		}
	}
	
	/*
	 * updates names in table for database.
	 */
	public void updatePersonInTable(String oldName, String newName)
	{
		try
		{
			Statement updateStatement = dataConnection.createStatement();
			String updateString = "UPDATE `graveard`.`people` "
			+ "SET `person_name` = '" + newName +
			"'"+"WHERE `person_name` = '" + oldName + "' ;";
			
			int result = updateStatement.executeUpdate(updateString);
			JOptionPane.showMessageDialog(null, "Successfully updated " + result + " row(s)");
			updateStatement.close();
		}
		catch(SQLException error)
		{
			displaySQLErrors(error);
		}
	}
	
	/*
	 * creates pople in the table for the database.
	 * Param: name of database to add to.
	 */
	public void createPeopleTable(String database)
	{
		clearConnection();
		int queryIndex = connectionString.indexOf("?");
		String connectionStart = connectionString.substring(0, queryIndex);
		String connectionEnd = connectionString.substring(queryIndex);
		connectionString = connectionStart + database + connectionEnd;
		
		setupConnection();
		
		try
		{
			Statement createTableStatement = dataConnection.createStatement();
			String createMyPersonTable = "CREATE TABLE IF NOT EXISTS `" + database + "`.`PEOPLE`" + 
			"(" +
					"`person_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
					"`person_name` VARCHAR (50) NOT NULL," +
					"`person_birth_date` VARCHAR (30),"+
					"`person_death_date` VARCHAR (30),"+
					"`person_is_married` BOOL,"+
					"`person_has_children` BOOL,"+
					"`person_age` INT," +
					") ENGINE = INNODB;";
			int result = createTableStatement.executeUpdate(createMyPersonTable);
			createTableStatement.close();
		}
		catch (SQLException currentSQLError)
		{
			displaySQLErrors(currentSQLError);
		}
	}
	
	/*
	 * selects data from the table
	 * param: table to select from.
	 * return Vector<Person> - data of people gathered from table.
	 */
	public Vector<Person> selectDataFromTable(String tableName)
	{
		Vector<Person> personVector = new Vector<Person>();
		ResultSet seeDeadPeopleResults;
		String selectQuery = "SELECT person_name, person_birth_date, person_death_date, person_age, person_is_married, person_has_children FROM `" + tableName + "`;";
		
		try
		{
			PreparedStatement selectStatement = dataConnection.prepareStatement(selectQuery);
			seeDeadPeopleResults = selectStatement.executeQuery();
			
			while(seeDeadPeopleResults.next())
			{
				Person tempPerson = new Person();
				String tempName = seeDeadPeopleResults.getString(1);
				String tempBirth = seeDeadPeopleResults.getString(2);
				String tempDeath = seeDeadPeopleResults.getString(3);
				int tempAge = seeDeadPeopleResults.getInt(4);
				Boolean tempMarried = seeDeadPeopleResults.getBoolean(5);
				Boolean tempChildren = seeDeadPeopleResults.getBoolean(6);
				
				tempPerson.setName(tempName);
				tempPerson.setBirthDate(tempBirth);
				tempPerson.setDeathDate(tempDeath);
				tempPerson.setAge(tempAge);
				tempPerson.setMarried(tempMarried);
				tempPerson.setHasChildren(tempChildren);
				
				
				personVector.add(tempPerson);
			}
			
			seeDeadPeopleResults.close();
			selectStatement.close();
		}
		catch (SQLException currentError)
		{
			displaySQLErrors(currentError);
		}
		
		return personVector;
	}
	
	/*
	 * connects to external server.
	 */
	public void connectToExternal()
	{
		buildConnectionString("10.228.6.204", "", "ctec", "student");
		setupConnection();
		createDatabase();
	}
	
	
}
