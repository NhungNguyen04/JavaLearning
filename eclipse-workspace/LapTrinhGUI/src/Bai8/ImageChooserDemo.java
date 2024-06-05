package Bai8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class ImageChooserDemo {

    private JFrame frame;
    private JLabel imageLabel;
    private JButton chooseImageButton;

    public static void main(String[] args) {
        ImageChooserDemo demo = new ImageChooserDemo();
        demo.createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Image Chooser Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Create label for displaying the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Create button to open file chooser
        chooseImageButton = new JButton("Choose Image");
        chooseImageButton.addActionListener(new ChooseImageButtonActionListener(frame, imageLabel));
        frame.getContentPane().add(chooseImageButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}