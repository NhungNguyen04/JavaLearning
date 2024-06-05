package Bai10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ColorMenuItemActionListener implements ActionListener {
    private final Color color;
    private JTextArea textArea;

    public ColorMenuItemActionListener(Color color, JTextArea textArea) {
        this.color = color;
        this.textArea = textArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setForeground(color);
    }
}
