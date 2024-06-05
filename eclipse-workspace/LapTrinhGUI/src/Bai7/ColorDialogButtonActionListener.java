package Bai7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ColorDialogButtonActionListener implements ActionListener {
	
	private final JFrame frame;
	private final JPanel colorPanel;
	
	public ColorDialogButtonActionListener(JFrame frame, JPanel colorPanel) {
		this.frame = frame;
		this.colorPanel = colorPanel;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        Color selectedColor = JColorChooser.showDialog(frame, "Choose Color", colorPanel.getBackground());
        if (selectedColor != null) {
            colorPanel.setBackground(selectedColor);
        }
    }
}
