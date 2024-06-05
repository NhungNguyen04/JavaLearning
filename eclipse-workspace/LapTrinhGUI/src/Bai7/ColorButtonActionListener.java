package Bai7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonActionListener implements ActionListener {

    private final Color color;
    private final JPanel colorPanel;

    public ColorButtonActionListener(Color color, JPanel panel) {
        this.color = color;
        this.colorPanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        colorPanel.setBackground(color);
    }
}
