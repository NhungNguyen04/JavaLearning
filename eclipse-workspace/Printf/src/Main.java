import java.util.ResourceBundle.Control;

public class Main {
	public static void main(String[] args) {
//		printf() = an optional method to control, format and display text to the console window
//				   two arguments = format string + (object/variable/value)
//				   % [flag] [precision] [width] [conversion-character]
//				[width] minimum number of characters to be written as output
//				[precision] sets number of digits of precision when outputting floating-point values
//				[flags] adds an effect to output based on the flag added to format specifier
//					-: left-justify
//					+: ouput a plus (+) or minus (-) sign for a numeric value
//					0: numeric values are zero-padded
//					,: comma grouping separator if numbers > 10000
		
		boolean myBoolean = true;
		int a = 20;
		char c = 'a';
		String name = "Nhung";
		double d = 8401.838093124;
		
//		System.out.printf("%d", a);
//		System.out.printf("%c", c);
//		System.out.printf("%b", myBoolean);
//		System.out.printf("Hello%-10s", name);
		System.out.printf("%,f", d);
		
	}
}
