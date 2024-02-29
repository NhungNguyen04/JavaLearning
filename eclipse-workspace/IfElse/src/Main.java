import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
		if (age < 13) {
			JOptionPane.showMessageDialog(null, "What you doing here kiddo!?");
		}
		else if (age < 19) {
			JOptionPane.showMessageDialog(null, "Hi teenager!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Dude you're old");
		}
	}
}
