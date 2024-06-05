package Bai2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Key Listener Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        final JLabel label = new JLabel("Pressed Key: ");
        frame.getContentPane().add(label, BorderLayout.CENTER);

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                String keyChar = Character.toString(e.getKeyCode());
                label.setText("Pressed Key: " + keyChar.toString());
            }

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        };

        frame.addKeyListener(keyListener);
        frame.setVisible(true);
	}
}
