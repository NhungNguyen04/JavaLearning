package Bai10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class FontRadioButtonActionListener implements ActionListener {
	
	private JRadioButton[] fontRadioButtons;
	private JTextArea textArea;
	
	public FontRadioButtonActionListener(JRadioButton[] fontRadioButtons, JTextArea textArea) {
		this.fontRadioButtons = fontRadioButtons;
		this.textArea = textArea;
	}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < fontRadioButtons.length; i++) {
            if (fontRadioButtons[i].isSelected()) {
                textArea.setFont(new Font("Font " + (i + 1), textArea.getFont().getStyle(), textArea.getFont().getSize()));
                break;
            }
        }
    }
}
