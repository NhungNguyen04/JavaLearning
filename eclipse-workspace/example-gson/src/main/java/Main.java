import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		
		// Deserialize JSON String into a Person object
		String jsonString1 = "{\"name\":\"Alice\",\"age\":30}";
		Gson gson = new Gson();
		Person person1 = gson.fromJson(jsonString1, Person.class); 
		System.out.println(person1.getName());  // Output: Alice
		System.out.println(person1.getAge());   // Output: 30
		
		// Serialize a Person object into JSON String
		Person person2 = new Person("Jane Doe", 25);
		String jsonString2 = gson.toJson(person2);
		System.out.println(jsonString2);
		
	}
}
