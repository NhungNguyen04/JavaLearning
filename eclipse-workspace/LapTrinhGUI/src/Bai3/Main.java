package Bai3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Text Area Copier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);

        // Create text areas
        final JTextArea textArea1 = new JTextArea();
        textArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        final JTextArea textArea2 = new JTextArea();
        textArea2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create copy button
        JButton copyButton = new JButton("Copy");
        Cursor cursor = new Cursor(0);
        copyButton.setCursor(cursor);
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected text from text area 1
                String selectedText = textArea1.getSelectedText();

                // Check if there is selected text
                if (selectedText != null && !selectedText.isEmpty()) {
                    // Copy selected text to text area 2
                    textArea2.append(selectedText + "\n");
                }
            }
        });

        // Arrange components in a panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(textArea1, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.0;
        panel.add(textArea2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weighty = 0.0;
        panel.add(copyButton, gbc);

        // Add panel to frame
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Make frame visible
        frame.setVisible(true);
    }
}
