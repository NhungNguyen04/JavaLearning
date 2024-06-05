package Bai2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int n = (int) (Math.random() * (15-5+1)+5);
		List <Shirt> shirts = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			Color color = Color.values()[(int) (Math.random()*7)];
			Size size = Size.values()[(int) (Math.random()*5)];
			shirts.add(new Shirt(color, size));
		}
		
	}
}

