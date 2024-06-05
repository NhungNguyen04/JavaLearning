package Bai8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ChooseImageButtonActionListener implements ActionListener {
	private JFrame frame;
    private JLabel imageLabel;
    
    public ChooseImageButtonActionListener(JFrame fr, JLabel imglb) {
    	this.frame = fr;
    	this.imageLabel = imglb;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(imageFilter);

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                ImageIcon imageIcon = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
                imageLabel.setIcon(imageIcon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error loading image: " + ex.getMessage());
            }
        }
    }
}
