import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Write your name");
		JOptionPane.showMessageDialog(null, "Hello " + name);
		
		int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you? "));
		JOptionPane.showMessageDialog(null, "You are " + age + " years old");
		
		double height = Double.parseDouble(JOptionPane.showInputDialog("How tall are you? "));
		JOptionPane.showMessageDialog(null, "You are " + height + " cm tall");
	}

}
 