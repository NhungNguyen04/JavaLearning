package Bai2;

enum Color {RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET};
enum Size {S,M,L,XL,XXL};

public class Shirt {
	Color color;
	Size size;
	
	public Shirt(Color c, Size s) {
		color = c;
		size = s;
	}
}
