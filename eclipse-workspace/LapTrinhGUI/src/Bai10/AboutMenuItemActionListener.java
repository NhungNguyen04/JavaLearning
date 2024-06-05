package Bai10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class AboutMenuItemActionListener implements ActionListener {
	
	private JFrame frame;
	
	public AboutMenuItemActionListener(JFrame fr) {
		this.frame = fr;
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "About Menu Bar Demo");
    }
}
