package Bai10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class MenuBarDemo {
	private JFrame frame;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu fileMenu, formatMenu;
    private JMenuItem aboutMenuItem, exitMenuItem, colorMenuItem, fontMenuItem;
    private JRadioButton[] fontRadioButtons;
    private JCheckBox boldCheckBox, italicCheckBox;

    public static void main(String[] args) {
        MenuBarDemo demo = new MenuBarDemo();
        demo.createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Menu Bar Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // Create text area for main content
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Create menu bar and menus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        formatMenu = new JMenu("Format");

        // Create menu items
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new AboutMenuItemActionListener(frame));
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitMenuItemActionListener());

        colorMenuItem = new JMenu("Color");
        colorMenuItem.add(createColorMenuItem("Red", Color.RED));
        colorMenuItem.add(createColorMenuItem("Green", Color.GREEN));
        colorMenuItem.add(createColorMenuItem("Blue", Color.BLUE));

        fontMenuItem = new JMenu("Font");
        fontRadioButtons = new JRadioButton[3];
        for (int i = 0; i < fontRadioButtons.length; i++) {
            fontRadioButtons[i] = new JRadioButton("Font " + (i + 1));
            fontRadioButtons[i].addActionListener(new FontRadioButtonActionListener(fontRadioButtons, textArea));
            fontMenuItem.add(fontRadioButtons[i]);
        }

        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.addActionListener(new BoldCheckBoxActionListener(boldCheckBox, italicCheckBox, textArea));
        italicCheckBox = new JCheckBox("Italic");
        italicCheckBox.addActionListener(new ItalicCheckBoxActionListener(boldCheckBox, italicCheckBox, textArea));

        // Add menu items to menus
        fileMenu.add(aboutMenuItem);
        fileMenu.add(exitMenuItem);

        formatMenu.add(colorMenuItem);
        formatMenu.add(fontMenuItem);
        formatMenu.add(boldCheckBox);
        formatMenu.add(italicCheckBox);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);

        // Set menu bar to frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private JMenuItem createColorMenuItem(String colorName, Color color) {
        JMenuItem menuItem = new JMenuItem(colorName);
        menuItem.setForeground(color);
        menuItem.addActionListener(new ColorMenuItemActionListener(color, textArea));
        return menuItem;
    }
}
