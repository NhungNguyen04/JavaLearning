package Bai9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextStyleDemo {

    private JFrame frame;
    private JTextField textField;
    private ButtonGroup buttonGroup;
    private JRadioButton normalRadioButton;
    private JRadioButton boldRadioButton;
    private JRadioButton italicRadioButton;
    private JRadioButton boldItalicRadioButton;

    public static void main(String[] args) {
        TextStyleDemo demo = new TextStyleDemo();
        demo.createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Text Style Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new FlowLayout());

        // Create text field
        textField = new JTextField(20);
        frame.getContentPane().add(textField);

        // Create radio buttons and button group
        buttonGroup = new ButtonGroup();
        normalRadioButton = new JRadioButton("Normal");
        normalRadioButton.setSelected(true); // Set initial selection
        buttonGroup.add(normalRadioButton);
        frame.getContentPane().add(normalRadioButton);

        boldRadioButton = new JRadioButton("Bold");
        buttonGroup.add(boldRadioButton);
        frame.getContentPane().add(boldRadioButton);

        italicRadioButton = new JRadioButton("Italic");
        buttonGroup.add(italicRadioButton);
        frame.getContentPane().add(italicRadioButton);

        boldItalicRadioButton = new JRadioButton("Bold Italic");
        buttonGroup.add(boldItalicRadioButton);
        frame.getContentPane().add(boldItalicRadioButton);

        // Add action listener to radio buttons
        ActionListener radioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTextStyle();
            }
        };
        normalRadioButton.addActionListener(radioButtonListener);
        boldRadioButton.addActionListener(radioButtonListener);
        italicRadioButton.addActionListener(radioButtonListener);
        boldItalicRadioButton.addActionListener(radioButtonListener);

        frame.setVisible(true);
    }
    
    private void applyTextStyle() {
        Font font = textField.getFont();
        int fontStyle = font.getStyle();
        int fontSize = font.getSize(); 

        if (normalRadioButton.isSelected()) {
            textField.setFont(new Font(font.getName(), Font.PLAIN, fontSize));
        } else if (boldRadioButton.isSelected()) {
            textField.setFont(new Font(font.getName(), Font.BOLD, fontSize));
        } else if (italicRadioButton.isSelected()) {
            textField.setFont(new Font(font.getName(), Font.ITALIC, fontSize));
        } else if (boldItalicRadioButton.isSelected()) {
            textField.setFont(new Font(font.getName(), Font.BOLD + Font.ITALIC, fontSize));
        }
    }
}
