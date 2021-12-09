package JavaApi1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ConnectToDb {

	public static void main(String[] args) throws SQLException {
		final String mysqlUrl = "jdbc:mysql://127.0.0.1:3306/resham";
		final String USER = "root";
		final String PASS = "";
		
		Connection conn = null;
		
		try {
			//Registering the Driver
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//Getting the connection
			conn = DriverManager.getConnection(mysqlUrl, USER, PASS);
			
			System.out.println("Connection established......");
			System.out.println();
			
	       // Execute a query
	        System.out.println("Inserting data into the table...");   
	          
	        PreparedStatement preparedStatement = conn.prepareStatement("insert into person values (?, ?, ?, ? )");
		
	        //JSON parser object to parse read file
			JSONParser jsonParser = new JSONParser();
	     
			try (FileReader reader = new FileReader("C:/Users/resham.gupta/eclipse-workspace/JavaApi1/lib/src/main/java/JavaApi1/persons.json"))
			{
				//Read JSON file
				Object obj = jsonParser.parse(reader);

				JSONArray personList = (JSONArray) obj;
				System.out.println(personList);
				
		        System.out.println();
	         	
			    for(Object personObject1 : personList) {

			    	JSONObject record = (JSONObject) personObject1;
					JSONObject personObject = (JSONObject) record.get("person");

			    	//Get person Id
					int Id = Integer.parseInt((String) personObject.get("Id"));
		    
			       //Get person first name
			       String firstname = (String) personObject.get("firstname");    
					
			       //Get person last name
			       String lastname = (String) personObject.get("lastname");  
									     
			       //Get person email
			       String email = (String) personObject.get("email");  
					
			       try {
			           	 preparedStatement.setInt(1, Id);
			           	 preparedStatement.setString(2, firstname);
			           	 preparedStatement.setString(3, lastname);
			           	 preparedStatement.setString(4, email);
			       }catch(SQLException e) {
			           	 e.getStackTrace();
			       }
			       preparedStatement.executeUpdate();

			    }
				System.out.println("Inserted data into the table successfully..."); 
				
				}finally {
					try {
						if (conn != null) {
							conn.close();
						}
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
            e.printStackTrace();
        }		
	}
}