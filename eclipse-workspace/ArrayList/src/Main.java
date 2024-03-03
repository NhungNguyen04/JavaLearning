import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
	public static void main (String[] args) {
//		ArrayList = a resizable array
//					Elments can be added and removed after compilation phase
//					store reference datatypes.
		
		ArrayList<String> food = new ArrayList<String>();
		
		food.add("pizza");
		food.add("hamburger");
		food.add("hotdog");
		
		food.set(0, "pasta");
		food.remove(2);
		food.clear();
		
		for(int i=0; i<food.size(); i++) {
			System.out.println(food.get(i));
		}
	 }
}
