
public class Main {
	public static void main(String[] args) {
//		overloaded methods = methods that share the same name but have different parameters
//							 method name + parameters = method signature
		double a = 1.235;
		int b = 2;
		int c = 3;
		int d = 4;
		
		System.out.println(add(a, b));
		add((int)a, b, c);
		add((int)a, b, c, d);
		
	}
	
	static int add (int a, int b, int c) {
		System.out.println("This is overloaded method #1");
		return a+b+c;
	}
	
	static double add (double a, double b) {
		System.out.println("This is overloaded method #2");
		return a+b;
	}
	
	static int add (int a, int b, int c, int d) {
		System.out.println("This is overloaded method #3");
		return a+b+c+d;
	}
}
