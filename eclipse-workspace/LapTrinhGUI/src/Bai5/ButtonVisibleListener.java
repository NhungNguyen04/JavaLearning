package Bai5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonVisibleListener implements ActionListener {
	
	private final JButton button;
	private JButton previousButton;
    private final JFrame frame;

    public ButtonVisibleListener(JButton button, JFrame frame) {
        this.button = button;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the panel containing the buttons
        JPanel buttonPanel = (JPanel) frame.getContentPane();

        // Hide the clicked button
        buttonPanel.remove(button);
        buttonPanel.revalidate();
        buttonPanel.repaint();

        // Show the remaining buttons
        previousButton.setVisible(true);
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton && component != button) {
                component.setVisible(true);
            }
        }
        
        previousButton = button;
    }
}
