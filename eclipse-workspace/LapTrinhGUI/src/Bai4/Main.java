package Bai4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("Button Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);

        // Create buttons
        JButton leftButton = new JButton("Left");
        leftButton.addActionListener(new ButtonActionListener(frame, FlowLayout.LEFT));
        JButton centerButton = new JButton("Center");
        centerButton.addActionListener(new ButtonActionListener(frame, FlowLayout.CENTER));
        JButton rightButton = new JButton("Right");
        rightButton.addActionListener(new ButtonActionListener(frame, FlowLayout.RIGHT));

        // Create panel and arrange buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.add(leftButton);
        buttonPanel.add(centerButton);
        buttonPanel.add(rightButton);

        // Add panel to frame
        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // Make frame visible
        frame.setVisible(true);
    }
}
