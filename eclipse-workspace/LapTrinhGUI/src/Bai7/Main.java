package Bai7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main {
	
	private static JFrame frame;
    private static JPanel colorPanel;
    private static ButtonGroup colorGroup;
    private static JRadioButton redButton;
	private static JRadioButton greenButton;
	private static JRadioButton blueButton;
    private static JButton colorDialogButton;

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() throws HeadlessException {
        frame = new JFrame("Color Chooser Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        // Create color panel
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.WHITE); // Initial color
        frame.getContentPane().add(colorPanel, BorderLayout.CENTER);

        // Create radio buttons for colors
        colorGroup = new ButtonGroup();
        try {
			redButton = new JRadioButton("Red");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        greenButton = new JRadioButton("Green");
        blueButton = new JRadioButton("Blue");

        colorGroup.add(redButton);
        colorGroup.add(greenButton);
        colorGroup.add(blueButton);

        redButton.setSelected(true); // Set red as default selection

        redButton.addActionListener(new ColorButtonActionListener(Color.RED, colorPanel));
        greenButton.addActionListener(new ColorButtonActionListener(Color.GREEN, colorPanel));
        blueButton.addActionListener(new ColorButtonActionListener(Color.BLUE, colorPanel));

        // Create button to open color dialog
        colorDialogButton = new JButton("Choose Color");
        colorDialogButton.addActionListener(new ColorDialogButtonActionListener(frame, colorPanel));

        // Arrange components
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(redButton);
        radioPanel.add(greenButton);
        radioPanel.add(blueButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(colorDialogButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(radioPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
	
}
