package dataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleUpdateQuery {
	
	@Test
	public void sampleUpdateQuery() throws SQLException
	{
		Driver driverRef = new Driver();
		
		//step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//step 2: Get the connection with the dataBase
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasm6db", "root", "root");
		
		//step 3: Issue createStatement
		Statement statement = connection.createStatement();
		
		//step 4: Execute any query
		String query = "insert into wasm6table value('Batman','Newyork',15)";
		int result = statement.executeUpdate(query);
		Assert.assertEquals(result, 1);
		
		//step 5: close the database
		connection.close();
	}

}
