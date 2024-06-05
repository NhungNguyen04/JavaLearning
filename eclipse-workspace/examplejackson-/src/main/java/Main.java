import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public static void main(String[] args) throws IOException {
		
		LocalDate localDate = LocalDate.of(2004, 10, 19);
		Date dob = Date.from(localDate.atStartOfDay().atZone(ZoneId.of("GMT")).toInstant());
		
		Person person = new Person("Alice", 30, dob, "nhung123");

		ObjectMapper mapper = new ObjectMapper();

		// Serializing to a string
		String jsonString = mapper.writeValueAsString(person);  
		System.out.println(jsonString);  // Output: {"name":"Alice","age":30} 

		// Serializing to a file
		mapper.writeValue(new File("person.json"), person); 

	}
}
