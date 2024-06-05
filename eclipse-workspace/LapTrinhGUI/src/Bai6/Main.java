package Bai6;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Main {

    private static JFrame frame;
    private static JList<String> categoryList;
    private static DefaultListModel<String> listModel;
    private static JButton submitButton;

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Book Category Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        // Create list of book categories
        String[] categories = {"Literature", "Science", "History", "Technology", "Sports", "Culture"};
        listModel = new DefaultListModel<>();
        listModel.addAll(Arrays.asList(categories));
        categoryList = new JList<>(listModel);
        categoryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Allow multiple selections

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonActionListener(frame, categoryList, listModel));

        // Add components to panel and frame
        JPanel panel = new JPanel();
        panel.add(categoryList);
        panel.add(submitButton);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
}