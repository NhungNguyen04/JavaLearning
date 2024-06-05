package Bai10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ItalicCheckBoxActionListener implements ActionListener {
	
	private JCheckBox boldCheckBox, italicCheckBox;
	private JTextArea textArea;
	
	public ItalicCheckBoxActionListener(JCheckBox boldCheckBox, JCheckBox italicCheckBox, JTextArea textArea) {
		
		this.boldCheckBox = boldCheckBox;
		this.italicCheckBox = italicCheckBox;
		this.textArea = textArea;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        int fontStyle = Font.PLAIN;
        if (boldCheckBox.isSelected()) {
            fontStyle |= Font.BOLD;
        }
        if (italicCheckBox.isSelected()) {
            fontStyle |= Font.ITALIC;
        }
        textArea.setFont(new Font(textArea.getFont().getName(), fontStyle, textArea.getFont().getSize()));
    }
}
