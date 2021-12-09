package JavaApi1;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ApiApp {
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		//first data
		JSONObject personDetails1 = new JSONObject();
		personDetails1.put("Id", "1");
		personDetails1.put("firstname", "Rutuja");
		personDetails1.put("lastname", "Gaonkar");
		personDetails1.put("email", "rutujag@gmail.com");
		
		JSONObject personObject1 = new JSONObject(); 
        personObject1.put("person", personDetails1);
        
        //second data
        JSONObject personDetails2 = new JSONObject();
		personDetails2.put("Id", "2");
		personDetails2.put("firstname", "Resham");
		personDetails2.put("lastname", "Gupta");
		personDetails2.put("email", "resham.guru12@gmail.com");
		
		JSONObject personObject2 = new JSONObject(); 
        personObject2.put("person", personDetails2);
        
        //third data
        JSONObject personDetails3 = new JSONObject();
		personDetails3.put("Id", "3");
		personDetails3.put("firstname", "Prajakta");
		personDetails3.put("lastname", "Khopkar");
		personDetails3.put("email", "prajKhopkar@gmail.com");
		
		JSONObject personObject3 = new JSONObject(); 
        personObject3.put("person", personDetails3);
        
        //fourth data
        JSONObject personDetails4 = new JSONObject();
		personDetails4.put("Id", "4");
		personDetails4.put("firstname", "Ankita");
		personDetails4.put("lastname", "Shinde");
		personDetails4.put("email", "shindes@gmail.com");
		
		JSONObject personObject4 = new JSONObject(); 
        personObject4.put("person", personDetails4);
        
      //Add employees to list
        JSONArray personList = new JSONArray();
        personList.add(personObject1);
        personList.add(personObject2);
        personList.add(personObject3);
        personList.add(personObject4);
        
		System.out.println(personList.toString());

        //Write JSON file
        try (FileWriter file = new FileWriter("C:\\Users\\resham.gupta\\eclipse-workspace\\JavaApi1\\lib\\src\\main\\java\\JavaApi1\\persons.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(personList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
