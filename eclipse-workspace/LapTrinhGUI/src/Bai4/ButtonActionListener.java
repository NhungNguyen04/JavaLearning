package Bai4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ButtonActionListener implements ActionListener {
    private final JFrame frame;
    private final int alignment;

    public ButtonActionListener(JFrame frame, int alignment) {
        this.frame = frame;
        this.alignment = alignment;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JPanel buttonPanel = (JPanel) frame.getContentPane();
        buttonPanel.setLayout(new FlowLayout(alignment, 1, 1));
        buttonPanel.revalidate();
        buttonPanel.repaint();
    }
    
}
