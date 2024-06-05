package Bai5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Bai4.ButtonActionListener;

public class ButtonVisibility {
    private JFrame frame;
    private JButton northButton, southButton, eastButton, westButton, centerButton;

    public static void main(String[] args) {
        ButtonVisibility app = new ButtonVisibility();
        app.createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Button Visibility");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        // Create buttons
        northButton = new JButton("North");
        southButton = new JButton("South");
        eastButton = new JButton("East");
        westButton = new JButton("West");
        centerButton = new JButton("Center");

        // Add action listeners to buttons
        northButton.addActionListener(new ButtonVisibleListener(northButton, frame));
        southButton.addActionListener(new ButtonVisibleListener(southButton, frame));
        eastButton.addActionListener(new ButtonVisibleListener(eastButton, frame));
        westButton.addActionListener(new ButtonVisibleListener(westButton, frame));
        centerButton.addActionListener(new ButtonVisibleListener(centerButton, frame));

        // Create panels and arrange buttons
        frame.getContentPane().add(northButton, BorderLayout.NORTH);
        frame.getContentPane().add(southButton, BorderLayout.SOUTH);
        frame.getContentPane().add(eastButton, BorderLayout.EAST);
        frame.getContentPane().add(westButton, BorderLayout.WEST);
        frame.getContentPane().add(centerButton, BorderLayout.CENTER);

        // Make frame visible
        frame.setVisible(true);
    }
}
