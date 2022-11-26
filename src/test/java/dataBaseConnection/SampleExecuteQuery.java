package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQuery {
	
	@Test
	public void sampleExecuteQuery() throws SQLException
	{
		Driver driverRef = new Driver();
		
		//step 1: Register driver
		DriverManager.registerDriver(driverRef);
		
		//step 2: get the connection with the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasm6db", "root", "root");
		
		//step 3: Issue createStatement 
		Statement statement = connection.createStatement();
		
		//step 4: execute any query
		String query = "select * from wasm6table";
		ResultSet result = statement.executeQuery(query);
		
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		//step 5: close the database
		connection.close();
	}

}
