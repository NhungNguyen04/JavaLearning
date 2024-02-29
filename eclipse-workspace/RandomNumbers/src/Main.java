import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		
		int x = random.nextInt();
		double y = random.nextDouble();
		boolean z = random.nextBoolean();
		System.out.println("Random int: "+ x + "\n" + "Random double: " + y + "\n" + "Random boolean: " + z);
	}
}
