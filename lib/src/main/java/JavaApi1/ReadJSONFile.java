package JavaApi1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class ReadJSONFile {
	
	public static void main(String args[]) {
		
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
     
		try (FileReader reader = new FileReader("C:/Users/resham.gupta/eclipse-workspace/JavaApi1/lib/src/main/java/JavaApi1/persons.json"))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray personList = (JSONArray) obj;
			System.out.println(personList);
         
			//Iterate over person array
			personList.forEach( per -> parsePersonObject( (JSONObject) per ) );

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void parsePersonObject(JSONObject person) 
	{
		//Get person object within list
		JSONObject personObject = (JSONObject) person.get("person");
     
		//Get person Id
        int Id = Integer.parseInt((String) personObject.get("Id"));
		System.out.println(Id);
    
		//Get person first name
		String firstname = (String) personObject.get("firstname");    
		System.out.println(firstname);
     
		//Get person last name
		String lastname = (String) personObject.get("lastname");  
		System.out.println(lastname);
     
		//Get person email name
		String email = (String) personObject.get("email");    
		System.out.println(email);	
	}
}

