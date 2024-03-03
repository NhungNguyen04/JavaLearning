import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> movies = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> horror = new ArrayList<String>();
		horror.add("The Conjuring");
		horror.add("IT");
		
		ArrayList<String> thriller = new ArrayList<String>();
		thriller.add("Silence Of The Lambs");
		thriller.add("The Shining");
		thriller.add("Royale Casino");
		
		ArrayList<String> romance = new ArrayList<String>();
		romance.add("La La Land");
		romance.add("Me Before You");
		romance.add("The Fault In Our Stars");
		
		movies.add(horror);
		movies.add(thriller);
		movies.add(romance);
		
		System.out.print(movies.get(1).get(2));
	}
}
